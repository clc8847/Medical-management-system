package clc.ui;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class MyJPanel extends JPanel 
{
	private BufferedImage image;
    public MyJPanel() 
    {
       try 
       {                
          image = ImageIO.read(new File("./src/µÇÂ¼½çÃæ.jpg"));
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
