package backend;

import java.time.LocalDateTime;

public class Content implements Comparable<Content>{
	private final User author;
	private final String title;
	private final LocalDateTime timeOfCreation;
	private String text;
	private String imagePath;
	
	public Content(User author, String title, String text) {
		super();
		this.timeOfCreation = LocalDateTime.now();
		this.author = author;
		this.title = title;
		this.text = text;
	}
	public Content(User author, String title, String text, String imagePath) {
		super();
		this.timeOfCreation = LocalDateTime.now();
		this.author = author;
		this.title = title;
		this.text = text;
		this.imagePath = imagePath;
	}

	
	public int compareTo(Content c) {
		return this.timeOfCreation.compareTo(c.timeOfCreation);
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
