package love.broccolai.crypt.api.holder;

import love.broccolai.crypt.api.key.Key;
import org.jspecify.annotations.NullMarked;

@NullMarked
public final class VirtualCurrencyHolder implements CurrencyHolder {

    public static final String NAMESPACE = "virtual";

    private final String identifier;

    VirtualCurrencyHolder(final String identifier) {
        this.identifier = identifier;
    }

    @Override
    public Key key() {
        return Key.key(NAMESPACE, this.identifier);
    }
}
