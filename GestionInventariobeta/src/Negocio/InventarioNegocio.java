
package Negocio;
import Controlador.inventarioControlador;
import Modelo.Producto;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;



public class InventarioNegocio {
    private final inventarioControlador controlador;
    public InventarioNegocio(inventarioControlador controlador) {
        this.controlador = controlador;
    }
     // Método para obtener los productos con o sin filtro
    public DefaultTableModel listarProductos(String texto) {
        // Llamamos al controlador para obtener los productos
        List<Producto> productos = controlador.listar(texto);

        // Definimos los títulos de las columnas
        String[] columnas = {"ID", "Nombre", "Descripción", "Precio", "Cantidad", "Categoría"};
        
        // Creamos el modelo de tabla para visualizar los productos
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        
        // Añadimos los productos al modelo
        for (Producto producto : productos) {
            String[] registro = new String[6];
            registro[0] = String.valueOf(producto.getIdProducto());
            registro[1] = producto.getNombreProducto();
            registro[2] = producto.getDescripcion();
            registro[3] = String.valueOf(producto.getPrecio());
            registro[4] = String.valueOf(producto.getCantidad());
            registro[5] = producto.getCategoria();
            modelo.addRow(registro);
        }

        return modelo;
    }

    // Método para insertar un producto
    public String insertarProducto(String nombre, String descripcion, double precio, int cantidad, String categoria) {
        // Creamos un objeto Producto con los datos proporcionados
        Producto producto = new Producto();
        producto.setNombreProducto(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        producto.setCategoria(categoria);

        // Usamos el controlador para insertar el producto en la base de datos
        if (controlador.insertar(producto)) {
            return "Producto insertado correctamente.";
        } else {
            return "Error al insertar el producto.";
        }
    }

    // Método para actualizar un producto
    public String actualizarProducto(Producto producto) {
        if (controlador.actualizar(producto)) {
            return "Producto actualizado correctamente.";
        } else {
            return "Error al actualizar el producto.";
        }
    }

    // Método para eliminar un producto
    public String eliminarProducto(String nombreProducto) {
        if (controlador.eliminar(nombreProducto)) {
            return "Producto eliminado correctamente.";
        } else {
            return "Error al eliminar el producto.";
        }
    }

    // Método para verificar si un producto existe
    public boolean existeProducto(String nombreProducto) {
        return controlador.existe(nombreProducto);
    }
    
}
