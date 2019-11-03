package test;

import main.java.CheckOneFour;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCheckOneFour extends Assert {
    private CheckOneFour task2;

    @Before
    public void createTestTask2() {
        task2 = new CheckOneFour();
    }

    @Test
    public void isHaveOneFoure() {
        assertFalse(task2.checkOneFourMethod(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    @Test
    public void isHaveOneFoure1() {
        assertTrue(task2.checkOneFourMethod(new int[]{1, 1, 4, 4, 1, 4, 1, 4}));
    }

    @Test
    public void isHaveOneFoure2() {
        assertFalse(task2.checkOneFourMethod(new int[]{1, 1, 1}));
    }

    @Test
    public void isHaveOneFoure3() {
        assertFalse(task2.checkOneFourMethod(new int[]{4, 4, 4, 4, 4, 4}));
    }

    @Test
    public void isHaveOneFoure4() {
        assertFalse(task2.checkOneFourMethod(new int[]{}));
    }

}