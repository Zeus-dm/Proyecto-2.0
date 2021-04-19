
package gui.MenuProductos;

import FunGenerales.FunProducto;
import gui.MenuPrincipal.*;
import gui.FramePrincipal;
import enumeraciones.Colores;
import enumeraciones.Texto;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class PanelMenuProductos extends javax.swing.JPanel {
    private FramePrincipal fp = null;
    private final List<String> barCodesFiltrados = new ArrayList<>();
    
    public PanelMenuProductos(FramePrincipal fp) {
        this.fp = fp;
        
        initComponents();
        
        iniciarDatos();
    }
    
    private void iniciarDatos(){
        cargarProductos(FunProducto.listarNombresTodosProductos(fp.getSistema(), barCodesFiltrados));
        labelError.setText("");
        
        switch (fp.imagen) {
            case 0 ->
                labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/imagenes/chefcito_100.png"))); // NOI18N
            case 1 ->
                labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/imagenes/seba_100.png"))); // NOI18N
        }
    }
    
    private void cargarProductos(List<String> productos){
        String matriz[][] = new String[productos.size()][1];
        
        for (int i = 0; i < productos.size(); i++) {
            matriz[i][0] = "  " + productos.get(i);
        }
        
        tableProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        buttonVolver = new javax.swing.JButton();
        textBuscar = new javax.swing.JTextField();
        buttonBuscar = new javax.swing.JButton();
        labelPrecio = new javax.swing.JLabel();
        labelMin = new javax.swing.JLabel();
        textMin = new javax.swing.JTextField();
        labelMax = new javax.swing.JLabel();
        textMax = new javax.swing.JTextField();
        labelError = new javax.swing.JLabel();
        jScrollPaneProductos = new javax.swing.JScrollPane();
        tableProductos = new javax.swing.JTable();
        jPanelImagen = new javax.swing.JPanel();
        labelImagen = new javax.swing.JLabel();
        buttonGraficar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(400, 450));
        setPreferredSize(new java.awt.Dimension(400, 450));

        jPanelFondo.setBackground(Color.decode(Colores.FONDO.getColor(fp.modo)));
        jPanelFondo.setMaximumSize(new java.awt.Dimension(400, 450));
        jPanelFondo.setMinimumSize(new java.awt.Dimension(400, 450));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(fp.modo))
        );
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.PRODUCTOS.getTexto());
        labelTitulo.setPreferredSize(new java.awt.Dimension(400, 32));

        buttonVolver.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(fp.modo)));
        buttonVolver.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonVolver.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(fp.modo)));
        buttonVolver.setText(Texto.VOLVER.getTexto());
        buttonVolver.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.modo))));
        buttonVolver.setFocusable(false);
        buttonVolver.setPreferredSize(new java.awt.Dimension(114, 32));
        buttonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVolverActionPerformed(evt);
            }
        });

        textBuscar.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(fp.modo)));
        textBuscar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textBuscar.setForeground(Color.decode(Colores.TEXTO.getColor(fp.modo)));
        textBuscar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.modo))), javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 1, Color.decode(Colores.FONDO_TABLA.getColor(fp.modo)))));
        textBuscar.setPreferredSize(new java.awt.Dimension(210, 32));

        buttonBuscar.setBackground(Color.decode(Colores.FONDO.getColor(fp.modo)));
        buttonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_LUPA.getColor(fp.modo))));
        buttonBuscar.setToolTipText("Buscar");
        buttonBuscar.setBorder(null);
        buttonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonBuscar.setFocusable(false);
        buttonBuscar.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarActionPerformed(evt);
            }
        });

        labelPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPrecio.setForeground(Color.decode(Colores.TEXTO.getColor(fp.modo)));
        labelPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPrecio.setText(Texto.PRECIO.getTexto());
        labelPrecio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(fp.modo))));
        labelPrecio.setPreferredSize(new java.awt.Dimension(114, 22));

        labelMin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelMin.setForeground(Color.decode(Colores.TEXTO.getColor(fp.modo)));
        labelMin.setText(Texto.MIN.getTexto());
        labelMin.setPreferredSize(new java.awt.Dimension(30, 22));

        textMin.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(fp.modo)));
        textMin.setForeground(Color.decode(Colores.TEXTO.getColor(fp.modo)));
        textMin.setText("0");
        textMin.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.modo))), javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 1, Color.decode(Colores.FONDO_TABLA.getColor(fp.modo)))));
        textMin.setPreferredSize(new java.awt.Dimension(69, 22));

        labelMax.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelMax.setForeground(Color.decode(Colores.TEXTO.getColor(fp.modo)));
        labelMax.setText(Texto.MAX.getTexto());
        labelMax.setPreferredSize(new java.awt.Dimension(30, 22));

        textMax.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(fp.modo)));
        textMax.setForeground(Color.decode(Colores.TEXTO.getColor(fp.modo)));
        textMax.setText("0");
        textMax.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.modo))), javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 1, Color.decode(Colores.FONDO_TABLA.getColor(fp.modo)))));
        textMax.setPreferredSize(new java.awt.Dimension(69, 22));

        labelError.setForeground(Color.decode(Colores.TEXTO_ERROR.getColor(fp.modo)));
        labelError.setText("* Error: Posible error");
        labelError.setPreferredSize(new java.awt.Dimension(114, 16));

        jScrollPaneProductos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.modo))));
        jScrollPaneProductos.setPreferredSize(new java.awt.Dimension(248, 338));
        jScrollPaneProductos.getViewport().setBackground(Color.decode(Colores.FONDO.getColor(fp.modo)));

        tableProductos.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(fp.modo)));
        tableProductos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableProductos.setForeground(Color.decode(Colores.TEXTO.getColor(fp.modo)));
        tableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableProductos.setGridColor(Color.decode(Colores.FONDO.getColor(fp.modo)));
        tableProductos.setRowHeight(35);
        tableProductos.getTableHeader().setReorderingAllowed(false);
        tableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductosMouseClicked(evt);
            }
        });
        jScrollPaneProductos.setViewportView(tableProductos);

        jPanelImagen.setBackground(Color.decode(Colores.FONDO.getColor(fp.modo)));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelImagenLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanelImagenLayout.setVerticalGroup(
            jPanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelImagenLayout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        buttonGraficar.setBackground(Color.decode(Colores.FONDO.getColor(fp.modo)));
        buttonGraficar.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_GRAFICO_BARRA.getColor(fp.modo))));
        buttonGraficar.setToolTipText("Graficar Marcas");
        buttonGraficar.setBorder(null);
        buttonGraficar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonGraficar.setFocusable(false);
        buttonGraficar.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGraficarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonGraficar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textMax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(labelPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                        .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(buttonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFondoLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(buttonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelFondoLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPaneProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(labelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addComponent(labelMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addComponent(textMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonGraficar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        PanelMenuPrincipal pmp = new PanelMenuPrincipal(fp);
        fp.cargarPanel(pmp);
    }//GEN-LAST:event_buttonVolverActionPerformed

    private void labelImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelImagenMouseClicked
        PanelMenuPrincipal pmp = new PanelMenuPrincipal(fp);
        fp.cargarPanel(pmp);
    }//GEN-LAST:event_labelImagenMouseClicked

    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarActionPerformed
        String ok = FunProducto.verificarMinMax(textMin.getText(), textMax.getText());
        if(ok != null){
            labelError.setText(ok);
        }else{
            labelError.setText("");
            int min = Integer.parseInt(textMin.getText());
            int max = Integer.parseInt(textMax.getText());
            cargarProductos( FunProducto.listarProductos(fp.getSistema(), min, max, textBuscar.getText(), barCodesFiltrados) ); //para que al seleccionar saber que filtraba en ese momento
        }
    }//GEN-LAST:event_buttonBuscarActionPerformed

    private void tableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductosMouseClicked
        int pos = tableProductos.getSelectedRow();
        
        DialogMenuProducto dmp = new DialogMenuProducto(new javax.swing.JFrame(), true, fp, barCodesFiltrados.get(pos));
        dmp.setVisible(true);

        String ok = FunProducto.verificarMinMax(textMin.getText(), textMax.getText());
        if(ok != null){
            labelError.setText(ok);
            cargarProductos( FunProducto.listarNombresTodosProductos(fp.getSistema(), barCodesFiltrados) );
        }else{
            labelError.setText("");
            int min = Integer.parseInt(textMin.getText());
            int max = Integer.parseInt(textMax.getText());
            cargarProductos( FunProducto.listarProductos(fp.getSistema(), min, max, textBuscar.getText(), barCodesFiltrados) ); //para que al seleccionar saber que filtraba en ese momento
        }
    }//GEN-LAST:event_tableProductosMouseClicked

    private void buttonGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGraficarActionPerformed
        DialogMenuProducto dmp = new DialogMenuProducto(new javax.swing.JFrame(), true, fp, "");
        dmp.setVisible(true);
    }//GEN-LAST:event_buttonGraficarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonGraficar;
    private javax.swing.JButton buttonVolver;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JPanel jPanelImagen;
    private javax.swing.JScrollPane jScrollPaneProductos;
    private javax.swing.JLabel labelError;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelMax;
    private javax.swing.JLabel labelMin;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTable tableProductos;
    private javax.swing.JTextField textBuscar;
    private javax.swing.JTextField textMax;
    private javax.swing.JTextField textMin;
    // End of variables declaration//GEN-END:variables
}