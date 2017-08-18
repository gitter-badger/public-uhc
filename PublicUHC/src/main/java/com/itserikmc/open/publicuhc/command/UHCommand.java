package com.itserikmc.open.publicuhc.command;

/*
 *
 * This project is under the licenses and terms stated at
 * https://raw.githubusercontent.com/ItsErikMC/public-uhc/master/LICENSE.md
 *
 */

import com.itserikmc.open.publicuhc.util.UtilMessages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class UHCommand implements CommandExecutor {

    String command;
    String desc;
    String[] aliases;

    public UHCommand(String command, String desc, String... aliases) {
        this.command = command;
        this.desc = desc;
        this.aliases = aliases;
    }

    public abstract void execute();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            UtilMessages.sendMessage((Player) sender, "command.senderNotPlayer");
            return false;
        }
        return false;
    }
}
