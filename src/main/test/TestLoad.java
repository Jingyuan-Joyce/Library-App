//package test;
//
//import model.Book;
//import model.Library;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class TestLoad {
//    Library library;
//    Book book;
//
//    @BeforeEach
//    public void setup() {
//
//        library = new Library();
//
//
//    }
//
//
//    @Test
//    public void testLoadable() throws IOException {
//
//        book = new Book("ee","ff",12,21);
//        library.addPublication(book);
//
//        library.savable(book);
//        library.loadable();
//        System.out.println(library.getLibrary().values());
//
//        assertTrue(book.compare(library.getLibrary().get(12)));//confirm they are the same
//        assertEquals(1,library.size());
////        library.getBook().values().stream().filter(b -> book.getBookNumber() == b.getBookNumber()).count();
//
//
//    }
//}
