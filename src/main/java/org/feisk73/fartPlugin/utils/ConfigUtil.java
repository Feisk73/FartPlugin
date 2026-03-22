package org.feisk73.fartPlugin.utils;

import cn.nukkit.utils.Config;

public class ConfigUtil {

    private static Config config;
    private static double cachedSpeed;
    private static double cachedGravity;
    private static int cachedSteps;

    public static void init(Config config) {
        ConfigUtil.config = config;
        reload();
    }
    public static void reload() {
        cachedSpeed = config.getDouble("trajectory.speed", 2.0);
        cachedGravity = config.getDouble("trajectory.gravity", 0.8);
        cachedSteps = config.getInt("trajectory.steps", 50);
    }

    public static double getSpeed() {
        return cachedSpeed;
    }
    public static double getGravity() {
        return cachedGravity;
    }
    public static int getSteps() {
        return cachedSteps;
    }
}
