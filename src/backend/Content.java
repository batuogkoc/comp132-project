package backend;

import java.time.LocalDateTime;
/***
 * backend component of the contents. Stores all relevant info and provides view-independant functionality like deletion.
 * @author batu
 *
 */
public class Content implements Comparable<Content>{
	private final User author; //author of the content
	private final String title; //title of content
	private final LocalDateTime timeOfCreation; //when the content was created
	private final ContentContainer contentDestination; //where this content belongs to, can be a user or a group. Used for when the content is deleted
	private String text; //text of the contetn
	private String imagePath; //path to image if there is any. value of "" means there is no image.
	
	/**
	 * Constructor of the content. Does input checks and initialises the creation time.
	 * @param contentDestination the contentContainer that is the owner of this content. Can be group or user
	 * @param author
	 * @param title
	 * @param text
	 * @throws IllegalArgumentException thrown when title is ""
	 */
	public Content(ContentContainer contentDestination, User author, String title, String text) throws IllegalArgumentException{
		super();
		this.timeOfCreation = LocalDateTime.now();
		this.author = author;
		if(title.equals("")) {
			throw new IllegalArgumentException("Invalid title");
		}
		this.contentDestination = contentDestination;
		this.title = title;
		this.text = text;
		this.contentDestination.addContent(this);
	}
	
	/**
	 * Constructor with the image path. Does input checks and initialises the creation time.
	 * @param contentDestination the contentContainer that is the owner of this content. Can be group or user
	 * @param author
	 * @param title
	 * @param text
	 * @param imagePath Path to the image. "" if no image is used
	 * @throws IllegalArgumentException thrown when title is ""
	 */
	public Content(ContentContainer contentDestination, User author, String title, String text, String imagePath) throws IllegalArgumentException{
		super();
		this.timeOfCreation = LocalDateTime.now();
		this.author = author;
		this.title = title;
		if(title.equals("")) {
			throw new IllegalArgumentException("Invalid title");
		}
		this.contentDestination = contentDestination;
		this.text = text;
		this.imagePath = imagePath;
		this.contentDestination.addContent(this);
	}

	/**
	 * compareTo method. Contens are sorted according to their creation times from most to least recent.
	 */
	@Override
	public int compareTo(Content c) {
		return -this.timeOfCreation.compareTo(c.timeOfCreation);
	}
	/**
	 * Functionally deletes the content by removing it from the owner's contentContainer. Garbage collector will actually delete it later
	 * @return
	 */
	public boolean delete() {
		return this.contentDestination.removeContent(this);
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public User getAuthor() {
		return author;
	}
	public String getTitle() {
		return title;
	}
	public LocalDateTime getTimeOfCreation() {
		return timeOfCreation;
	}
}
