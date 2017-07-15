package anakonda;

import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: Widget 
 * @Description: （抽象）部件类 
 * @author lieh
 * @date 2017年1月19日 上午9:06:46 
 *
 */
public abstract class Widget extends Position implements Iterable<Position>{

	protected List<Direction> qVector;
	public Widget(int posX, int posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}

	public abstract Iterator<Position> iterator();
}
