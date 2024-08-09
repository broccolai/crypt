package love.broccolai.crypt.user;

import java.util.Objects;
import love.broccolai.crypt.api.Crypt;
import love.broccolai.crypt.api.holder.CurrencyHolder;
import love.broccolai.crypt.api.result.BalanceResult;
import love.broccolai.crypt.api.result.DepositResult;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.incendo.cloud.bukkit.parser.PlayerParser;
import org.incendo.cloud.execution.ExecutionCoordinator;
import org.incendo.cloud.paper.PaperCommandManager;
import org.incendo.cloud.paper.util.sender.PaperSimpleSenderMapper;
import org.incendo.cloud.paper.util.sender.PlayerSource;
import org.incendo.cloud.paper.util.sender.Source;
import org.incendo.cloud.parser.standard.DoubleParser;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public final class CryptUser extends JavaPlugin {

    @Override
    public void onEnable() {
        PaperCommandManager<Source> commandManager = PaperCommandManager
            .builder(PaperSimpleSenderMapper.simpleSenderMapper())
            .executionCoordinator(ExecutionCoordinator.asyncCoordinator())
            .buildOnEnable(this);

        commandManager.command(
            commandManager.commandBuilder("balance")
                .senderType(PlayerSource.class)
                .required("target", PlayerParser.playerParser())
                .handler(ctx -> {
                    Player target = ctx.get("target");

                    this.loadCrypt().balance(
                        CurrencyHolder.player(target.getUniqueId()),
                        Crypt.DEFAULT_BANK
                    ).thenAccept(balanceResult -> {
                        if (balanceResult instanceof BalanceResult.Success success) {
                            ctx.sender().source().sendMessage("result: " + success.result());
                        }
                    });
                })
        );

        commandManager.command(
            commandManager.commandBuilder("deposit")
                .senderType(PlayerSource.class)
                .required("target", PlayerParser.playerParser())
                .required("amount", DoubleParser.doubleParser())
                .handler(ctx -> {
                    Player sender = ctx.sender().source();
                    Player target = ctx.get("target");
                    double amount = ctx.get("amount");

                    this.loadCrypt().deposit(
                        CurrencyHolder.player(target.getUniqueId()),
                        CurrencyHolder.player(sender.getUniqueId()),
                        Crypt.DEFAULT_BANK,
                        amount
                    ).thenAccept(depositResult -> {
                        if (depositResult instanceof DepositResult.Success) {
                            sender.sendMessage("Deposited " + amount + " to " + target.getName());
                        } else if (depositResult instanceof DepositResult.Failure failure) {
                            sender.sendMessage("Failed to deposit: " + failure.reason().getMessage());
                        }
                    });
                })
        );
    }

    private @Nullable Crypt crypt = null;

    private Crypt loadCrypt() {
        if (this.crypt == null) {
            this.crypt = Bukkit.getServicesManager().load(Crypt.class);
        }

        return Objects.requireNonNull(this.crypt);
    }
}
