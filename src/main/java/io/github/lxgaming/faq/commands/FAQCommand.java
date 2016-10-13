package io.github.lxgaming.faq.commands;

import java.util.List;

import io.github.lxgaming.faq.FAQ;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Command;

public class FAQCommand extends Command {
	
	public FAQCommand() {
		super("faq");
	}
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if (args.length == 0) {
			sender.sendMessage(new ComponentBuilder("===== ").color(ChatColor.GOLD).append("FAQ").color(ChatColor.GREEN).append(" =====").color(ChatColor.GOLD).create());
			sender.sendMessage(new ComponentBuilder(" - ").color(ChatColor.GOLD).append("Version 0.1.2").color(ChatColor.AQUA).create());
			sender.sendMessage(new ComponentBuilder(" - ").color(ChatColor.GOLD).append("Author - LX_Gaming").color(ChatColor.AQUA).create());
			sender.sendMessage(new ComponentBuilder("===== ").color(ChatColor.GOLD).append("Commands").color(ChatColor.GREEN).append(" =====").color(ChatColor.GOLD).create());
			List<String> commandList = FAQ.getConfig().getStringList("FAQ.Command");
			for(String command : commandList) {
				sender.sendMessage(new ComponentBuilder(" - FAQ ").color(ChatColor.GOLD).append(command).color(ChatColor.AQUA).create());
			}
			return;
		}
		
		if (args.length == 1) {
			List<String> messageList = FAQ.getConfig().getStringList("FAQ.Message." + args[0].toLowerCase());
			for(String message : messageList) {
				sender.sendMessage(new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', message)).create());
			}
			return;
		}
		sender.sendMessage(new ComponentBuilder("Invalid Command").color(ChatColor.RED).create());
		return;
	}
}