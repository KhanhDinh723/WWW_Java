package edu.iuh.fit.se.bookbe.services;

import edu.iuh.fit.se.bookbe.entities.Book;

import java.util.List;

/**
 * Author: Khánh Đinh
 * Date:   10/30/2025
 * Time:   11:12 AM
 */
public interface IBookService {
    List<Book> findAll();
    Book findById(Integer id);
    Book create (Book b);
    Book update (Integer id, Book b);
    void delete (Integer id);
}
