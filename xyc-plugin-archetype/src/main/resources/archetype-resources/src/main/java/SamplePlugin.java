package io.github.xxyy.sampleplugin;

import io.github.xxyy.common.xyplugin.GenericXyPlugin;

/**
 * Briefly describe the purpose of your plugin here.
 *
 * @author <a href="http://xxyy.github.io/">xxyy</a>
 * @since 1.0
 */
public class SamplePlugin extends GenericXyPlugin {
    @Override
    public void enable() {
        //Init your plugin here
        initConfig();

        getLogger().info("Enabled " + getPluginVersion().toString());
    }

    @Override
    public void disable() {
        //Deinit your plugin here
    }

    @Override
    public String getChatPrefix() {
        return "§3[§2SP§3]";
    }

    private void initConfig() {
        getConfig().options().copyDefaults(true);
        getConfig().options().header("SamplePlugin config file - Use valid YAML!\n" +
                "Test your YAML file using https://yaml-online-parser.appspot.com/ before\n" +
                "saving to ensure you got the syntax right!\n\n" +
                "If you have trouble configuring this plugin, join #lit on irc.spi.gt, ask\n" +
                "your question and patiently wait for an answer. If you don't know how to,\n" +
                "just click here: https://irc.spi.gt/iris/?channels=lit");
        getConfig().options().copyHeader(true);
    }
}
