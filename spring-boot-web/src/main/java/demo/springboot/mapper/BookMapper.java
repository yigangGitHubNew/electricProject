package demo.springboot.mapper;

import demo.springboot.domain.Book;

import java.util.List;

public interface BookMapper {
    List<Book> selectBookList();

    int insert(Book book);

    int update(Book book);

    int delete(Long id);

    Book findById(Long id);
}
