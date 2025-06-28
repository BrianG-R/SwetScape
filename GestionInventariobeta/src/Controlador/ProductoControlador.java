/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Interfaces.CrudInterface;

/**
 *
 * @author Gamer
 */
public class ProductoControlador implements CrudInterface {
    private Connection conexion;

    public ProductoControlador(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Producto> listar(String texto) {
        List<Producto> productos = new ArrayList<>();
    String sql = "SELECT * FROM producto WHERE nombre LIKE ?";
    
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, "%" + texto + "%");  // Filtra por nombre_producto
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            // Asegúrate de que los tipos de datos coincidan con los de la clase Producto
            productos.add(new Producto(
                    rs.getInt("id_producto"),       // id_producto es un entero
                    rs.getString("nombre"),// nombre_producto es una cadena
                    rs.getString("descripcion"),    // descripcion es una cadena
                    rs.getDouble("precio"),         // precio es un double
                    rs.getInt("cantidad_stock"),          // cantidad es un entero
                    rs.getString("categoria")       // categoria es una cadena
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return productos;
        
    }

    
    public boolean insertar(Producto producto) {
        String sql = "INSERT INTO producto (nombre, descripcion, precio, cantidad_stock, categoria) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, producto.getNombreProducto());
            stmt.setString(2, producto.getDescripcion());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getCantidad());
            stmt.setString(5, producto.getCategoria());

            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        
        
        
    }

    @Override
    public boolean actualizar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existe(String nombreProducto) {
        String sql = "SELECT 1 FROM producto WHERE nombre = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombreProducto);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        
    }

    @Override
    public List<Producto> buscar(String texto) {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE nombre LIKE ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, "%" + texto + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                productos.add(new Producto(
                    rs.getInt("id_producto"),       // id_producto es un entero
                    rs.getString("nombre"),// nombre_producto es una cadena
                    rs.getString("descripcion"),    // descripcion es una cadena
                    rs.getDouble("precio"),         // precio es un double
                    rs.getInt("cantidad"),          // cantidad es un entero
                    rs.getString("categoria")       // categoria es una cadena
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return productos;
    }

    @Override
    public boolean insertar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
