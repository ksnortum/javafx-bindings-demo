package net.snortum.javafx.bindingsdemo;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BookController {
	
	private Stage stage;
	private int index = 0; 
	List<Book> books = new ArrayList<>();
	
	@FXML private TextField author;
	@FXML private TextField title;
	@FXML private TextField isbn;
	@FXML private Button previous;
	@FXML private Button next;
	@FXML private Button exit;
	
	@FXML
	private void initialize() {
		loadBooks();
		bindCurrentBook();
	}
	
	void setStage(Stage stage) {
		this.stage = stage;
	}

	private void loadBooks() {
		books.add(new Book("Herman Melville", "Moby-Dick", "9781974305032"));
		books.add(new Book("J. D. Salinger", "Catcher in the Rye", "9788970120676"));
		books.add(new Book("Ernest Hemingway", "For Whom the Bell Tolls", "9788432000638"));
		books.add(new Book("Harper Lee", "To Kill a Mockingbird", "9788931001990"));
		index = 0;
	}

	@FXML
	private void handleExitAction(ActionEvent event) {
		stage.close();
	}
	
	@FXML
	private void handleNextAction(ActionEvent event) {
		unbindCurrentBook();
		index = nextIndex();
		bindCurrentBook();
	}
	
	@FXML
	private void handlePrevAction(ActionEvent event) {
		unbindCurrentBook();
		index = prevIndex();
		bindCurrentBook();
	}
	
	private int nextIndex() {
		index++;
		return index > books.size() - 1 ? 0 : index; 
	}
	
	private int prevIndex() {
		index--;
		return index < 0 ? books.size() - 1 : index;
	}

	private void unbindCurrentBook() {
		Book book = books.get(index);
     	author.textProperty().unbindBidirectional(book.authorProperty());
		title.textProperty().unbindBidirectional(book.titleProperty());
		isbn.textProperty().unbindBidirectional(book.isbnProperty());
	}
	
	private void bindCurrentBook() {
		Book book = books.get(index);
		author.textProperty().bindBidirectional(book.authorProperty());
		title.textProperty().bindBidirectional(book.titleProperty());
		isbn.textProperty().bindBidirectional(book.isbnProperty());
	}
}
