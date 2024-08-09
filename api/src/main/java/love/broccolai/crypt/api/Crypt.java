package love.broccolai.crypt.api;

import java.util.concurrent.CompletableFuture;
import love.broccolai.crypt.api.holder.CurrencyHolder;
import love.broccolai.crypt.api.key.Key;
import love.broccolai.crypt.api.result.BalanceResult;
import love.broccolai.crypt.api.result.DepositResult;
import org.jspecify.annotations.NullMarked;

@NullMarked
public interface Crypt {

    Key DEFAULT_BANK = Key.key("crypt", "bank");

    CompletableFuture<DepositResult> deposit(
        CurrencyHolder target,
        CurrencyHolder source,
        Key bank,
        double amount
    );

    CompletableFuture<BalanceResult> balance(
        CurrencyHolder target,
        Key bank
    );

}
