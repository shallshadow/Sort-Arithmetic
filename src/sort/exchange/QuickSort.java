
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
 * @description
 * ������<br/>
 * 	���������ǲ��ȶ�������<br/>
 * 	���������ʱ�临�Ӷ�ΪO(nlogn)��<br/>
 *  ���ʱ�临�Ӷ�ΪO(n^2)�������������<br/>
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
			//��û�׼Ԫ��
			int middle = postion(datas, low, high);
			//������벿�֣���ȡԪ���ұߵ�һ������Ϊ��׼Ԫ��
			quickSort(datas, low, middle - 1);
			//�����Ұ벿�֣�������ߵ�һ������Ϊ��׼Ԫ��
			quickSort(datas, middle + 1, high);
		}
	}
	
	/**
	 * ��ȡ�����һ����Ϊ��׼Ԫ�أ����������ݺ󣬷��ػ�׼��ǰ��λ��
	 * @param datas ��Ҫ���������
	 * @param low ��λ
	 * @param high ��λ
	 * @return ���ص�ǰ��׼����λ��
	 */
	private int postion(int[] datas, int low, int high){
		//��׼Ԫ��
		int temp = datas[low];
		//��֤ѭ������ʽ 
		while(low < high){			
			//�ҵ��Ȼ�׼Ԫ��С��Ԫ��λ��
			while(low < high && datas[high] >= temp){
				high--;
			}		
			//����СԪ��Ų����׼Ԫ��λ��
			datas[low] = datas[high];
			//�ҵ��Ȼ�׼Ԫ�ش��Ԫ��λ��
			while(low < high && datas[low] <= temp){
				low++;
			}
			//���ϴ�Ԫ��Ų����λ�ϣ�����һ�����ƽ�СԪ��λ��
			datas[high] = datas[low];
		}
		//����׼Ԫ��������ǰ�ϵ�λ����
		datas[low] = temp;
		return low;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Quick Sort : ";
	}
	
}
