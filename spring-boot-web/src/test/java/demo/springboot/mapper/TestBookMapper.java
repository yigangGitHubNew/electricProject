package demo.springboot.mapper;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonAlias;
import demo.springboot.domain.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBookMapper {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testList(){
        List<Book> books = bookMapper.selectBookList();
        System.out.println(JSONArray.toJSONString(books));
    }

    @Test
    public void insert(){
        Book book = new Book();
        book.setIntroduction("这是一本很不错的书");
        book.setName("java");
        book.setWriter("java");
        bookMapper.insert(book);
        System.out.println(JSONArray.toJSONString(book));
    }

    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setId(5L);
        book.setWriter("mysql");
        book.setName("mysql");
        book.setIntroduction("mysql");
        bookMapper.update(book);
        System.out.println(JSONArray.toJSONString(book));
    }

    @Test
    public void testDelete(){
        bookMapper.delete(5L);
    }

    @Test
    public void testFindById(){
        Book book = bookMapper.findById(1L);
        Assert.assertTrue("张三".equals(book.getWriter()));
    }
}
