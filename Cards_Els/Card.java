import java.util.*;

public /*abstract*/ class Card //implements Comparable<Card>  
{
	//char type;
	int cardID;//essential
	//int val;
	//double effect;

    public Card() 
    {
    	cardID=0;
    }
    
    public Card(int n)
    {
    	cardID=n;
    }
    
}