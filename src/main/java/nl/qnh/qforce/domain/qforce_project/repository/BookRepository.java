package nl.qnh.qforce.domain.qforce_project.repository;

import nl.qnh.qforce.domain.qforce_project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer>{

    Iterable<Book> findAllByTitle(String title); //Make SQL query
//    Iterable<Book> findAllByTitleContainingIgnoreCase(String title); //Make SQL query


}
