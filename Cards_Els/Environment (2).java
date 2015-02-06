import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Environment 
{
	public static void main (String[] args) 
	{
		JFrame tre = new JFrame();
		tre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Background t = new Background();
		//TestCard p = new TestCard(100,100);
		
		tre.add(t);
		//tre.add(p);
		
		tre.setBounds(0,0,1400,750);
	//	tre.pack();
		tre.setVisible(true);
    }
}
class Background extends JPanel implements MouseListener
{
	//TreeMap<Boolean,Card> inPlay;//stores what is in play, each boolean value indicates the player who owns it
	///ArrayList<Card> sideGood;
	///ArrayList<Card> sideBad;
	//// ArrayList<Card> Discard; contains all the used Cards
	boolean win;// did anyone win?
	////////////////////////////////////////////////////////Card field; stores the field spell
	Rectangle r1,r2,r3,r4,r5,f1,f2,f3,f4,f5;// put all the other ones that will be in this loction, will be used by MouseListener.
	int type;//field type
	Point loc;// this stores the mouses loction. Depending upon the step of the turn, this will have differnent effect
	int numClicks;// this will change the phase
	public Background()
	{
		//r1 = new Rectangle()
		int x = 100;
		int y=100;
		for(int i=1;i<6;i++)
		{
			x = 100*i;
			y=100; 
			Point c = new Point(x+(i*100),y);
			switch(i)
			{
				case 1:r1 =new Rectangle(c,new Dimension(50,100));break;
				case 2:r2 =new Rectangle(c,new Dimension(50,100));break;
				case 3:r3 =new Rectangle(c,new Dimension(50,100));break;
				case 4:r4 =new Rectangle(c,new Dimension(50,100));break;
				case 5:r5 =new Rectangle(c,new Dimension(50,100));break;
			}
		}
		y=200;
		for(int i=1;i<6;i++)
		{
			x = 100*i;
			y=100; 
			Point c = new Point(x+(i*100),y);
			switch(i)
			{
				case 1:r1 =new Rectangle(c,new Dimension(50,100));break;
				case 2:r2 =new Rectangle(c,new Dimension(50,100));break;
				case 3:r3 =new Rectangle(c,new Dimension(50,100));break;
				case 4:r4 =new Rectangle(c,new Dimension(50,100));break;
				case 5:r5 =new Rectangle(c,new Dimension(50,100));break;
			}
		}
		win=false;
		type =0;
		setVisible(true);
	//	field  = new EnvironCard();
	}
	public void paint(Graphics g)
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
			for(int u=1;u<6;u++)
			{
				TestCard t  = new TestCard(100*u+(u*105),100);
				t.drawCard(g);
			}
			
			g.setColor(Color.magenta);
			g.fillRect(0,100,150,220);
			g.fillRect(0,350,150,220);
			g.setFont(new Font("Arial",Font.ITALIC,21));
			g.setColor(Color.cyan);
			g.drawString("FIELD EFFECT",0,210);
			g.drawString("DISCARD PILE",0,470);
			
			for(int u=1;u<6;u++)
			{
				TestCard t  = new TestCard(100*u+(u*105),350);
				t.drawCard(g);
			}
			//First step will be to wait until the player draws.
			///next step is to display cards he has.
			/// next, display cards on the field.
	}
	public void mouseExited(MouseEvent e)
	{
		
	}
	public void mouseEntered(MouseEvent e)
	{
		
	}
	public void mouseClicked(MouseEvent e)
	{
		loc = e.getPoint();
		if(loc.equals(new Point(1200,600)))// the draw button
			numClicks++;
		else
		{
			// this will show either your hand or your magic card
			// then, when endd is clicked, the stage will become the evironment
			// damage calulations will be done after this in paintComponent
			
		}	
	}
	public void mouseReleased(MouseEvent e)
	{
		
	}
	public void mousePressed(MouseEvent e)
	{
		
	}
}
class TestCard extends JLayeredPane
{
	int x1;
	int y1;
	public TestCard(int x, int y)
	{
		x1=x;
		y1=y;
		setVisible(true);
		setFocusable(true);
	    //setSize(new Dimension(50,200));
	}
	public void drawCard(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(x1,y1,150,220);
	}
	
}
/*class CardPic extends JPanel implements MouseListener 
{
	Card data;
	public CardPic(Card d)
	{
		data=d;
	}
	public void paint(Graphics g)
	{
		///take in the image using ImageIO
		/// then draw it in the location that is availible if played
		/// else display in the hand area.
	}

	public void mouseExited(MouseEvent e)
	{
		
	}
	public void mouseEntered(MouseEvent e)
	{
		
	}
	public void mouseClicked(MouseEvent e)
	{
		
	}
	public void mouseReleased(MouseEvent e)
	{
		
	}
	public void mousePressed(MouseEvent e)
	{
		
	}
	
	
} */