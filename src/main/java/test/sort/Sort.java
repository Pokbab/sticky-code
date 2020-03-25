package test.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sort {

	/**
	 * 버블정렬
	 * 역순으로 정렬되어 있는 리스트를 정렬할때 O(n2)
	 * 이미 정렬되어있는 리스트를 정렬할 때엔 O(n)
	 * 공간복잡도는 temp 공간 추가정도
	 *
	 * @param list
	 * @return
	 */
	public static List<Integer> bubbleSort(List<Integer> list) {
		boolean switched;

		do {
			switched = false;

			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i)	> list.get(i + 1)) {
					int temp = list.get(i + 1);
					list.set(i + 1, list.get(i));
					list.set(i, temp);

					switched = true;
				}
			}
		} while (switched);

		return list;
	}

	/**
	 * 삽입정렬
	 * 이미 정렬되어 있는 리스트를 정렬하는건 O(n2)
	 * 역순으로 정렬된 리스트를 정렬할때엔 O(n)
	 * 공간복잡도는 2
	 *
	 * @param list
	 * @return
	 */
	public static List<Integer> insertSort(List<Integer> list) {
		final List<Integer> sortedList = new LinkedList<>();

		originalList: for (Integer number : list) {
			for (int i = 0; i < sortedList.size(); i++) {
				if (number < sortedList.get(i)) {
					sortedList.add(i, number);
					continue originalList;
				}
			}
			sortedList.add(sortedList.size(), number);
		}
		return sortedList;
	}

	/**
	 * 퀵정렬
	 * 평균적으로는 O(n log n)
	 * 최악의 경우(pivot 선택에 따라) O(n2)
	 *
	 * @param list
	 * @return
	 */
	public static List<Integer> quickSort(List<Integer> list) {
		if (list.size() <= 1) {
			return list;
		}

		final int pivot = list.get(0);
		final List<Integer> lower = new ArrayList<>();
		final List<Integer> higher = new ArrayList<>();

		for (int item : list) {
			if (item < pivot) {
				lower.add(item);
			} else {
				higher.add(item);
			}
		}

		final List<Integer> sorted = quickSort(lower);
		sorted.add(pivot);
		sorted.addAll(quickSort(higher));

		return sorted;
	}

}
