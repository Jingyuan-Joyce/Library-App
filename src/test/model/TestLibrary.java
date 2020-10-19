package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class TestLibrary { //what should I test?
    Library testLibrary;//test library, must create library object
    Publication testPublication1;
    Publication testPublication2;
    Publication testPublication3;
    Reader testReader1;
    Reader testReader2;
    Reader testReader3;
//initialize the book,and add it to the library,see if the object is the same as library.get(int number


    @BeforeEach
    public void setup() {
        testLibrary = new Library();
        testReader1 = new Reader("Joyce",55);
        testReader2 = new Reader("Audrey",99);
        testReader3 = new Reader("ivy",66);
        testPublication1 = new Book("qq", 16, 909);
        testPublication2 = new Video("mystery", 25, 99);
        testPublication3 = new Video("yy",55,89);
    }

    @Test
    public void testAddOneBookAlreadyInLibrary(){
        testLibrary.addPublication(testPublication1);
        testLibrary.addPublication(testPublication1);
        assertEquals(1,testLibrary.librarySize());
    }



    @Test
    public void testAddOneBook() {
//        Book oneBook = new Book("ABC", "Joyce", 003, 1997);//do i need to make a book oj again?
//        library.addBook("ABC", "Joyce", 003, 1997);//should I use Library or ArrayList object to call the method?
//        assertTrue("ABC",library.get); //don't use book,use library instead
        testLibrary.addPublication(testPublication1);
        try {
            assertTrue(testPublication1.equals(testLibrary.lookForPublication(16)));
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(1, testLibrary.librarySize());
        assertEquals(testPublication1.getPublicationLocation(),testLibrary);
    }

    @Test
    public void testAddDiffObj() {
        testLibrary.addPublication(testPublication1);
        testLibrary.addPublication(testPublication2);
        try {
            assertTrue(testPublication1.equals(testLibrary.lookForPublication(16)));
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        }
        try {
            assertTrue(testPublication2.equals(testLibrary.lookForPublication(25)));
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(2, testLibrary.librarySize());
        assertEquals(testPublication1.getPublicationLocation(),testLibrary);
        assertEquals(testPublication2.getPublicationLocation(),testLibrary);

    }

    @Test
    public void testLookForBook() {
        testLibrary.addPublication(testPublication1);
        try {
            assertTrue(testPublication1.equals(testLibrary.lookForPublication(testPublication1.getNumber())));
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testLookForDiffObj() {
        testLibrary.addPublication(testPublication1);
        testLibrary.addPublication(testPublication2);
        try {
            assertTrue(testPublication1.equals(testLibrary.lookForPublication(testPublication1.getNumber())));
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        }
        try {
            assertTrue(testPublication2.equals(testLibrary.lookForPublication(testPublication2.getNumber())));
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testBorrowOnePub() {
        testLibrary.addPublication(testPublication1);
        try {
            testLibrary.borrowBook(testPublication1);
        } catch (BookNotFoundException e) {
            fail();
        }

        assertEquals(0, testLibrary.librarySize());

    }

    @Test
    public void testBorrowMultiplePub() {
        testLibrary.addPublication(testPublication1);
        testLibrary.addPublication(testPublication2);
        try {
            testLibrary.borrowBook(testPublication1);
        } catch (BookNotFoundException e) {
            fail();

        }
        try {
            testLibrary.borrowBook(testPublication2);
        } catch (BookNotFoundException e) {
            fail();

        }

        assertEquals(0, testLibrary.librarySize());
    }

    @Test
    public void testBookNotFoundWithNoBook() {
        try {
            testLibrary.borrowBook(testPublication2);
            fail();
        } catch (BookNotFoundException e) {
            System.out.println("No book in library");
        }
    }

    @Test
    public void testBookNotFoundWithOneBookInLibrary() {
        testLibrary.addPublication(testPublication1);
        try {
            testLibrary.borrowBook(testPublication2);
            fail();
        } catch (BookNotFoundException e) {
            System.out.println("One book in library, We don't have this book");

        }

    }

    @Test
    public void testBookNotFoundWithMultipleBookInLibrary() {
        testLibrary.addPublication(testPublication1);
        testLibrary.addPublication(testPublication2);
        try {
            testLibrary.borrowBook(testPublication3);
            fail();
        } catch (BookNotFoundException e) {
            System.out.println("Have book in library, we don't have the book");
        }
    }

    @Test
    public void testSize() {
        testLibrary.addPublication(testPublication1);
        testLibrary.addPublication(testPublication2);
        assertEquals(2, testLibrary.librarySize());
    }

    @Test
    public void testSavable() throws IOException {
        Library anotherLibrary = new Library();
        testLibrary.addPublication(testPublication1);
        testLibrary.addPublication(testPublication2);
        testLibrary.savable("data.txt");
        anotherLibrary.loadable("data.txt");
        assertEquals(anotherLibrary.librarySize(), testLibrary.librarySize());
    }

    @Test
    public void testLoadable() throws IOException {
        Library anotherLibrary = new Library();
        testLibrary.addPublication(testPublication1);
        testLibrary.addPublication(testPublication2);
        testLibrary.savable("data.txt");
        anotherLibrary.loadable("data.txt");
        assertEquals(anotherLibrary.librarySize(), testLibrary.librarySize());


    }
    @Test
    public void testGetCustomerId(){
        assertEquals(55, testReader1.getReaderId());

    }
    @Test
    public void testSetCustomerId(){
        testReader1.setReaderId(99);
        assertEquals(99, testReader1.getReaderId());
    }
    @Test
    public void testGetCustomer(){
        testLibrary.addCustomer(testReader1);
        assertEquals(testReader1,testLibrary.getReader(55));

    }
    @Test
    public void testCrossOutBookWhenBookNotThere(){
        testLibrary.addPublication(testPublication1);
        testLibrary.deletePublication(testPublication2);
        assertEquals(1,testLibrary.librarySize());
        assertTrue(testLibrary.getPublicationMap().containsValue(testPublication1));

    }
    @Test
    public void testCrossOutBookWhenBookIsThere(){
        testLibrary.addPublication(testPublication1);
        testLibrary.addPublication(testPublication2);
        assertEquals(2,testLibrary.librarySize());
        testLibrary.deletePublication(testPublication1);
        assertEquals(1,testLibrary.librarySize());
        assertTrue(testLibrary.getPublicationMap().containsValue(testPublication2));
        assertFalse(testLibrary.getPublicationMap().containsValue(testPublication1));

    }
    @Test
    public void testGetReader(){
        testLibrary.addCustomer(testReader1);
        testLibrary.addCustomer(testReader2);
        testLibrary.addCustomer(testReader3);
        assertEquals(testReader1,testLibrary.getReader(55));
        assertEquals(testReader2,testLibrary.getReader(99));
        assertEquals(testReader3,testLibrary.getReader(66));
    }
    @Test
    public void testAddReader(){
        testLibrary.addCustomer(testReader1);
        assertEquals(1,testLibrary.readerSize());

        assertEquals(testReader1,testLibrary.lookForReader(55));
        assertEquals(testLibrary,testReader1.getReaderLibrary());

    }
    @Test
    public void testReaderSize(){
        testLibrary.addCustomer(testReader1);
        assertEquals(1,testLibrary.readerSize());
    }
    @Test
    public void testRemoveReader(){
        testLibrary.addCustomer(testReader1);
        assertEquals(1,testLibrary.readerSize());
        assertEquals(testReader1,testLibrary.lookForReader(55));

        testLibrary.removeCustomer(55);
        assertEquals(0,testLibrary.librarySize());
        assertEquals(null,testLibrary.lookForReader(55));
    }
    @Test
    public void testContainReaderNo(){
        testLibrary.addCustomer(testReader2);
        assertEquals(null,testLibrary.lookForReader(55));
    }
    @Test
    public void tstContainReaderYes(){
        testLibrary.addCustomer(testReader3);
        assertEquals(testReader3,testLibrary.lookForReader(66));
    }
}
//    @Test
//    public void testPublicationMapInString(){
//        testLibrary.addPublication(testPublication1);
//        testLibrary.getPublicationMapInString()
//    }

//    @Test
//    public void testGetLibrary() {
//        testLibrary.addPublication(testPublication1);
//        String[] tokens = testLibrary.getLibrary().split("// ");
//        for (String s : tokens) {
//            testPublication1.toString() //how to compare the info in library?
//        }
//
//    }


//    @Test
//    public void testLookForBook(){
//        Book aBook= new Book("ABC","Joyce",003,1997);
//        l.addBook("ABC","Joyce",003,1997);
//        assertEquals(aBook.getBookName(),"ABC");
//        assertEquals(aBook.getAuthor(),"Joyce");
//        assertEquals(aBook.getBookNumber(),003);
//        assertEquals(aBook.getYear(),1997);
//        l.lookForBook(003);




