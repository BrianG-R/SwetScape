
package Controlador;
import Modelo.Reporte;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Interfaces.CrudInterface;

public class ReporteControlador implements CrudInterface {
     private Connection conexion;

    public ReporteControlador(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List listar(String texto) {
        List<Reporte> reportes = new ArrayList<>();
        String sql = "SELECT * FROM reportes WHERE descripcion LIKE ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, "%" + texto + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reportes.add(new Reporte(
                        rs.getInt("id"),  // ID del reporte
                        rs.getDate("fecha_inicio"),  // Fecha de inicio del reporte
                        rs.getDate("fecha_fin"),  // Fecha de fin del reporte
                        rs.getDouble("total_ventas")  // Total de ventas
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reportes;
    }

    
    public boolean insertar(Reporte reporte) {
         String sql = "INSERT INTO reportes (fecha_inicio, fecha_fin, total_ventas) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setDate(1, new java.sql.Date(reporte.getFechaInicio().getTime()));
            stmt.setDate(2, new java.sql.Date(reporte.getFechaFin().getTime()));
            stmt.setDouble(3, reporte.getTotalVentas());

            if (stmt.executeUpdate() > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    reporte.setId(rs.getInt(1)); // Obtiene el ID generado para el nuevo reporte
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
    public boolean actualizar(Reporte reporte) {
        String sql = "UPDATE reportes SET fecha_inicio = ?, fecha_fin = ?, total_ventas = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(reporte.getFechaInicio().getTime()));
            stmt.setDate(2, new java.sql.Date(reporte.getFechaFin().getTime()));
            stmt.setDouble(3, reporte.getTotalVentas());
            stmt.setInt(4, reporte.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminar(String id) {
        String sql = "DELETE FROM reportes WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(id));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean existe(String id) {
         String sql = "SELECT 1 FROM reportes WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List buscar(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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