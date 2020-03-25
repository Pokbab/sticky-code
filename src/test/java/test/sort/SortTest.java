package test.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SortTest {

	@Test
	public void bubbleSort() {
		List<Integer> actual = Sort.bubbleSort(Arrays.asList(6, 4, 9, 5));

		assertEquals(Arrays.asList(4, 5, 6, 9), actual);
	}

	@Test
	public void insertSort() {
		List<Integer> actual = Sort.insertSort(Arrays.asList(6, 4, 9, 5));

		assertEquals(Arrays.asList(4, 5, 6, 9), actual);
	}
}