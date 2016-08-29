
package sort.exchange;

/**
 * @fun ��β������(˫��ð�������㷨) ����˼�룺���ҵ���С�����֣������ŵ���һλ��Ȼ���ҵ��������ַŵ����һλ��Ȼ�����ҵ��ڶ�С�����ַŵ��ڶ�λ��
 *      <br/>
 *      ���ҵ��ڶ�������ַŵ������ڶ�λ���������ƣ�ֱ���������<br/>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��29������8:02:52
 * @version 1.0
 * @since
 * 
 * 		������<br/>
 *        ��β�������������ƽ�������ѵĴ�������O(n^2)�������������һ��ʼ�Ѿ��󲿷�������Ļ�����ӽ�O(n)��<br/>
 **/
public class CocktailSort implements IExchangeSort {

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		if (datas == null || datas.length == 0) {
			return;
		}

		for (int i = 0; i < datas.length; i++) {
			// ���������ŵ���β
			for (int j = 0; j < datas.length - i - 1; j++) {
				if (datas[j] > datas[j + 1]) {
					swap(datas, j, j + 1);
				}
			}
			// ����С�����ŵ���ͷ
			for (int j = datas.length - 1 - (i + 1); j > i; j--) {
				if (datas[j] < datas[j - 1]) {
					swap(datas, j, j - 1);
				}
			}
		}
	}

	private void swap(int[] datas, int i, int j) {
		int temp = datas[j];
		datas[j] = datas[i];
		datas[i] = temp;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Cocktail Sort : ";
	}

}
