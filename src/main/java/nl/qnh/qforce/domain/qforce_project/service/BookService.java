package nl.qnh.qforce.domain.qforce_project.service;

import nl.qnh.qforce.domain.qforce_project.exception.RecordNotFoundException;
import nl.qnh.qforce.domain.qforce_project.model.Book;
import nl.qnh.qforce.domain.qforce_project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book getBook(int id){
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()){
            return optionalBook.get();
        }
        else{
            throw new RecordNotFoundException("ID does not exist");
        }

    }

    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }

    public int addBook(Book book){
        Book newBook = bookRepository.save(book);
        return newBook.getId();
    }

    public void updateBook(int id, Book book){
        Book existingBook = bookRepository.findById(id).orElse(null);

        if (!book.getTitle().isEmpty()) {
            existingBook.setTitle(book.getTitle());
        }
        if (!book.getAuthor().isEmpty()) {
            existingBook.setAuthor(book.getAuthor());
        }
        if (!book.getIsbn().isEmpty()) {
            existingBook.setIsbn(book.getIsbn());
        }
        bookRepository.save(existingBook);
    }

    public void partialUpdateBook(int id, Book book){
        Book existingBook = bookRepository.findById(id).orElse(null);

        if (!(book.getTitle() == null) && !book.getTitle().isEmpty()) {
            existingBook.setTitle(book.getTitle());
        }
        if (!(book.getAuthor() == null) &&!book.getAuthor().isEmpty()) {
            existingBook.setAuthor(book.getAuthor());
        }
        if (!(book.getIsbn() == null) &&!book.getIsbn().isEmpty()) {
            existingBook.setIsbn(book.getIsbn());
        }
        bookRepository.save(existingBook);
    }

}
