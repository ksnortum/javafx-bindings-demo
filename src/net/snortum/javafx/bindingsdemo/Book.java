package net.snortum.javafx.bindingsdemo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book {
	private StringProperty authorProp = new SimpleStringProperty(this, "author");
	private StringProperty titleProp  = new SimpleStringProperty(this, "title");
	private StringProperty isbnProp = new SimpleStringProperty(this, "isbn");
	
	public Book(String author, String title, String isbn) {
		authorProp.set(author);
		titleProp.set(title);
		isbnProp.set(isbn);
	}

	public StringProperty authorProperty() {
		return authorProp;
	}

	public StringProperty titleProperty() {
		return titleProp;
	}
	
	public StringProperty isbnProperty() {
		return isbnProp;
	}
}
