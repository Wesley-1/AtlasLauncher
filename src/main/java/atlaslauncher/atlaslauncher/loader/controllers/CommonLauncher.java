package atlaslauncher.atlaslauncher.loader.controllers;

import atlaslauncher.atlaslauncher.AtlasLauncher;
import atlaslauncher.atlaslauncher.loader.Pair;
import atlaslauncher.atlaslauncher.loader.interfaces.ILauncher;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class CommonLauncher implements ILauncher<AtlasLauncher> {

    private static File modulesFolder;

    static {
        modulesFolder = new File(AtlasLauncher.getLauncher().getDataFolder() + File.separator + "modules");
    }

    private final LinkedList<Pair<File, List<String>>> loadedModules;

    public CommonLauncher(LinkedList<Pair<File, List<String>>> loadedModules) {
        this.loadedModules = loadedModules;
    }

    @Override
    public LinkedList<Pair<File, List<String>>> loadedModules() {
        return loadedModules;
    }

    @Override
    public void launch(AtlasLauncher launcher) {
        if (!modulesFolder.exists())
            return;

        modulesFolder.mkdir();

        Arrays.stream(Objects.requireNonNull(modulesFolder.listFiles())).forEach(
                obj -> {
                    if (obj.toString().endsWith(".jar")) {
                        try {
                            loadedModules.add(
                                    new Pair<>(obj, scanDepends(new File(modulesFolder + "/depends/" + FilenameUtils.removeExtension(obj.getName()) + ".txt"))));
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        loadedModules.forEach((fileListPair -> {
            fileListPair.getFirst().getName();
            URL[] urls;
            try {
            urls = new URL[]{fileListPair.getFirst().toURL()};
            URLClassLoader cl = new URLClassLoader(urls);
            Class<?> c = Class.forName("skyenchants.skyenchants.SkyEnchants", true, cl);
            Method m = c.getDeclaredMethod("onEnable");
            Object o = c.newInstance();
            m.invoke(o);
            } catch (MalformedURLException | NoSuchMethodException | InstantiationException | ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }));
    }

    public List<String> scanDepends(File file) throws FileNotFoundException {
        List<String> depends = new LinkedList<>();
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) depends.add(scanner.nextLine());

        return depends;
    }
}
