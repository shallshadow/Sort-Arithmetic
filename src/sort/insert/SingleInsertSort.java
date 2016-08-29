
package sort.insert;

/**
 *
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��28������7:35:06
 * @version 1.0
 * @since  1.0
 * @fun  ֱ�Ӳ�������(�Ӻ���ǰ�ҵ�����λ�ú����)<br/>
 * 		   ����˼�룺ÿ����һ��������ļ�¼������˳�����С���뵽ǰ���Ѿ�����������еĺ���λ��(�Ӻ���ǰ�ҵ�����λ�ú�)��ֱ��ȫ������������Ϊֹ��<br/>
 *  	   �ļ���̬��ͬʱ��ֱ�Ӳ����������ķѵ�ʱ���кܴ���졣<br/>
 *  	        ���ļ���̬Ϊ������ÿ��������ļ�¼ֻ��Ҫ�Ƚ�һ�ξ��ܹ��ҵ����ʵ�λ�ò��룬���㷨��ʱ�临�Ӷ�ΪO(n)����ʱ��õ������<br/>
 *         ����̬Ϊ�������i���������¼��Ҫ�Ƚ�i+1�β����ҵ�����λ�ò��룬��ʱ�临�Ӷ�ΪO(n2)����ʱ��������<br/>
����		  ֱ�Ӳ��������ƽ��ʱ�临�Ӷ�ΪO(n2)��<br/>
 **/
public class SingleInsertSort implements IInsertSort {

	public static void main(String[] args) {

	}

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		for (int i = 1; i < datas.length; i++) {
			int temp = datas[i];
			int j;
			//�Ӻ���ǰ�ң����Ǳ�temp���������
			for (j = i - 1; j >= 0; j--) {
				if (datas[j] > temp) {
					datas[j + 1] = datas[j];
				} else {
					break;
				}
			}
			datas[j + 1] = temp;
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Insert Sort : ";
	}
}
