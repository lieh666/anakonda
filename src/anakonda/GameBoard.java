package anakonda;

import java.awt.event.KeyEvent;
import java.util.Map;

public class GameBoard{
    private int width;
    private int height;
    private Widget[] widgets;
    private Map mapKeyCode;

    public GameBoard(int width, int height){
        this.width = width;
        this.height = height;
        this.LoadWidgets(null, null);
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public Short[][] ProjectWidgets(){
        Short[][] result = new Short[this.width][this.height];

        for (Widget widget: widgets) {
            for (Position position : widget) {
                TilePosition tilePosition = (TilePosition) position;
                if(tilePosition.getX() < this.width && tilePosition.getY() < this.height) {
                    result[tilePosition.getX()][tilePosition.getY()] = tilePosition.getTileId();
                }else{
                    //TODO:越界处理
                }
            }
        }
        return result;
    }

    public Short[][] KeyDispath(int keycode){
        //Short [][] result = new Short[this.width][this.height];
        Snake snake = (Snake)widgets[0];
        switch(keycode){
        case KeyEvent.VK_LEFT:
        	//snake.Move(Direction.LEFT, true);
        	snake.Move(Direction.LEFT, false);
        	break;
        case KeyEvent.VK_UP:
        	//snake.Move(Direction.UP, true);
        	snake.Move(Direction.UP, false);
        	break;
        case KeyEvent.VK_RIGHT:
        	//snake.Move(Direction.RIGHT, true);
        	snake.Move(Direction.RIGHT, false);
        	break;
        case KeyEvent.VK_DOWN:
	    	//snake.Move(Direction.DOWN, true);
        	snake.Move(Direction.DOWN, false);
	    	break;
        }
        return ProjectWidgets();
    }

    /*
    加载部件
     */
    public void LoadWidgets(Widget[] widgets, Map keymap){
        Snake snake = new Snake(15, 15, (short)3);
        Mouse mouse = new Mouse(10,10);
        this.widgets = new Widget[]{snake,mouse};
    }
}