package atlaslauncher.atlaslauncher.loader.interfaces;

import atlaslauncher.atlaslauncher.loader.Pair;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public interface ILauncher<O extends JavaPlugin> {

    /**
     *
     * @return This will return the LinkedList with the loaded modules.
     *
     * The reason this is important is because we will be using a URLClassLoader
     * We will be scanning the directory for modules and then we will see what is there.
     * If the module is one of ours we will load it. We will load it onEnable and disable it onDisable.
     * There will also be some safety features in place to make sure all dependencies are added.
     *
     * So the TriPair is for the Location, then theres the URL then you have the List for dependencies.
     */
    LinkedList<Pair<File, List<String>>> loadedModules();

    /**
     * This is the method that will be called. This launch method will scan through all modules that need to be loaded.
     * Once it has scanned it will then check the dependencies for each.
     */
    void launch(O launcher);

}
