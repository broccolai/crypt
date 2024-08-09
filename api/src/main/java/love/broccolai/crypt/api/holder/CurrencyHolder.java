package love.broccolai.crypt.api.holder;

import java.util.UUID;
import love.broccolai.crypt.api.identities.Identity;
import org.jspecify.annotations.NullMarked;

@NullMarked
public interface CurrencyHolder extends Identity {

    static PlayerCurrencyHolder player(final UUID uuid) {
        return new PlayerCurrencyHolder(uuid);
    }

    static VirtualCurrencyHolder virtual(final String identifier) {
        return new VirtualCurrencyHolder(identifier);
    }

    static ServerCurrencyHolder server() {
        return new ServerCurrencyHolder();
    }

}
