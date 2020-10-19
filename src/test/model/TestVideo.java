package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestVideo {
    Video video;
    Library testLibrary;

    @BeforeEach
    public void setup() {

        video = new Video("crazy", 23, 145);
        testLibrary = new Library();
    }

    @Test
    public void testVideoConstructor() {
        assertEquals("crazy", video.getName());
        assertEquals(23, video.getNumber());
        assertEquals(145, video.getLength());
    }
    @Test
    public void testSetPublicationLocationChangeLocation(){
        Library anotherLibrary = new Library();
        anotherLibrary.addPublication(video);
        assertEquals(anotherLibrary,video.getPublicationLocation());
        assertEquals(1,anotherLibrary.librarySize());
        video.assignToLibrary(testLibrary);
        assertTrue(testLibrary.equals(video.getPublicationLocation()));
        assertEquals(0,anotherLibrary.librarySize());
        assertEquals(1,testLibrary.librarySize());
    }

    @Test
    public void testSetVideoNumber() {
        video.setNumber(22);
        assertEquals(22, video.getNumber());
    }

    @Test
    public void testTimeSpentOn() {
        video.setLength(45);
        assertEquals(45, video.timeSpendOn());
    }

    @Test
    public void testToString() {
        String[] tokens = video.toString().split("\\ ");
        for (String s : tokens) {
            s.equals(video.getName());
            s.equals("23");
            s.equals("145");

        }
    }

    @Test
    public void testEquals() {
        Video anotherVideo = new Video("crazy", 23, 145);
        assertTrue(anotherVideo.equals(video));
    }
    @Test
    public void testEqualsOnlyNumberSame(){
        Video anotherVideo = new Video("aha",23,144);
        assertTrue(anotherVideo.equals(video));
    }
}
