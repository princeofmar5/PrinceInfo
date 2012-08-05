package com.github.princeofmar5;

import org.bukkit.plugin.java.JavaPlugin;

public class PrinceInfo extends JavaPlugin
{
	private PrinceInfoCommandExecutor myExecutor;
	
	public void onEnable()
	{
		getConfig();
		myExecutor = new PrinceInfoCommandExecutor(this);
		getCommand("pinfo").setExecutor(myExecutor);
		getCommand("pireload").setExecutor(myExecutor);
		getCommand("plist").setExecutor(myExecutor);
		getLogger().info("PrinceInfo enabled!");
	}
	
	public void onDisable()
	{
		getLogger().info("PrinceInfo disabled!");
	}
}
