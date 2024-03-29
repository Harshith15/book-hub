package syr.edu.booksinventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import syr.edu.booksinventory.model.Book;
import syr.edu.booksinventory.service.BookService;
import java.util.List;


@RestController
@RequestMapping(path = "/api/book") // This means URL's start with /api/book (after Application path)
public class BookController {

    @Autowired // This means to get the bean called bookService
    // Which is auto-generated by Spring, we will use it to get the services of the book
    private BookService bookService;

    // This map the GET Requests and shows all the books present in the DB
    @GetMapping(path = "/all")
    public @ResponseBody List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    /**
     * This map the POST Requests. It calls the service to buy a book.
     *
     * @param  id the id of the book
     * @return A String "Success" or "Failure"
     */
    @PostMapping(path = "/buy")
    public @ResponseBody String buyBook(@RequestParam long id) {
        return bookService.buyBook(id);
    }

    /**
     * This map the POST Requests. It calls the service to sell a book.
     *
     * @param  id the id of the book
     * @return A String "Success + Price" or "Failure"
     */
    @PostMapping(path = "/sell")
    public @ResponseBody String sellBook(@RequestParam long id) {
        return bookService.sellBook(id);
    }

    /**
     * This map the POST Requests. It calls the service to add a book.
     *
     * @param isbn           a unique number given to each book
     * @param title          Title of the book
     * @param author         Author(s) of the Book
     * @param yearPublished  Year the Book got Published
     * @param edition        Edition of the Book
     * @param price          Cost of the Book
     * @return A String "Success + Price" or "Failure"
     */
    @PostMapping(path = "/add")
    public @ResponseBody String addBook(@RequestParam String isbn,
                                        @RequestParam String title,
                                        @RequestParam String author,
                                        @RequestParam String yearPublished,
                                        @RequestParam String edition,
                                        @RequestParam Float price) {
        return bookService.addBook(isbn, title, author, yearPublished, edition, price);
    }

}
