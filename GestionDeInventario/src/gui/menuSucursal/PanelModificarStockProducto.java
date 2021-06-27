package gui.menuSucursal;

import enumeraciones.Colores;
import enumeraciones.Texto;
import enumeraciones.TextoErrores;
import gui.TextPrompt;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanelModificarStockProducto extends javax.swing.JPanel {

    PanelMenuSucursal pms = null;

    public PanelModificarStockProducto(PanelMenuSucursal pms) {
        this.pms = pms;

        initComponents();
        
        iniciarPanel();
    }
    
    private void iniciarPanel() {
        List<String> datos = pms.controlProducto.seleccionarProducto(pms.barCode);

        textNombre.setText(datos.get(0));
        pms.getFramePrincipal().reCargarTexto(textNombre, 18, 388, 0);
        
        textStockTienda.setText(datos.get(4));
    }

    private void recargarColores() {
        textStockTienda.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));

        labelErrorStock.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JLabel();
        labelStockTienda = new javax.swing.JLabel();
        textStockTienda = new javax.swing.JTextField();
        labelErrorStock = new javax.swing.JLabel();
        buttonAceptar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();

        setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(pms.getFramePrincipal().getModo())));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.MODIFICAR_STOCK.getTexto());
        labelTitulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        labelTitulo.setPreferredSize(new java.awt.Dimension(548, 32));
        add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        labelNombre.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelNombre.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pms.getFramePrincipal().getModo())));
        labelNombre.setText(Texto.NOMBRE.getTexto());
        labelNombre.setPreferredSize(new java.awt.Dimension(388, 16));
        add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        textNombre.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textNombre.setText("Nombre del Producto");
        textNombre.setOpaque(true);
        add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 66, 388, 28));

        labelStockTienda.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelStockTienda.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pms.getFramePrincipal().getModo())));
        labelStockTienda.setText(Texto.STOCK.getTexto());
        labelStockTienda.setPreferredSize(new java.awt.Dimension(140, 16));
        add(labelStockTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 112, -1, -1));

        textStockTienda.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        textStockTienda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textStockTienda.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textStockTienda.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        textStockTienda.setPreferredSize(new java.awt.Dimension(140, 28));
        TextPrompt placeHolder = new TextPrompt(Texto.EDAD.getTexto(), textStockTienda);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textStockTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 128, -1, -1));

        labelErrorStock.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
        labelErrorStock.setToolTipText("Aqui deberia de ir un Error");
        labelErrorStock.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorStock.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorStock.setVisible(false);
        add(labelErrorStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 128, -1, -1));

        buttonAceptar.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        buttonAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonAceptar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pms.getFramePrincipal().getModo())));
        buttonAceptar.setText(Texto.ACEPTAR.getTexto());
        buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        buttonAceptar.setFocusPainted(false);
        buttonAceptar.setFocusable(false);
        buttonAceptar.setOpaque(true);
        buttonAceptar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAceptar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pms.getFramePrincipal().getModo())));
                buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAceptar.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
                buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
        });
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });
        add(buttonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 206, -1, -1));

        buttonCancelar.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        buttonCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonCancelar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pms.getFramePrincipal().getModo())));
        buttonCancelar.setText(Texto.CANCELAR.getTexto());
        buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        buttonCancelar.setFocusPainted(false);
        buttonCancelar.setFocusable(false);
        buttonCancelar.setOpaque(true);
        buttonCancelar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCancelar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pms.getFramePrincipal().getModo())));
                buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCancelar.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
                buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
        });
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        add(buttonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 206, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed
        recargarColores();

        try {
            String error = pms.controlProducto.modificarStockProducto(pms.barCode, textStockTienda.getText());
            if (error == null) {
                PanelSeleccionarProductoSucursal psps = new PanelSeleccionarProductoSucursal(pms);
                pms.getFramePrincipal().cargarPanel(pms.getPanelProducto(), psps);
            } else if (error.equals(TextoErrores.STOCK_VACIO.getTexto()) || error.equals(TextoErrores.STOCK_RANGO.getTexto()) || error.equals(TextoErrores.STOCK_MAYOR_CERO.getTexto()) || error.equals(TextoErrores.STOCK_INVALIDO.getTexto())) {
                labelErrorStock.setVisible(true);
                labelErrorStock.setToolTipText(error);

                textStockTienda.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelModificarStockProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAceptarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        PanelSeleccionarProductoSucursal psps = new PanelSeleccionarProductoSucursal(pms);
        pms.getFramePrincipal().cargarPanel(pms.getPanelProducto(), psps);
    }//GEN-LAST:event_buttonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JLabel labelErrorStock;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelStockTienda;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel textNombre;
    private javax.swing.JTextField textStockTienda;
    // End of variables declaration//GEN-END:variables
}