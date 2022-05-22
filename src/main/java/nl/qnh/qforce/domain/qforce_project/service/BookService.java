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

    public Iterable<Book> getBooks(String title){
        if (title.isEmpty()){
            return bookRepository.findAll();
        }
        else{
            return bookRepository.findAllByTitle(title);
        }
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

    public int addBook(Book book){
        Book newBook = bookRepository.save(book);
        return newBook.getId();
    }

}
