package love.broccolai.crypt.api.holder;

import java.util.UUID;
import love.broccolai.crypt.api.key.Key;
import org.jspecify.annotations.NullMarked;

@NullMarked
public final class PlayerCurrencyHolder implements CurrencyHolder {

    public static final String NAMESPACE = "player";

    private final UUID uuid;

    PlayerCurrencyHolder(final UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public Key key() {
        return Key.key(NAMESPACE, this.uuid.toString());
    }
}
