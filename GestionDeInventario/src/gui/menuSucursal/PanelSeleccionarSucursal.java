package gui.menuSucursal;

import enumeraciones.Colores;
import enumeraciones.Texto;

import java.awt.Color;
import java.util.List;

public class PanelSeleccionarSucursal extends javax.swing.JPanel {

    PanelMenuSucursal pms = null;

    public PanelSeleccionarSucursal(PanelMenuSucursal pms) {
        this.pms = pms;

        initComponents();

        iniciarPanel();
    }

    private void iniciarPanel() {
        List<String> datos = pms.controlSucursal.seleccionarSucursal(pms.nombreSucursal);
        
        textDireccion.setText(datos.get(1));
        textTelefono.setText(datos.get(2));
        
        textNombre.setText(datos.get(3));
        pms.getFramePrincipal().reCargarTexto(textNombre, 18, 350, 0);
        
        textEdad.setText(datos.get(4));
        
        if(pms.controlSucursal.verificarExistenciaJefe(datos.get(0))){
            pms.getFramePrincipal().cargarPanel(panelBotones, panelBotonesConJefe);
        }else{
            pms.getFramePrincipal().cargarPanel(panelBotones, panelBotonesSinJefe);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotonesSinJefe = new javax.swing.JPanel();
        buttonAgregarJefe = new javax.swing.JButton();
        panelBotonesConJefe = new javax.swing.JPanel();
        buttonModificarJefe = new javax.swing.JButton();
        buttonEliminarJefe = new javax.swing.JButton();
        labelDirecccion = new javax.swing.JLabel();
        textDireccion = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelIdTelefono = new javax.swing.JLabel();
        textTelefono = new javax.swing.JLabel();
        buttonModificar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();
        labelJefeSucursal = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JLabel();
        labelEdad = new javax.swing.JLabel();
        textEdad = new javax.swing.JLabel();
        panelDecorativo = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();

        panelBotonesSinJefe.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        panelBotonesSinJefe.setPreferredSize(new java.awt.Dimension(70, 168));

        buttonAgregarJefe.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_AGREGAR_JEFE_SUCURSAL.getColor(pms.getFramePrincipal().getModo()))));
        buttonAgregarJefe.setBorder(null);
        buttonAgregarJefe.setBorderPainted(false);
        buttonAgregarJefe.setContentAreaFilled(false);
        buttonAgregarJefe.setFocusPainted(false);
        buttonAgregarJefe.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonAgregarJefe.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_AGREGAR_JEFE_SUCURSAL.getColor(pms.getFramePrincipal().getModo()))));
        buttonAgregarJefe.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_AGREGAR_JEFE_SUCURSAL_DRAGGED.getColor(pms.getFramePrincipal().getModo()))));
        buttonAgregarJefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarJefeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesSinJefeLayout = new javax.swing.GroupLayout(panelBotonesSinJefe);
        panelBotonesSinJefe.setLayout(panelBotonesSinJefeLayout);
        panelBotonesSinJefeLayout.setHorizontalGroup(
            panelBotonesSinJefeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesSinJefeLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(buttonAgregarJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelBotonesSinJefeLayout.setVerticalGroup(
            panelBotonesSinJefeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesSinJefeLayout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(buttonAgregarJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        panelBotonesConJefe.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        panelBotonesConJefe.setPreferredSize(new java.awt.Dimension(70, 168));

        buttonModificarJefe.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODIFICAR_JEFE_SUCURSAL.getColor(pms.getFramePrincipal().getModo()))));
        buttonModificarJefe.setBorder(null);
        buttonModificarJefe.setBorderPainted(false);
        buttonModificarJefe.setContentAreaFilled(false);
        buttonModificarJefe.setFocusPainted(false);
        buttonModificarJefe.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonModificarJefe.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODIFICAR_JEFE_SUCURSAL.getColor(pms.getFramePrincipal().getModo()))));
        buttonModificarJefe.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODIFICAR_JEFE_SUCURSAL_DRAGGED.getColor(pms.getFramePrincipal().getModo()))));
        buttonModificarJefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarJefeActionPerformed(evt);
            }
        });

        buttonEliminarJefe.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ELIMINAR_JEFE_SUCURSAL.getColor(pms.getFramePrincipal().getModo()))));
        buttonEliminarJefe.setBorder(null);
        buttonEliminarJefe.setBorderPainted(false);
        buttonEliminarJefe.setContentAreaFilled(false);
        buttonEliminarJefe.setFocusPainted(false);
        buttonEliminarJefe.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonEliminarJefe.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ELIMINAR_JEFE_SUCURSAL.getColor(pms.getFramePrincipal().getModo()))));
        buttonEliminarJefe.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ELIMINAR_JEFE_SUCURSAL_DRAGGED.getColor(pms.getFramePrincipal().getModo()))));
        buttonEliminarJefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarJefeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesConJefeLayout = new javax.swing.GroupLayout(panelBotonesConJefe);
        panelBotonesConJefe.setLayout(panelBotonesConJefeLayout);
        panelBotonesConJefeLayout.setHorizontalGroup(
            panelBotonesConJefeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesConJefeLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelBotonesConJefeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonModificarJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEliminarJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelBotonesConJefeLayout.setVerticalGroup(
            panelBotonesConJefeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesConJefeLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(buttonModificarJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(buttonEliminarJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelDirecccion.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelDirecccion.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pms.getFramePrincipal().getModo())));
        labelDirecccion.setText(Texto.DIRECCION.getTexto());
        labelDirecccion.setPreferredSize(new java.awt.Dimension(388, 16));
        add(labelDirecccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, -1));

        textDireccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDireccion.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textDireccion.setText("(Direccion Sucursal)");
        add(textDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 16, 388, 28));

        labelTelefono.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelTelefono.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pms.getFramePrincipal().getModo())));
        labelTelefono.setText(Texto.TELEFONO.getTexto());
        labelTelefono.setPreferredSize(new java.awt.Dimension(194, 16));
        add(labelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 62, 388, -1));

        labelIdTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelIdTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        labelIdTelefono.setText(Texto.ID_TELEFONO.getTexto());
        labelIdTelefono.setPreferredSize(new java.awt.Dimension(54, 28));
        add(labelIdTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 78, -1, -1));

        textTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textTelefono.setText("(Telefono Sucursal)");
        textTelefono.setPreferredSize(new java.awt.Dimension(140, 28));
        add(textTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 78, 149, -1));

        buttonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODIFICAR.getColor(pms.getFramePrincipal().getModo()))));
        buttonModificar.setBorder(null);
        buttonModificar.setBorderPainted(false);
        buttonModificar.setContentAreaFilled(false);
        buttonModificar.setFocusPainted(false);
        buttonModificar.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonModificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODIFICAR.getColor(pms.getFramePrincipal().getModo()))));
        buttonModificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODIFICAR_DRAGGED.getColor(pms.getFramePrincipal().getModo()))));
        buttonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarActionPerformed(evt);
            }
        });
        add(buttonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 136, -1, -1));

        buttonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ELIMINAR.getColor(pms.getFramePrincipal().getModo()))));
        buttonEliminar.setBorder(null);
        buttonEliminar.setBorderPainted(false);
        buttonEliminar.setContentAreaFilled(false);
        buttonEliminar.setFocusPainted(false);
        buttonEliminar.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonEliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ELIMINAR.getColor(pms.getFramePrincipal().getModo()))));
        buttonEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ELIMINAR_DRAGGED.getColor(pms.getFramePrincipal().getModo()))));
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });
        add(buttonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 136, -1, -1));

        labelJefeSucursal.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        labelJefeSucursal.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        labelJefeSucursal.setForeground(Color.decode(Colores.TITULO.getColor(pms.getFramePrincipal().getModo())));
        labelJefeSucursal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJefeSucursal.setText(Texto.JEFE_SUCURSAL.getTexto());
        labelJefeSucursal.setOpaque(true);
        labelJefeSucursal.setPreferredSize(new java.awt.Dimension(134, 32));
        add(labelJefeSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 134, -1));

        labelNombre.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelNombre.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pms.getFramePrincipal().getModo())));
        labelNombre.setText(Texto.NOMBRE.getTexto());
        labelNombre.setPreferredSize(new java.awt.Dimension(350, 16));
        add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 350, -1));

        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textNombre.setText("(Nombre Jefe)");
        add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 256, -1, -1));

        labelEdad.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelEdad.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pms.getFramePrincipal().getModo())));
        labelEdad.setText(Texto.EDAD.getTexto());
        labelEdad.setPreferredSize(new java.awt.Dimension(350, 16));
        add(labelEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 302, 350, -1));

        textEdad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textEdad.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textEdad.setText("(Edad jefe)");
        textEdad.setPreferredSize(new java.awt.Dimension(150, 28));
        add(textEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 318, 350, -1));

        panelDecorativo.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        panelDecorativo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));

        panelBotones.setPreferredSize(new java.awt.Dimension(70, 168));
        panelBotones.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout panelDecorativoLayout = new javax.swing.GroupLayout(panelDecorativo);
        panelDecorativo.setLayout(panelDecorativoLayout);
        panelDecorativoLayout.setHorizontalGroup(
            panelDecorativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDecorativoLayout.createSequentialGroup()
                .addGap(0, 378, Short.MAX_VALUE)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelDecorativoLayout.setVerticalGroup(
            panelDecorativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(panelDecorativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 450, 170));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        /*DialogoConfirmarEliminarCliente dcec = new DialogoConfirmarEliminarCliente(new javax.swing.JFrame(), true, pms);
        dcec.setLocationRelativeTo(this);
        dcec.setVisible(true);*/
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarActionPerformed
        /*PanelModificarCliente pmdc = new PanelModificarCliente(pms);
        pms.getFramePrincipal().cargarPanel(pms.getPanelCliente(), pmdc);*/
    }//GEN-LAST:event_buttonModificarActionPerformed

    private void buttonAgregarJefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarJefeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAgregarJefeActionPerformed

    private void buttonModificarJefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarJefeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonModificarJefeActionPerformed

    private void buttonEliminarJefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarJefeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonEliminarJefeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAgregarJefe;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonEliminarJefe;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JButton buttonModificarJefe;
    private javax.swing.JLabel labelDirecccion;
    private javax.swing.JLabel labelEdad;
    private javax.swing.JLabel labelIdTelefono;
    private javax.swing.JLabel labelJefeSucursal;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelBotonesConJefe;
    private javax.swing.JPanel panelBotonesSinJefe;
    private javax.swing.JPanel panelDecorativo;
    private javax.swing.JLabel textDireccion;
    private javax.swing.JLabel textEdad;
    private javax.swing.JLabel textNombre;
    private javax.swing.JLabel textTelefono;
    // End of variables declaration//GEN-END:variables
}
