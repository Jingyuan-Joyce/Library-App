//package test;
//
//import model.Book;
//import model.Library;
//import org.junit.jupiter.api.BeforeEach;
//
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class TestSavable {
//    Library library;
//    Book book;
//  //  call save,
//
//    @BeforeEach
//    public void setup() {
//        library = new Library();
//        book = new Book("ee","tt",13,31);
//    }
//
//    public void testSavable() throws IOException {
//        library.savable(book);
//        library.loadable();
//        assertEquals(book,library.getLibrary().get(13));
//
//    }
//
//
//}
