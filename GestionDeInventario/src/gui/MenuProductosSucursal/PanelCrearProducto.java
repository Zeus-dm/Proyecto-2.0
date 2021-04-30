
package gui.MenuProductosSucursal;

import gui.MenuProductos.*;
import enumeraciones.Colores;
import enumeraciones.Texto;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PanelCrearProducto extends javax.swing.JPanel {
    private DialogMenuProductosSucursal dmps = null;
    
    public PanelCrearProducto(DialogMenuProductosSucursal dmps) {
        this.dmps = dmps;
        
        int tamX = dmps.getSize().width - 350;
        int tamY = dmps.getSize().height - 430;

        initComponents();
        this.dmps.setSize(350, 430);
        this.dmps.setLocation(dmps.getLocation().x + (tamX/2), dmps.getLocation().y + (tamY/2));
        
        iniciarDatos();
    }
    
    private void iniciarDatos(){
        labelError.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        labelMarca = new javax.swing.JLabel();
        textMarca = new javax.swing.JTextField();
        labelBarCode = new javax.swing.JLabel();
        labelSignoGato = new javax.swing.JLabel();
        textBarCode = new javax.swing.JTextField();
        labelPrecio = new javax.swing.JLabel();
        labelSignoPeso = new javax.swing.JLabel();
        textPrecio = new javax.swing.JTextField();
        labelDescripcion = new javax.swing.JLabel();
        jScrollPaneDescripcion = new javax.swing.JScrollPane();
        textDescripcion = new javax.swing.JTextPane();
        labelError = new javax.swing.JLabel();
        buttonAceptar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        labelStock = new javax.swing.JLabel();
        textStock = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))));

        jPanelFondo.setBackground(Color.decode(Colores.FONDO.getColor(dmps.getFramePrincipal().modo)));
        jPanelFondo.setPreferredSize(new java.awt.Dimension(350, 270));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(dmps.getFramePrincipal().modo)));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.AGREGAR_NUEVO_PRODUCTO.getTexto());
        labelTitulo.setPreferredSize(new java.awt.Dimension(350, 30));

        labelNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNombre.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        labelNombre.setText(Texto.NOMBRE.getTexto());
        labelNombre.setPreferredSize(new java.awt.Dimension(90, 26));

        textNombre.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(dmps.getFramePrincipal().modo)));
        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        textNombre.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))), javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 1, Color.decode(Colores.FONDO_TABLA.getColor(dmps.getFramePrincipal().modo)))));
        textNombre.setPreferredSize(new java.awt.Dimension(182, 26));

        labelMarca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelMarca.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        labelMarca.setText(Texto.MARCA.getTexto());
        labelMarca.setPreferredSize(new java.awt.Dimension(90, 26));

        textMarca.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(dmps.getFramePrincipal().modo)));
        textMarca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMarca.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        textMarca.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))), javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 1, Color.decode(Colores.FONDO_TABLA.getColor(dmps.getFramePrincipal().modo)))));
        textMarca.setPreferredSize(new java.awt.Dimension(182, 26));

        labelBarCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelBarCode.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        labelBarCode.setText(Texto.BARCODE.getTexto());
        labelBarCode.setPreferredSize(new java.awt.Dimension(90, 26));

        labelSignoGato.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelSignoGato.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        labelSignoGato.setText("#");
        labelSignoGato.setPreferredSize(new java.awt.Dimension(10, 25));

        textBarCode.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(dmps.getFramePrincipal().modo)));
        textBarCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textBarCode.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        textBarCode.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))), javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 1, Color.decode(Colores.FONDO_TABLA.getColor(dmps.getFramePrincipal().modo)))));
        textBarCode.setPreferredSize(new java.awt.Dimension(166, 26));

        labelPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPrecio.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        labelPrecio.setText(Texto.PRECIO.getTexto());
        labelPrecio.setPreferredSize(new java.awt.Dimension(90, 26));

        labelSignoPeso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelSignoPeso.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        labelSignoPeso.setText("$");
        labelSignoPeso.setPreferredSize(new java.awt.Dimension(10, 25));

        textPrecio.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(dmps.getFramePrincipal().modo)));
        textPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPrecio.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        textPrecio.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))), javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 1, Color.decode(Colores.FONDO_TABLA.getColor(dmps.getFramePrincipal().modo)))));
        textPrecio.setPreferredSize(new java.awt.Dimension(166, 26));

        labelDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDescripcion.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        labelDescripcion.setText(Texto.DESCRIPCION.getTexto());
        labelDescripcion.setPreferredSize(new java.awt.Dimension(90, 26));

        jScrollPaneDescripcion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))));
        jScrollPaneDescripcion.setPreferredSize(new java.awt.Dimension(230, 70));

        textDescripcion.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(dmps.getFramePrincipal().modo)));
        textDescripcion.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 1, Color.decode(Colores.FONDO_TABLA.getColor(dmps.getFramePrincipal().modo)))));
        textDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDescripcion.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        jScrollPaneDescripcion.setViewportView(textDescripcion);

        labelError.setForeground(Color.decode(Colores.TEXTO_ERROR.getColor(dmps.getFramePrincipal().modo)));
        labelError.setText("* Posible Error");
        labelError.setPreferredSize(new java.awt.Dimension(290, 16));

        buttonAceptar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonAceptar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonAceptar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonAceptar.setText(Texto.ACEPTAR.getTexto());
        buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))));
        buttonAceptar.setFocusable(false);
        buttonAceptar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });

        buttonCancelar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonCancelar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonCancelar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonCancelar.setText(Texto.CANCELAR.getTexto());
        buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))));
        buttonCancelar.setFocusable(false);
        buttonCancelar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        labelStock.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelStock.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        labelStock.setText(Texto.STOCK.getTexto());
        labelStock.setPreferredSize(new java.awt.Dimension(90, 26));

        textStock.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(dmps.getFramePrincipal().modo)));
        textStock.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textStock.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        textStock.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))), javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 1, Color.decode(Colores.FONDO_TABLA.getColor(dmps.getFramePrincipal().modo)))));
        textStock.setPreferredSize(new java.awt.Dimension(182, 26));

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(buttonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanelFondoLayout.createSequentialGroup()
                                    .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(textNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelFondoLayout.createSequentialGroup()
                                    .addComponent(labelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(textMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelFondoLayout.createSequentialGroup()
                                    .addComponent(labelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPaneDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelFondoLayout.createSequentialGroup()
                                    .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanelFondoLayout.createSequentialGroup()
                                            .addComponent(labelBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(labelSignoGato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelFondoLayout.createSequentialGroup()
                                            .addComponent(labelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(labelSignoPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(3, 3, 3)
                                    .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textBarCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanelFondoLayout.createSequentialGroup()
                                    .addComponent(labelStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(textStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelSignoGato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSignoPeso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, 348, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed
        try {
            String ok = dmps.controladorProductoSucursal.agregarProducto(textNombre.getText(), textMarca.getText(), textBarCode.getText(), textStock.getText(), textPrecio.getText(), textDescripcion.getText());
            if(ok != null){
                labelError.setText(ok);
            }else{
                dmps.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelCrearProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAceptarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        PanelMenuAgregarProducto pmap = new PanelMenuAgregarProducto(dmps);
        dmps.cargarPanel(pmap);
    }//GEN-LAST:event_buttonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JScrollPane jScrollPaneDescripcion;
    private javax.swing.JLabel labelBarCode;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelError;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelSignoGato;
    private javax.swing.JLabel labelSignoPeso;
    private javax.swing.JLabel labelStock;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextField textBarCode;
    private javax.swing.JTextPane textDescripcion;
    private javax.swing.JTextField textMarca;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textPrecio;
    private javax.swing.JTextField textStock;
    // End of variables declaration//GEN-END:variables
}