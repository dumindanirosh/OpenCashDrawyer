/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package opencashdrawyer;

import java.awt.print.PrinterJob;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

/**
 *
 * @author Duminda
 */
public class OpenCashDrawyer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Runnable openCashDrawer = new Runnable() {

            public synchronized void run() {
                try {

                    PrintService[] printService1 = PrinterJob.lookupPrintServices();

                    PrintService printService = printService1[0];
                    DocPrintJob job = printService.createPrintJob();
                    DocAttributeSet das = new HashDocAttributeSet();
                    PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
                    SimpleDoc doc = new SimpleDoc(new byte[]{0x1B, 0x70, 0x00, 0x32, -0x06}, DocFlavor.BYTE_ARRAY.AUTOSENSE, das);
                    job.print(doc, pras);

                } catch (PrintException ex) {

                   

                }
            }
        };
        (new Thread(openCashDrawer)).start();
    }

}
