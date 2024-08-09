package love.broccolai.crypt.provider;

import love.broccolai.crypt.api.Crypt;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jspecify.annotations.NullMarked;

@NullMarked
public final class CryptProvider extends JavaPlugin {

    @Override
    public void onEnable() {
        ServicesManager servicesManager = this.getServer().getServicesManager();

        servicesManager.register(Crypt.class, new ExampleCrypt(), this, ServicePriority.Normal);
    }
}
