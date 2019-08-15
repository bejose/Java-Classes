//
/**
 * Code for the Phrase O Matic example from the book
 * Heads First Java
 * @author Jose_Bezerra
 * @version 
 */
public class PhraseOMatic
{

    public static void main (String [] args)
    {
        //make three sets of words to choose from. Add your own!
        String[] wordListOne = {"24/7", "multi-Tier", "30,000 foot", "B-to-B", "win-win", "frotend",        
                                "web-based", "pervasive", "smart", "sixsigma", "critical-path", "dynamic"};
                                
        String[] wordListTwo = {"empowered", "sticky", "value-added", "oriented", "centric", "distributed",
                                "clustered", "branded", "outside-the-box", "positioned", "networked", "focused",
                                "leveraged", "aligned", "targeted", "shared", "cooperative", "acelerated"};
                                
        String[] wordListThree = {"process", "tippingpoint", "solution", "architeture", "core competency", "strategy",
                                "mindshare", "portal", "space", "vision", "paradigm", "mission"};
        
        //find out how many words are in each list                       
        int oneLenght = wordListOne.length;
        int twoLenght = wordListTwo.length;                        
        int threeLenght = wordListThree.length;
        
        //generate three random numbers
        int rand1 = (int)(Math.random() * oneLenght);
        int rand2 = (int)(Math.random() * twoLenght);
        int rand3 = (int)(Math.random() * threeLenght);
        
        //now generate a phrase
        String phrase = wordListOne[rand1] + " " +wordListTwo[rand2] + " " + wordListThree[rand3];
        
        //print out the phrase
        System.out.println("What we need is a " + phrase);
        
    }
}//end of the class