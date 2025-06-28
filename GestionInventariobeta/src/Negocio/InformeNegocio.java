
package Negocio;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JTable;
/**
 *
 * @author Gamer
 */
public class InformeNegocio {
    // Método para generar informe (imprimir tabla)
    public void imprimirTabla(JTable table) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(new Printable() {
            public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2d = (Graphics2D) g;
                g2d.translate(pf.getImageableX(), pf.getImageableY());

                // Aquí es donde imprimimos la tabla
                table.print(g);

                return Printable.PAGE_EXISTS;
            }
        });

        // Mostrar el diálogo de impresión
        boolean doPrint = printerJob.printDialog();
        if (doPrint) {
            try {
                // Ejecutar la impresión
                printerJob.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
    }
}
