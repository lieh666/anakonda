package anakonda;

import java.util.Iterator;
import java.util.List;

public class TileIterator extends TilePosition implements Iterator<Position>{
	private List<Direction> itrVector;//向量队列
	private Iterator<Direction> itrVectorItera;//向量迭代器
	private Direction preNodeDir;
	
	public TileIterator(Position Pos, List<Direction> qVector) {
		super(Pos.getX(), Pos.getY());
		this.itrVector = qVector;
		preNodeDir = null;
		if(qVector != null){
			itrVectorItera = itrVector.iterator();
		}
	}

	@Override
	public boolean hasNext() {
		if(itrVectorItera.hasNext()){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Position next(){
		TilePosition result = new TilePosition(super.posX, super.posY);
		if(itrVector.size() > 1 && itrVectorItera.hasNext()){
			//TilePosition result = new TilePosition(super.posX, super.posY);
			Direction dir = itrVectorItera.next();
			if(itrVectorItera.hasNext()){
				super.posX += Direction.AdjustPosX[dir.getValue()];
				super.posY += Direction.AdjustPosY[dir.getValue()];

				if(preNodeDir == null){
					result.setTileId((short)5, dir.getOpposite().getValue());
				}else{
					result.setTileId(dir.getValue(), preNodeDir.getValue());
				}
			}else{
				result.setTileId((short)4, preNodeDir.getValue());
			}
			preNodeDir = dir;
			return result;
		}else if(itrVector.size() == 1 && itrVectorItera.hasNext()){
			Direction dir = itrVectorItera.next();
			result.setTileId((short)1, (short)0);
			return result;
		}
		return null;
	}
	
}
