package anakonda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: Snake 
 * @Description: 蛇,包括蛇的信息和移动等方法
 * @author lieh
 * @date 2017-01-19 11:10:08 
 *
 */
public class Snake extends Widget{

	private short length;//蛇的长度
	private Direction dirMove;//蛇的移动方向
	//private List<Direction> qVector;//蛇的方向队列
	
	public Snake(int posX, int posY) {
		super(posX, posY);
	}
	
	/**
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param posX X轴位置
	 * @param posY Y轴位置
	 * @param length 长度
	 */
	public Snake(int posX, int posY, short length){
		super(posX, posY);
		this.length = length;
		this.dirMove = Direction.RIGHT;//初始化移动方向为向右
		/*
		 * 初始化方向队列
		 */
		this.qVector = new ArrayList<Direction>();
		for(int i = 0; i < this.length; i++){
			this.qVector.add(this.dirMove.getOpposite());
		}
	}
	
	/**
	 * <p>Title: Move</p> 
	 * <p>Description: 通过移动方向移动一步，并返回移动结果</p> 
	 * @param dir 移动方向
	 * @return 移动结果（TRUE、FALSE）
	 */
	public boolean Move(final Direction dir, boolean isIncrease){
		if(!qVector.isEmpty() && qVector.get(0) == dir)
			return false;
		dirMove = dir;//移动方向校正
		this.posX += Direction.AdjustPosX[dir.getValue()];//X轴对应变化
		this.posY += Direction.AdjustPosY[dir.getValue()];//Y轴对应变化
		qVector.add(0, dir.getOpposite());//队头前移一步
		/*
		 * 向量队列长度大于蛇的长度时，移除队尾多余项
		 */
		if(!isIncrease){
			while(length < qVector.size())
				qVector.remove(qVector.size()-1);
		}
		return true;
	}


	/**
	 * <p>Title: getMoveDir</p> 
	 * <p>Description: 取得当前移动方向</p> 
	 * @return 移动方向
	 */
	public Direction getMoveDir(){
		return dirMove;
	}
	
	@Override
	public Iterator<Position> iterator() {
		// TODO Auto-generated method stub
		return new TileIterator(this, this.qVector);
	}

}
