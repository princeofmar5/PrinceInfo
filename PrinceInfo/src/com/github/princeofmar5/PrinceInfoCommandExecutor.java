package com.github.princeofmar5;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrinceInfoCommandExecutor implements CommandExecutor 
{
	PrinceInfo plugin;
	
	public PrinceInfoCommandExecutor(PrinceInfo instance) 
	{
		plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		Player player = null;
		if (sender instanceof Player) 
		{
			player = (Player) sender;
		}
		
		if (cmd.getName().equalsIgnoreCase("pireload"))
		{
			if (sender.hasPermission("princeinfo.reload"))
			{
				if (args.length > 0)
				{
					sender.sendMessage("Too Many Arguments!");
					return false;
				} else
				{
					plugin.reloadConfig();
					sender.sendMessage(ChatColor.GREEN + "Reloaded PrinceInfo!");
					return true;
				}
			} else
			{
				sender.sendMessage("You don't have permission!");
				return true;
			}
		}
		if (player == null)
		{
			sender.sendMessage("You need to be a player to use this command");
		} else
		{
			if (cmd.getName().equalsIgnoreCase("pinfo"))
			{
				if (args.length > 1)
				{
					sender.sendMessage("Too Many Arguments!");
					return false;
				}
				if (args.length < 1)
				{
					sender.sendMessage("Not Enough Arguments!");
					return false;
				} else
				{
					List<String> argList = plugin.getConfig().getStringList("arglist");
					
					if (argList.contains(args[0]))
					{
						for (String s : plugin.getConfig().getStringList(args[0]))
						{
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
		                }
		                return true;
					} else
					{
		                sender.sendMessage(args[0] + " is not in the config!");
		                return true;
					}
				}
			}
			if (cmd.getName().equalsIgnoreCase("plist"))
			{
				if (args.length > 0)
				{
					sender.sendMessage("Too Many Arguments!");
					return false;
				} else
				{
					for (String s : plugin.getConfig().getStringList("arglist"))
					{
						sender.sendMessage(s);
					}
					return true;
				}
			}
		}
		
		return false;
	}

}
