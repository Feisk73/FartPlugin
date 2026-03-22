package org.feisk73.fartPlugin.commands;

import cn.nukkit.level.ParticleEffect;
import cn.nukkit.level.Sound;
import cn.nukkit.math.Vector3;

public class SpitCommand extends BaseCommand {
    public SpitCommand() {
        super("spit", "Spit command");
        permission = "fartplugin.command.spit";
        particleEffect = ParticleEffect.LLAMA_SPIT;
        particleOffset = new Vector3(0, 1.5, 2.5);
        soundName = Sound.MOB_LLAMA_SPIT.getSound();
    }
}