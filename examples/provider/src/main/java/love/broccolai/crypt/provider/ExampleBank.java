package love.broccolai.crypt.provider;

import love.broccolai.crypt.api.key.Key;
import love.broccolai.crypt.api.key.Keyed;

public final class ExampleBank implements Keyed {

    private final Key key;
    private double balance = 0.0;

    public ExampleBank(final Key key) {
        this.key = key;
    }

    public double balance() {
        return this.balance;
    }

    public void balance(final double balance) {
        this.balance = balance;
    }

    @Override
    public Key key() {
        return this.key;
    }
}
