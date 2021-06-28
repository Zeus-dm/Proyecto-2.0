package gui.menuRegion;

import FunGenerales.FunSucursal;
import enumeraciones.Colores;
import enumeraciones.Texto;
import enumeraciones.TextoErrores;
import gui.TextPrompt;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanelAgregarSucursal extends javax.swing.JPanel {

    PanelMenuRegiones pmr = null;
    private boolean jefe = false;

    public PanelAgregarSucursal(PanelMenuRegiones pmr) {
        this.pmr = pmr;

        initComponents();

        iniciarPanel();
    }

    private void iniciarPanel() {
        pmr.getFramePrincipal().reCargarTexto(labelTitulo, 24, 510, 3);
        pmr.getFramePrincipal().cargarPanel(panelFondoJefe, subPanelSinJefe);
    }

    private void recargarColores() {
        textNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        labelIdTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        textTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        textDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        
        if(jefe){
            textNombreJefe.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
            textEdadJefe.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
            
            labelErrorNombreJefe.setVisible(false);
            labelErrorEdadJefe.setVisible(false);
        }

        labelErrorNombre.setVisible(false);
        labelErrorTelefono.setVisible(false);
        labelErrorDireccion.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subPanelSinJefe = new javax.swing.JPanel();
        labelJefeSucursal = new javax.swing.JLabel();
        buttonAgregarJefe = new javax.swing.JButton();
        buttonAceptar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        subPanelConJefe = new javax.swing.JPanel();
        labelJefeSucursal1 = new javax.swing.JLabel();
        buttonQuitarAgregarJefe = new javax.swing.JButton();
        buttonAceptarConJefe = new javax.swing.JButton();
        buttonCancelarConJefe = new javax.swing.JButton();
        labelNombreJefe = new javax.swing.JLabel();
        textNombreJefe = new javax.swing.JTextField();
        labelErrorNombreJefe = new javax.swing.JLabel();
        labelEdadJefe = new javax.swing.JLabel();
        textEdadJefe = new javax.swing.JTextField();
        labelErrorEdadJefe = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        labelErrorNombre = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelIdTelefono = new javax.swing.JLabel();
        textTelefono = new javax.swing.JTextField();
        labelErrorTelefono = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        textDireccion = new javax.swing.JTextField();
        labelErrorDireccion = new javax.swing.JLabel();
        panelFondoJefe = new javax.swing.JPanel();

        subPanelSinJefe.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        subPanelSinJefe.setPreferredSize(new java.awt.Dimension(548, 210));
        subPanelSinJefe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelJefeSucursal.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        labelJefeSucursal.setForeground(Color.decode(Colores.TITULO.getColor(pmr.getFramePrincipal().getModo())));
        labelJefeSucursal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelJefeSucursal.setText(Texto.JEFE_SUCURSAL.getTexto());
        labelJefeSucursal.setPreferredSize(new java.awt.Dimension(300, 32));
        subPanelSinJefe.add(labelJefeSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 12, -1, -1));

        buttonAgregarJefe.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MOSTRAR_AGREGAR_JEFE_SUCURSAL.getColor(pmr.getFramePrincipal().getModo()))));
        buttonAgregarJefe.setBorder(null);
        buttonAgregarJefe.setBorderPainted(false);
        buttonAgregarJefe.setContentAreaFilled(false);
        buttonAgregarJefe.setFocusPainted(false);
        buttonAgregarJefe.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonAgregarJefe.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MOSTRAR_AGREGAR_JEFE_SUCURSAL.getColor(pmr.getFramePrincipal().getModo()))));
        buttonAgregarJefe.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MOSTRAR_AGREGAR_JEFE_SUCURSAL_DRAGGED.getColor(pmr.getFramePrincipal().getModo()))));
        buttonAgregarJefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarJefeActionPerformed(evt);
            }
        });
        subPanelSinJefe.add(buttonAgregarJefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 12, -1, -1));

        buttonAceptar.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        buttonAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonAceptar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pmr.getFramePrincipal().getModo())));
        buttonAceptar.setText(Texto.ACEPTAR.getTexto());
        buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        buttonAceptar.setFocusPainted(false);
        buttonAceptar.setFocusable(false);
        buttonAceptar.setOpaque(true);
        buttonAceptar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAceptar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pmr.getFramePrincipal().getModo())));
                buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAceptar.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
                buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
            }
        });
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });
        subPanelSinJefe.add(buttonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 94, -1, -1));

        buttonCancelar.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        buttonCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonCancelar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pmr.getFramePrincipal().getModo())));
        buttonCancelar.setText(Texto.CANCELAR.getTexto());
        buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        buttonCancelar.setFocusPainted(false);
        buttonCancelar.setFocusable(false);
        buttonCancelar.setOpaque(true);
        buttonCancelar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCancelar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pmr.getFramePrincipal().getModo())));
                buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCancelar.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
                buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
            }
        });
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        subPanelSinJefe.add(buttonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 94, -1, -1));

        subPanelConJefe.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        subPanelConJefe.setPreferredSize(new java.awt.Dimension(548, 210));
        subPanelConJefe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelJefeSucursal1.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        labelJefeSucursal1.setForeground(Color.decode(Colores.TITULO.getColor(pmr.getFramePrincipal().getModo())));
        labelJefeSucursal1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelJefeSucursal1.setText(Texto.JEFE_SUCURSAL.getTexto());
        labelJefeSucursal1.setPreferredSize(new java.awt.Dimension(300, 32));
        subPanelConJefe.add(labelJefeSucursal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 12, -1, -1));

        buttonQuitarAgregarJefe.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_QUITAR_AGREGAR_JEFE_SUCURSAL.getColor(pmr.getFramePrincipal().getModo()))));
        buttonQuitarAgregarJefe.setBorder(null);
        buttonQuitarAgregarJefe.setBorderPainted(false);
        buttonQuitarAgregarJefe.setContentAreaFilled(false);
        buttonQuitarAgregarJefe.setFocusPainted(false);
        buttonQuitarAgregarJefe.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonQuitarAgregarJefe.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_QUITAR_AGREGAR_JEFE_SUCURSAL.getColor(pmr.getFramePrincipal().getModo()))));
        buttonQuitarAgregarJefe.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_QUITAR_AGREGAR_JEFE_SUCURSAL_DRAGGED.getColor(pmr.getFramePrincipal().getModo()))));
        buttonQuitarAgregarJefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQuitarAgregarJefeActionPerformed(evt);
            }
        });
        subPanelConJefe.add(buttonQuitarAgregarJefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 12, -1, -1));

        buttonAceptarConJefe.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        buttonAceptarConJefe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonAceptarConJefe.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pmr.getFramePrincipal().getModo())));
        buttonAceptarConJefe.setText(Texto.ACEPTAR.getTexto());
        buttonAceptarConJefe.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        buttonAceptarConJefe.setFocusPainted(false);
        buttonAceptarConJefe.setFocusable(false);
        buttonAceptarConJefe.setOpaque(true);
        buttonAceptarConJefe.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonAceptarConJefe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAceptarConJefe.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pmr.getFramePrincipal().getModo())));
                buttonAceptarConJefe.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAceptarConJefe.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
                buttonAceptarConJefe.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
            }
        });
        buttonAceptarConJefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });
        subPanelConJefe.add(buttonAceptarConJefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 162, -1, -1));

        buttonCancelarConJefe.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        buttonCancelarConJefe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonCancelarConJefe.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pmr.getFramePrincipal().getModo())));
        buttonCancelarConJefe.setText(Texto.CANCELAR.getTexto());
        buttonCancelarConJefe.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        buttonCancelarConJefe.setFocusPainted(false);
        buttonCancelarConJefe.setFocusable(false);
        buttonCancelarConJefe.setOpaque(true);
        buttonCancelarConJefe.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonCancelarConJefe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCancelarConJefe.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pmr.getFramePrincipal().getModo())));
                buttonCancelarConJefe.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCancelarConJefe.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
                buttonCancelarConJefe.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
            }
        });
        buttonCancelarConJefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        subPanelConJefe.add(buttonCancelarConJefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 162, -1, -1));

        labelNombreJefe.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelNombreJefe.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmr.getFramePrincipal().getModo())));
        labelNombreJefe.setText(Texto.NOMBRE.getTexto() + " " + Texto.JEFE_SUCURSAL.getTexto());
        labelNombreJefe.setPreferredSize(new java.awt.Dimension(388, 16));
        subPanelConJefe.add(labelNombreJefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        textNombreJefe.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        textNombreJefe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textNombreJefe.setForeground(Color.decode(Colores.TEXTO.getColor(pmr.getFramePrincipal().getModo())));
        textNombreJefe.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        textNombreJefe.setPreferredSize(new java.awt.Dimension(388, 28));
        TextPrompt placeHolderJefe = new TextPrompt(Texto.NOMBRE.getTexto() + " " + Texto.JEFE_SUCURSAL.getTexto(), textNombreJefe);
        placeHolderJefe.changeAlpha(0.75f);
        placeHolderJefe.changeStyle(Font.ITALIC);
        subPanelConJefe.add(textNombreJefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 66, -1, -1));

        labelErrorNombreJefe.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pmr.getFramePrincipal().getModo()))));
        labelErrorNombreJefe.setToolTipText("Aqui deberia de ir un Error");
        labelErrorNombreJefe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorNombreJefe.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorNombre.setVisible(false);
        subPanelConJefe.add(labelErrorNombreJefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 66, -1, -1));

        labelEdadJefe.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelEdadJefe.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmr.getFramePrincipal().getModo())));
        labelEdadJefe.setText(Texto.EDAD.getTexto() + " " + Texto.JEFE_SUCURSAL.getTexto());
        labelEdadJefe.setPreferredSize(new java.awt.Dimension(388, 16));
        subPanelConJefe.add(labelEdadJefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 106, -1, -1));

        textEdadJefe.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        textEdadJefe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textEdadJefe.setForeground(Color.decode(Colores.TEXTO.getColor(pmr.getFramePrincipal().getModo())));
        textEdadJefe.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        textEdadJefe.setPreferredSize(new java.awt.Dimension(388, 28));
        placeHolderJefe = new TextPrompt(Texto.EDAD.getTexto() + " " + Texto.JEFE_SUCURSAL.getTexto(), textEdadJefe);
        placeHolderJefe.changeAlpha(0.75f);
        placeHolderJefe.changeStyle(Font.ITALIC);
        subPanelConJefe.add(textEdadJefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 122, -1, -1));

        labelErrorEdadJefe.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pmr.getFramePrincipal().getModo()))));
        labelErrorEdadJefe.setToolTipText("Aqui deberia de ir un Error");
        labelErrorEdadJefe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorEdadJefe.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorNombre.setVisible(false);
        subPanelConJefe.add(labelErrorEdadJefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 122, -1, -1));

        setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(pmr.getFramePrincipal().getModo())));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.AGREGAR_SUCURSAL.getTexto() + " a " + pmr.nombreRegion);
        labelTitulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 510, -1));

        labelNombre.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelNombre.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmr.getFramePrincipal().getModo())));
        labelNombre.setText(Texto.NOMBRE.getTexto());
        labelNombre.setPreferredSize(new java.awt.Dimension(388, 16));
        add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        textNombre.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TEXTO.getColor(pmr.getFramePrincipal().getModo())));
        textNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        textNombre.setPreferredSize(new java.awt.Dimension(388, 28));
        TextPrompt placeHolder = new TextPrompt(Texto.NOMBRE.getTexto(), textNombre);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 66, -1, -1));

        labelErrorNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pmr.getFramePrincipal().getModo()))));
        labelErrorNombre.setToolTipText("Aqui deberia de ir un Error");
        labelErrorNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorNombre.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorNombre.setVisible(false);
        add(labelErrorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 66, -1, -1));

        labelTelefono.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelTelefono.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmr.getFramePrincipal().getModo())));
        labelTelefono.setText(Texto.TELEFONO.getTexto());
        labelTelefono.setPreferredSize(new java.awt.Dimension(194, 16));
        add(labelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 112, -1, -1));

        labelIdTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelIdTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(pmr.getFramePrincipal().getModo())));
        labelIdTelefono.setText(Texto.ID_TELEFONO.getTexto());
        labelIdTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        labelIdTelefono.setPreferredSize(new java.awt.Dimension(54, 29));
        add(labelIdTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 128, -1, -1));

        textTelefono.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        textTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(pmr.getFramePrincipal().getModo())));
        textTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        textTelefono.setPreferredSize(new java.awt.Dimension(140, 28));
        placeHolder = new TextPrompt(Texto.TELEFONO.getTexto(), textTelefono);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 129, -1, -1));

        labelErrorTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pmr.getFramePrincipal().getModo()))));
        labelErrorTelefono.setToolTipText("Aqui deberia de ir un Error");
        labelErrorTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorTelefono.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorTelefono.setVisible(false);
        add(labelErrorTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 129, -1, -1));

        labelDireccion.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelDireccion.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmr.getFramePrincipal().getModo())));
        labelDireccion.setText(Texto.DIRECCION.getTexto());
        labelDireccion.setPreferredSize(new java.awt.Dimension(388, 16));
        add(labelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 175, -1, -1));

        textDireccion.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        textDireccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDireccion.setForeground(Color.decode(Colores.TEXTO.getColor(pmr.getFramePrincipal().getModo())));
        textDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        textDireccion.setPreferredSize(new java.awt.Dimension(388, 28));
        placeHolder = new TextPrompt(Texto.DIRECCION.getTexto(), textDireccion);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 191, -1, -1));

        labelErrorDireccion.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pmr.getFramePrincipal().getModo()))));
        labelErrorDireccion.setToolTipText("Aqui deberia de ir un Error");
        labelErrorDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorDireccion.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorDireccion.setVisible(false);
        add(labelErrorDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 191, -1, -1));

        panelFondoJefe.setPreferredSize(new java.awt.Dimension(548, 210));
        panelFondoJefe.setLayout(new java.awt.CardLayout());
        add(panelFondoJefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAgregarJefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarJefeActionPerformed
        jefe = true;
        pmr.getFramePrincipal().cargarPanel(panelFondoJefe, subPanelConJefe);
        recargarColores();
    }//GEN-LAST:event_buttonAgregarJefeActionPerformed

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed
        recargarColores();

        try {
            FunSucursal controlSucursal = new FunSucursal(pmr.getFramePrincipal().getSistema().obtenerRegion(pmr.nombreRegion), pmr.getFramePrincipal().getSistema());
            String error;
            if (jefe) {
                error = controlSucursal.agregarSucursal(textNombre.getText(), textDireccion.getText(), textTelefono.getText(), textNombreJefe.getText(), textEdadJefe.getText());
            } else {
                error = controlSucursal.agregarSucursal(textNombre.getText(), textDireccion.getText(), textTelefono.getText());
            }

            if (error == null) {
                PanelSeleccionarRegion psr = new PanelSeleccionarRegion(pmr);
                pmr.getFramePrincipal().cargarPanel(pmr.getPanelRegion(), psr);
            } else if (error.equals(TextoErrores.NOMBRE_VACIO.getTexto()) || error.equals(TextoErrores.MAXIMO_CARACTERES_NOMBRE_20.getTexto()) || error.equals(TextoErrores.SUCURSAL_DUPLICADO.getTexto())) {
                labelErrorNombre.setVisible(true);
                labelErrorNombre.setToolTipText(error);

                textNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pmr.getFramePrincipal().getModo()))));
            } else if (error.equals(TextoErrores.TELEFONO_VACIO.getTexto()) || error.equals(TextoErrores.TELEFONO_RANGO.getTexto()) || error.equals(TextoErrores.TELEFONO_INVALIDO.getTexto())) {
                labelErrorTelefono.setVisible(true);
                labelErrorTelefono.setToolTipText(error);

                textTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pmr.getFramePrincipal().getModo()))));
                labelIdTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pmr.getFramePrincipal().getModo()))));
            } else if (error.equals(TextoErrores.DIRECCION_VACIO.getTexto()) || error.equals(TextoErrores.MAXIMO_CARACTERES_DIRECCION_20.getTexto())) {
                labelErrorDireccion.setVisible(true);
                labelErrorDireccion.setToolTipText(error);

                textDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pmr.getFramePrincipal().getModo()))));
            } else if (jefe) {
                if (error.equals(TextoErrores.NOMBRE_VACIO_JEFE.getTexto()) || error.equals(TextoErrores.MAXIMO_CARACTERES_NOMBRE_40.getTexto())) {
                    labelErrorNombreJefe.setVisible(true);
                    labelErrorNombreJefe.setToolTipText(error);

                    textNombreJefe.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pmr.getFramePrincipal().getModo()))));
                } else if (error.equals(TextoErrores.EDAD_VACIO.getTexto()) || error.equals(TextoErrores.EDAD_NO_RANGO.getTexto()) || error.equals(TextoErrores.EDAD_NO_NUMERO.getTexto())) {
                    labelErrorEdadJefe.setVisible(true);
                    labelErrorEdadJefe.setToolTipText(error);

                    textEdadJefe.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pmr.getFramePrincipal().getModo()))));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelAgregarRegion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAceptarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        PanelSeleccionarRegion psr = new PanelSeleccionarRegion(pmr);
        pmr.getFramePrincipal().cargarPanel(pmr.getPanelRegion(), psr);
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonQuitarAgregarJefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQuitarAgregarJefeActionPerformed
        jefe = false;
        pmr.getFramePrincipal().cargarPanel(panelFondoJefe, subPanelSinJefe);
        recargarColores();
    }//GEN-LAST:event_buttonQuitarAgregarJefeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private javax.swing.JButton buttonAceptarConJefe;
    private javax.swing.JButton buttonAgregarJefe;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonCancelarConJefe;
    private javax.swing.JButton buttonQuitarAgregarJefe;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelEdadJefe;
    private javax.swing.JLabel labelErrorDireccion;
    private javax.swing.JLabel labelErrorEdadJefe;
    private javax.swing.JLabel labelErrorNombre;
    private javax.swing.JLabel labelErrorNombreJefe;
    private javax.swing.JLabel labelErrorTelefono;
    private javax.swing.JLabel labelIdTelefono;
    private javax.swing.JLabel labelJefeSucursal;
    private javax.swing.JLabel labelJefeSucursal1;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNombreJefe;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelFondoJefe;
    private javax.swing.JPanel subPanelConJefe;
    private javax.swing.JPanel subPanelSinJefe;
    private javax.swing.JTextField textDireccion;
    private javax.swing.JTextField textEdadJefe;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textNombreJefe;
    private javax.swing.JTextField textTelefono;
    // End of variables declaration//GEN-END:variables
}
