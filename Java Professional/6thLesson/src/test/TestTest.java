package test;

import main.java.TestTask;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTest extends Assert {

    TestTask testTask;

    @Before
    public void startTest() {
        testTask = new TestTask();
    }


    @Test
    public void assertArrayEquals0() {
        assertArrayEquals(new int[]{5, 6, 7}, testTask.arrayAfterLastFour(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    @Test
    public void assertArrayEquals1() {
        assertArrayEquals(new int[]{2, 2, 7}, testTask.arrayAfterLastFour(new int[]{4, 2, 3, 4, 2, 2, 7}));
    }

    @Test
    public void assertArrayEquals2() {
        assertArrayEquals(new int[]{1, 8, 7, 5}, testTask.arrayAfterLastFour(new int[]{6, 2, 3, 4, 1, 8, 7, 5}));
    }

    @Test
    public void assertArrayEquals3() {
        assertArrayEquals(new int[]{}, testTask.arrayAfterLastFour(new int[]{1, 2, 3, 4, 5, 6, 4}));
    }
}
