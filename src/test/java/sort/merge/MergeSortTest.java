/*************************************************************************
	> File Name: src/test/java/sort/merge/MergeSortTest.java
	> Author: shall
	> Mail: zyydqpi@163.com
	> Created Time: Thu 10 Nov 2016 09:02:37 AM CST
 ************************************************************************/

package sort.merge.test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertArrayEquals;

import sort.merge.MergeSort;

public class MergeSortTest {
    private MergeSort sort;

    @Before
    public void init() {
        sort = new MergeSort();
    }
    
    @Test
    public void testSort() {
        int[] datas = new int[]{1, 3, 2, 4, 5, -1, -2};
        int[] expectedDatas = new int[]{-2, -1, 1, 2, 3, 4, 5};
        sort.sort(datas);

        assertArrayEquals("MergeSortTest : ", datas, expectedDatas);

    }
}
