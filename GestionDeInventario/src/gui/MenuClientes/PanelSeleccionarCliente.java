
package gui.MenuClientes;

import FunGenerales.FunCliente;
import enumeraciones.Colores;
import enumeraciones.Texto;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class PanelSeleccionarCliente extends javax.swing.JPanel {
    DialogMenuCliente dmc = null;
    
    public PanelSeleccionarCliente(DialogMenuCliente dmc) {
        this.dmc = dmc;
        
        initComponents();
        this.dmc.setSize(450, 248);
        this.dmc.setLocationRelativeTo(this.dmc.getFramePrincipal());
        
        iniciarDatos();
    }
    
    private void iniciarDatos(){
        List<String> datos = FunCliente.seleccionarCliente(dmc.getFramePrincipal().getSistema(), dmc.posicion);
        
        textNombre.setText(datos.get(0));
        ajustarTitulo();

        textEdad.setText(datos.get(1));
        textDireccion.setText(datos.get(2));
        textTelefono.setText(datos.get(3));
        textEmail.setText(datos.get(4));
    }
    
    private void ajustarTitulo(){
        int tamano = 20;
        
        textNombre.setFont(new java.awt.Font("Segoe UI", 3, tamano));
        while(true){
            if(textNombre.getPreferredSize().width > 260){
                textNombre.setFont(new java.awt.Font("Segoe UI", 3, tamano));
            }else{
                break;
            }
            tamano -= 1;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogConfirmacion = new javax.swing.JDialog();
        jPanelConfirmacion = new javax.swing.JPanel();
        labelTituloConfirmacion = new javax.swing.JLabel();
        buttonAceptarConfirmacion = new javax.swing.JButton();
        buttonCancelarConfirmacion = new javax.swing.JButton();
        jPanelFondo = new javax.swing.JPanel();
        textNombre = new javax.swing.JLabel();
        labelEdad = new javax.swing.JLabel();
        textEdad = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        textDireccion = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelIdTelefono = new javax.swing.JLabel();
        textTelefono = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        textEmail = new javax.swing.JLabel();
        jPanelBotones = new javax.swing.JPanel();
        buttonEliminar = new javax.swing.JButton();
        buttonModificar = new javax.swing.JButton();
        buttonVolver = new javax.swing.JButton();

        DialogConfirmacion.setTitle("Confirmacion");
        DialogConfirmacion.setMinimumSize(new java.awt.Dimension(325, 175));
        DialogConfirmacion.setModal(true);

        jPanelConfirmacion.setBackground(Color.decode(Colores.FONDO.getColor(dmc.getFramePrincipal().modo)));
        jPanelConfirmacion.setPreferredSize(new java.awt.Dimension(310, 135));

        labelTituloConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        labelTituloConfirmacion.setForeground(Color.decode(Colores.TITULO.getColor(dmc.getFramePrincipal().modo)));
        labelTituloConfirmacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTituloConfirmacion.setText(Texto.CONFIRMACION_ELIMINAR.getTexto());

        buttonAceptarConfirmacion.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmc.getFramePrincipal().modo)));
        buttonAceptarConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonAceptarConfirmacion.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmc.getFramePrincipal().modo)));
        buttonAceptarConfirmacion.setText(Texto.ACEPTAR.getTexto());
        buttonAceptarConfirmacion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmc.getFramePrincipal().modo))));
        buttonAceptarConfirmacion.setFocusable(false);
        buttonAceptarConfirmacion.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonAceptarConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarConfirmacionActionPerformed(evt);
            }
        });

        buttonCancelarConfirmacion.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmc.getFramePrincipal().modo)));
        buttonCancelarConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonCancelarConfirmacion.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmc.getFramePrincipal().modo)));
        buttonCancelarConfirmacion.setText(Texto.CANCELAR.getTexto());
        buttonCancelarConfirmacion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmc.getFramePrincipal().modo))));
        buttonCancelarConfirmacion.setFocusable(false);
        buttonCancelarConfirmacion.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonCancelarConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarConfirmacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConfirmacionLayout = new javax.swing.GroupLayout(jPanelConfirmacion);
        jPanelConfirmacion.setLayout(jPanelConfirmacionLayout);
        jPanelConfirmacionLayout.setHorizontalGroup(
            jPanelConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTituloConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelConfirmacionLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(buttonAceptarConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(buttonCancelarConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanelConfirmacionLayout.setVerticalGroup(
            jPanelConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfirmacionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelTituloConfirmacion)
                .addGap(30, 30, 30)
                .addGroup(jPanelConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAceptarConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancelarConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DialogConfirmacionLayout = new javax.swing.GroupLayout(DialogConfirmacion.getContentPane());
        DialogConfirmacion.getContentPane().setLayout(DialogConfirmacionLayout);
        DialogConfirmacionLayout.setHorizontalGroup(
            DialogConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        DialogConfirmacionLayout.setVerticalGroup(
            DialogConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelFondo.setBackground(Color.decode(Colores.FONDO.getColor(dmc.getFramePrincipal().modo)));
        jPanelFondo.setPreferredSize(new java.awt.Dimension(435, 208));

        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TITULO.getColor(dmc.getFramePrincipal().modo)));
        textNombre.setText("(Nombre Cliente)");

        labelEdad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelEdad.setForeground(Color.decode(Colores.TEXTO.getColor(dmc.getFramePrincipal().modo)));
        labelEdad.setText(Texto.EDAD.getTexto());
        labelEdad.setPreferredSize(new java.awt.Dimension(70, 26));

        textEdad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEdad.setForeground(Color.decode(Colores.TEXTO.getColor(dmc.getFramePrincipal().modo)));
        textEdad.setText("(Edad Cliente)");
        textEdad.setPreferredSize(new java.awt.Dimension(178, 26));

        labelDireccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDireccion.setForeground(Color.decode(Colores.TEXTO.getColor(dmc.getFramePrincipal().modo)));
        labelDireccion.setText(Texto.DIRECCION.getTexto());
        labelDireccion.setPreferredSize(new java.awt.Dimension(70, 26));

        textDireccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDireccion.setForeground(Color.decode(Colores.TEXTO.getColor(dmc.getFramePrincipal().modo)));
        textDireccion.setText("(Direccion Cliente)");
        textDireccion.setPreferredSize(new java.awt.Dimension(178, 26));

        labelTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(dmc.getFramePrincipal().modo)));
        labelTelefono.setText(Texto.TELEFONO.getTexto());
        labelTelefono.setPreferredSize(new java.awt.Dimension(70, 26));

        labelIdTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelIdTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(dmc.getFramePrincipal().modo)));
        labelIdTelefono.setText(Texto.ID_TELEFONO.getTexto());
        labelIdTelefono.setPreferredSize(new java.awt.Dimension(40, 26));

        textTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(dmc.getFramePrincipal().modo)));
        textTelefono.setText("(Telefono Cliente)");
        textTelefono.setPreferredSize(new java.awt.Dimension(132, 26));

        labelEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelEmail.setForeground(Color.decode(Colores.TEXTO.getColor(dmc.getFramePrincipal().modo)));
        labelEmail.setText(Texto.EMAIL.getTexto());
        labelEmail.setPreferredSize(new java.awt.Dimension(70, 26));

        textEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmail.setForeground(Color.decode(Colores.TEXTO.getColor(dmc.getFramePrincipal().modo)));
        textEmail.setText("(Email Cliente)");
        textEmail.setPreferredSize(new java.awt.Dimension(178, 26));

        jPanelBotones.setBackground(Color.decode(Colores.FONDO.getColor(dmc.getFramePrincipal().modo)));
        jPanelBotones.setPreferredSize(new java.awt.Dimension(144, 208));

        buttonEliminar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmc.getFramePrincipal().modo)));
        buttonEliminar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonEliminar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmc.getFramePrincipal().modo)));
        buttonEliminar.setText(Texto.ELIMINAR.getTexto());
        buttonEliminar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmc.getFramePrincipal().modo))));
        buttonEliminar.setFocusable(false);
        buttonEliminar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        buttonModificar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmc.getFramePrincipal().modo)));
        buttonModificar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonModificar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmc.getFramePrincipal().modo)));
        buttonModificar.setText(Texto.MODIFICAR.getTexto());
        buttonModificar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmc.getFramePrincipal().modo))));
        buttonModificar.setFocusable(false);
        buttonModificar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarActionPerformed(evt);
            }
        });

        buttonVolver.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmc.getFramePrincipal().modo)));
        buttonVolver.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonVolver.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmc.getFramePrincipal().modo)));
        buttonVolver.setText(Texto.VOLVER.getTexto());
        buttonVolver.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmc.getFramePrincipal().modo))));
        buttonVolver.setFocusable(false);
        buttonVolver.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(labelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelIdTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(labelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(labelEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(labelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIdTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        DialogConfirmacion.setIconImage(new ImageIcon("src/gui/imagenes/chefcito_icon_80.png").getImage());
        DialogConfirmacion.setLocationRelativeTo(dmc);
        DialogConfirmacion.setVisible(true);
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarActionPerformed
        PanelModificarCliente pmc = new PanelModificarCliente(dmc);
        dmc.cargarPanel(pmc);
    }//GEN-LAST:event_buttonModificarActionPerformed

    private void buttonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVolverActionPerformed
        dmc.setVisible(false);
    }//GEN-LAST:event_buttonVolverActionPerformed

//Botones Confirmacion
    private void buttonAceptarConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarConfirmacionActionPerformed
        try {
            FunCliente.eliminarCliente(dmc.getFramePrincipal().getSistema(), dmc.posicion);
            DialogConfirmacion.setVisible(false);
            dmc.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSeleccionarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAceptarConfirmacionActionPerformed

    private void buttonCancelarConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarConfirmacionActionPerformed
        DialogConfirmacion.setVisible(false);
    }//GEN-LAST:event_buttonCancelarConfirmacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DialogConfirmacion;
    private javax.swing.JButton buttonAceptarConfirmacion;
    private javax.swing.JButton buttonCancelarConfirmacion;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JButton buttonVolver;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelConfirmacion;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelEdad;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelIdTelefono;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelTituloConfirmacion;
    private javax.swing.JLabel textDireccion;
    private javax.swing.JLabel textEdad;
    private javax.swing.JLabel textEmail;
    private javax.swing.JLabel textNombre;
    private javax.swing.JLabel textTelefono;
    // End of variables declaration//GEN-END:variables
}
