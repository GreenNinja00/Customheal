import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("customheal").setExecutor(new commands());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}