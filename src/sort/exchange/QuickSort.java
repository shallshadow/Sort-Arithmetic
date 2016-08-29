
package sort.exchange;

import sort.distribution.IDistributionSort;

/**
 * @fun �������� <br/>
 * 		����˼�룺ѡ��һ����׼Ԫ�أ�ͨ��ѡ���һ��Ԫ�ػ������һ��Ԫ�أ�ͨ��һ��ɨ�裬���������зֳ������֣�һ���ֱȻ�׼Ԫ��С��һ���ִ��ڵ��ڻ�׼Ԫ�ء�<br/>\
 * 		��ʱ��׼Ԫ�������ź�������ȷλ�ã�Ȼ������ͬ���ķ����ݹ�����򻮷ֵ������֡�<br/>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��29������3:27:24
 * @version 1.0
 * @since 
 * 
 * ������<br/>
 * 	���������ǲ��ȶ�������<br/>
 * 	���������ʱ�临�Ӷ�ΪO(nlogn)��<br/>
 * 	��n�ϴ�ʱʹ�ÿ��űȽϺã������л�������ʱ�ÿ��ŷ������á�<br/>
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
			int middle = getMiddle(datas, low, high);
			//������벿��
			quickSort(datas, 0, middle - 1);
			//�����Ұ벿��
			quickSort(datas, middle + 1, high);
		}
	}
	
	private int getMiddle(int[] datas, int low, int high){
		//��׼Ԫ��
		int temp = datas[low];
		
		while(low < high){			
			//�ҵ��Ȼ�׼Ԫ��С��λ��
			while(low < high && datas[high] >= temp){
				high--;
			}			
			datas[low] = datas[high];
			
			while(low < high && datas[low] <= temp){
				low++;
			}
			datas[high] = datas[low];
		}
		datas[low] = temp;
		return low;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Quick Sort : ";
	}
	
}