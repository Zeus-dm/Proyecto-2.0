
package gui.MenuSucursales;

import enumeraciones.Colores;
import enumeraciones.Texto;
import gui.MenuProductosSucursal.PanelMenuProductosSucursal;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class PanelSeleccionarSucursal extends javax.swing.JPanel {
    private DialogMenuSucursal dms = null;
    
    public PanelSeleccionarSucursal(DialogMenuSucursal dms) {
        this.dms = dms;
        
        int tamX = dms.getSize().width - 430;
        int tamY = dms.getSize().height - 253;
        
        initComponents();
        this.dms.setSize(430, 253);
        this.dms.setLocation(dms.getLocation().x + (tamX/2), dms.getLocation().y + (tamY/2));
        
        iniciarDatos();
    }
    
    private void iniciarDatos(){
        List<String> datos = dms.controladorSucursal.seleccionarSucursal(dms.nombreSucursal);
        
        textNombre.setText(datos.get(0));
        ajustarTitulo();
        
        textDireccion.setText(datos.get(1));
        textTelefono.setText(datos.get(2));
        
        textNombreJefe.setText(datos.get(3));
        textEdadJefe.setText(datos.get(4));
        
        if(dms.controladorSucursal.verificarExistenciaJefe(datos.get(0))){
            cargarPanel(jPanelBotonesConJefe);
        }else{
            cargarPanel(jPanelBotonesSinJefe);
        }
    }
    
    private void ajustarTitulo(){
        int tamano = 20;
        
        textNombre.setFont(new java.awt.Font("Segoe UI", 3, tamano));
        while(true){
            if(textNombre.getPreferredSize().width > 248){
                textNombre.setFont(new java.awt.Font("Segoe UI", 3, tamano));
            }else{
                break;
            }
            tamano -= 1;
        }
    }
    
    private void cargarPanel(JPanel nuevoPanel){
        this.jPanelBotonesJefe.removeAll();
        this.jPanelBotonesJefe.add(nuevoPanel);
        this.jPanelBotonesJefe.repaint();
        this.jPanelBotonesJefe.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBotonesSinJefe = new javax.swing.JPanel();
        buttonAgregarJefe = new javax.swing.JButton();
        jPanelBotonesConJefe = new javax.swing.JPanel();
        buttonModificarJefe = new javax.swing.JButton();
        buttonEliminarJefe = new javax.swing.JButton();
        DialogConfirmacion = new javax.swing.JDialog();
        jPanelConfirmacion = new javax.swing.JPanel();
        labelTituloConfirmacion = new javax.swing.JLabel();
        buttonAceptarConfirmacion = new javax.swing.JButton();
        buttonCancelarConfirmacion = new javax.swing.JButton();
        jPanelFondo = new javax.swing.JPanel();
        jPanelBotonesSucursal = new javax.swing.JPanel();
        buttonProductos = new javax.swing.JButton();
        buttonModificar = new javax.swing.JButton();
        buttonVolver = new javax.swing.JButton();
        textNombre = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        textDireccion = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelIdTelefono = new javax.swing.JLabel();
        textTelefono = new javax.swing.JLabel();
        labelLineaSeparadora = new javax.swing.JLabel();
        labelJefeSucursal = new javax.swing.JLabel();
        labelNombreJefe = new javax.swing.JLabel();
        textNombreJefe = new javax.swing.JLabel();
        labelEdadJefe = new javax.swing.JLabel();
        textEdadJefe = new javax.swing.JLabel();
        jPanelBotonesJefe = new javax.swing.JPanel();

        jPanelBotonesSinJefe.setBackground(Color.decode(Colores.FONDO.getColor(dms.getFramePrincipal().modo)));
        jPanelBotonesSinJefe.setPreferredSize(new java.awt.Dimension(40, 117));

        buttonAgregarJefe.setBackground(Color.decode(Colores.FONDO.getColor(dms.getFramePrincipal().modo)));
        buttonAgregarJefe.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_AGREGAR_JEFE_SUCURSAL.getColor(dms.getFramePrincipal().modo))));
        buttonAgregarJefe.setToolTipText("Agregar Jefe de Sucursal");
        buttonAgregarJefe.setBorder(null);
        buttonAgregarJefe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAgregarJefe.setFocusable(false);
        buttonAgregarJefe.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonAgregarJefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarJefeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesSinJefeLayout = new javax.swing.GroupLayout(jPanelBotonesSinJefe);
        jPanelBotonesSinJefe.setLayout(jPanelBotonesSinJefeLayout);
        jPanelBotonesSinJefeLayout.setHorizontalGroup(
            jPanelBotonesSinJefeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesSinJefeLayout.createSequentialGroup()
                .addComponent(buttonAgregarJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanelBotonesSinJefeLayout.setVerticalGroup(
            jPanelBotonesSinJefeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesSinJefeLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(buttonAgregarJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanelBotonesConJefe.setBackground(Color.decode(Colores.FONDO.getColor(dms.getFramePrincipal().modo)));
        jPanelBotonesConJefe.setPreferredSize(new java.awt.Dimension(40, 117));

        buttonModificarJefe.setBackground(Color.decode(Colores.FONDO.getColor(dms.getFramePrincipal().modo)));
        buttonModificarJefe.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODIFICAR_JEFE_SUCURSAL.getColor(dms.getFramePrincipal().modo))));
        buttonModificarJefe.setToolTipText("Modificar Jefe de Sucursal");
        buttonModificarJefe.setBorder(null);
        buttonModificarJefe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonModificarJefe.setFocusable(false);
        buttonModificarJefe.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonModificarJefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarJefeActionPerformed(evt);
            }
        });

        buttonEliminarJefe.setBackground(Color.decode(Colores.FONDO.getColor(dms.getFramePrincipal().modo)));
        buttonEliminarJefe.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ELIMINAR_JEFE_SUCURSAL.getColor(dms.getFramePrincipal().modo))));
        buttonEliminarJefe.setToolTipText("Eliminar Jefe de Sucursal");
        buttonEliminarJefe.setBorder(null);
        buttonEliminarJefe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonEliminarJefe.setFocusable(false);
        buttonEliminarJefe.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonEliminarJefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarJefeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesConJefeLayout = new javax.swing.GroupLayout(jPanelBotonesConJefe);
        jPanelBotonesConJefe.setLayout(jPanelBotonesConJefeLayout);
        jPanelBotonesConJefeLayout.setHorizontalGroup(
            jPanelBotonesConJefeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesConJefeLayout.createSequentialGroup()
                .addGroup(jPanelBotonesConJefeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonModificarJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEliminarJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanelBotonesConJefeLayout.setVerticalGroup(
            jPanelBotonesConJefeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesConJefeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(buttonModificarJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonEliminarJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        DialogConfirmacion.setTitle("Confirmacion");
        DialogConfirmacion.setMinimumSize(new java.awt.Dimension(310, 135));
        DialogConfirmacion.setModal(true);
        DialogConfirmacion.setUndecorated(true);

        jPanelConfirmacion.setBackground(Color.decode(Colores.FONDO.getColor(dms.getFramePrincipal().modo)));
        jPanelConfirmacion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dms.getFramePrincipal().modo))));
        jPanelConfirmacion.setPreferredSize(new java.awt.Dimension(310, 135));

        labelTituloConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        labelTituloConfirmacion.setForeground(Color.decode(Colores.TITULO.getColor(dms.getFramePrincipal().modo)));
        labelTituloConfirmacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTituloConfirmacion.setText(Texto.CONFIRMACION_ELIMINAR_JEFE.getTexto());

        buttonAceptarConfirmacion.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dms.getFramePrincipal().modo)));
        buttonAceptarConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonAceptarConfirmacion.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dms.getFramePrincipal().modo)));
        buttonAceptarConfirmacion.setText(Texto.ACEPTAR.getTexto());
        buttonAceptarConfirmacion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dms.getFramePrincipal().modo))));
        buttonAceptarConfirmacion.setFocusable(false);
        buttonAceptarConfirmacion.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonAceptarConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarConfirmacionActionPerformed(evt);
            }
        });

        buttonCancelarConfirmacion.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dms.getFramePrincipal().modo)));
        buttonCancelarConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonCancelarConfirmacion.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dms.getFramePrincipal().modo)));
        buttonCancelarConfirmacion.setText(Texto.CANCELAR.getTexto());
        buttonCancelarConfirmacion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dms.getFramePrincipal().modo))));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
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
                .addContainerGap(28, Short.MAX_VALUE))
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

        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dms.getFramePrincipal().modo))));

        jPanelFondo.setBackground(Color.decode(Colores.FONDO.getColor(dms.getFramePrincipal().modo)));

        jPanelBotonesSucursal.setBackground(Color.decode(Colores.FONDO.getColor(dms.getFramePrincipal().modo)));
        jPanelBotonesSucursal.setPreferredSize(new java.awt.Dimension(150, 252));

        buttonProductos.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dms.getFramePrincipal().modo)));
        buttonProductos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonProductos.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dms.getFramePrincipal().modo)));
        buttonProductos.setText(Texto.PRODUCTOS.getTexto());
        buttonProductos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dms.getFramePrincipal().modo))));
        buttonProductos.setFocusable(false);
        buttonProductos.setPreferredSize(new java.awt.Dimension(124, 30));
        buttonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProductosActionPerformed(evt);
            }
        });

        buttonModificar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dms.getFramePrincipal().modo)));
        buttonModificar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonModificar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dms.getFramePrincipal().modo)));
        buttonModificar.setText(Texto.MODIFICAR.getTexto());
        buttonModificar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dms.getFramePrincipal().modo))));
        buttonModificar.setFocusable(false);
        buttonModificar.setPreferredSize(new java.awt.Dimension(124, 30));
        buttonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarActionPerformed(evt);
            }
        });

        buttonVolver.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dms.getFramePrincipal().modo)));
        buttonVolver.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonVolver.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dms.getFramePrincipal().modo)));
        buttonVolver.setText(Texto.VOLVER.getTexto());
        buttonVolver.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dms.getFramePrincipal().modo))));
        buttonVolver.setFocusable(false);
        buttonVolver.setPreferredSize(new java.awt.Dimension(124, 30));
        buttonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesSucursalLayout = new javax.swing.GroupLayout(jPanelBotonesSucursal);
        jPanelBotonesSucursal.setLayout(jPanelBotonesSucursalLayout);
        jPanelBotonesSucursalLayout.setHorizontalGroup(
            jPanelBotonesSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesSucursalLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanelBotonesSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanelBotonesSucursalLayout.setVerticalGroup(
            jPanelBotonesSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesSucursalLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(buttonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        textNombre.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TITULO.getColor(dms.getFramePrincipal().modo)));
        textNombre.setText("(Nombre de la Sucursal)");

        labelDireccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDireccion.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        labelDireccion.setText(Texto.DIRECCION.getTexto());
        labelDireccion.setPreferredSize(new java.awt.Dimension(70, 26));

        textDireccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDireccion.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        textDireccion.setText("(Direccion sucursal)");
        textDireccion.setPreferredSize(new java.awt.Dimension(172, 26));

        labelTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        labelTelefono.setText(Texto.TELEFONO.getTexto());
        labelTelefono.setPreferredSize(new java.awt.Dimension(70, 26));

        labelIdTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelIdTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        labelIdTelefono.setText(Texto.ID_TELEFONO.getTexto());
        labelIdTelefono.setPreferredSize(new java.awt.Dimension(40, 26));

        textTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        textTelefono.setText("(Telefono sucursal)");
        textTelefono.setMaximumSize(new java.awt.Dimension(43, 26));
        textTelefono.setMinimumSize(new java.awt.Dimension(43, 26));
        textTelefono.setPreferredSize(new java.awt.Dimension(126, 26));

        labelLineaSeparadora.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(dms.getFramePrincipal().modo))));
        labelLineaSeparadora.setPreferredSize(new java.awt.Dimension(248, 1));

        labelJefeSucursal.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        labelJefeSucursal.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        labelJefeSucursal.setText(Texto.JEFE_SUCURSAL.getTexto());
        labelJefeSucursal.setPreferredSize(new java.awt.Dimension(190, 27));

        labelNombreJefe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNombreJefe.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        labelNombreJefe.setText(Texto.NOMBRE.getTexto());
        labelNombreJefe.setPreferredSize(new java.awt.Dimension(70, 26));

        textNombreJefe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNombreJefe.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        textNombreJefe.setText("(Nombre Jefe)");
        textNombreJefe.setPreferredSize(new java.awt.Dimension(114, 26));

        labelEdadJefe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelEdadJefe.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        labelEdadJefe.setText(Texto.EDAD.getTexto());
        labelEdadJefe.setPreferredSize(new java.awt.Dimension(70, 26));

        textEdadJefe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEdadJefe.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        textEdadJefe.setText("(Edad Jefe)");
        textEdadJefe.setPreferredSize(new java.awt.Dimension(114, 26));

        jPanelBotonesJefe.setPreferredSize(new java.awt.Dimension(40, 117));
        jPanelBotonesJefe.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelFondoLayout.createSequentialGroup()
                            .addComponent(labelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelIdTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(labelLineaSeparadora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelFondoLayout.createSequentialGroup()
                            .addComponent(labelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addComponent(labelNombreJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textNombreJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addComponent(labelEdadJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textEdadJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelJefeSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelBotonesJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelBotonesSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIdTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelLineaSeparadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(labelJefeSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNombreJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNombreJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEdadJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textEdadJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanelBotonesJefe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jPanelBotonesSucursal, 251, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProductosActionPerformed
        PanelMenuProductosSucursal pmps = new PanelMenuProductosSucursal(dms.getFramePrincipal(), dms.controladorSucursal.nombreRegion(), dms.nombreSucursal);
        dms.getFramePrincipal().cargarPanel(pmps);
        dms.setVisible(false);
    }//GEN-LAST:event_buttonProductosActionPerformed

    private void buttonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarActionPerformed
        PanelModificarSucursal pss = new PanelModificarSucursal(dms);
        dms.cargarPanel(pss);
    }//GEN-LAST:event_buttonModificarActionPerformed

    private void buttonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVolverActionPerformed
        dms.setVisible(false);
    }//GEN-LAST:event_buttonVolverActionPerformed

    private void buttonAgregarJefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarJefeActionPerformed
        DialogMenuSucursal dmss = new DialogMenuSucursal(new javax.swing.JFrame(), true, dms.getFramePrincipal(), 4, dms.controladorSucursal.nombreRegion(), dms.nombreSucursal);
        dmss.setLocationRelativeTo(dms);
        dmss.setVisible(true);
        
        PanelSeleccionarSucursal pss = new PanelSeleccionarSucursal(dms);
        dms.cargarPanel(pss);
    }//GEN-LAST:event_buttonAgregarJefeActionPerformed

    private void buttonModificarJefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarJefeActionPerformed
        DialogMenuSucursal dmss = new DialogMenuSucursal(new javax.swing.JFrame(), true, dms.getFramePrincipal(), 5, dms.controladorSucursal.nombreRegion(), dms.nombreSucursal);
        dmss.setLocationRelativeTo(dms);
        dmss.setVisible(true);
        
        PanelSeleccionarSucursal pss = new PanelSeleccionarSucursal(dms);
        dms.cargarPanel(pss);
    }//GEN-LAST:event_buttonModificarJefeActionPerformed

    private void buttonEliminarJefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarJefeActionPerformed
        DialogConfirmacion.setLocationRelativeTo(dms);
        DialogConfirmacion.setVisible(true);
    }//GEN-LAST:event_buttonEliminarJefeActionPerformed

    private void buttonAceptarConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarConfirmacionActionPerformed
        try {
            dms.controladorSucursal.eliminarJefe(dms.nombreSucursal);
            DialogConfirmacion.setVisible(false);
            
            PanelSeleccionarSucursal pss = new PanelSeleccionarSucursal(dms);
            dms.cargarPanel(pss);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSeleccionarSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAceptarConfirmacionActionPerformed

    private void buttonCancelarConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarConfirmacionActionPerformed
        DialogConfirmacion.setVisible(false);
    }//GEN-LAST:event_buttonCancelarConfirmacionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DialogConfirmacion;
    private javax.swing.JButton buttonAceptarConfirmacion;
    private javax.swing.JButton buttonAgregarJefe;
    private javax.swing.JButton buttonCancelarConfirmacion;
    private javax.swing.JButton buttonEliminarJefe;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JButton buttonModificarJefe;
    private javax.swing.JButton buttonProductos;
    private javax.swing.JButton buttonVolver;
    private javax.swing.JPanel jPanelBotonesConJefe;
    private javax.swing.JPanel jPanelBotonesJefe;
    private javax.swing.JPanel jPanelBotonesSinJefe;
    private javax.swing.JPanel jPanelBotonesSucursal;
    private javax.swing.JPanel jPanelConfirmacion;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelEdadJefe;
    private javax.swing.JLabel labelIdTelefono;
    private javax.swing.JLabel labelJefeSucursal;
    private javax.swing.JLabel labelLineaSeparadora;
    private javax.swing.JLabel labelNombreJefe;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelTituloConfirmacion;
    private javax.swing.JLabel textDireccion;
    private javax.swing.JLabel textEdadJefe;
    private javax.swing.JLabel textNombre;
    private javax.swing.JLabel textNombreJefe;
    private javax.swing.JLabel textTelefono;
    // End of variables declaration//GEN-END:variables
}
