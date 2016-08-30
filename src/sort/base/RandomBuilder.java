
package sort.base;

import java.util.Random;

/**
 * @fun ����������������������
 * @author shadow E-mail:zyydqpi@163.com
 * @Date 2016��8��30������8:42:03
 * @version 1.0
 * @since 
 **/
public class RandomBuilder {
	private Random random;
	private int[] datas;
	public RandomBuilder(int num) {
		// TODO Auto-generated constructor stub
		datas = new int[num];
		random = new Random(System.currentTimeMillis());
	}
	
	public void generate(){
		for(int i = 0; i < datas.length; i++){
			datas[i] = random.nextInt(datas.length);
		}
	}
	
	public int[] getDatas(){
		return datas;
	}
}
