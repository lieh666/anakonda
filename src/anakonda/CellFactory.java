package anakonda;

/**
 * 享元工厂
 * @author lieh
 *
 */
public class CellFactory {
	public static ImageCell getImageCell(int key){
		ImageCell imgCell = new ImageCell(key);
		return imgCell;
	}
}
