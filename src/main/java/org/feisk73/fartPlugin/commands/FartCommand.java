package org.feisk73.fartPlugin.commands;

import cn.nukkit.level.ParticleEffect;
import cn.nukkit.math.Vector3;

public class FartCommand extends BaseCommand {
    public FartCommand() {
        super("fart", "fart command");
        permission = "fartplugin.command.fart";
        particleEffect = ParticleEffect.CAMERA_SHOOT_EXPLOSION;
        particleOffset = new Vector3(0, 0.5, 0);
        soundName = "fartSound";
    }
}