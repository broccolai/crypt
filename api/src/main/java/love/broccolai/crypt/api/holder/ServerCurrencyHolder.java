package love.broccolai.crypt.api.holder;

import love.broccolai.crypt.api.identities.AbstractIdentity;
import org.jspecify.annotations.NullMarked;

@NullMarked
public final class ServerCurrencyHolder extends AbstractIdentity implements CurrencyHolder {

    public static final String NAMESPACE = "server";

    ServerCurrencyHolder() {
        super(NAMESPACE, NAMESPACE);
    }
}
