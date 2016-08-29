
package sort.select;

/**
 * @fun ������<br/>
 *      ����˼�룺��������һ������ѡ�������Ƕ�ֱ��ѡ���������Ч�Ľ���<br/>
 *      �ѵĶ����£�����n��Ԫ�ص�����
 *      ��h1,h2,...,hn),���ҽ������㣨hi>=h2i,hi>=2i+1����hi<=h2i,hi<=2i+1��
 *      (i=1,2,...,n/2)ʱ��֮Ϊ�ѡ�<br/>
 *      ������ֻ��������ǰ�������Ķѡ��ɶѵĶ�����Կ������Ѷ�Ԫ�أ�����һ��Ԫ�أ���Ϊ�����󶥶ѣ���<br/>
 *      ��ȫ�� �������Ժ�ֱ�۵ر�ʾ�ѵĽṹ���Ѷ�Ϊ��������Ϊ����������������<br/>
 *      <p>
 *      ˼��:��ʼʱ��Ҫ������������п�����һ��˳��洢�Ķ��������������ǵĴ洢��ʹ֮��Ϊһ�� �ѣ���ʱ�ѵĸ��ڵ�������<br/>
 *      Ȼ�󽫸��ڵ���ѵ����һ���ڵ㽻����Ȼ���ǰ��(n-1)�������µ���ʹ֮��Ϊ�ѡ�<br/>
 *      �������ƣ�ֱ��ֻ�������ڵ�Ķѣ����� ���������������õ���n���ڵ���������С�<br/>
 *      </p>
 *      <p>
 *      ���㷨������������������Ҫ�������̣�һ�ǽ����ѣ����ǶѶ���ѵ����һ��Ԫ�ؽ���λ�á�<br/>
 *      ���Զ�����������������ɡ�һ�ǽ��ѵ���͸���������Ƿ���������͸����ʵ������ĺ�����<br/>
 *      </P>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��28������9:05:51
 * @version 1.0
 * @since
 * 
 * 		������<br/>
 *        ������Ҳ��һ�ֲ��ȶ��������㷨��<br/>
 *        ���������ڼ�ѡ�������ԭ��<br/>
 *        ֱ��ѡ�������У�Ϊ�˴�R[1..n]��ѡ���ؼ�����С�ļ�¼���������n-1�αȽϣ�Ȼ����R[2..n]��ѡ���ؼ�����С�ļ�¼������Ҫ��n-
 *        2�αȽϡ�<br/>
 *        ��ʵ�ϣ������n-2�αȽ��У������ȽϿ�����ǰ���n-1�αȽ����Ѿ�������������ǰһ������ʱδ������Щ�ȽϽ����
 *        ���Ժ�һ������ʱ���ظ�ִ������Щ�Ƚϲ�����<br/>
 *        �������ͨ�����νṹ���沿�ֱȽϽ�����ɼ��ٱȽϴ�����<br/>
 *        ��������ʱ�临�Ӷ�ΪO(nlogn)�������ƽ�����ܽϽӽ�������ܡ�<br/>
 *        ���ڽ���ʼ������ıȽϴ����϶࣬���Զ����������ڼ�¼�����ٵ��ļ���<br/>
 **/
public class HeapSort implements ISelectSort {

	@Override
	public void sort(int[] datas) {
		// TODO Auto-generated method stub
		if (datas == null || datas.length == 0) {
			return;
		}

		buildMaxHeap(datas);
	}

	/**
	 * ����
	 * 
	 * @param datas
	 */
	private void buildMaxHeap(int[] datas) {
		// ѭ������
		int len = datas.length;
		for (int i = 0; i < len; i++) {
			// ����
			buildMaxHeap(datas, len - i - 1);
			// �����Ѷ������һ��Ԫ�أ���Ҫ��
			swap(datas, 0, len - 1 - i);
		}
	}

	/**
	 * ��data���ݴ�0��lastIndex���󶥶�
	 * 
	 * @param datas
	 * @param lastIndex
	 */
	private void buildMaxHeap(int[] datas, int lastIndex) {
		// ��lastIndex���ڵ�(���һ���ڵ�)�ĸ��ڵ㿪ʼ
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// k���浱ǰ�����жϵĽڵ�
			int k = i;
			// �����ǰk�ڵ���ӽڵ����
			while (k * 2 + 1 <= lastIndex) {
				// k�ڵ�����ӽڵ������
				int biggerIndex = 2 * k + 1;
				// ���biggerIndexС��lastIndex,��biggerIndex+1�����k�ڵ�����ӽڵ����
				if (biggerIndex < lastIndex) {
					// ������ӽڵ��ֵ�ϴ�
					if (datas[biggerIndex] < datas[biggerIndex + 1]) {
						// biggerIndex���Ǽ�¼�ϴ��ӽڵ������
						biggerIndex++;
					}
				}
				// ���k�ڵ��ֵС����ϴ���ӽڵ��ֵ
				if (datas[k] < datas[biggerIndex]) {
					// ʩ�н���
					swap(datas, k, biggerIndex);
					// ��biggerIndex����k����ʼwhileѭ������һ��ѭ�������±�֤k�ڵ��ֵ�����������ӽڵ��ֵ
					k = biggerIndex;
				} else {
					break;
				}
			}

		}
	}

	/**
	 * ����
	 * 
	 * @param data
	 * @param i
	 * @param j
	 */
	private void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Heap Sort : ";
	}

}
