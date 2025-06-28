package Modelo;


public class Proveedor {
    
    private String nombreProveedor;
    private String direccion;
    private int numeroTelefono;
    
    
    public Proveedor(String nombreProveedor, String direccion, int numeroTelefono){
        
        this.nombreProveedor = nombreProveedor;
        this.direccion = direccion;
        this.numeroTelefono = numeroTelefono;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "nombreProveedor=" + nombreProveedor + ", direccion=" + direccion + ", numeroTelefono=" + numeroTelefono + '}';
    }
            
    
}
