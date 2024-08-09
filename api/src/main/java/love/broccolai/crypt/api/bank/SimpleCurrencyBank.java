package love.broccolai.crypt.api.bank;

import love.broccolai.crypt.api.identities.AbstractIdentity;
import org.jspecify.annotations.NullMarked;

@NullMarked
final class SimpleCurrencyBank extends AbstractIdentity implements CurrencyBank {
    SimpleCurrencyBank(String namespace, String value) {
        super(namespace, value);
    }
}
