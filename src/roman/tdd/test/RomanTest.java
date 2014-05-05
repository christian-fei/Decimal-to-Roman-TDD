package roman.tdd.test;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map.Entry;

import roman.tdd.app.*;
import static org.junit.Assert.*;

import org.junit.*;

public class RomanTest {
    public Roman roman;
    
    /* new Roman(dec) shortcut*/
    public void nr(int dec){
        try { roman = new Roman(dec); }
        catch (Exception e) { e.printStackTrace();}
    }
    
    @Test(expected=Exception.class)
    public void minusOneShouldFail(){
        nr(-1);
        assertEquals(roman.toString(), "I");
    }
        
    @Test
    public void oneShouldEqualI(){
        nr(1);
        assertEquals(roman.toString(), "I");
    }

    @Test
    public void twoShouldEqualII(){
        nr(2);
        assertEquals(roman.toString(), "II");
    }
    
    @Test
    public void twentyFourShouldEqualXXIV(){
        nr(24);
        assertEquals(roman.toString(), "XXIV");
    }
    
    public void testingOtherNumbers(){
        nr(50);
        assertEquals(roman.toString(), "L");
        nr(40);
        assertEquals(roman.toString(), "XL");
        nr(39);
        assertEquals(roman.toString(), "IXL");
        nr(35);
        assertEquals(roman.toString(), "XXXV");
        nr(38);
        assertEquals(roman.toString(), "XXXVIII");
        nr(156);
        assertEquals(roman.toString(), "CLVI");
    }

}
