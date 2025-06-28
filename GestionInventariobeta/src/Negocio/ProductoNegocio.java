/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import Controlador.ProductoControlador;
import Modelo.Producto;
import Controlador.Conexion;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gamer
 */
public class ProductoNegocio {
    private final ProductoControlador DATOS;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    // Constructor que recibe una conexión
    public ProductoNegocio() {
        this.DATOS = new ProductoControlador(Conexion.getInstancia().conectar());;
    }

    // Método para obtener productos con o sin filtro
   public DefaultTableModel listar(String texto) {
        List<Producto> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));
        
        String[] titulos = {"nombre", "Descripción", "Precio", "Cantidad_stock", "Categoría"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String[] registro = new String[5];
        
        for (Producto item : lista) {
            registro[0] = item.getNombreProducto();
            registro[1] = item.getDescripcion();
            registro[2] = String.valueOf(item.getPrecio());
            registro[3] = String.valueOf(item.getCantidad());
            registro[4] = item.getCategoria();
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }
}
   
    

