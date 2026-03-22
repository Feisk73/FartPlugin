    package org.feisk73.fartPlugin;

    import cn.nukkit.plugin.PluginBase;
    import org.feisk73.fartPlugin.commands.FartCommand;
    import org.feisk73.fartPlugin.commands.PissCommand;
    import org.feisk73.fartPlugin.commands.ReloadCommand;
    import org.feisk73.fartPlugin.commands.SpitCommand;
    import org.feisk73.fartPlugin.utils.ConfigUtil;

    import java.util.List;

    public class Main extends PluginBase {
        private final String pluginName = "fartplugin";

        @Override
        public void onEnable() {
            this.saveDefaultConfig();
            this.reloadConfig();
            ConfigUtil.init(getConfig());
            this.getLogger().info("Fart plugin enabled");
            this.getServer().getCommandMap().registerAll(pluginName,
                    List.of(
                            new FartCommand(),
                            new PissCommand(),
                            new SpitCommand(),
                            new ReloadCommand()
                    ));

        }

        @Override
        public void onDisable() {
            this.getLogger().info("Fart plugin disabled");
        }
    }