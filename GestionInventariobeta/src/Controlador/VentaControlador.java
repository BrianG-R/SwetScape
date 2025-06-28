
package Controlador;
import Modelo.Ventas;
import java.sql.*;
import Interfaces.CrudInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Controlador.Conexion;

public class VentaControlador implements CrudInterface {
    private Connection conexion;

    public VentaControlador(Connection conexion) {
        this.conexion = conexion;
    }

    // Implementación del método listar
    public List<Ventas> listar(String texto) {
        List<Ventas> ventas = new ArrayList<>();
        String sql = "SELECT * FROM venta WHERE id_venta LIKE ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, "%" + texto + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ventas.add(new Ventas(
                        rs.getInt("id_venta"),
                        null, // Aquí iría la consulta para los productos vendidos
                        null,
                        rs.getString("cliente"),
                        rs.getDate("fecha"),
                        rs.getDouble("total")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }

    // Método insertar una venta
    public boolean insertar(Ventas venta) {
        String sql = "INSERT INTO ventas (cliente, fecha, total) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, venta.getCliente());
            stmt.setDate(2, new java.sql.Date(venta.getFecha().getTime()));
            stmt.setDouble(3, venta.getTotal());

            if (stmt.executeUpdate() > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int idVenta = rs.getInt(1);
                    // Aquí puedes insertar productos vendidos si es necesario
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método actualizar una venta
    public boolean actualizar(Ventas venta) {
        String sql = "UPDATE ventas SET cliente = ?, fecha = ?, total = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, venta.getCliente());
            stmt.setDate(2, new java.sql.Date(venta.getFecha().getTime()));
            stmt.setDouble(3, venta.getTotal());
            stmt.setInt(4, venta.getIdVenta());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método eliminar venta por id
    @Override
    public boolean eliminar(String id) {
        String sql = "DELETE FROM ventas WHERE id=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(id));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método existe venta por cliente
    @Override
    public boolean existe(String texto) {
        String sql = "SELECT 1 FROM ventas WHERE cliente = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, texto);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método buscar venta por id
    public Ventas buscarPorId(int id) {
        String sql = "SELECT * FROM ventas WHERE id=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Ventas(
                        rs.getInt("id_venta"),
                        null, // Aquí iría la consulta para los productos vendidos
                        null,
                        rs.getString("cliente"),
                        rs.getDate("fecha"),
                        rs.getDouble("total")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Implementación del método buscar en la interfaz
    @Override
    public List<Ventas> buscar(String texto) {
        return listar(texto);  // Redirigir a listar si el propósito es el mismo
    }

    // Eliminar las versiones genéricas de insertar y actualizar ya que no son necesarias
    @Override
    public boolean insertar(Object obj) {
        throw new UnsupportedOperationException("No se necesita esta implementación.");
    }

    @Override
    public boolean actualizar(Object obj) {
        throw new UnsupportedOperationException("No se necesita esta implementación.");
    }

    
    
}
