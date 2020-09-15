package spicy.chatCommands.commands;

import spicy.SpicyClient;
import spicy.chatCommands.Command;

public class Name extends Command {

	public Name() {
		super("name", "name <clientName>", 1);
	}
	
	@Override
	public void commandAction(String message) {
		
		String[] splitMessage = message.split(" ");
		String clientName = "";
		
		for (String s : splitMessage) {
			clientName += s + " ";
		}
		
		clientName = clientName.replaceFirst(".name ", "");
		
		SpicyClient.config.clientName = clientName.substring(0, clientName.length() - 1);
		SpicyClient.config.clientVersion = "";
		
	}
	
	@Override
	public void incorrectParameters() {
		sendPrivateChatMessage("Please use .name <clientName>");
	}
	
}
