package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestManager {

    private Manager testManager;

    Library BigLibrary = new Library();
    Reader r = new Reader("Kendall",13);

    @BeforeEach
    public void setup(){
        testManager =new Manager("Kanye");
    }

    @Test
    public void testSetName(){
        testManager.setName("q");
        assertEquals("q",testManager.getName());
    }
    @Test
    public void testGetName(){
        assertEquals("Kanye",testManager.getName());
    }

    @Test
    public void testUpdate(){
        BigLibrary.addObserver(testManager);
        BigLibrary.addCustomer(r);
        assertTrue(testManager.getHasUpdate());
    }
    @Test
    public void testSetHasUpdate(){
        testManager.setHasUpdated(true);
        assertTrue(testManager.getHasUpdate());
    }
    @Test
    public void testGetHasUpdate(){
        assertFalse(testManager.getHasUpdate());
    }




}
