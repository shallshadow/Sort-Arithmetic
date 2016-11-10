
package sort.base;

import sort.distribution.BucketSort;
import sort.distribution.RadixSort;
import sort.exchange.BubbleSort;
import sort.exchange.CocktailSort;
import sort.exchange.QuickSort;
import sort.insert.BinaryInsertSort;
import sort.insert.ShellSort;
import sort.insert.SingleInsertSort;
import sort.merge.MergeSort;
import sort.select.HeapSort;
import sort.select.SingleSelectSort;

/**
 * @fun 常用排序测试类<br/>
 * 		目前所有的排序有：简单插入排序、二分插入排序、希尔排序、简单选择排序、堆排序、冒泡排序、归并排序、基准排序、鸡尾酒排序、快速排序。<br/>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月28日下午7:49:29
 * @version 1.0
 * @since
 **/
public class MainTest {
	static RandomBuilder builder = new RandomBuilder(100000);
	
	public static void main(String[] args) {
		builder.generate();
		//testRadixSort();
		testShellSort();
	}
	
	public static void testShellSort(){
		ISort sort = new ShellSort();
		testOne(sort);
	}
	

	public static void testRadixSort(){		
		ISort sort = new RadixSort();
		testOne(sort);		
	}
	
	public static void testOne(ISort sort){
		int datas[] = builder.getDatas();
		SortContext context = new SortContext(sort);
		context.sort(datas);
		context.show(datas);
	}
	
	
	public static void testAll(){

		int datas[] = builder.getDatas();
		//ISort[] sort = {new RadixSort()};
		ISort[] sort = { new SingleInsertSort(), new BinaryInsertSort(), new ShellSort(), new SingleSelectSort(),
				new HeapSort(), new BubbleSort(),  new MergeSort(), new RadixSort(), new CocktailSort(),
				new BucketSort(),new QuickSort()};
		
		SortContext context = null;
		for (int i = 0; i < sort.length; i++) {
			context = new SortContext(sort[i]);

			context.sort(datas);
			//context.show(datas);
		}
	}
}
/**
 总结：<br/>
一、稳定性:<br/>
　  	 稳定：冒泡排序、插入排序、归并排序和基数排序<br/>
　   	不稳定：选择排序、快速排序、希尔排序、堆排序<br/>
二、平均时间复杂度<br/>
　　	O(n^2):直接插入排序，简单选择排序，冒泡排序。<br/>
　　	在数据规模较小时（9W内），直接插入排序，简单选择排序差不多。当数据较大时，冒泡排序算法的时间代价最高。<br/>
	性能为O(n^2)的算法基本上是相邻元素进行比较，基本上都是稳定的。<br/>
　　	O(nlogn):快速排序，归并排序，希尔排序，堆排序。<br/>
　　	其中，快排是最好的， 其次是归并和希尔，堆排序在数据量很大时效果明显。<br/>
三、排序算法的选择<br/>
　　1.数据规模较小<br/>
  　　（1）待排序列基本序的情况下，可以选择直接插入排序；<br/>
  　　（2）对稳定性不作要求宜用简单选择排序，对稳定性有要求宜用插入或冒泡<br/>
　　2.数据规模不是很大<br/>
　　（1）完全可以用内存空间，序列杂乱无序，对稳定性没有要求，快速排序，此时要付出log（N）的额外空间。<br/>
　　（2）序列本身可能有序，对稳定性有要求，空间允许下，宜用归并排序<br/>
　　3.数据规模很大<br/>
   　　（1）对稳定性有求，则可考虑归并排序。<br/>
    　　（2）对稳定性没要求，宜用堆排序<br/>
　　4.序列初始基本有序（正序），宜用直接插入，冒泡 排序<br/>
 * */
