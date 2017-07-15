package anakonda;
/**
 * @author lieh
 *
 */
public class Position {
	protected int posX;
	protected int posY;
	
	/**
	 * 构造函数，通过X,Y构造一个位置
	 * @param posX
	 * @param posY
	 */
	public Position(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}
	
	public int getX() {
		return posX;
	}
	public int getY() {
		return posY;
	}
}
