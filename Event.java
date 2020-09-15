package spicy.events;

public class Event<T> {
	
	public boolean canceled;
	public EventType type;
	public EventDirection direction;
	
	public boolean isCanceled() {
		return canceled;
	}
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	public EventType getType() {
		return type;
	}
	public void setType(EventType type) {
		this.type = type;
	}
	public EventDirection getDirection() {
		return direction;
	}
	public void setDirection(EventDirection direction) {
		this.direction = direction;
	}
	
	public boolean isPre() {
		if (type == null) {
			return false;
		}
		
		return type == EventType.PRE;
		
	}
	
	public boolean isPost() {
		if (type == null) {
			return false;
		}
		
		return type == EventType.POST;
		
	}
	
	public boolean isIncoming() {
		if (direction == null) {
			return false;
		}
		
		return direction == EventDirection.INCOMING;
		
	}
	
	public boolean isOutgoing() {
		if (direction == null) {
			return false;
		}
		
		return direction == EventDirection.OUTGOING;
		
	}
	
}
