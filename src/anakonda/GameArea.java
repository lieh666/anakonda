package anakonda;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

public class GameArea extends JComponent{
	private Short[][] tileIds;
	int cellSize;
	IImageCell[] tileImages;
	GameBoard gameBoard;
	
	public GameArea() {
		this.setBackground(Color.blue);
		this.setSize(200, 200);
		this.gameBoard = new GameBoard(32,20);
		this.cellSize = 32;
		this.addKeyListener(myKeyListener);
		this.setFocusable(true);
	}

	/**
	 * <p>Title: 绘图区构造函数</p> 
	 * <p>Description: 构造绘图区</p> 
	 * @param gboard 控制器
	 * @param tileImages 贴片组
	 * @param cellSize 单元格尺寸
	 */
	public GameArea(GameBoard gboard, IImageCell[] tileImages, int cellSize){
		this.gameBoard = gboard;
		this.tileImages = tileImages;
		this.cellSize = cellSize;
		this.setBackground(Color.black);
		this.setSize(gameBoard.getWidth()*cellSize, gameBoard.getHeight()*cellSize);
		this.addKeyListener(myKeyListener);
		this.setFocusable(true);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}	
	
	/**
	 * 
	 * Title: paintComponent
	 * Description: 绘制游戏区域
	 * @param g 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		tileIds = gameBoard.ProjectWidgets();
		for(int x = 0; x < gameBoard.getWidth(); x++){
			for(int y = 0; y < gameBoard.getHeight(); y++){
				if(tileIds[x][y] != null){
					g.drawImage(CellPool.getImageCell(tileIds[x][y]).getImg(), 32*x, 32*y, 32, 32, this);
				}else{
					g.drawImage(CellPool.getImageCell(01).getImg(), 32*x, 32*y, 32, 32, this);
				}
			}
		}
	}
	
	public void DoKeyPressed(){
		this.repaint();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	KeyListener myKeyListener = new KeyListener() {
		
		/**
		 * 键盘按下的监听
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			tileIds = gameBoard.KeyDispath(e.getKeyCode());
			DoKeyPressed();
		}
		
		/**
		 * 没用到
		 */
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	
		/**
		 * 没用到
		 */
		@Override
		public void keyReleased(KeyEvent e) {
		}
	};
}
