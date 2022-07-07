package atlaslauncher.atlaslauncher;

import atlaslauncher.atlaslauncher.loader.controllers.CommonLauncher;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedList;

public final class AtlasLauncher extends JavaPlugin {

    private static AtlasLauncher launcher;

    public static AtlasLauncher getLauncher() {
        return launcher;
    }

    @Override
    public void onEnable() {
        launcher = this;
        saveDefaultConfig();
        CommonLauncher commonLauncher = new CommonLauncher(new LinkedList<>());
        commonLauncher.launch(this);
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());
        System.out.println(commonLauncher.loadedModules());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
