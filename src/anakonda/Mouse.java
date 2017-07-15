package anakonda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: Mouse 
 * @Description: 老鼠，包括老鼠的位置信息
 * @author lieh
 * @date 2017-01-19 11:06:04 
 *
 */
public class Mouse extends Widget{

	//private List<Direction> qVector;//老鼠的方向队列
	public Mouse(int posX, int posY) {
		super(posX, posY);
		this.qVector = new ArrayList<Direction>();
		this.qVector.add(Direction.UP);
	}

	@Override
	public Iterator<Position> iterator() {
		return new TileIterator(this, qVector);
	}

}
