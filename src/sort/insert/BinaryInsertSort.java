
package sort.insert;

/**
 *
 * @fun ���ַ���������(�����ַ��ҵ�����λ�ò���)<br/> 
 *      ����˼�룺���ַ����������˼���ֱ�Ӳ���һ����ֻ���ҵ����ʵĲ���λ�õķ�ʽ��ͬ�������ǰ����ַ��ҵ����ʵ�λ�ã����Լ��ٱȽϴ�����<br/>
 *		�ȶ��������㷨��<br/>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��28������8:03:28
 * @version 1.0
 * @since
 * 	������
 * 	���ֲ�������ıȽϴ�����������¼�ĳ�ʼ״̬�޹أ��������ڼ�¼�ĸ�����
 * 	��n�ϴ�ʱ����ֱ�Ӳ�����������Ƚϴ����ٵöࡣ
 * 	������ֱ�Ӳ����������С�Ƚϴ�����
 * 	�㷨���ƶ�������ֱ�Ӳ��������㷨����ͬ��������Ϊn2/2����õ����Ϊn��ƽ���ƶ�����ΪO(n2)��
 **/
public class BinaryInsertSort implements IInsertSort {

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		binarySort(datas);
	}
	
	/**
	 * ���ֲ��������㷨ʵ��
	 * @param datas ��Ҫ���������
	 */
	private void binarySort(int[] datas){
		if(datas == null || datas.length == 0){
			return;
		}
		
		for(int i = 1; i < datas.length; i++){
			int temp = datas[i];
			//��ȡ��ǰ�����λ��
			int left =binarySearch(datas, i);
			//ѭ���������ƶ�����
			for(int j = i - 1; j >= left; j--){
				datas[j + 1] = datas[j];
			}

			if(left != i){
				datas[left] = temp;
			}
		}
	}

	//���ַ���������
	private int binarySearch(int[] datas, int i) {
		int temp = datas[i];
		
		int left = 0;
		int right = i - 1;
		int mid = 0;
		
		while (left <= right) {
			mid = (left + right) / 2;
			if (temp < datas[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return left;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Binary Insertion : ";
	}

}
