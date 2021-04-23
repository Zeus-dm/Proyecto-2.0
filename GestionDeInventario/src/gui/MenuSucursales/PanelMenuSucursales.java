
package gui.MenuSucursales;

import FunGenerales.FunSucursal;
import gui.MenuRegiones.*;
import gui.MenuPrincipal.*;
import gui.FramePrincipal;
import enumeraciones.Colores;
import enumeraciones.Texto;

import java.awt.Color;
import java.util.List;

public class PanelMenuSucursales extends javax.swing.JPanel {
    private FramePrincipal fp = null;
    private final FunSucursal controladorSucursal;
    
    public PanelMenuSucursales(FramePrincipal fp, String nombreRegion) {
        this.fp = fp;
        controladorSucursal = new FunSucursal(this.fp.getSistema().obtenerRegion(nombreRegion));
        
        initComponents();
        
        iniciarDatos();
    }
    
    private void iniciarDatos(){
        labelTitulo.setText(controladorSucursal.nombreRegion()+" - Sucursales");
        ajustarTitulo();
        
        cargarSucursales(controladorSucursal.nombresSucursales());
        
        switch (fp.imagen) {
            case 0 ->
                labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/imagenes/chefcito_100.png"))); // NOI18N
            case 1 ->
                labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/imagenes/seba_100.png"))); // NOI18N
        }
    }
    
    private void ajustarTitulo(){
        int tamano = 24;
        
        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, tamano));
        while(true){
            if(labelTitulo.getPreferredSize().width > 400){
                labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, tamano));
            }else{
                break;
            }
            tamano -= 1;
        }
    }
    
    private void cargarSucursales(List<String> sucursales){
        String matriz[][] = new String[sucursales.size()][1];
        
        for (int i = 0; i < sucursales.size(); i++) {
            matriz[i][0] = "  " + sucursales.get(i);
        }
        
        tableSucursales.setModel(new javax.swing.table.DefaultTableModel(
            matriz,
            new String [] {
                ""
            }
        ){
            @Override
            public boolean isCellEditable(int row, int column){return false;}
        }     
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        jScrollPaneSucursales = new javax.swing.JScrollPane();
        tableSucursales = new javax.swing.JTable();
        jPanelImagen = new javax.swing.JPanel();
        labelImagen = new javax.swing.JLabel();
        buttonAgregar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();
        buttonVolver = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(400, 450));
        setPreferredSize(new java.awt.Dimension(400, 450));

        jPanelFondo.setBackground(Color.decode(Colores.FONDO.getColor(fp.modo)));
        jPanelFondo.setMaximumSize(new java.awt.Dimension(400, 450));
        jPanelFondo.setMinimumSize(new java.awt.Dimension(400, 450));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(fp.modo))
        );
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.REGIONES.getTexto());
        labelTitulo.setPreferredSize(new java.awt.Dimension(400, 32));

        jScrollPaneSucursales.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.modo))));
        jScrollPaneSucursales.setPreferredSize(new java.awt.Dimension(214, 376));
        jScrollPaneSucursales.getViewport().setBackground(Color.decode(Colores.FONDO.getColor(fp.modo)));

        tableSucursales.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(fp.modo)));
        tableSucursales.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableSucursales.setForeground(Color.decode(Colores.TEXTO.getColor(fp.modo)));
        tableSucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableSucursales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableSucursales.setGridColor(Color.decode(Colores.FONDO.getColor(fp.modo)));
        tableSucursales.setRowHeight(35);
        tableSucursales.getTableHeader().setReorderingAllowed(false);
        tableSucursales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSucursalesMouseClicked(evt);
            }
        });
        jScrollPaneSucursales.setViewportView(tableSucursales);

        jPanelImagen.setBackground(Color.decode(Colores.FONDO.getColor(fp.modo)));
        jPanelImagen.setPreferredSize(new java.awt.Dimension(120, 120));

        labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/imagenes/chefcito_100.png"))); // NOI18N
        labelImagen.setToolTipText("Volver al Menu Principal");
        labelImagen.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.modo))));
        labelImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelImagen.setPreferredSize(new java.awt.Dimension(100, 100));
        labelImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelImagenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelImagenLayout = new javax.swing.GroupLayout(jPanelImagen);
        jPanelImagen.setLayout(jPanelImagenLayout);
        jPanelImagenLayout.setHorizontalGroup(
            jPanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImagenLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelImagenLayout.setVerticalGroup(
            jPanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImagenLayout.createSequentialGroup()
                .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        buttonAgregar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(fp.modo)));
        buttonAgregar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonAgregar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(fp.modo)));
        buttonAgregar.setText(Texto.AGREGAR.getTexto());
        buttonAgregar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.modo))));
        buttonAgregar.setFocusable(false);
        buttonAgregar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarActionPerformed(evt);
            }
        });

        buttonEliminar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(fp.modo)));
        buttonEliminar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonEliminar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(fp.modo)));
        buttonEliminar.setText(Texto.ELIMINAR.getTexto());
        buttonEliminar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.modo))));
        buttonEliminar.setFocusable(false);
        buttonEliminar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        buttonVolver.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(fp.modo)));
        buttonVolver.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonVolver.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(fp.modo)));
        buttonVolver.setText(Texto.VOLVER.getTexto());
        buttonVolver.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.modo))));
        buttonVolver.setFocusable(false);
        buttonVolver.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneSucursales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(jPanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(buttonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVolverActionPerformed
        PanelMenuRegiones pmr = new PanelMenuRegiones(fp);
        fp.cargarPanel(pmr);
    }//GEN-LAST:event_buttonVolverActionPerformed

    private void tableSucursalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSucursalesMouseClicked
       
    }//GEN-LAST:event_tableSucursalesMouseClicked

    private void labelImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelImagenMouseClicked
        PanelMenuPrincipal pmp = new PanelMenuPrincipal(fp);
        fp.cargarPanel(pmp);
    }//GEN-LAST:event_labelImagenMouseClicked

    private void buttonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarActionPerformed
        DialogMenuSucursal dms = new DialogMenuSucursal(new javax.swing.JFrame(), true, fp, 1, controladorSucursal.nombreRegion());
        dms.setVisible(true);
        
        cargarSucursales(controladorSucursal.nombresSucursales());
    }//GEN-LAST:event_buttonAgregarActionPerformed

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        /*DialogMenuSucursal dms = new DialogMenuSucursal(new javax.swing.JFrame(), true, fp, 2, posRegion);
        dms.setVisible(true);*/
    }//GEN-LAST:event_buttonEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAgregar;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonVolver;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JPanel jPanelImagen;
    private javax.swing.JScrollPane jScrollPaneSucursales;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTable tableSucursales;
    // End of variables declaration//GEN-END:variables
}