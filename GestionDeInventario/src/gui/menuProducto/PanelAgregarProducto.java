package gui.menuProducto;

import enumeraciones.Colores;
import enumeraciones.Texto;
import enumeraciones.TextoErrores;
import gui.TextPrompt;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanelAgregarProducto extends javax.swing.JPanel {

    PanelMenuProductos pmp = null;

    public PanelAgregarProducto(PanelMenuProductos pmp) {
        this.pmp = pmp;

        initComponents();
    }

    private void recargarColores() {
        textNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
        textMarca.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
        textBarCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
        textPrecio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));

        labelErrorNombre.setVisible(false);
        labelErrorMarca.setVisible(false);
        labelErrorBarCode.setVisible(false);
        labelErrorPrecio.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        labelErrorNombre = new javax.swing.JLabel();
        labelMarca = new javax.swing.JLabel();
        textMarca = new javax.swing.JTextField();
        labelErrorMarca = new javax.swing.JLabel();
        labelBarCode = new javax.swing.JLabel();
        textBarCode = new javax.swing.JTextField();
        labelErrorBarCode = new javax.swing.JLabel();
        labelPrecio = new javax.swing.JLabel();
        textPrecio = new javax.swing.JTextField();
        labelErrorPrecio = new javax.swing.JLabel();
        labelDescripcion = new javax.swing.JLabel();
        scrollDescripcion = new javax.swing.JScrollPane();
        textDescripcion = new javax.swing.JTextPane();
        buttonAceptar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();

        setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(pmp.getFramePrincipal().getModo())));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.AGREGAR_PRODUCTO.getTexto());
        labelTitulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelTitulo.setPreferredSize(new java.awt.Dimension(548, 32));
        add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        labelNombre.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelNombre.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmp.getFramePrincipal().getModo())));
        labelNombre.setText(Texto.NOMBRE.getTexto());
        labelNombre.setPreferredSize(new java.awt.Dimension(388, 16));
        add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        textNombre.setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        textNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
        textNombre.setPreferredSize(new java.awt.Dimension(350, 28));
        TextPrompt placeHolder = new TextPrompt(Texto.NOMBRE.getTexto(), textNombre);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 66, 388, -1));

        labelErrorNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pmp.getFramePrincipal().getModo()))));
        labelErrorNombre.setToolTipText("Aqui deberia de ir un Error");
        labelErrorNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorNombre.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorNombre.setVisible(false);
        add(labelErrorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 66, -1, -1));

        labelMarca.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelMarca.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmp.getFramePrincipal().getModo())));
        labelMarca.setText(Texto.MARCA.getTexto());
        labelMarca.setPreferredSize(new java.awt.Dimension(171, 16));
        add(labelMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 112, -1, -1));

        textMarca.setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        textMarca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textMarca.setForeground(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        textMarca.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
        textMarca.setPreferredSize(new java.awt.Dimension(171, 28));
        placeHolder = new TextPrompt(Texto.MARCA.getTexto(), textMarca);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 128, -1, -1));

        labelErrorMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pmp.getFramePrincipal().getModo()))));
        labelErrorMarca.setToolTipText("Aqui deberia de ir un Error");
        labelErrorMarca.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorMarca.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorMarca.setVisible(false);
        add(labelErrorMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 128, -1, -1));

        labelBarCode.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelBarCode.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmp.getFramePrincipal().getModo())));
        labelBarCode.setText(Texto.BARCODE.getTexto());
        labelBarCode.setPreferredSize(new java.awt.Dimension(171, 16));
        add(labelBarCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 112, -1, -1));

        textBarCode.setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        textBarCode.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textBarCode.setForeground(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        textBarCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
        textBarCode.setPreferredSize(new java.awt.Dimension(171, 28));
        placeHolder = new TextPrompt(Texto.BARCODE.getTexto(), textBarCode);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textBarCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 128, -1, -1));

        labelErrorBarCode.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pmp.getFramePrincipal().getModo()))));
        labelErrorBarCode.setToolTipText("Aqui deberia de ir un Error");
        labelErrorBarCode.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorBarCode.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorBarCode.setVisible(false);
        add(labelErrorBarCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 129, -1, -1));

        labelPrecio.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelPrecio.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmp.getFramePrincipal().getModo())));
        labelPrecio.setText(Texto.PRECIO.getTexto());
        labelPrecio.setPreferredSize(new java.awt.Dimension(171, 16));
        add(labelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 175, -1, -1));

        textPrecio.setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        textPrecio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textPrecio.setForeground(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        textPrecio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
        textPrecio.setPreferredSize(new java.awt.Dimension(171, 28));
        placeHolder = new TextPrompt(Texto.PRECIO.getTexto(), textPrecio);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 191, -1, -1));

        labelErrorPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pmp.getFramePrincipal().getModo()))));
        labelErrorPrecio.setToolTipText("Aqui deberia de ir un Error");
        labelErrorPrecio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorPrecio.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorPrecio.setVisible(false);
        add(labelErrorPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 191, -1, -1));

        labelDescripcion.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelDescripcion.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmp.getFramePrincipal().getModo())));
        labelDescripcion.setText(Texto.DESCRIPCION.getTexto());
        labelDescripcion.setPreferredSize(new java.awt.Dimension(388, 16));
        add(labelDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 237, -1, -1));

        scrollDescripcion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
        scrollDescripcion.setPreferredSize(new java.awt.Dimension(388, 88));

        textDescripcion.setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        textDescripcion.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 1, Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())))));
        textDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDescripcion.setForeground(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        textDescripcion.setCaretPosition(0);
        textDescripcion.setPreferredSize(new java.awt.Dimension(388, 85));
        placeHolder = new TextPrompt(Texto.DESCRIPCION.getTexto(), textDescripcion);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        scrollDescripcion.setViewportView(textDescripcion);

        add(scrollDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 253, 388, 87));

        buttonAceptar.setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        buttonAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonAceptar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pmp.getFramePrincipal().getModo())));
        buttonAceptar.setText(Texto.ACEPTAR.getTexto());
        buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
        buttonAceptar.setFocusPainted(false);
        buttonAceptar.setFocusable(false);
        buttonAceptar.setOpaque(true);
        buttonAceptar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAceptar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pmp.getFramePrincipal().getModo())));
                buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAceptar.setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
                buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
            }
        });
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });
        add(buttonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, -1, -1));

        buttonCancelar.setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        buttonCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonCancelar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pmp.getFramePrincipal().getModo())));
        buttonCancelar.setText(Texto.CANCELAR.getTexto());
        buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
        buttonCancelar.setFocusPainted(false);
        buttonCancelar.setFocusable(false);
        buttonCancelar.setOpaque(true);
        buttonCancelar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCancelar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pmp.getFramePrincipal().getModo())));
                buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCancelar.setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
                buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
            }
        });
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        add(buttonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed
        recargarColores();

        try {
            String error = pmp.controlProducto.agregarProducto(textNombre.getText(), textMarca.getText(), textBarCode.getText(), textPrecio.getText(), textDescripcion.getText());
            if (error == null) {
                PanelMenuProductos newPmp = new PanelMenuProductos(pmp.getFramePrincipal());
                pmp.getFramePrincipal().cargarPanel(newPmp);
            } else if (error.equals(TextoErrores.NOMBRE_VACIO.getTexto()) || error.equals(TextoErrores.MAXIMO_CARACTERES_NOMBRE_40.getTexto())) {
                labelErrorNombre.setVisible(true);
                labelErrorNombre.setToolTipText(error);

                textNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pmp.getFramePrincipal().getModo()))));
            } else if (error.equals(TextoErrores.MARCA_VACIO.getTexto()) || error.equals(TextoErrores.MAXIMO_CARACTERES_MARCA_20.getTexto())) {
                labelErrorMarca.setVisible(true);
                labelErrorMarca.setToolTipText(error);

                textMarca.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pmp.getFramePrincipal().getModo()))));
            } else if (error.equals(TextoErrores.BARCODE_VACIO.getTexto()) || error.equals(TextoErrores.BARCODE_RANGO.getTexto()) || error.equals(TextoErrores.BARCODE_DUPLICADO.getTexto())) {
                labelErrorBarCode.setVisible(true);
                labelErrorBarCode.setToolTipText(error);

                textBarCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pmp.getFramePrincipal().getModo()))));
            } else if (error.equals(TextoErrores.PRECIO_VACIO.getTexto()) || error.equals(TextoErrores.PRECIO_RANGO.getTexto()) || error.equals(TextoErrores.PRECIO_CERO.getTexto()) || error.equals(TextoErrores.PRECIO_INVALIDO.getTexto())) {
                labelErrorPrecio.setVisible(true);
                labelErrorPrecio.setToolTipText(error);

                textPrecio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pmp.getFramePrincipal().getModo()))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelAgregarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAceptarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        PanelMenuProductos newPmp = new PanelMenuProductos(pmp.getFramePrincipal());
        pmp.getFramePrincipal().cargarPanel(newPmp);
    }//GEN-LAST:event_buttonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JLabel labelBarCode;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelErrorBarCode;
    private javax.swing.JLabel labelErrorMarca;
    private javax.swing.JLabel labelErrorNombre;
    private javax.swing.JLabel labelErrorPrecio;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JScrollPane scrollDescripcion;
    private javax.swing.JTextField textBarCode;
    private javax.swing.JTextPane textDescripcion;
    private javax.swing.JTextField textMarca;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textPrecio;
    // End of variables declaration//GEN-END:variables
}
