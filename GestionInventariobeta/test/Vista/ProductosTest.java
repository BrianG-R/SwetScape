/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Vista;
import Negocio.ProductoNegocio;
import Modelo.Producto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.table.DefaultTableModel;
import Vista.Productos;
import javax.swing.JTable;  
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel; 



/**
 *
 * @author Gamer
 */
public class ProductosTest {
    private Productos vista;
    private ProductoNegocio negocio;
    private DefaultTableModel tableModel;
    
    public ProductosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       
        vista = new Productos();
        negocio = new ProductoNegocio();
        tableModel = (DefaultTableModel) vista.getTabla1().getModel();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    //Esta es la prueba unitaria para el metodo de cargar datos en la tabla
    @Test
    public void testCargarDatosTabla() {
        // Simulamos que el negocio lista los productos correctamente
        DefaultTableModel modeloEsperado = negocio.listar("");
        // Comprobamos que el modelo de la tabla tiene los mismos datos
        assertEquals(modeloEsperado.getRowCount(), vista.getTabla1().getRowCount());

    }
    

    
}   
