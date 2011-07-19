package manager;

import java.util.Collection;


public class Post {
private String enclosure;
private String link;
private String category;
private String source;
private String author;
private String description;
private String title;
public Collection<Feedback>feedback;



public Post(String enclosure, String link, String category, String source,
		String author, String description, String title,
		Collection<Feedback> feedback) {
	this.enclosure = enclosure;
	this.link = link;
	this.category = category;
	this.source = source;
	this.author = author;
	this.description = description;
	this.title = title;
	this.feedback = feedback;
}
public String getEnclosure() {
	return enclosure;
}
public void setEnclosure(String enclosure) {
	this.enclosure = enclosure;
}
public String getLink() {
	return link;
}
public void setLink(String link) {
	this.link = link;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
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
public Collection<Feedback> getFeedback() {
	return feedback;
}
public void setFeedback(Collection<Feedback> feedback) {
	this.feedback = feedback;
}


}
