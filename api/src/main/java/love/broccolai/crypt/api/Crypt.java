package love.broccolai.crypt.api;

import java.util.concurrent.CompletableFuture;
import love.broccolai.crypt.api.bank.CurrencyBank;
import love.broccolai.crypt.api.holder.CurrencyHolder;
import love.broccolai.crypt.api.result.BalanceResult;
import love.broccolai.crypt.api.result.DepositResult;
import org.jspecify.annotations.NullMarked;

@NullMarked
public interface Crypt {

    CurrencyBank DEFAULT_BANK = CurrencyBank.bank("crypt", "bank");

    CompletableFuture<DepositResult> deposit(
        CurrencyHolder source,
        CurrencyHolder target,
        CurrencyBank bank,
        double amount
    );

    CompletableFuture<BalanceResult> balance(
        CurrencyHolder target,
        CurrencyBank bank
    );

}
