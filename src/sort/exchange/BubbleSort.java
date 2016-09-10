
package sort.exchange;
/**
 * @fun ð������	�ȶ��������㷨
 * 		����˼�룺��Ҫ�����һ�����֣��Ե�ǰ��δ�ź���ķ�Χ�ڶ�ȫ���������϶��¶����ڵ����������ν��бȽϺ͵�����<br/>
 *		�ýϴ�������³�����С��������ð������ÿ�������ڵ����ȽϺ������ǵ����������Ҫ���෴ʱ���������ǡ�<br/>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��29������3:03:29
 * @version 1.0
 * @since 1.0   
 * @description  
 *  1.
 *  
 * ������<br/>
 * 	���ļ���״Ϊ������һ�����ݾͿ��������������ıȽϴ���Ϊn-1����û�м�¼�ƶ���ʱ�临�Ӷ���O(n)
 *	���ļ���̬Ϊ��������Ҫn-1�����ݣ�ÿ�˽���n-i��������ıȽϣ���ÿ�αȽ϶��ƶ����Σ��ȽϺ��ƶ��������ﵽ���ֵ��O(n^2)
 *	��������ƽ��ʱ�临�Ӷ�ΪO(n^2)
 **/
public class BubbleSort implements IExchangeSort {

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		if(datas ==  null || datas.length == 0){
			return;
		}
		
		for(int i = 0; i < datas.length; i++){
			//-i��Ҫ��ÿ����һ�ζ�������i�������������ȥ�ˣ�û�б�Ҫ���滻�ˡ�
			for(int j = 0; j < datas.length - i - 1; j++){
				if(datas[j] > datas[j + 1]){
					swap(datas, j, j + 1);
				}
			}
		}
	}
	
	/**
	 * ���������е�i���͵�j��Ԫ��
	 * @param datas Ŀ������
	 * @param i �±�i
	 * @param j �±�j
	 */
	private void swap(int[] datas, int i, int j){
		int temp = datas[j];
		datas[j] = datas[i];
		datas[i] = temp;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Bubble Sort : ";
	}

}
