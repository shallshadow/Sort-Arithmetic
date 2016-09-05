
package sort.distribution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @fun �������� ����˼�룺�����д��Ƚ���ֵ(������)ͳһΪͬ����λ�����ȣ���λ�϶̵���ǰ�油�㡣Ȼ�󣬴����λ��ʼ�����ν���һ������<br/>
 *      ���������λ����һֱ�����λ��������Ժ����оͱ��һ���������С�<br/>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��29������7:29:37
 * @version 1.0
 * @since
 * 
 * ������<br/>
 * �����������ȶ��������㷨��<br/>
 * ���������ʱ�临�Ӷ�ΪO(d(n+r)),dΪλ����rΪ����<br/>
 **/
public class RadixSort implements IDistributionSort {
	private final int QUEUEMAX = 10;
	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		if(datas == null || datas.length == 0){
			return;
		}
		//�ҵ����ֵ
		int max = getMax(datas);
		//�ж�λ��
		int times= getTimes(max);
		
		//����QUEUEMAX������
		List<Deque<Integer>> list = new ArrayList<>();
		for(int i = 0; i < QUEUEMAX; i++){
			Deque<Integer> deque = new LinkedList<>();
			list.add(deque);
		}
		//����times�η�����ռ�
		for(int i = 0; i < times; i++){
			for(int j = 0; j < datas.length; j++){
				//����ʮ��ǧλ����ȡ��
				int x = datas[j] % (int)Math.pow(10, i+1) / (int)Math.pow(10, i);
				//��ȡλ�������Ӧ�Ķ���
				Deque<Integer> deque = list.get(x);
				deque.offer(datas[j]);
				//���ö�����������xλ�ô���List
				list.set(x, deque);
			}
			//�ռ�
			int count = 0;
			for(int j = 0; j < QUEUEMAX; j++){
				//����
				while(list.get(j).size() > 0){
					Deque<Integer> deque = list.get(j);
					datas[count] = deque.poll();
					count++;
				}
			}
		}
		
	}

	private int getMax(int[] datas) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < datas.length; i++) {
			if (max < datas[i]) {
				max = datas[i];
			}
		}

		return max;
	}

	private int getTimes(int max) {
		int sum = 0;
		while (max > 0) {
			max = max / 10;
			sum++;
		}
		return sum;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Radix Sort : ";
	}

}
