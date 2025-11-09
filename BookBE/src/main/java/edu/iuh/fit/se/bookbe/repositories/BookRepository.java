package edu.iuh.fit.se.bookbe.repositories;

import edu.iuh.fit.se.bookbe.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Khánh Đinh
 * Date:   10/30/2025
 * Time:   11:10 AM
 */
public interface BookRepository extends JpaRepository<Book,Integer> {
    boolean existsByIsbn(String isbn);



}
