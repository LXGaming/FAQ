package io.github.lxgaming.faq;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.google.common.io.ByteStreams;

import io.github.lxgaming.faq.commands.FAQCommand;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class FAQ extends Plugin {
	
	private static Configuration config;
	
	@Override
	public void onEnable() {
		getLogger().info("FAQ is Starting!");
		getProxy().getPluginManager().registerCommand(this, new FAQCommand());
		loadConfig();
	}
	
	@Override
	public void onDisable() {
		getLogger().info("FAQ is Stopping!");
	}
	
	public void loadConfig() {
		if(!getDataFolder().exists()) {
			getDataFolder().mkdir();
		}
		File configFile = new File(getDataFolder(), "config.yml");
		if(!configFile.exists()) {
			try {
				configFile.createNewFile();
				try (InputStream is = getResourceAsStream("config.yml"); OutputStream os = new FileOutputStream(configFile)) {
					ByteStreams.copy(is, os);
					getLogger().info("Config Created!");
				}
			}catch (IOException e) {
				throw new RuntimeException("Unable to create configuration file", e);
			}
		}
		try {
			config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Configuration getConfig() {
		return config;
	}
}