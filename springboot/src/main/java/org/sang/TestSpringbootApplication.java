package org.sang;

import beans.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan(basePackages = {"beans","org.sang"})
public class TestSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringbootApplication.class, args);
	}

    @Value(value = "${book.author}")
    private String bookAuthor;

	@Autowired
	private BookBean bookBean;


	@RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
    String hello(){
		System.out.print(bookAuthor);
		System.out.print(bookBean);
	    return bookBean.getAuthor();
    }

}
