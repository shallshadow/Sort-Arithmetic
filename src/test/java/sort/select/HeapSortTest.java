/*************************************************************************
	> File Name: src/test/java/sort/select/HeapSortTest.java
	> Author: shall
	> Mail: zyydqpi@163.com
	> Created Time: Fri 11 Nov 2016 04:27:25 PM CST
 ************************************************************************/

package sort.select.test;

import org.junit.Test;
import org.junit.Before;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

import sort.select.HeapSort;
import sort.base.test.Final;

public class HeapSortTest {
    private HeapSort heap;

    @Before
    public void init() {
        heap = new HeapSort();
    }

    @Test
    public void testHeapSort() {
        int[] datas = Arrays.copyOf(Final.DATAS[0], Final.DATAS[0].length);
        heap.sort(datas);

        assertArrayEquals(datas, Final.DATAS[1]);
    }

}
