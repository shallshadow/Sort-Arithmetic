
package sort.base;

/**
 *
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016年8月28日下午7:29:04
 * @version 1.0
 * @since
 **/
public class SortContext {
	private ISort sort;
	//记录消耗时间
	private long timeConsum;
	public SortContext(ISort sort) {
		// TODO Auto-generated constructor stub
		this.sort = sort;
	}

	public void sort(int datas[]) {
		long start = System.currentTimeMillis();
		this.sort.sort(datas);
		timeConsum = System.currentTimeMillis() - start;
	}
	
	public void show(int datas[]){
		if(datas == null || datas.length == 0){
			return;
		}
		
		System.out.println(this.sort.getName());
		for(int i = 0; i < datas.length; i++){
			System.out.print(datas[i] + "  ");
		}
		System.out.println();
		System.out.println("Time consuming : " + timeConsum);
	}
}
