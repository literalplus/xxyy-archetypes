package io.github.xxyy.sampleplugin;

import io.github.xxyy.common.xyplugin.SqlXyGamePlugin;
import io.github.xxyy.common.sql.SqlConnectable;

import java.io.File;

/**
 * Briefly describe the purpose of your plugin here.
 *
 * @author <a href="http://xxyy.github.io/">xxyy</a>
 * @since 1.0
 */
public class SamplePlugin extends SqlXyGamePlugin {
    @Override
    public void enable() {
        try {
            //Init your plugin here

            getLogger().info("Enabled " + getPluginVersion().toString());
        } catch (Exception e) {
            e.printStackTrace();
            getServer().getConsoleSender().sendMessage("§4~~~~~ SamplePlugin failed to enable ~~~~");
            getServer().getConsoleSender().sendMessage(getPluginVersion().toString());
            setEnabled(false);
        }
    }

    @Override
    public void disable() {
        //Deinit your plugin here
    }

    @Override
    protected void initConfig() {
        saveDefaultConfig();

        if (getConfig().getString("sql.password").equals("pleasechangeme")) {
            setEnabled(false);
            getServer().getConsoleSender().sendMessage("§e~~~~~ Generated SamplePlugin configuration! ~~~~"); //Logger doesn't understand formatting codes
            getServer().getConsoleSender().sendMessage("§ePlease insert your SQL credentials there.");
            getServer().getConsoleSender().sendMessage("§eFile path: " + new File(getDataFolder()));
            return;
        }
    }

    @Override
    public String getChatPrefix() {
        return "§3[§2SP§3]";
    }

    @Override
    protected SqlConnectable getConnectable() {
        return new SqlConnectable() {
            @Override
            public String getSqlDb() {
                return getConfig().getString("sql.database");
            }

            @Override
            public String getSqlHost() {
                return getConfig().getString("sql.host");
            }

            @Override
            public String getSqlPwd() {
                return getConfig().getString("sql.password");
            }

            @Override
            public String getSqlUser() {
                return getConfig().getString("sql.user");
            }
        };
    }

    @Override
    public void setError(String desc, String caller) {
        throw new UnsupportedOperationException("XYC error: " + desc + " at " + caller);
    }
}
