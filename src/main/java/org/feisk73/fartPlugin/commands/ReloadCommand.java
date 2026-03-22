package org.feisk73.fartPlugin.commands;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import org.feisk73.fartPlugin.utils.ConfigUtil;

public class ReloadCommand extends Command {
    public ReloadCommand() {
        super("fartreload", "Reload FartPlugin config");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!sender.hasPermission("fartplugin.command.reload")) return false;
        ConfigUtil.reload();
        sender.sendMessage("[FartPlugin] Config reloaded");
        return true;
    }
}
