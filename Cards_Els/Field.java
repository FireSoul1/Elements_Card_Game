import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*; 
public class Field
{
	public static void main (String[] args) 
	{
		JFrame tre = new JFrame();
		tre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Background t = new Background();
		tre.add(t);
		tre.setBounds(0,0,1400,750);
		tre.setVisible(true);
    }
}
class Environment extends JPanel implements KeyListener, MouseListener
{
	int type;
	boolean win;
	int numClicks;
	public Environment()
	{
		type=0;
		win=false;
		numClicks=0;
	}
	public void demoCards(Graphics g)
	{
		try
			{
				 c1=ImageIO.read(new File("lee1.gif"));
				 c3=ImageIO.read(new File("bal1.gif"));
				 c4=ImageIO.read(new File("sou1.gif"));
				 c2=ImageIO.read(new File("mad1.gif"));
				 fiel=ImageIO.read(new File("hell1.gif"));		
				/// change button images
			}catch(IOException e){}
			g.drawImage(c1,100*1+(1*105),350,null);
			///timer.delay(10000);
			g.drawImage(c2,100*2+(2*105),100,null);
			//timer.delay(1000);
			g.drawImage(c3,100*3+(3*105),350,null);
			///timer.delay(1000);
			g.drawImage(c4,100*4+(4*105),100,null);
			g.drawImage(fiel,0,100,null);
				
	}
	public void paintComponent(Graphics g)
	{
		while(!win)
		{
			backDraw(g);
			if(numClicks==1)
			{
				demoCards(g);	
			}
			try
			{
				Thread.sleep(10000);
			}catch(Exception e){};
		}
	}
	Image
	public void backDraw(Graphics g)
	{
		switch(type)
			{
				case 0:g.setColor(Color.yellow);break;
				case 1: g.setColor(Color.red);break;
				case 2: g.setColor(Color.green);break;
			}
			g.fillRect(0,0,1400,750);
			
			g.setColor(Color.green);
			g.fillRect(25,25,500,40);
			g.fillRect(25,600,500,40);
			g.setColor(Color.gray);
			g.setFont(new Font("Arial", Font.BOLD, 24));
			g.drawString("PLAYER 1", 75,60);
			g.drawString("PLAYER 2", 75,635);
			
			g.setColor(Color.magenta);
			g.fillRect(0,100,150,220);
			g.fillRect(0,350,150,220);
			g.setFont(new Font("Arial",Font.ITALIC,21));
			g.setColor(Color.cyan);
			g.drawString("FIELD EFFECT",0,210);
			g.drawString("DISCARD PILE",0,470);	
	}
	
	
	public void mouseExited(MouseEvent e)
	{
		
	}
	public void mouseEntered(MouseEvent e)
	{
		
	}
	public void mouseClicked(MouseEvent e)
	{
		//loc = e.getPoint();
		numClicks++;
		
			// this will show either your hand or your magic card
			// then, when end is clicked, the stage will become the environment
			// damage calulations will be done after this in paintComponent
			/*
			 *
			 *
			 **/
			
	}
	public void mouseReleased(MouseEvent e)
	{
		
	}
	public void mousePressed(MouseEvent e)
	{
		
	}
	public void keyPressed(KeyEvent e)
	{
		
	}
	public void keyReleased(KeyEvent e)
	{
	}
	public void keyTyped(KeyEvent e)
	{
	}


	
	
}