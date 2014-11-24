package me.mike1665.mcbow;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
  implements Listener
{
  public Plugin instance = null;

  public void onEnable()
  {
    this.instance = this;
    Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
    super.onEnable();
  }

  public void onDisable()
  {
    this.instance = null;
    super.onDisable();
  }
}