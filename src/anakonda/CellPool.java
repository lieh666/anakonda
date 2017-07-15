package anakonda;

import java.util.HashMap;

/**
 * 享元资源池
 * @author lieh
 *
 */
public class CellPool {
	//资源池
	private static HashMap<Integer, ImageCell> cellPool = new HashMap<Integer, ImageCell>();
	
	/**
	 * 通过key取出某个享元，资源池中不存在时，从工厂新建一个资源
	 * @param key
	 * @return
	 */
	public static ImageCell getImageCell(int key){
		/*
		 * 如果资源池中没有该资源，从工厂创建一个放入资源池中
		 */
		if(!cellPool.containsKey(key)){
			cellPool.put(key, CellFactory.getImageCell(key));
		}
		return cellPool.get(key);
	}
	
	/**
	 * 取得资源池中享元数量
	 * @return
	 */
	public static int getPoolSize(){
		return cellPool.size();
	}
}
