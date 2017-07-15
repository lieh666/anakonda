package anakonda;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.*;

public class MainFrame extends JFrame {
	public MainFrame() {
	}
	
	/**
	 * <p>Title: 构造函数</p> 
	 * <p>Description: 给Frame传递窗口名和绘图区</p> 
	 * @param title 窗口名
	 * @param canvas 绘图区
	 */
	public MainFrame(String title, JComponent canvas){
		this.setTitle(title);
		this.setSize(canvas.getSize());
		this.setLocation(new Point(200,50));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(canvas);
		this.setVisible(true);
	}

	public static void main(String[] args){
		GameArea gameArea = new GameArea(new GameBoard(32, 20), null, 32);
		MainFrame anakonda = new MainFrame("贪吃蛇", gameArea);
		anakonda.setVisible(true);
	}
	
	private static final long serialVersionUID = 1L;
	
}
