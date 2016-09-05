
package sort.base;
/**
 *
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月28日下午7:16:22
 * @version 1.0
 * @since 
 **/
public interface ISort {
	/**
	 * 排序算法执行
	 * @param datas 需要进行排序的数据集合
	 */
	void sort(int[] datas);
	
	/**
	 * 
	 * @return 当前排序算法的名称
	 */
	String getName();
}
