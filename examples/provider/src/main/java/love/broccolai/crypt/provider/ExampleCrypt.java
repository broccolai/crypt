package love.broccolai.crypt.provider;

import java.util.concurrent.CompletableFuture;
import love.broccolai.crypt.api.Crypt;
import love.broccolai.crypt.api.holder.CurrencyHolder;
import love.broccolai.crypt.api.key.Key;
import love.broccolai.crypt.api.result.BalanceResult;
import love.broccolai.crypt.api.result.DepositResult;
import org.jspecify.annotations.NullMarked;

@NullMarked
public final class ExampleCrypt implements Crypt {

    private final ExampleBanks banks = new ExampleBanks();

    @Override
    public CompletableFuture<DepositResult> deposit(CurrencyHolder target, CurrencyHolder source, Key bank, double amount) {
        this.banks.deposit(target, bank, amount);
        return CompletableFuture.completedFuture(DepositResult.success());
    }

    @Override
    public CompletableFuture<BalanceResult> balance(CurrencyHolder target, Key bank) {
        double balance = this.banks.balance(target, bank);
        return CompletableFuture.completedFuture(BalanceResult.success(balance));
    }
}
