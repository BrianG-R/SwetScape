
package Controlador;
import Modelo.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Interfaces.CrudInterface;


public class inventarioControlador implements CrudInterface {
    private Connection conexion;

    public inventarioControlador(Connection conexion) {
        this.conexion = conexion;
    }

   
    public List<Producto> listar(String texto) {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE nombre LIKE ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, "%" + texto + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Producto(
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
    return lista;
    }

    
    public boolean insertar(Producto producto) {
        String sql = "INSERT INTO producto (nombre, descripcion, precio, cantidad_stock, categoria) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombreProducto());
            stmt.setString(2, producto.getDescripcion());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getCantidad());
            stmt.setString(5, producto.getCategoria());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
    public boolean actualizar(Producto producto) {
        String sql = "UPDATE producto SET descripcion=?, precio=?, cantidad_stock=?, categoria=? WHERE nombre=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, producto.getDescripcion());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getCantidad());
            stmt.setString(4, producto.getCategoria());
            stmt.setString(5, producto.getNombreProducto());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
    public boolean eliminar(String id) {
        String sql = "DELETE FROM producto WHERE nombre=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
    public boolean existe(String texto) {
        String sql = "SELECT COUNT(*) FROM producto WHERE nombre=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, texto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
    public List<Producto> buscar(String texto) {
        return listar(texto);
    }

    @Override
    public boolean insertar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
