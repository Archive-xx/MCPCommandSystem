package spicy.chatCommands.commands;

import java.io.IOException;

import spicy.SpicyClient;
import spicy.chatCommands.Command;
import spicy.files.FileManager;

public class Config extends Command {

	public Config() {
		super("config", "config <save/load> <configName>", 2);
	}
	
	@Override
	public void commandAction(String message) {
		
		String[] splitMessage = message.split(" ");
		String configName = "";
		
		for (int i = 0; i < splitMessage.length; i++) {
			if (i >= 2) {
				configName += splitMessage[i] + " ";
			}
		}
		
		configName = configName.replaceFirst(".config ", "");
		configName = configName.substring(0, configName.length() - 1);
		
		if (splitMessage[1].equalsIgnoreCase("save")) {
			try {
				sendPrivateChatMessage("Saving the config...");
				FileManager.save_config(configName);
				sendPrivateChatMessage("Config saved");
			} catch (IOException e) {
				sendPrivateChatMessage("Failed to save config");
				e.printStackTrace();
			}
		}
		else if (splitMessage[1].equalsIgnoreCase("load")) {
			try {
				sendPrivateChatMessage("Loading the config...");
				FileManager.load_config(configName);
				sendPrivateChatMessage("Config loaded");
			} catch (IOException e) {
				sendPrivateChatMessage("Failed to load config");
				e.printStackTrace();
			}
		}else {	
			incorrectParameters();
		}
		
	}
	
	@Override
	public void incorrectParameters() {
		sendPrivateChatMessage("Please use .config <save/load> <configName>");
	}
	
}
