package Controlador;

import Controlador.Conexion;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PruebaConexion {
    public static void main(String[] args) {
            Conexion con=Conexion.getInstancia();
            con.conectar();
            if (con.cadena!=null){
                System.out.println("Conectado");
            } else{
                System.out.println("Desconectado");
            }
            con.desconectar(); 
    }
}
