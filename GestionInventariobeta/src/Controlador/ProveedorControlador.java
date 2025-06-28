/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Proveedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Controlador.Conexion;
/**
 *
 * @author Gamer
 */
public class ProveedorControlador {
    private Connection conexion;

    // Constructor que recibe la conexión
    public ProveedorControlador(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para listar todos los proveedores
    public List<Proveedor> listar(String texto) {
        List<Proveedor> lista = new ArrayList<>();
    String sql = "SELECT * FROM proveedor WHERE nombre LIKE ?";
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, "%" + texto + "%");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Proveedor proveedor = new Proveedor(
                rs.getString("nombre"),
                rs.getString("direccion"),
                rs.getInt("Telefono")
            );
            lista.add(proveedor);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
    }

    // Método para buscar proveedores por nombre
    public List<Proveedor> buscar(String texto) {
        return listar(texto);  // Llama al método listar para la búsqueda
    }
    
}
