import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//The "lookup table" for all cards to refer to
// as well as the way to create cards

//IMPORTANT INFO:
//ENVIRONMENT cards: ids begin at 0 and end at _
//MONSTER cards: ids begin at _ and end at _
//EFFECT cards: ids begin at _ and end at _

/*
  Full list of Card ID's (and corresponding name)
  1		Meteor
  2		Shadows
  3		Night
  4		Forest
  5		Village
  6		House
  7		Deep-Woods
  8		Midnight
  9		Tomb
  10	Catacombs
  11	Hell
  12	Cemetary
  13	RESERVED
  14	RESERVED
  15	RESERVED
  16	RESERVED
  17	RESERVED
  18	RESERVED
  19	RESERVED
  20	RESERVED
  21	RESERVED
  22	RESERVED
  23	RESERVED
  24	RESERVED
  25	Vixen
  26	Harlot
  27	Aphrodite
  28	Eros
  29	Black Man
  30	Abigail
  31	Siren
  32	
  33	
  34	
  35	
  36	
  37	
  38	
  39	
  40	
  41	
  42	
  43	
  44	
  45	
  46	
  47	
  48	
  49	
  50	
  
  
  
  
  
  
  
  
  
  
  
 */

public class CardFactory {
	public static final int numCardIDs = 150;
	
	private static Scanner in;
	private static Mode mode;

	public static Card createCard(String read){
		Card ret;
		String[] data = read.split(" ");
		char code = data[0].charAt(0);
		switch(code){
			case 'M':ret = new MonsterCard(Integer.parseInt(data[1]),10000,10000);
			case 'P':ret = new EffectCard(Integer.parseInt(data[1]));
			case 'E':ret = new EnvironmentCard(Integer.parseInt(data[1]));
			default:ret = new EnvironmentCard(0);
		}
		return ret;
	}
	
	public static Card createCard(int x){
		return new EnvironmentCard(x);
	}
	
	public static String getCardName(int cardID){//returns an empty string by default
		changeMode(Mode.NAME);
		for(int i = 0;i < cardID;i++)
			in.nextLine();
		return in.nextLine();
		//return "";
	}
	
	public static Type getCardType(int cardID){//returns NORMAL by default
		changeMode(Mode.TYPE);
		switch(cardID){
		case 1:return Type.NORMAL;//CARD TYPE GOES HERE
		}
		return Type.NORMAL;
	}
	
	public static Action getCardAction(int cardID){//returns null by default. Be careful when using this!
		switch(cardID){
		case 0:
			return new Action(){// This card is _____
				public void actUpon(Environment e){
					
					//CARD LOGIC GOES HERE e.g.
					//e.type = Type.NORMAL;
					
				}
			};
		case 1://rinse and repeat
				
		}
		return null;
	}
	
	private static boolean changeMode(Mode m){//returns true if mode changes
		boolean change = mode!=m;
		if(change)
			try {
				in = new Scanner(new File(m.assocFileName()));
			} catch (FileNotFoundException e) {
				System.out.println(e.getStackTrace());
			}
		return change;
	}
	
	private enum Mode{
		NAME("name.dat"),
		TYPE("types.dat"),
		STATS("stats.dat");
		
		String file;
		
		Mode(String s){
			file=s;
		}
		
		String assocFileName(){
			return file;
		}
	}
	
}
