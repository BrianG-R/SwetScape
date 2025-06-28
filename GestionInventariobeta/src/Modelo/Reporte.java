
package Modelo;
import java.util.Date;
import java.util.List;

public class Reporte {

    private int id; // ID del reporte
    private Date fechaInicio; // Fecha de inicio del reporte
    private Date fechaFin; // Fecha de fin del reporte
    private double totalVentas; // Total de ventas en el reporte
    
    // Constructor para crear el reporte con fechas y total de ventas
    public Reporte(int id, Date fechaInicio, Date fechaFin, double totalVentas) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.totalVentas = totalVentas;
        
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }

   
    // Método para representar el reporte como un string
    @Override
    public String toString() {
        return "Reporte{" +
                "id=" + id +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", totalVentas=" + totalVentas +
                
                '}';
    }
}
