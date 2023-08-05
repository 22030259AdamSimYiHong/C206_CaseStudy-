import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism 
 *
 * 22012568,3 Aug 202311:28:23 pm
 */

/**
 * @author 22012568
 *
 */
public class Event extends Tag{
	private String eventName;
	private LocalDate eventDate;
	private LocalTime eventTime;
	private String venue;
	/**
	 * @return the eventName
	 */
	
	public String getEventName() {
		return eventName;
	}
	/**
	 * @param eventName
	 * @param eventDate
	 * @param eventTime
	 * @param venue
	 */
	public Event(String tag,String eventName, LocalDate eventDate, LocalTime eventTime, String venue) {
		super(tag);
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.venue = venue;
	}
	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	/**
	 * @return the eventDate
	 */
	public LocalDate getEventDate() {
		return eventDate;
	}
	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
	/**
	 * @return the eventTime
	 */
	public LocalTime getEventTime() {
		return eventTime;
	}
	/**
	 * @param eventTime the eventTime to set
	 */
	public void setEventTime(LocalTime eventTime) {
		this.eventTime = eventTime;
	}
	/**
	 * @return the venue
	 */
	public String getVenue() {
		return venue;
	}
	/**
	 * @param venue the venue to set
	 */
	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	
	
	
}
