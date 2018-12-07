package demo.springboot.service.impl;

import demo.springboot.domain.Book;
import demo.springboot.mapper.BookMapper;
import demo.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Book 业务层实现
 *
 * Created by bysocket on 30/09/2017.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> findAll() {
        return bookMapper.selectBookList();
    }

    @Override
    public Book insertByBook(Book book) {
        bookMapper.insert(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        bookMapper.update(book);
        return book;
    }

    @Override
    public Book delete(Long id) {
        bookMapper.delete(id);
        return null;
    }

    @Override
    public Book findById(Long id) {
        return bookMapper.findById(id);
    }
}
