
package sort.insert;

/**
 * @fun ϣ������ (Shell Sort) ���ȶ��������㷨<br/>
 *      ����˼�룺��ȡһ��С��n������d1��Ϊ��һ�����������ļ���ȫ����¼�ֳ�d1���顣���о���Ϊd1�ı����ļ�¼����ͬһ�����С�
 *      ���ڸ����ڽ���ֱ�Ӳ�������<br/>
 *      Ȼ��ȡ�ڶ�������d2<d1�ظ������ķ��������ֱ����ȡ������dt=1(d1>d2>...>dt)�������м�¼����ͬһ���н���ֱ�Ӳ�������Ϊֹ��
 *      <br/>
 *      ʵ���Ƿ�����뷨��<br/>
 * 
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��28������8:25:38
 * @version 1.0
 * @since
 * 
 * 		ϣ�������ʱ����������ֱ�Ӳ�������ԭ�����£�<br/>
 *        ��1�����ļ���̬��������ʱֱ�Ӳ�����������ıȽϺ��ƶ����������١�<br/>
 *        ��2����nֵ��Сʱ��n��n2�Ĳ��Ҳ��С����ֱ�Ӳ�����������ʱ�临�Ӷ�O(n)���ʱ�临�Ӷ�0(n2)��𲻴�<br/>
 *        ��3����ϣ������ʼʱ�����ϴ󣬷���϶࣬ÿ��ļ�¼��Ŀ�٣��ʸ�����ֱ�Ӳ���Ͽ죬��������di����С���������𽥼��٣�<br/>
 *        ������ļ�¼��Ŀ�����࣬�������Ѿ���di-1��Ϊ�����Ź���ʹ�ļ��Ͻӽ�������״̬�������µ�һ���������Ҳ�Ͽ졣<br/>
 *        ��ˣ�ϣ��������Ч���Ͻ�ֱ�Ӳ��������нϴ�ĸĽ��� ϣ�������ƽ��ʱ�临�Ӷ�ΪO(nlogn)��<br/>
 *
  
 *        **/
public class ShellSort implements IInsertSort {

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		if (datas == null || datas.length == 0) {
			return;
		}

		int d = datas.length;
		while (true) {
			d = d / 2;
			for (int x = 0; x < d; x++) {
				// ֱ�Ӳ�������
				for (int i = x + d; i < datas.length; i = i + d) {
					int temp = datas[i];
					int j;
					for (j = i - 1; j >= 0; j--) {
						if (temp < datas[j]) {
							datas[j + 1] = datas[j];
						} else {
							break;
						}
					}
					datas[j + 1] = temp;
				}
			}

			if (d == 1) {
				break;
			}
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Shell Sort : ";
	}

}
