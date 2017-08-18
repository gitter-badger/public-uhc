package com.itserikmc.open.publicuhc.util;

/*
 *
 * This project is under the licenses and terms stated at
 * https://raw.githubusercontent.com/ItsErikMC/public-uhc/master/LICENSE.md
 *
 */

import com.itserikmc.open.publicuhc.PublicUHC;
import org.bukkit.entity.Player;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilMessages {

    public static void log(Level level, String message) {
        Logger.getLogger("PublicUHC").log(level, message);
    }

    public static String getMessage(String path) {
        return PublicUHC.getInstance().lang.getString(path);
    }

    public static void sendMessage(Player player, String path, String... vars) {
        String message = getMessage(path);
        for(int i = 0; i < vars.length + 1; i++)
            message.replaceAll("{" + i + "}", vars[i]);
    }
}
