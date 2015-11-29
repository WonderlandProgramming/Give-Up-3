/**
 * 
 */
package dev.wonderland.gameDev.event;

/**
 * This is the base Event and it can be extendet to create more complext Events.
 * 
 * @author Lukas Kannenberg, Lukas Peer
 * @since 09.10.2015
 * @version 0.1
 */
public class Event {
	private Class<? extends Event> type;

	/**
	 * Creates a Event with the given Type
	 * 
	 * @param type
	 *            the type of the Event
	 */
	protected Event(Class<? extends Event> type) {
		this.type = type;
	}

	/**
	 * Gets the ID of the Event
	 * 
	 * @return the ID / Type
	 */
	public Class<? extends Event> getType() {
		return type;
	}
}
