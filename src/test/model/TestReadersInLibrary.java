//package model;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class TestReadersInLibrary {
//    private ReadersInLibrary readersInLibrary;
//    Reader reader1,reader2,reader3;
//    Library testLibrary;
//
//    @BeforeEach
//    public void setup(){
//        readersInLibrary = new ReadersInLibrary();
//        testLibrary = new Library();
//        reader1 = new Reader(11,testLibrary);
//        reader2 = new Reader(12,testLibrary);
//        reader3 = new Reader(13,testLibrary);
//
//    }
//    @Test
//    public void testGetReader(){
//        readersInLibrary.addReader(reader1);
//        readersInLibrary.addReader(reader2);
//        readersInLibrary.addReader(reader3);
//        assertEquals(reader1,readersInLibrary.getReader(11));
//        assertEquals(reader2,readersInLibrary.getReader(12));
//        assertEquals(reader3,readersInLibrary.getReader(13));
//    }
//    @Test
//    public void testAddReader(){
//        readersInLibrary.addReader(reader1);
//        assertEquals(1,readersInLibrary.readerSize());
//        assertTrue(readersInLibrary.containReader(reader1));
//        assertEquals(testLibrary,reader1.getReaderLibrary());
//
//    }
//    @Test
//    public void testReaderSize(){
//        readersInLibrary.addReader(reader1);
//        assertEquals(1,readersInLibrary.readerSize());
//    }
//    @Test
//    public void testRemoveReader(){
//        readersInLibrary.addReader(reader1);
//        assertEquals(1,readersInLibrary.readerSize());
//        assertTrue(readersInLibrary.containReader(reader1));
//
//        readersInLibrary.removeReader(reader1);
//        assertEquals(0,testLibrary.librarySize());
//        assertFalse(testLibrary.containReader(reader1));
//    }
//    @Test
//    public void testContainReaderNo(){
//        readersInLibrary.addReader(reader1);
//        assertFalse(readersInLibrary.containReader(reader2));
//    }
//    @Test
//    public void tstContainReaderYes(){
//        readersInLibrary.addReader(reader3);
//        assertTrue(readersInLibrary.containReader(reader3));
//    }
//}
