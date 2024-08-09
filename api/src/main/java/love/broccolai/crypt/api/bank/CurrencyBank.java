package love.broccolai.crypt.api.bank;

import love.broccolai.crypt.api.identities.Identity;
import org.jspecify.annotations.NullMarked;

@NullMarked
public interface CurrencyBank extends Identity {

    static CurrencyBank bank(final String namespace, final String value) {
        return new SimpleCurrencyBank(namespace, value);
    }
}
