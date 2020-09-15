package spicy.chatCommands.commands;

import spicy.SpicyClient;
import spicy.chatCommands.Command;

public class Say extends Command {

	public Say() {
		super("say", "say <message>", 1);
	}
	
	@Override
	public void commandAction(String message) {
		
		String[] splitMessage = message.split(" ");
		String publicMessage = "";
		
		for (String s : splitMessage) {
			publicMessage += s + " ";
		}
		
		publicMessage = publicMessage.replaceFirst(".say ", "");
		publicMessage = publicMessage.substring(0, publicMessage.length() - 1);
		
		sendPublicChatMessage(publicMessage);
		
	}
	
	@Override
	public void incorrectParameters() {
		sendPrivateChatMessage("Please use .name <ClientName>");
	}
	
}
