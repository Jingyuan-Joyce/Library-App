package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestReader {

    private Reader reader;
    private Library testLibraryForReader;
    private Library testBigLibrary;
    Publication book;
    Publication video;
    @BeforeEach
    public void setup(){
        testLibraryForReader = new Library();
        reader = new Reader("kim",56);
        testBigLibrary = new Library();
        book = new Book ("happy",12,78);
        video = new Video("lovely",34,88);

    }

    @Test
    public void testSetReaderId(){
        reader.setReaderId(88);
        assertEquals(88,reader.getReaderId());
    }
    @Test
    public void testGetReaderId(){
        assertEquals(56,reader.getReaderId());
    }

    @Test
    public void testSetReaderName(){
        reader.setReaderName("baby");
        assertEquals("baby",reader.getName());
    }
    @Test
    public void testGetReaderName(){
        assertEquals("kim",reader.getName());
    }
    @Test
    public void testEqualsWithSameNameDiffId(){
        Reader reader1 = new Reader("kim",55);
        assertFalse(reader.equals(reader1));
    }
    @Test
    public void testEqualsWithSameNameAndId(){
        Reader reader1 = new Reader("kim",56);
        assertEquals(reader1,reader);

    }
    @Test
    public void testEqualsWithDiffNameAndId(){
        Reader reader1 = new Reader("kylie",44);
        assertFalse(reader.equals(reader1));
    }
    @Test
    public void testEqualsWithDiffNameSameId(){
        Reader reader1 = new Reader("kk",56);
        assertEquals(reader1,reader);
    }
    @Test
    public void testToString(){
        assertEquals("kim56",reader.toString());
    }
    @Test
    public void testGetReaderLibrary(){
        reader.setReaderLibrary(testLibraryForReader);
        assertEquals(testLibraryForReader,reader.getReaderLibrary());
    }
    @Test
    public void testSetReaderLibrary(){
        reader.setReaderLibrary(testLibraryForReader);
        assertEquals(testLibraryForReader,reader.getReaderLibrary());
    }

    @Test
    public void testAssignReaderToNullLibrary(){
        reader.assignReaderToLibrary(null);
        assertEquals(null,reader.getReaderLibrary());
    }

    @Test
    public void testAssignReaderToLibraryNotAssignBefore(){
        reader.assignReaderToLibrary(testLibraryForReader);
        assertEquals(1,testLibraryForReader.readerSize());
        assertEquals(testLibraryForReader,reader.getReaderLibrary());
    }
    @Test
    public void testAssignReaderToLibraryAssignBefore(){
        reader.setReaderLibrary(testBigLibrary);
        reader.assignReaderToLibrary(testLibraryForReader);
        assertEquals(0,testBigLibrary.readerSize());
        assertEquals(1,testLibraryForReader.readerSize());
        assertEquals(testLibraryForReader,reader.getReaderLibrary());

    }


    @Test
    public void testSearchReaderPubNotFound(){
        testLibraryForReader.addPublication(book);
        assertEquals(null,reader.searchReaderPub(33));
    }

    @Test
    public void testSearchReaderPubSetNull(){
        reader.setReaderLibrary(null);
        assertEquals(null,reader.searchReaderPub(12));
    }
    @Test
    public void testSearchReaderPubFound(){
        testBigLibrary.addPublication(book);
        testBigLibrary.addPublication(video);
        reader.setReaderLibrary(testLibraryForReader);
        reader.borrowPub(book,testBigLibrary);
        assertEquals(1,reader.getReaderLibrary().librarySize());
        assertEquals(1,testBigLibrary.librarySize());
        assertEquals(testLibraryForReader,book.getPublicationLocation());
        assertEquals(book,reader.searchReaderPub(12));
    }
    @Test
    public void testBorrowPubNotFound(){
        reader.borrowPub(book,testBigLibrary);
        assertEquals(0,testLibraryForReader.librarySize());
    }
    @Test
    public void testBorrowBookFound(){
        testBigLibrary.addPublication(book);
        testBigLibrary.addPublication(video);
        reader.setReaderLibrary(testLibraryForReader);
        reader.borrowPub(book,testBigLibrary);
        assertEquals(1,reader.getReaderLibrary().librarySize());
        assertEquals(1,testBigLibrary.librarySize());
        assertEquals(testLibraryForReader,book.getPublicationLocation());

    }
    @Test
    public void testReturnBook(){
        testBigLibrary.addPublication(book);
        testBigLibrary.addPublication(video);
        reader.setReaderLibrary(testLibraryForReader);
        reader.borrowPub(video,testBigLibrary);
        assertEquals(1,reader.getReaderLibrary().librarySize());
        assertEquals(1,testBigLibrary.librarySize());
        reader.returnPub(video,testBigLibrary);
        assertEquals(2,testBigLibrary.librarySize());
        assertEquals(0,testLibraryForReader.librarySize());
        assertEquals(testBigLibrary,video.getPublicationLocation());

    }


    }








