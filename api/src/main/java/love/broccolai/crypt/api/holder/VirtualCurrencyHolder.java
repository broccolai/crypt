package love.broccolai.crypt.api.holder;

import love.broccolai.crypt.api.identities.AbstractIdentity;
import org.jspecify.annotations.NullMarked;

@NullMarked
public final class VirtualCurrencyHolder extends AbstractIdentity implements CurrencyHolder {

    public static final String NAMESPACE = "virtual";

    private final String identifier;

    VirtualCurrencyHolder(final String identifier) {
        super(NAMESPACE, identifier);
        this.identifier = identifier;
    }

    public String identifier() {
        return this.identifier;
    }
}
