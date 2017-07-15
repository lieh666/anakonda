package anakonda;

/**
 * @ClassName: TilePosition 
 * @Description: 位置贴片
 * @author lieh
 * @date 2017年1月19日 上午9:04:20 
 *
 */
public class TilePosition extends Position{

	private short tileId;

	private short[][] tileIds = {
			{(short)00, (short)01, (short)02, (short)03},
			{(short)10, (short)11, (short)12, (short)13},
			{(short)20, (short)21, (short)22, (short)23},
			{(short)30, (short)31, (short)32, (short)33},
			{(short)40, (short)41, (short)42, (short)43},
			{(short)50, (short)51, (short)52, (short)53}
	};
	
	/*
	 * 构造一个位置贴片（无贴片信息）
	 */
	public TilePosition(int X, int Y) {
		super(X, Y);
	}
	
	/*
	 * 构造一个位置贴片（含贴片Id）
	 */
	public TilePosition(int X, int Y, short tileId){
		super(X, Y);
		this.tileId = tileId;
	}

	public short getTileId(){
		return this.tileId;
	}

	/*
	 * 设置贴片信息
	 */
	public boolean setTileId(short preDir, short currentDir){
		this.tileId = tileIds[preDir][currentDir];
		return true;
	}
}
