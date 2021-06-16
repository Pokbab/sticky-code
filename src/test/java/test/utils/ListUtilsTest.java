package test.utils;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ListUtilsTest {

    @Test
    public void testContains() {
        assertTrue("리스트 요소 검색", Arrays.asList(90, 990, 9990, 99990).contains(90));
    }

}
