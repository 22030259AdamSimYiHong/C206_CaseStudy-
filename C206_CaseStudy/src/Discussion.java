/**
 * I declare that this code was writn by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism 
 *
 * 22012568,3 Aug 202311:27:13 pm
 */

/**
 * @author 22012568
 *
 */
public class Discussion extends Tag{
	private String topic;
	private String question;
	/**
	 * @return the topic
	 */
	
	
	public String getTopic() {
		return topic;
	}
	/**
	 * @param topic
	 * @param question
	 */
	
	/**
	 * @param difficulty
	 * @param topic
	 * @param question
	 */
	public Discussion(String difficulty, String topic, String question) {
		super(difficulty);
		this.topic = topic;
		this.question = question;
	}

	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	
	

}
