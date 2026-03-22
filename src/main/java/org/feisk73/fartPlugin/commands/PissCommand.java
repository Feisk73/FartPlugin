package org.feisk73.fartPlugin.commands;

import cn.nukkit.Player;
import cn.nukkit.level.ParticleEffect;
import cn.nukkit.level.Position;
import org.feisk73.fartPlugin.utils.ConfigUtil;
import org.feisk73.fartPlugin.utils.TrajectoryUtil;

import java.util.List;

public class PissCommand extends BaseCommand {

    public PissCommand() {
        super("piss", "piss command");
        permission = "fartplugin.command.piss";
        particleEffect = ParticleEffect.FALLING_DUST_SAND;
        soundName = null;
    }

    @Override
    protected void spawnParticle(Player player) {
        Position position = player.getPosition();
        double yaw = player.getYaw();
        TrajectoryUtil trajectoryUtil = new TrajectoryUtil(yaw, position, ConfigUtil.getSpeed(), ConfigUtil.getGravity(), ConfigUtil.getSteps());
        List<Position> tragectory = trajectoryUtil.calculate();
        for (Position ignored : tragectory) {
            player.getLevel().addParticleEffect(position, particleEffect);
        }
    }

}