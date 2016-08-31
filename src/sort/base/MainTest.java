
package sort.base;

import sort.distribution.BucketSort;
import sort.distribution.RadixSort;
import sort.exchange.BubbleSort;
import sort.exchange.CocktailSort;
import sort.exchange.QuickSort;
import sort.insert.BinaryInsertSort;
import sort.insert.ShellSort;
import sort.insert.SingleInsertSort;
import sort.merge.MergeSort;
import sort.select.HeapSort;
import sort.select.SingleSelectSort;

/**
 * @fun �������������<br/>
 * 		Ŀǰ���е������У��򵥲������򡢶��ֲ�������ϣ�����򡢼�ѡ�����򡢶�����ð�����򡢹鲢���򡢻�׼���򡢼�β�����򡢿�������<br/>
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��28������7:49:29
 * @version 1.0
 * @since
 **/
public class MainTest {
	public static void main(String[] args) {
		RandomBuilder builder = new RandomBuilder(1000);
		builder.generate();
		int datas[] = builder.getDatas();
		//ISort[] sort = {new RadixSort()};
		ISort[] sort = { new SingleInsertSort(), new BinaryInsertSort(), new ShellSort(), new SingleSelectSort(),
				new HeapSort(), new BubbleSort(),  new MergeSort(), new RadixSort(), new CocktailSort(),
				new BucketSort(),new QuickSort(),};
		
		SortContext context = null;
		for (int i = 0; i < sort.length; i++) {
			context = new SortContext(sort[i]);

			context.sort(datas);
			context.show(datas);
		}
	}
}
/**
 �ܽ᣺<br/>
һ���ȶ���:<br/>
��  	 �ȶ���ð�����򡢲������򡢹鲢����ͻ�������<br/>
��   	���ȶ���ѡ�����򡢿�������ϣ�����򡢶�����<br/>
����ƽ��ʱ�临�Ӷ�<br/>
����	O(n^2):ֱ�Ӳ������򣬼�ѡ������ð������<br/>
����	�����ݹ�ģ��Сʱ��9W�ڣ���ֱ�Ӳ������򣬼�ѡ�������ࡣ�����ݽϴ�ʱ��ð�������㷨��ʱ�������ߡ�<br/>
	����ΪO(n^2)���㷨������������Ԫ�ؽ��бȽϣ������϶����ȶ��ġ�<br/>
����	O(nlogn):�������򣬹鲢����ϣ�����򣬶�����<br/>
����	���У���������õģ� ����ǹ鲢��ϣ�������������������ܴ�ʱЧ�����ԡ�<br/>
���������㷨��ѡ��<br/>
����1.���ݹ�ģ��С<br/>
  ������1���������л����������£�����ѡ��ֱ�Ӳ�������<br/>
  ������2�����ȶ��Բ���Ҫ�����ü�ѡ�����򣬶��ȶ�����Ҫ�����ò����ð��<br/>
����2.���ݹ�ģ���Ǻܴ�<br/>
������1����ȫ�������ڴ�ռ䣬�����������򣬶��ȶ���û��Ҫ�󣬿������򣬴�ʱҪ����log��N���Ķ���ռ䡣<br/>
������2�����б���������򣬶��ȶ�����Ҫ�󣬿ռ������£����ù鲢����<br/>
����3.���ݹ�ģ�ܴ�<br/>
   ������1�����ȶ���������ɿ��ǹ鲢����<br/>
    ������2�����ȶ���ûҪ�����ö�����<br/>
����4.���г�ʼ�����������򣩣�����ֱ�Ӳ��룬ð�� ����<br/>
 * */
