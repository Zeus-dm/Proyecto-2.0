package gui.menuCliente;

import enumeraciones.Colores;
import enumeraciones.Texto;

import java.awt.Color;
import java.util.List;

public class PanelSeleccionarCliente extends javax.swing.JPanel {

    PanelMenuClientes pmc = null;

    public PanelSeleccionarCliente(PanelMenuClientes pmc) {
        this.pmc = pmc;

        initComponents();

        iniciarPanel();
    }

    private void iniciarPanel() {
        if (pmc.idCliente != -1) {
            List<String> datos = pmc.controlCliente.seleccionarCliente(pmc.idCliente);

            textNombre.setText(datos.get(0));
            pmc.getFramePrincipal().reCargarTexto(textNombre, 18, 350, 0);
            
            textEdad.setText(datos.get(1));
            textDireccion.setText(datos.get(2));
            textTelefono.setText(datos.get(3));
            
            textEmail.setText(datos.get(4));
            pmc.getFramePrincipal().reCargarTexto(textEmail, 18, 350, 0);
        }else{
            buttonModificar.setVisible(false);
            buttonEliminar.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelImagen = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JLabel();
        labelEdad = new javax.swing.JLabel();
        textEdad = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelIdTelefono = new javax.swing.JLabel();
        textTelefono = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        textDireccion = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        textEmail = new javax.swing.JLabel();
        buttonModificar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();

        setBackground(Color.decode(Colores.FONDO.getColor(pmc.getFramePrincipal().getModo())));

        labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/imagenes/iconosMultiProposito/chefcito_redondo_100.gif"))); // NOI18N

        labelNombre.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelNombre.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmc.getFramePrincipal().getModo())));
        labelNombre.setText(Texto.NOMBRE.getTexto());
        labelNombre.setPreferredSize(new java.awt.Dimension(350, 16));

        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TEXTO.getColor(pmc.getFramePrincipal().getModo())));
        textNombre.setText("(Nombre Cliente)");

        labelEdad.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelEdad.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmc.getFramePrincipal().getModo())));
        labelEdad.setText(Texto.EDAD.getTexto());
        labelEdad.setPreferredSize(new java.awt.Dimension(150, 16));

        textEdad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textEdad.setForeground(Color.decode(Colores.TEXTO.getColor(pmc.getFramePrincipal().getModo())));
        textEdad.setText("(Edad Cliente)");
        textEdad.setPreferredSize(new java.awt.Dimension(150, 28));

        labelTelefono.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelTelefono.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmc.getFramePrincipal().getModo())));
        labelTelefono.setText(Texto.TELEFONO.getTexto());
        labelTelefono.setPreferredSize(new java.awt.Dimension(194, 16));

        labelIdTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelIdTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(pmc.getFramePrincipal().getModo())));
        labelIdTelefono.setText(Texto.ID_TELEFONO.getTexto());
        labelIdTelefono.setPreferredSize(new java.awt.Dimension(54, 28));

        textTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(pmc.getFramePrincipal().getModo())));
        textTelefono.setText("(Telefono Cliente)");
        textTelefono.setPreferredSize(new java.awt.Dimension(140, 28));

        labelDireccion.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelDireccion.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmc.getFramePrincipal().getModo())));
        labelDireccion.setText(Texto.DIRECCION.getTexto());
        labelDireccion.setPreferredSize(new java.awt.Dimension(350, 16));

        textDireccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDireccion.setForeground(Color.decode(Colores.TEXTO.getColor(pmc.getFramePrincipal().getModo())));
        textDireccion.setText("(Direccion Cliente)");
        textDireccion.setMaximumSize(new java.awt.Dimension(350, 28));
        textDireccion.setMinimumSize(new java.awt.Dimension(350, 28));
        textDireccion.setPreferredSize(new java.awt.Dimension(350, 28));

        labelEmail.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelEmail.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmc.getFramePrincipal().getModo())));
        labelEmail.setText(Texto.EMAIL.getTexto());
        labelEmail.setPreferredSize(new java.awt.Dimension(350, 16));

        textEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textEmail.setForeground(Color.decode(Colores.TEXTO.getColor(pmc.getFramePrincipal().getModo())));
        textEmail.setText("(Email Cliente)");

        buttonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODIFICAR.getColor(pmc.getFramePrincipal().getModo()))));
        buttonModificar.setBorder(null);
        buttonModificar.setBorderPainted(false);
        buttonModificar.setContentAreaFilled(false);
        buttonModificar.setFocusPainted(false);
        buttonModificar.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonModificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODIFICAR.getColor(pmc.getFramePrincipal().getModo()))));
        buttonModificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODIFICAR_DRAGGED.getColor(pmc.getFramePrincipal().getModo()))));
        buttonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarActionPerformed(evt);
            }
        });

        buttonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ELIMINAR.getColor(pmc.getFramePrincipal().getModo()))));
        buttonEliminar.setBorder(null);
        buttonEliminar.setBorderPainted(false);
        buttonEliminar.setContentAreaFilled(false);
        buttonEliminar.setFocusPainted(false);
        buttonEliminar.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonEliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ELIMINAR.getColor(pmc.getFramePrincipal().getModo()))));
        buttonEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ELIMINAR_DRAGGED.getColor(pmc.getFramePrincipal().getModo()))));
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelImagen)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(textEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelIdTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(textTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelIdTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelImagen))
                .addGap(18, 18, 18)
                .addComponent(labelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        DialogoConfirmarEliminarCliente dcec = new DialogoConfirmarEliminarCliente(new javax.swing.JFrame(), true, pmc);
        dcec.setLocationRelativeTo(this);
        dcec.setVisible(true);
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarActionPerformed
        PanelModificarCliente pmdc = new PanelModificarCliente(pmc);
        pmc.getFramePrincipal().cargarPanel(pmc.getPanelCliente(), pmdc);
    }//GEN-LAST:event_buttonModificarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelEdad;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelIdTelefono;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel textDireccion;
    private javax.swing.JLabel textEdad;
    private javax.swing.JLabel textEmail;
    private javax.swing.JLabel textNombre;
    private javax.swing.JLabel textTelefono;
    // End of variables declaration//GEN-END:variables
}
