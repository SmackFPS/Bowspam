package me.mike1665.mcbow;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class InteractListener
  implements Listener
{
  Main m;

  @EventHandler
  public void onInteract(PlayerInteractEvent e)
  {
    if (e.getAction() != Action.RIGHT_CLICK_AIR) {
      System.out.println(e.getAction().toString());
      return;
    }
    Player p = e.getPlayer();
    if (p.getItemInHand() == null) {
      System.out.println(p.getItemInHand().toString());
      return;
    }
    ItemStack item = p.getItemInHand();
    if (item.getType() != Material.BOW) {
      System.out.println(item.getType().toString());
      return;
    }
    if (!p.getInventory().contains(Material.ARROW)) {
      System.out.println(p.getInventory().contains(Material.ARROW));
      return;
    }
    Arrow arrow = (Arrow)p.launchProjectile(Arrow.class);
    arrow.setVelocity(arrow.getVelocity().multiply(2).normalize());
    p.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.ARROW, 1) });
  }
}