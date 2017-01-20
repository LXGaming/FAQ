/*
 * Copyright 2017 Alex Thomson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
