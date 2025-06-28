

package Negocio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Modelo.Ventas;
import Controlador.VentaControlador;
import Controlador.Conexion;

/**
 *
 * @author Gamer
 */
public class VentaNegocio {
     private final VentaControlador DATOS;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;
    
    public VentaNegocio() {
         this.DATOS = new VentaControlador(Conexion.getInstancia().conectar());
    }
    
    public DefaultTableModel listar(String texto) {
        List<Ventas> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));        
        String[] titulos = {"ID", "Cliente", "Fecha", "Total"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String[] registro = new String[4];
        
        for (Ventas item : lista) {
            registro[0] = String.valueOf(item.getIdVenta());
            registro[1] = item.getCliente();
            registro[2] = item.getFecha().toString();
            registro[3] = String.valueOf(item.getTotal());
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }
    
    public String insertar(String cliente, java.util.Date fecha, double total) {
        if (DATOS.existe(cliente)) {
            return "ATENCIÓN, el registro ya existe...";
        } else {
            Ventas obj = new Ventas();
            obj.setCliente(cliente);
            obj.setFecha(fecha);
            obj.setTotal(total);
            
            if (DATOS.insertar(obj)) {
                return "ATENCIÓN, registro almacenado correctamente";
            } else {
                return "ATENCIÓN, ocurrió un error al guardar el registro.";
            }
        }
    }
}

    
    

