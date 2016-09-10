
package sort.select;
/**
 * @fun �򵥵�ѡ������
 * 		����˼�룺��Ҫ�����һ�����У�ѡ����С��һ�����͵�һ��λ�õ���������Ȼ����ʣ�µ�������������С����ڶ���λ�õ���������<br/>
 * 		���ѭ���������ڶ����������һ�����Ƚ�Ϊֹ��<br/>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��28������8:54:22
 * @version 1.0
 * @since 
 * 
 * @analysis ��ѡ�������ǲ��ȶ�������ʱ�临�Ӷȣ�T(n)=O(n^2)��
 **/
public class SingleSelectSort implements ISelectSort {

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		if(datas == null || datas.length == 0){
			return;
		}
		
		for(int i = 0; i < datas.length; i++){
			int min = datas[i];
			int minIndex = i;
			for(int j = i + 1; j < datas.length; j++){
				if(min > datas[j]){
					min = datas[j];
					minIndex = j;
				}
			}
			
			datas[minIndex] = datas[i];
			datas[i] = min;				
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Single Selection Sort : ";
	}

}
