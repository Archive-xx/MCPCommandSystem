package spicy.chatCommands;

import java.rmi.activation.ActivationGroupDesc.CommandEnvironment;
import java.util.ArrayList;

import spicy.chatCommands.commands.*;
import spicy.events.listeners.EventChatmessage;

public class CommandManager {
	
	// This will add all of the commands to the list when the command manager is created
	public CommandManager() {
		
		addCommand(new Help());
		addCommand(new Toggle());
		addCommand(new Name());
		addCommand(new Config());
		addCommand(new Say());
		
	}
	
	public String prefix = ".";
	
	// Contains all of the commands
	public ArrayList<Command> commands = new ArrayList<Command>();
	
	// Adds a command to the command list
	public void addCommand(Command c) {
		commands.add(c);
	}
	
	// Runs the commands
	public void runCommands(EventChatmessage e) {
		
		String message = e.message;
		
		if (e.canceled) {
			return;
		}
		
		boolean commandDone = false;
		
		for (Command c : commands) {
			
			if (message.toLowerCase().startsWith(prefix.toLowerCase() + c.command.toLowerCase())) {
				
				if (c.parameters == 0) {
					c.commandAction(message);
					commandDone = true;
				}else {
					
					String[] messageSplit = message.split(" ");
					
					if (c.parameters + 1 <= messageSplit.length) {
						c.commandAction(message);
						commandDone = true;
					}else {
						c.incorrectParameters();
						commandDone = true;
					}
					
				}
				
			}
			
		}
		
		if (!commandDone) {
			Command.sendPrivateChatMessage("Unknown command, please do .help to view all of the commands");
		}
		
	}
	
}
