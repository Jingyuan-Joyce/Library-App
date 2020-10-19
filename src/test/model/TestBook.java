package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TestBook {
    Book oneBook;
    Library testLibrary;

    @BeforeEach
    public void setup() {

        oneBook = new Book("jj", 12, 989);
        testLibrary = new Library();
    }

    @Test
    public void testBookConstructor() {
        assertEquals("jj", oneBook.getName());
        assertEquals(12, oneBook.getNumber());
        assertEquals(989, oneBook.getLength());

    }

    @Test
    public void testSetPublicationLocationChangeLocation(){
        Library anotherLibrary = new Library();
        anotherLibrary.addPublication(oneBook);
        assertEquals(anotherLibrary,oneBook.getPublicationLocation());
        assertEquals(1,anotherLibrary.librarySize());
        oneBook.assignToLibrary(testLibrary);
        assertTrue(testLibrary.equals(oneBook.getPublicationLocation()));
        assertEquals(0,anotherLibrary.librarySize());
        assertEquals(1,testLibrary.librarySize());
    }
    @Test
    public void testRemoveFromLibraryNotAssign(){
        Book book2 = new Book("kk",15,76);
        testLibrary.addPublication(book2);
        oneBook.removeFromLibrary();
        assertEquals(1,testLibrary.librarySize());
        assertTrue(testLibrary.getPublicationMap().containsValue(book2));

    }
    @Test
    public void testRemoveFromLibraryAlreadyAssign(){
        testLibrary.addPublication(oneBook);
        assertEquals(1,testLibrary.getPublicationMap().size());
        assertTrue(testLibrary.getPublicationMap().containsValue(oneBook));
        oneBook.removeFromLibrary();
        assertEquals(0,testLibrary.getPublicationMap().size());
        assertFalse(testLibrary.getPublicationMap().containsValue(oneBook));
    }



    @Test
    public void testSetBookName() {
        oneBook.setName("bang");
        assertEquals("bang", oneBook.getName());

    }

    @Test
    public void testTimeSpentOn() {
        oneBook.setLength(888);
        assertEquals(888, oneBook.timeSpendOn());
    }

    @Test
    public void testToString() {
        String[] tokens = oneBook.toString().split("// ");
        for (String s : tokens) {
            s.equals(oneBook.getName());
            s.equals("12");
            s.equals("989");
        }
    }

    @Test
    public void testEquals() {
        Book anotherBook = new Book("jj", 11, 989);
        assertFalse(anotherBook.equals(oneBook));
    }

    @Test
    public void testEqualsOnlyNumberSame(){
        Book anotherBook = new Book("aha",12,144);
        assertTrue(anotherBook.equals(oneBook));
    }

}
