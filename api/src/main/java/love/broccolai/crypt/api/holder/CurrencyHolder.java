package love.broccolai.crypt.api.holder;

import java.util.UUID;
import love.broccolai.crypt.api.key.Keyed;

public interface CurrencyHolder extends Keyed {

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
