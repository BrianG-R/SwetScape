/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Vista.Venta;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author conta
 */

public class Menu extends javax.swing.JFrame {
    
   
  private boolean estado;
    
    private ImageIcon imagen;
    private Icon icono;
    public Menu() {
        initComponents();
        eventosmenu();
       //this.pintarImagen(jimagen, "src/main/java/Imagenes/fondo.jpg");
    }

    
     // metodo para salir   del jframe menu
     public void cerrar(){
              int opcion = 0;
            opcion = JOptionPane.showConfirmDialog(this,
                    "¿Seguro que desea cerrar el programa?", "Aviso",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

            switch (opcion) {
                case JOptionPane.YES_OPTION:
                    System.exit(0);
                    break;
                case JOptionPane.NO_OPTION:
                    break;
                case JOptionPane.CLOSED_OPTION:
                    break;
                default:
                    break;
            }
     }
    
     private void eventosmenu()
    {
       
         
    
  
       
    }
    
    public void setEstado(boolean estado2)
    {
        this.estado = estado2;
    }
    
    public boolean getEstado()
    {
        return estado;
    }
    
    private void pintarImagen(JLabel lbl, String ruta)
    {
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(this.imagen.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
        lbl.setIcon(this.icono);
        this.repaint();
    }
      

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jAcceso = new javax.swing.JMenu();
        jMaestros = new javax.swing.JMenu();
        jAyuda = new javax.swing.JMenu();
        jAcceso1 = new javax.swing.JMenu();
        jAcceso2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jAcceso.setText("Inventario");
        jAcceso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAccesoMouseClicked(evt);
            }
        });
        jMenuBar2.add(jAcceso);

        jMaestros.setText("Producto");
        jMaestros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMaestrosMouseClicked(evt);
            }
        });
        jMenuBar2.add(jMaestros);

        jAyuda.setText("Proveedor");
        jAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAyudaMouseClicked(evt);
            }
        });
        jAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAyudaActionPerformed(evt);
            }
        });
        jMenuBar2.add(jAyuda);

        jAcceso1.setText("Reporte");
        jMenuBar2.add(jAcceso1);

        jAcceso2.setText("Venta");
        jAcceso2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAcceso2MouseClicked(evt);
            }
        });
        jMenuBar2.add(jAcceso2);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 751, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAyudaActionPerformed

    }//GEN-LAST:event_jAyudaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrar();
       
    }//GEN-LAST:event_formWindowClosing

    private void jAcceso2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAcceso2MouseClicked
        Venta venta = new Venta();
        venta.setVisible(true);
                // TODO add your handling code here:
    }//GEN-LAST:event_jAcceso2MouseClicked

    private void jAccesoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAccesoMouseClicked
        Inventario inventario = new Inventario();
        inventario.setVisible(true);
    }//GEN-LAST:event_jAccesoMouseClicked

    private void jMaestrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMaestrosMouseClicked
        Productos producto = new Productos();
        producto.setVisible(true);
        
    }//GEN-LAST:event_jMaestrosMouseClicked

    private void jAyudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAyudaMouseClicked
        Proveedores proveedor = new Proveedores();
        proveedor.setVisible(true);
    }//GEN-LAST:event_jAyudaMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jAcceso;
    private javax.swing.JMenu jAcceso1;
    private javax.swing.JMenu jAcceso2;
    private javax.swing.JMenu jAyuda;
    private javax.swing.JMenu jMaestros;
    private javax.swing.JMenuBar jMenuBar2;
    // End of variables declaration//GEN-END:variables
}
