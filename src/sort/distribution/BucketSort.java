package sort.distribution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
;

/**
 * @fun Ͱ����(Bucket sort)<br/>
 *      ����˼�룺������ֵ�����������Ͱ���<br/>
 *      ÿ��Ͱ���ٸ��������п�����ʹ��������������㷨�����Եݹ�ķ�ʽ����ʹ��Ͱ�������������򣩡�<br/>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��29������8:13:25
 * @version 1.0
 * @since
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
		 * ÿ��Ͱ��һ��List��������ڴ�Ͱ�ϵ�Ԫ�ء�
		 */
		@SuppressWarnings("unchecked")
		ArrayList<Integer> list[] = new ArrayList[length];
		// ����Ͱ����Ԫ��
		for (int i = 0; i < length; i++) {
			int temp = (int) Math.floor(datas[i] % length);
			if (null == list[temp]) {
				list[temp] = new ArrayList<Integer>();
			}
			list[temp].add(datas[i]);
		}
		//Ͱ������
		for (int i = 0; i < length; i++) {
			if(null != list[i]){
				//�˴����򷽷����������������������⣬��û��Collections��Arrays���sort�ã��Ż���Ŀ�������
				Collections.sort(list[i]);
			}
		}
		
		//���
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
