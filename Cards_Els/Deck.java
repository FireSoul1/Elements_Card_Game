import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Deck 
{
	private ArrayList<Card> deck;
	
    public Deck() 
    {
    	Scanner i = new Scanner(System.in);
    	deck = new ArrayList<Card>();
    	try {
			importDeck(i.next());
		} catch (FileNotFoundException e) {
			//SWALLOW EXCEPTION
			e.printStackTrace();
		}
    }

    public void importDeck(String file) throws FileNotFoundException
    {
    	if(file.equals(""))
    	{	
    		Scanner in = new Scanner(new File("default.dat"));
    		while(in.hasNext())
    		{
    			//String[] inp = in.nextLine().split(" " );
    			deck.add(CardFactory.createCard(in.nextLine()));
    		}
    		
    	}
    	else
    	{
    		Scanner in = new Scanner(new File(file));
    		while(in.hasNext())
    		{
    			//String[] inp = in.nextLine().split(" " );
    			deck.add(CardFactory.createCard(in.nextLine()));
    		}
    	}
    }

	public void drawTo(ArrayList<Card> hand) {//draws a card from the "top"(index 0) of the deck and puts it in hand
		if(!deck.isEmpty()){
			Card c = deck.remove(0);
			hand.add(c);
		}
	}
    
}