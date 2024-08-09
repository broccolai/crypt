package love.broccolai.crypt.api.holder;

import love.broccolai.crypt.api.key.Key;
import org.jspecify.annotations.NullMarked;

@NullMarked
public final class ServerCurrencyHolder implements CurrencyHolder {

    public static final String NAMESPACE = "server";

    @Override
    public Key key() {
        return Key.key(NAMESPACE, NAMESPACE);
    }
}
