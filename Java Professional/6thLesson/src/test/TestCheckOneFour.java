package test;

import main.java.CheckOneFour;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCheckOneFour extends Assert {
    CheckOneFour task2;

    @Before
    public void createTestTask2(){
        task2 = new CheckOneFour();
    }

    @Test
    public void isHaveOneFoure() {
        assertEquals(false, task2.checkOneFourMethod(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    @Test
    public void isHaveOneFoure1() {
        assertEquals(true, task2.checkOneFourMethod(new int[]{1, 1, 4, 4, 1, 4, 1, 4}));
    }

    @Test
    public void isHaveOneFoure2() {
        assertEquals(false, task2.checkOneFourMethod(new int[]{1, 1, 1}));
    }

    @Test
    public void isHaveOneFoure3() {
        assertEquals(false, task2.checkOneFourMethod(new int[]{4, 4, 4, 4, 4, 4}));
    }

    @Test
    public void isHaveOneFoure4() {
        assertEquals(false, task2.checkOneFourMethod(new int[]{}));
    }

}