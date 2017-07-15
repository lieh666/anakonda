package anakonda;

/**
 * 枚举方向类
 * 定义了四个方向的常量，和向四个方向移动时的坐标轴变化
 * @author lieh
 *
 */
public enum Direction {
	UP((short)0),
	DOWN((short)1), 
	LEFT((short)2), 
	RIGHT((short)3);//移动方向，枚举类型

	public static final byte[] AdjustPosX = {0, 0, -1, 1};//X轴变化
	public static final byte[] AdjustPosY = {-1, 1, 0, 0};//Y轴变化
	
	private short value;
	
	/*
	 * 枚举构造函数，只能是私有函数
	 */
	private Direction(short value){
		this.value = value;
	}
	
	/*
	 * 获取方向的值
	 */
	public short getValue(){
		return this.value;
	}
	
	/*
	 * 返回移动方向的反方向，作为部件连接的方向
	 */
	public Direction getOpposite(){
		final Direction[] oppvs = {DOWN, UP, RIGHT, LEFT};
		return oppvs[this.getValue()];
	}

	
	/*
	 * 复写ToString值
	 */
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
