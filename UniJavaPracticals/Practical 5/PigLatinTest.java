
import static org.junit.Assert.*;
import org.junit.Test;


/**
 * Unit test for Pig Latin translation
 */
public class PigLatinTest
{
    private void pigLatinTest(String original, String translated)
    {
        String msg = "Testing input string: "+original;
        assertEquals(msg, translated, PigLatin.translateToPigLatin(original)); 
    }
    
    @Test
    public void emptyStringTest()
    {
        pigLatinTest("", "");
    }
    
    @Test
    public void vowelFirstTest()
    {
        pigLatinTest("edit", "editway");
        pigLatinTest("apple", "appleway");
        pigLatinTest("is", "isway");
    }
    
    @Test
    public void oneConsonantTest()
    {
        pigLatinTest("duck", "uckday");
        pigLatinTest("goose", "oosegay");
        pigLatinTest("pigeon", "igeonpay");
    }

    @Test
    public void severalConsonantsTest()
    {
        pigLatinTest("slide", "ideslay");
        pigLatinTest("pride", "idepray");
        pigLatinTest("brain", "ainbray");
    }

    @Test
    public void unmodifiedTest()
    {
        pigLatinTest("yes", "yes");
        pigLatinTest("yay", "yay");
    }
    
    @Test
    public void uppercaseTest()
    {
        pigLatinTest("Duck", "uckday");
        pigLatinTest("GROUSE", "ousegray");
        pigLatinTest("Eel", "eelway");
    }

    @Test
    public void sentenceTest()
    {
        pigLatinTest("They all spoke a queer jargon which they themselves had invented", 
                     "eythay allway okespay away ueerqay argonjay ichwhay eythay emselvesthay adhay inventedway");
    }

}
