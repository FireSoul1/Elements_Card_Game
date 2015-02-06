import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*; 
public class Environment 
{
	public static void main (String[] args) 
	{
		JFrame tre = new JFrame();
		tre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Background t = new Background();
		//TestCard p = new TestCard(100,100);
		tre.add(t);
		//tre.pack();
		//tre.add(p);
		
		tre.setBounds(0,0,1400,750);
	//	tre.pack();
		tre.setVisible(true);
    }
}
class Background extends JPanel implements MouseListener
{
	
	int LifePoints1;
	int LifePoints2;
	//TreeMap<Boolean,Card> inPlay;//stores what is in play, each boolean value indicates the player who owns it
	///ArrayList<Card> sideGood;
	///ArrayList<Card> sideBad;
	////ArrayList<Card> handG;
	////ArrayList<Card> handB;
	//// ArrayList<Card> Discard; contains all the used Cards
	GameProgress progress;// did anyone win?
	////////////////Card field; stores the field spell
	Rectangle r1,r2,r3,r4,r5,f1,f2,f3,f4,f5;// put all the other ones that will be in this loction, will be used by MouseListener.
	int type;//field type
	Point loc;// this stores the mouses loction. Depending upon the step of the turn, this will have differnent effect
	int numClicks;// this will change the phase
	boolean turn;
	Image fiel;
	public Background()
	{
		numClicks=0;
		try
		{
			 timer = new Robot();
		}catch(Exception e){}
		progress = GameProgress.INPROGRESS;
		
		LifePoints1 = 4000;
		LifePoints2 = 4000;
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
		numClicks=0;
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
	//	win=false;
		type =0;
		setVisible(true);
	//	field  = new EnvironCard();
	}
	Image c1,c2,c3,c4;
	Robot timer;
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
	public void paintComponent(Graphics g) 
	{
		while(numClicks>=0/*progress!=GameProgress.P1WIN && progress!=GameProgress.P2WIN*/)
		{
			
			//g.setFont(new Font("Arial", Font.BOLD, 34));
			//timer.delay(1000);
			//g.setColor(Color.CYAN);
			//g.drawString("WELCOME TO THE ROMANTIC YUGIOH CHILDREN'S CARD GAME!!!",200,200);
			ArrayList<Card> f = new ArrayList<Card>();
			//timer.delay(1000);
			for(int i=0;i<3;i++)
			{
				CardFactory.createCard((int)(Math.random()*5/*CardFactory.numCardIDs*/));
			}
			backDraw(g);
			Hand h1 = new Hand(f,g);
			for(int u=1;u<6;u++)
			{
				TestCard t  = new TestCard(100*u+(u*105),100);
				t.drawCard(g);
			}	
			if(numClicks==0)
			{			
				timer.delay(1000);
			}
			//First step will be to wait until the player draws.
			///next step is to display cards he has.
			/// next, display cards on the field.
			if(numClicks>0) 
				demoCards(g);
			turn=!turn;
		 	//numClicks=0;
		//	clear(g);
		}
			
	}
	public void clear(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0,0,1400,750);
	}
	Image t2,t3,t4;

	public void drawButtons(Graphics f)
	{
		
		try
		{
			c1=ImageIO.read(new File("i1.gif")); 
			t2=ImageIO.read(new File("i2.png")); 
			t3=ImageIO.read(new File("i3.gif"));
			t4=ImageIO.read(new File("i4.gif"));	
			//c1=cl;		
				/// change button images
		}catch(IOException e){}
		f.drawImage(c1,1180,250,null);
		f.drawImage(t2,1180,00,null);
		f.drawImage(t3,1180,470,null);
		f.drawImage(t4,950,580,null);
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
		numClicks++;
		if(loc.equals(new Point(1200,600)))// the draw button
		{
			numClicks++;
			progress = GameProgress.P1WIN;
			///if(turn)
			//////handG.add(play1.remove(0));
			///else
			//////handB.add(play2.remove(0));
		}
		else
		{
			// this will show either your hand or your magic card
			// then, when end is clicked, the stage will become the environment
			// damage calulations will be done after this in paintComponent
			/*
			 *
			 *
			 **/
			
		}	
		//repaint();	
	}
	public void mouseReleased(MouseEvent e)
	{
		
	}
	public void mousePressed(MouseEvent e)
	{
		
	}
	
	//if you want to perform card action
	//CardFactory.getCardAction(card.cardID).actUpon(Background e);
	//may have to change to take in background and hand
	
	private enum GameProgress{
		INPROGRESS,
		P1WIN,
		P2WIN;
	}
}
class Hand 
{
	ArrayList<Image> ar;
	Graphics gr;
	Image c1;
	public Hand(ArrayList<Card> s1, Graphics f)
	{
		//ar = s1;
		ar= new ArrayList<Image>();
		gr=f;
		try
		{
			c1=ImageIO.read(new File("lee1.gif"));
			ar.add(c1);
			c1=ImageIO.read(new File("sail1.png")); 
			ar.add(c1);
			c1=ImageIO.read(new File("rog1.gif"));
			ar.add(c1);
			c1=ImageIO.read(new File("sou1.gif"));	
			ar.add(c1);	
			//c1=cl;		
				/// change button images
		}catch(IOException e){}
	//	setVisible(true);
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		//g.fillRect(0,0,1400,750);
		g.setColor(Color.black);
		int offSet = 100;
		
		g.drawString("CHOMEIFTHISDOESN'TDISPLAY",100,offSet);
		offSet+=200;
	}
	public Image play(int num)
	{
		// switch(input)
		/*case VK_1:;break;
		 *case VK_2:;break;
		 *case VK_3:;break;
		 **/
		return ar.remove(0);
	}
	public void keyPressed(KeyEvent e)
	{
		play(Integer.parseInt(e.getKeyText(e.getKeyCode())));
	}
	public void keyReleased(KeyEvent e)
	{
	}
	public void keyTyped(KeyEvent e)
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

enum Type{
	NORMAL,
	LUST,
	GREED,
	DEATH,
	FAITH,
	NATURE;
	
	
}