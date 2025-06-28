/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import Controlador.ProveedorControlador;
import Modelo.Proveedor;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Gamer
 */
public class ProveedorNegocio {
     private ProveedorControlador controlador;

    // Constructor que recibe la conexión de la base de datos
    public ProveedorNegocio(Connection conexion) {
        this.controlador = new ProveedorControlador(conexion);
    }

    // Método para listar los proveedores que coinciden con el texto de búsqueda
    public List<Proveedor> listarProveedores(String texto) {
        // Aquí podrías aplicar alguna lógica adicional si es necesario
        return controlador.listar(texto);
    }

    // Método para buscar proveedores por nombre
    public List<Proveedor> buscarProveedores(String texto) {
        // Lógica de negocio adicional si es necesario
        return controlador.buscar(texto);
    }
    
}
