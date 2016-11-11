
package sort.exchange;

import sort.distribution.IDistributionSort;
import java.util.Random;

/**
 * @fun 快速排序 <br/>
 * 		基本思想：选择一个基准元素，通常选择第一个元素或者最后一个元素，通过一趟扫描，将待排序列分成两部分，一部分比基准元素小，一部分大于等于基准元素。<br/>\
 * 		此时基准元素在其排好序后的正确位置，然后再用同样的方法递归地排序划分的两部分。<br/>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月29日下午3:27:24
 * @version 1.0
 * @since 
 * @description
 * 分析：<br/>
 * 	快速排序是不稳定的排序。<br/>
 * 	快速排序的时间复杂度为O(nlogn)。<br/>
 *  最坏的时间复杂度为O(n^2)，即逆序情况下<br/>
 * 	当n较大时使用快排比较好，当序列基本有序时用快排反而不好。<br/>
 **/
public class QuickSort implements IExchangeSort,IDistributionSort {

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		if(datas == null || datas.length == 0){
			return;
		} 
		
		quickSort(datas, 0, datas.length - 1);
	}

	private void quickSort(int[] datas, int low, int high){
		if(low < high){
            //Random the datas
            random_partion(datas, low, high);
			//求得基准元素
			int middle = postion(datas, low, high);
			//先排左半部分，采取元素右边第一个数据为基准元素
			quickSort(datas, low, middle - 1);
			//后排右半部分，采油左边第一个数据为基准元素
			quickSort(datas, middle + 1, high);
		}
	}

    private void random_partion(int[] datas, int low, int high) {
        int i = low + new Random().nextInt(high - low + 1);
        swap(datas, i, high);
    }
    
    private void swap(int[] datas, int low, int high) {
        int temp = datas[low];
        datas[low] = datas[high];
        datas[high] = temp;
    }
	
	/**
	 * 采取数组第一个数为基准元素，交换完数据后，返回基准当前的位置
	 * @param datas 需要排序的数据
	 * @param low 低位
	 * @param high 高位
	 * @return 返回当前基准所在位置
	 */
	private int postion(int[] datas, int low, int high){
		//基准元素
		int temp = datas[low];
		//保证循环不定式 
		while(low < high){			
			//找到比基准元素小的元素位置
			while(low < high && datas[high] >= temp){
				high--;
			}		
			//将较小元素挪到基准元素位置
			datas[low] = datas[high];
			//找到比基准元素大的元素位置
			while(low < high && datas[low] <= temp){
				low++;
			}
			//将较大元素挪到高位上，即上一个被移较小元素位置
			datas[high] = datas[low];
		}
		//将基准元素移至当前较低位置上
		datas[low] = temp;
		return low;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Quick Sort : ";
	}
	
}
