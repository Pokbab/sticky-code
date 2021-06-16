package test.utils;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.junit.Test;

import com.google.common.collect.Iterables;

public class ListUtilsTest {

    @Test
    public void testContains() {
        assertTrue("리스트 요소 검색", Arrays.asList(90, 990, 9990, 99990).contains(90));
    }

    @Test
    public void testFindFirst() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        assertEquals(1, list.get(0).longValue());
        assertEquals(1, list.stream().findFirst());

        assertEquals(1, CollectionUtils.get(list, 0).longValue());
        assertEquals(1, IterableUtils.get(list, 0).longValue());
        assertEquals(1, IteratorUtils.get(list.iterator(), 0).longValue());

        assertEquals(1, Iterables.getFirst(list, 0).longValue());
    }

}
