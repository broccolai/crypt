package love.broccolai.crypt.api.holder;

import java.util.UUID;
import love.broccolai.crypt.api.identities.AbstractIdentity;
import org.jspecify.annotations.NullMarked;

@NullMarked
public final class PlayerCurrencyHolder extends AbstractIdentity implements CurrencyHolder {

    public static final String NAMESPACE = "player";

    private final UUID uuid;

    PlayerCurrencyHolder(final UUID uuid) {
        super(NAMESPACE, uuid.toString());
        this.uuid = uuid;
    }

    public UUID uuid() {
        return this.uuid;
    }
}
