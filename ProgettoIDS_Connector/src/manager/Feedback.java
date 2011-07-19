package manager;

public class Feedback {
 private int feedbackName;
 private String description;
 private String title;
 private String author;
 
 
 
public Feedback(int feedbackName, String description, String title,
		String author) {
	this.feedbackName = feedbackName;
	this.description = description;
	this.title = title;
	this.author = author;
}

public int getFeedbackName() {
	return feedbackName;
}
public void setFeedbackName(int feedbackName) {
	this.feedbackName = feedbackName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
 
}
