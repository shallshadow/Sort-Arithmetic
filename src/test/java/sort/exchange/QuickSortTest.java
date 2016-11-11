/*************************************************************************
	> File Name: src/test/java/sort/exchange/QuickSortTest.java
	> Author: shall
	> Mail: zyydqpi@163.com
	> Created Time: Fri 11 Nov 2016 04:27:25 PM CST
 ************************************************************************/

package sort.exchange.test;

import org.junit.Test;
import org.junit.Before;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

import sort.exchange.QuickSort;
import sort.base.test.Final;

public class QuickSortTest {
    private QuickSort heap;

    @Before
    public void init() {
        heap = new QuickSort();
    }

    @Test
    public void testHeapSort() {
        int[] datas = Arrays.copyOf(Final.DATAS[0], Final.DATAS[0].length);
        heap.sort(datas);

        assertArrayEquals(datas, Final.DATAS[1]);
    }

}
