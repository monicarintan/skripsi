/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ahc_monica;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MONICA
 */
public class AHC_MONICA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.next();
        NumberFormat nf=NumberFormat.getInstance();
        if(nf instanceof DecimalFormat){
            ((DecimalFormat)nf).getDecimalFormatSymbols().setDecimalSeparator(',');
        }
        try {
            System.out.println(nf.parse(str));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
    
}
