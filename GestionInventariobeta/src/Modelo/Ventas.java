package Modelo;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Ventas {
    private int idVenta;
    private List<Producto> productos;
    private List<Integer> cantidades;
    private String cliente;
    private Date fecha;
    private double total;

    public Ventas(int idVenta, List<Producto> productos, List<Integer> cantidades, String cliente, Date fecha, double total) {
        this.idVenta = idVenta;
        this.productos = productos;
        this.cantidades = cantidades;
        this.cliente = cliente;
        this.fecha = fecha;
        this.total = total;
    }
     public Ventas() {
        this.productos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }

    public void setCantidades(List<Integer> cantidades) {
        this.cantidades = cantidades;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", productos=" + productos +
                ", cantidades=" + cantidades +
                ", cliente='" + cliente + '\'' +
                ", fecha=" + fecha +
                ", total=" + total +
                '}';
    }
    
}
