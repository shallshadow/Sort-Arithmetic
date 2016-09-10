package sort.distribution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
;

/**
 * @fun 桶排序(Bucket sort)<br/>
 *      基本思想：将数组分到有限数量的桶子里。<br/>
 *      每个桶子再个别排序（有可能再使用其他别的排序算法或是以递归的方式继续使用桶排序来进行排序）。<br/>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月29日下午8:13:25
 * @version 1.0
 * @since
 * @description 
 * 1.假设待排序的一组数统一的分布在一个范围中，并将这一范围分成几个子范围，即桶。<br/>
 * 2.将待排序的一组数，分档归入这些子桶，并将桶中的数据进行排序。<br/>
 * 3.将各个桶中的数据依次组合起来即可。<br/>
 * 
 * 时间复杂度O(n) 空间复杂度O(N)
 **/
public class BucketSort implements IDistributionSort {

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		if (datas == null || datas.length == 0) {
			return;
		}

		int length = datas.length;
		/**
		 * 每个桶是一个List，存放落在此桶上的元素。
		 */
		@SuppressWarnings("unchecked")
		ArrayList<Integer> list[] = new ArrayList[length];
		// 划分桶并填元素
		for (int i = 0; i < length; i++) {
			//划分范围[0...length-1]
			int temp = (int) Math.floor(datas[i] % length);
			if (null == list[temp]) {
				list[temp] = new ArrayList<Integer>();
			}
			//！！在添加的同时维护其有序性
			list[temp].add(datas[i]);
		}
		//桶内排序
		for (int i = 0; i < length; i++) {
			if(null != list[i]){
				//此处排序方法不定。除三大线性排序外，都没有Collections和Arrays里的sort好，优化后的快速排序
				Collections.sort(list[i]);
			}
		}
		
		//输出
		int count = 0;
		for(int i = 0; i < length; i++){
			if(null != list[i]){
				Iterator<Integer> iterator = list[i].iterator();
				while(iterator.hasNext()){
					datas[count++] = iterator.next();
				}
			}
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Bucket Sort : ";
	}

}
/**
 * 排序算法动画演示：http://www.cs.usfca.edu/~galles/visualization/BucketSort.html
 */
