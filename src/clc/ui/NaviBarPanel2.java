package clc.ui;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class NaviBarPanel2 extends JPanel 
{
	private BufferedImage image;
    public NaviBarPanel2() 
    {
       try 
       {                
          image = ImageIO.read(new File("./src/¸¨Öú.jpg"));
       } 
       catch (IOException ex) 
       {   
    	   ex.printStackTrace();
       }
    }
    
    @Override
    public void paintComponent(Graphics g) 
    {
        g.drawImage(image, 0,0,this.getWidth(), this.getHeight(), null);
    }
}
