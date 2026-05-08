/*
 * Mathematical Skills II, Programming
 */
 
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for EAN codes
 *
 */
public class EANTest
{
    
    private void testEAN(long ean, boolean valid) {
        String msg = "Testing "+ (valid ? "" : "in") + "valid EAN "+ean;
        assertEquals(msg, valid, EAN.isValidEAN(ean));
    }

    private void testBarcode(long ean, String expectedBarcode) {
        String msg = "Testing EAN "+ean;
        assertEquals(msg, expectedBarcode, EAN.constructBarcode(ean));
    }
    @Test
    public void isValidEANTest()
    {
        testEAN(4006381333931L, true);
        testEAN(9783540614517L, true);
        testEAN(5016196048554L, true);
        
        testEAN(4003994155486L, true);
        testEAN(4103994155486L, false);
        testEAN(4003994155476L, false);

        testEAN(4017100209239L, true);
        testEAN(3017100209239L, false);
        testEAN(4017101209239L, false);
        testEAN(4017100209231L, false);

        testEAN(12345, false);
        testEAN(-1234567890123L, false);
        testEAN(12345678901234L, false);

    }
    
    @Test
    public void constructBarcodeTest()
    {
        testBarcode(4017100209239L, "X_X___XX_X_XX__XX_XXX_XX__XX__X_X__XXX_X__XXX_X_X_XX_XX__XXX__X_XXX_X__XX_XX__X____X_XXX_X__X_X");
        testBarcode(9783540614517L, "X_X_XXX_XX___X__X_X____X_XX___X__XXX_X___XX_X_X_X_X_X____XX__XX_X_XXX__X__XXX_XX__XX_X___X__X_X");
        testBarcode(4004764391288L, "X_X___XX_X_X__XXX_X___XX_XXX_XX____X_X__XXX_X_X_X_X____X_XXX_X__XX__XX_XX_XX__X__X___X__X___X_X");
    }

}
