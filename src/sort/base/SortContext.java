
package sort.base;

/**
 *
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��28������7:29:04
 * @version 1.0
 * @since
 **/
public class SortContext {
	private ISort sort;

	public SortContext(ISort sort) {
		// TODO Auto-generated constructor stub
		this.sort = sort;
	}

	public void sort(int datas[]) {
		this.sort.sort(datas);
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
	}
}
