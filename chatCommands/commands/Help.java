package spicy.chatCommands.commands;

import spicy.SpicyClient;
import spicy.chatCommands.Command;

public class Help extends Command {

	public Help() {
		super("help", "help", 0);
	}
	
	@Override
	public void commandAction(String message) {
		
		sendPrivateChatMessage("-----Help Menu-----");
		
		for (Command c : SpicyClient.commandManager.commands) {
			sendPrivateChatMessage(SpicyClient.commandManager.prefix + c.helpText);
		}
		
		sendPrivateChatMessage("-------------------");
		
	}
	
}
