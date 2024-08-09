package love.broccolai.crypt.provider;

import love.broccolai.crypt.api.bank.CurrencyBank;

public final class ExampleBank {

    private final CurrencyBank key;
    private double balance = 0.0;

    public ExampleBank(final CurrencyBank key) {
        this.key = key;
    }

    public double balance() {
        return this.balance;
    }

    public void balance(final double balance) {
        this.balance = balance;
    }

    public CurrencyBank key() {
        return this.key;
    }
}
