package edu.iuh.fit.se.bookbe.services.impl;

import edu.iuh.fit.se.bookbe.entities.Book;
import edu.iuh.fit.se.bookbe.repositories.BookRepository;
import edu.iuh.fit.se.bookbe.services.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Khánh Đinh
 * Date:   10/30/2025
 * Time:   11:12 AM
 */
@Service
public class BookServiceImpl implements IBookService {

    private  final BookRepository repo;

    public BookServiceImpl(BookRepository repo) {
        this.repo = repo;
    }


    @Override
    public List<Book> findAll() {
        return repo.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Book create(Book b) {
        return repo.save(b);
    }

    @Override
    public Book update(Integer id, Book b) {
        Book old = repo.findById(id).orElse(null);
        if(old==null) return null;
        old.setTitle(b.getTitle());
        old.setAuthor(b.getAuthor());
        old.setIsbn(b.getIsbn());
        old.setPrice(b.getPrice());
        old.setStock(b.getStock());
        old.setPublishedDate(b.getPublishedDate());
        return repo.save(old);
    }
    @Override
    public void delete(Integer id) {
        repo.deleteById(id);

    }
}
