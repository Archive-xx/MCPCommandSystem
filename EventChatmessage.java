package spicy.events.listeners;

import net.minecraft.entity.player.EntityPlayerMP;
import spicy.events.Event;

public class EventChatmessage extends Event<EventChatmessage> {
	
	public String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
