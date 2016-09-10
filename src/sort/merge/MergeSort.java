
package sort.merge;

/**
 * @fun �鲢����<br/>
 *      ����˼�룺�鲢(Merge)�����ǽ�����(��������)�����ϲ���һ���µ���������Ѵ��������з�Ϊ���ɸ������У�ÿ��������ʽ����ġ�<br/>
 *      Ȼ���ٰ����������кϲ�Ϊ�����������С�<br/>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��29������4:16:26
 * @version 1.0
 * @since
 * 
 * ������<br/>
 *��	�鲢�������ȶ������򷽷���<br/>
 *	�鲢�����ʱ�临�Ӷ�ΪO(nlogn)��<br/>
 *	�ٶȽ����ڿ�������Ϊ�ȶ������㷨��һ�����ڶ��������򣬵��Ǹ����������������С�<br/>
 **/
public class MergeSort implements IMergerSort {

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		if (datas == null || datas.length == 0) {
			return;
		}
		
		mergeSort(datas, 0, datas.length - 1);
	}
	/**
	 * �鲢����
	 * @param datas ��Ҫ���������
	 * @param left  ��ֵ��������������
	 * @param right ��ֵ��������ұ�����
	 */
	private void mergeSort(int[] datas, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			//����߽��еݹ�
			mergeSort(datas, left, middle);
			//���ұ߽��еݹ�
			mergeSort(datas, middle + 1, right);
			//�ϲ�
			merge(datas, left, middle, right);
		}
	}

	/**
	 * �ϲ���������
	 * @param datas  ��������
	 * @param left   ���������
	 * @param middle �м�����
	 * @param right  ���ұ�����
	 */
	private void merge(int[] datas, int left, int middle, int right) {
		int[] tmpArr = new int[datas.length];
		// �ұߵ���ʼλ��
		int mid = middle + 1;
		int tmp = left;
		int third = left;
		
		// ������������ѡȡ��С���������м�����
		while (left <= middle && mid <= right) {			
			if (datas[left] <= datas[mid]) {
				tmpArr[third++] = datas[left++];
			} else {
				tmpArr[third++] = datas[mid++];
			}
		}
		
		//��ʣ��Ĳ��ַ����м�����
		while(left <= middle){
			tmpArr[third++] = datas[left++];
		}
		
		while(mid <= right){
			tmpArr[third++] = datas[mid++];
		}
		
		//���м����鸴�ƻ�ԭ����
		while(tmp <= right){
			datas[tmp] = tmpArr[tmp++];
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Merge Sort : ";
	}

}
