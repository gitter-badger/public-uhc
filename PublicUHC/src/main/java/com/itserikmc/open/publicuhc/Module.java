package com.itserikmc.open.publicuhc;

/*
 *
 * This project is under the licenses and terms stated at
 * https://raw.githubusercontent.com/ItsErikMC/public-uhc/master/LICENSE.md
 *
 */

import org.bukkit.Bukkit;

public abstract class Module {

    String name;
    boolean core;

    public Module(String name, boolean core) {
        this.name = name;
        this.core = core;
        if(!getClass().getPackage().getName().startsWith("com.itserikmc.open.publicuhc")) {
            throw new RuntimeException("You cannot use Module(String name, boolean core). Please use Module(String) instead.");
        }
    }

    public Module(String name) {
        this(name, false);
    }

    public abstract void Enable();
    public abstract void Disable();
}
