package anakonda;

import javax.swing.ImageIcon;
import java.awt.*;

/**
 * 享元单位
 * @author lieh
 *
 */
public class ImageCell implements IImageCell{
	private ImageIcon img = null;
	private int tileId;
	
	public ImageCell(int key){
		this.tileId = key;
		img = new ImageIcon("resource\\" + key + ".png");
    }
	
	public Image getImg(){
		return img.getImage();
	}

	@Override
	public void Draw() {
		// TODO Auto-generated method stub
		System.out.println("key = " + tileId);
	}
}
