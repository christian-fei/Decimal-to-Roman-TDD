package roman.tdd.app;

import static org.junit.Assert.*;

import java.util.*;
import java.util.Map.Entry;

import org.junit.Before;

public class Roman {    
    private int decimal;
    private int reduced;
    
    // {{}} initilization http://www.c2.com/cgi/wiki?DoubleBraceInitialization
    // order is important for the reduce process
    private LinkedHashMap<Integer, String> decimalRomanMap = new LinkedHashMap<Integer, String>(){{
        put(1000, "M");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};
    
    public Roman(int decimal) throws Exception{
        if( decimal < 0 || decimal > 3999 ){ throw new Exception("Romans would be mad. Number must be between 0 and 3999");}
        this.decimal = decimal;
    }
    
    private String reduce(){
        this.reduced = this.decimal;
        String roman = "";
        for( Entry<Integer, String> entry : decimalRomanMap.entrySet() ){
            while( reduced >= entry.getKey() ){
                reduced -= entry.getKey();
                roman += entry.getValue();
            }
        }
        return roman;
    }
    
    public String toString(){
        String roman = decimalRomanMap.get( this.decimal );
        if( roman != null ) return roman;
        return reduce();
    }
}
