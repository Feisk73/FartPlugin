package org.feisk73.fartPlugin.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.ParticleEffect;
import cn.nukkit.level.Position;
import cn.nukkit.level.Sound;
import cn.nukkit.math.Vector3;
import cn.nukkit.network.protocol.PlaySoundPacket;

import java.util.Random;

public abstract class BaseCommand extends Command {
    protected ParticleEffect particleEffect = ParticleEffect.TOTEM;
    protected Vector3 particleOffset = new Vector3(0, 0, 0);
    protected String soundName = Sound.RANDOM_TOAST.getSound();
    protected String permission = "";

    public BaseCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        Player player = (Player) sender;
        if (!player.hasPermission(permission)) return false;
        spawnParticle(player);
        playSound(player);
        return true;
    }

    protected void spawnParticle(Player player) {
        Position position = player.getPosition();
        try {
            player.getLevel().addParticleEffect(position.add(particleOffset), particleEffect);
        } catch (IllegalArgumentException e) {
            player.sendMessage("Particle effect not found!");
        }
    }

    protected void playSound(Player player) {
        if (soundName.equals(null)) {
            return;
        }
        float volume = 1;
        float minPitch = 0.5f;
        float maxPitch = 1.5f;

        Random random = new Random();
        float Pitch = minPitch + random.nextFloat() * maxPitch;
        PlaySoundPacket packet = new PlaySoundPacket();
        packet.name = soundName;
        packet.volume = volume;
        packet.pitch = Pitch;
        packet.x = (int) player.getX();
        packet.y = (int) player.getY();
        packet.z = (int) player.getZ();
        player.dataPacket(packet);
    }
}
