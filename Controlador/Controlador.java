/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Compra;
import Modelo.Productos;
import Modelo.Proveedor;
import Modelo.Venta;
import Vista.ClienteVisual;
import Vista.CompraVisual;
import Vista.Principal;
import Vista.ProductoVisual;
import Vista.ProveedorVisual;
import Vista.VentaVisual;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author ervin
 */
public class Controlador implements ActionListener, CaretListener, ChangeListener, KeyListener {

    private ClienteVisual cliente;
    private CompraVisual compra;
    private Principal principal;
    private ProveedorVisual proveedor;
    private VentaVisual venta;
    private ProductoVisual producto;
    private Cliente ente;
    private Proveedor edor;
    private Venta enta;
    private Compra pra;
    private Productos ducto;

    ///private ArrayList<Cliente> cliente1;
    public Controlador(Cliente ente, Proveedor edor, Principal principal, ClienteVisual cliente, ProveedorVisual proveedor, VentaVisual venta, CompraVisual compra, Venta enta, Compra pra, ProductoVisual producto, Productos ducto) {
        this.cliente = cliente;
        this.compra = compra;
        this.principal = principal;
        this.proveedor = proveedor;
        this.venta = venta;
        this.producto = producto;
        ///Frame Principal
        this.principal.getAfiliados().addActionListener(this);
        this.principal.getCitas().addActionListener(this);
        this.principal.getServiciosSalud().addActionListener(this);
        this.principal.getConsultorios().addActionListener(this);
        this.principal.getProductos().addActionListener(this);
        ////Frame  Cliente
        this.cliente.getActulizar2().addActionListener(this);
        this.cliente.getAgregar2().addActionListener(this);
        this.cliente.getAtras2().addActionListener(this);
        this.cliente.getListar2().addActionListener(this);
        this.cliente.getEliminar2().addActionListener(this);
        this.cliente.getBuscar1().addCaretListener(this);
        this.cliente.getNombreuno().addKeyListener(this);
        this.cliente.getApellidouno().addKeyListener(this);
        this.cliente.getId().addKeyListener(this);
        ////Frame  Compra
        this.compra.getActulizar2().addActionListener(this);
        this.compra.getAgregar2().addActionListener(this);
        this.compra.getAtras2().addActionListener(this);
        this.compra.getListar2().addActionListener(this);
        this.compra.getEliminar2().addActionListener(this);
        this.compra.getCodigo1().addKeyListener(this);
        this.compra.getNombre1().addKeyListener(this);
        this.compra.getPrecio1().addKeyListener(this);
        this.compra.getStock1().addChangeListener(this);
        this.compra.getCombo1().addActionListener(this);
        this.compra.getProveedor().addActionListener(this);

        ////Frame  Proveedor
        this.proveedor.getActulizar2().addActionListener(this);
        this.proveedor.getAgregar2().addActionListener(this);
        this.proveedor.getAtras2().addActionListener(this);
        this.proveedor.getListar2().addActionListener(this);
        this.proveedor.getEliminar2().addActionListener(this);
        this.proveedor.getSearch().addCaretListener(this);
        this.proveedor.getCodigo1().addKeyListener(this);
        this.proveedor.getRuc1().addKeyListener(this);
        this.proveedor.getNombre1().addKeyListener(this);
        this.proveedor.getCiudad1().addKeyListener(this);
        this.proveedor.getTelefono1().addKeyListener(this);
        ////Frame  Venta
        this.venta.getActulizar2().addActionListener(this);
        this.venta.getAgregar2().addActionListener(this);
        this.venta.getAtras2().addActionListener(this);
        this.venta.getListar2().addActionListener(this);
        this.venta.getEliminar2().addActionListener(this);
        this.venta.getStock1().addChangeListener(this);
        this.venta.getCombo1().addActionListener(this);
        this.venta.getCodigo1().addKeyListener(this);
        this.venta.getNombre1().addKeyListener(this);
         this.venta.getCliente().addActionListener(this);
        // this.venta.getPrecio1().addKeyListener(this);

        /////Frame Productos
        this.producto.getActulizar2().addActionListener(this);
        this.producto.getAgregar2().addActionListener(this);
        this.producto.getAtras2().addActionListener(this);
        this.producto.getListar2().addActionListener(this);
        this.producto.getEliminar2().addActionListener(this);
        this.producto.getNombreuno().addKeyListener(this);
        this.producto.getPrecioouno().addKeyListener(this);
        this.producto.getCantidaduno().addKeyListener(this);

        ////CLIENTE
        this.ente = ente;
        ////PROVEEDOR
        this.edor = edor;
        /// VENTA
        this.enta = enta;
        /// COMPRA
        this.pra = pra;
        ////PRODUCTO
        this.ducto = ducto;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ///////EVENTOS MOVIMIENTOS ENTRE FRAMES
        if (e.getSource().equals(principal.getAfiliados())) {

            principal.setVisible(false);
            /*serviciosSalud*/ cliente.setVisible(false);
            /*consultorios*/ compra.setVisible(false);
            /*medicosEspecialistas*/ //producto.setVisible(false);
            /*PROVEEDOR*/ proveedor.setVisible(true);
            /*citas*/ venta.setVisible(false);
            producto.setVisible(false);
        }

        if (e.getSource().equals(principal.getCitas())) {
            principal.setVisible(false);
            cliente.setVisible(false);
            compra.setVisible(false);
            proveedor.setVisible(false);
            producto.setVisible(false);
            venta.setVisible(true);

        } else if (e.getSource().equals(principal.getServiciosSalud())) {
            principal.setVisible(false);
            cliente.setVisible(true);
            compra.setVisible(false);
            proveedor.setVisible(false);
            venta.setVisible(false);
            producto.setVisible(false);
        } else if (e.getSource().equals(principal.getConsultorios())) {
            principal.setVisible(false);
            cliente.setVisible(false);
            compra.setVisible(true);
            proveedor.setVisible(false);
            venta.setVisible(false);
            producto.setVisible(false);
        } else if (e.getSource().equals(principal.getProductos())) {
            principal.setVisible(false);
            cliente.setVisible(false);
            compra.setVisible(false);
            proveedor.setVisible(false);
            venta.setVisible(false);
            producto.setVisible(true);
        } else if (e.getSource().equals(producto.getAtras2())) {
            principal.setVisible(true);
            cliente.setVisible(false);
            compra.setVisible(false);
            proveedor.setVisible(false);
            venta.setVisible(false);

        } else if (e.getSource().equals(cliente.getAtras2())) {
            principal.setVisible(true);
            cliente.setVisible(false);
            compra.setVisible(false);
            proveedor.setVisible(false);
            venta.setVisible(false);

        } else if (e.getSource().equals(compra.getAtras2())) {
            principal.setVisible(true);
            cliente.setVisible(false);
            compra.setVisible(false);
            proveedor.setVisible(false);
            venta.setVisible(false);
        } else if (e.getSource().equals(venta.getAtras2())) {
            principal.setVisible(true);
            cliente.setVisible(false);
            compra.setVisible(false);
            proveedor.setVisible(false);
            venta.setVisible(false);
        } else if (e.getSource().equals(proveedor.getAtras2())) {
            principal.setVisible(true);
            cliente.setVisible(false);
            compra.setVisible(false);
            proveedor.setVisible(false);
            venta.setVisible(false);
        }else if (e.getSource().equals(venta.getCliente())) {
              cliente.setVisible(true);
        }else if (e.getSource().equals(compra.getProveedor())) {
             proveedor.setVisible(true);
            
        }
        

        if (e.getSource().equals(cliente.getAgregar2())) {
            //ente.AgregarClientes();
            //ente.GuardarDatosClientes();
            ente.Comparar();

            // ente.GuardarDatosClientes();
            cliente.getNombreuno().setText("");
            cliente.getApellidouno().setText("");
            cliente.getId().setText("");
        }

        if (e.getSource().equals(cliente.getListar2())) {
            try {
                int fila = cliente.getTabla().getRowCount();
                for (int i = 0; fila > 0; i++) {

                    cliente.getModelo().removeRow(0);
                }
            } catch (Exception E) {
                JOptionPane.showMessageDialog(null, "Se Limpio la tabla.");
            }

            for (Cliente ente : ente.RecuperarClientes()) {
                cliente.getModelo().addRow(
                        new Object[]{ente.getNombre(),
                            ente.getApellido(),
                            ente.getCedula(),});
            }

        }
        if (e.getSource().equals(cliente.getActulizar2())) {
            ente.ActualizarClientes();

        }
        if (e.getSource().equals(cliente.getEliminar2())) {
            String dAfiliado = ente.getCedula();
            boolean bandera = false;
            String cedulaAfiliado = JOptionPane.showInputDialog("Ingrese la cedula del Cliente que se qiere  eliminar");

            for (int j = 0; j < ente.RecuperarClientes().size(); j++) {
                for (int i = 0; i < enta.RecuperarVentas().size(); i++) {
                    if ((ente.RecuperarClientes().get(i).getCedula()).equals(cedulaAfiliado)) {
                        if (enta.RecuperarVentas().get(i).getCodigo().equals(ente.RecuperarClientes().get(j).getCedula())) {
                            bandera = true;
                            System.out.println("NO se puede Eliminnar");

                            break;
                        }

                    }

                }
            }
            if (bandera == false) {
                ente.EliminarClientes();
                System.out.println("SE  puede Eliminnar");
            }
        }

        if (e.getSource().equals(proveedor.getAgregar2())) {
            edor.Comparar();
            proveedor.getCodigo1().setText("");
            proveedor.getRuc1().setText("");
            proveedor.getNombre1().setText("");
            proveedor.getDireccion1().setText("");
            proveedor.getCiudad1().setText("");
            proveedor.getTelefono1().setText("");
            proveedor.getEmail1().setText("");
        }

        if (e.getSource().equals(proveedor.getListar2())) {
            try {
                int fila = proveedor.getTabla().getRowCount();
                for (int i = 0; fila > 0; i++) {

                    proveedor.getModelo().removeRow(0);
                }
            } catch (Exception E) {
                JOptionPane.showMessageDialog(null, "Se Limpio la tabla.");
            }
            for (Proveedor edor1 : edor.RecuperarProveedores()) {
                proveedor.getModelo().addRow(
                        new Object[]{edor1.getCodigo(),
                            edor1.getRut(),
                            edor1.getNombre(),
                            edor1.getDireccion(),
                            edor1.getCiudad(),
                            edor1.getTelefono(),
                            edor1.getEmail(),});
            }

        }
        if (e.getSource().equals(proveedor.getActulizar2())) {
            edor.ActualizarProveedores();

        }
        if (e.getSource().equals(proveedor.getEliminar2())) {
            //edor.EliminarProveedores();

            String dAfiliado = edor.getCodigo();
            boolean bandera = false;
            String cedulaAfiliado = JOptionPane.showInputDialog("Ingrese la cedula del Cliente que se qiere  eliminar");

            for (int j = 0; j < edor.RecuperarProveedores().size(); j++) {
                for (int i = 0; i < pra.RecuperarVentas().size(); i++) {
                    if ((edor.RecuperarProveedores().get(i).getCodigo()).equals(cedulaAfiliado)) {
                        if (pra.RecuperarVentas().get(i).getCodigo().equals(edor.RecuperarProveedores().get(j).getCodigo())) {
                            bandera = true;
                            System.out.println("NO se puede Eliminnar");

                            break;
                        }

                    }

                }
            }
            if (bandera == false) {
                edor.EliminarProveedores();
                System.out.println("SE  puede Eliminnar");
            }

        }
        if (e.getSource().equals(venta.getCombo1().getSelectedItem())) {
            enta.AgregarVentas();

        }

        if (e.getSource().equals(venta.getAgregar2())) {
            enta.Comparar();
            venta.getCodigo1().setText("");
            venta.getNombre1().setText("");
            //venta.getPrecio1().setText("");
            venta.getTipo1().setText("");
            venta.getStock1().setToolTipText("");
        }
        if (e.getSource().equals(venta.getListar2())) {

            try {
                int fila = venta.getTabla().getRowCount();
                for (int i = 0; fila > 0; i++) {

                    venta.getModelo().removeRow(0);
                }
            } catch (Exception E) {
                JOptionPane.showMessageDialog(null, "Se Limpio la tabla.");
            }
            for (Venta enta : enta.RecuperarVentas()) {
                venta.getModelo().addRow(
                        new Object[]{
                            enta.getCodigo(),
                            enta.getNombre(),
                            enta.getPrecio(),
                            enta.getStock(),
                            enta.getTipo(),});
            }
        }

        if (e.getSource().equals(venta.getActulizar2())) {
            enta.ActualizarVentas();

        }

        if (e.getSource().equals(venta.getEliminar2())) {

            String dAfiliado = ente.getCedula();
            boolean bandera = false;
            String cedulaAfiliado = JOptionPane.showInputDialog("Ingrese la cedula del Cliente que se qiere  eliminar");

            for (int j = 0; j < ente.RecuperarClientes().size(); j++) {
                for (int i = 0; i < enta.RecuperarVentas().size(); i++) {
                    if ((enta.RecuperarVentas().get(i).getCodigo()).equals(cedulaAfiliado)) {
                        if (enta.RecuperarVentas().get(i).getCodigo().equals(ente.RecuperarClientes().get(j).getCedula())) {

                            enta.EliminaVentas();
                            bandera = true;

                        }

                    }

                }
            }
            if (bandera == false) {
                System.out.println("NO se puede Eliminnar");
            }

        }
        /////
        if (e.getSource().equals(compra.getCombo1().getSelectedItem())) {
            pra.AgregarVentas();

        }

        if (e.getSource().equals(compra.getAgregar2())) {
            pra.Comparar();
            compra.getCodigo1().setText("");
            compra.getNombre1().setText("");
            compra.getPrecio1().setText("");
            compra.getTipo1().setText("");
            compra.getStock1().setToolTipText("");
        }
        if (e.getSource().equals(compra.getListar2())) {

            try {
                int fila = compra.getTabla().getRowCount();
                for (int i = 0; fila > 0; i++) {

                    compra.getModelo().removeRow(0);
                }
            } catch (Exception E) {
                JOptionPane.showMessageDialog(null, "Se Limpio la tabla.");
            }
            for (Compra enta : pra.RecuperarVentas()) {
                compra.getModelo().addRow(
                        new Object[]{
                            enta.getCodigo(),
                            enta.getNombre(),
                            enta.getPrecio(),
                            enta.getStock(),
                            enta.getTipo(),});
            }
        }

        if (e.getSource().equals(compra.getActulizar2())) {
            pra.ActualizarVentas();

        }

        if (e.getSource().equals(compra.getEliminar2())) {

            String dAfiliado = edor.getCodigo();
            boolean bandera = false;
            String cedulaAfiliado = JOptionPane.showInputDialog("Ingrese la cedula del Cliente que se qiere  eliminar");

            for (int j = 0; j < edor.RecuperarProveedores().size(); j++) {
                for (int i = 0; i < pra.RecuperarVentas().size(); i++) {
                    if ((edor.RecuperarProveedores().get(i).getCodigo()).equals(cedulaAfiliado)) {
                        if (pra.RecuperarVentas().get(i).getCodigo().equals(edor.RecuperarProveedores().get(j).getCodigo())) {

                            pra.EliminaVentas();
                            bandera = true;
                            System.out.println(" se puede Eliminnarl");
                        }

                    }

                }
            }
            if (bandera == false) {

                System.out.println(" No Se puede Eliminnarl");
            }

        }

        if (e.getSource().equals(producto.getAgregar2())) {
            ducto.AgregarProductos();
            ducto.GuardarDatosProductos();
            producto.getNombreuno().setText("");
            producto.getPrecioouno().setText("");
            producto.getCantidaduno().setText("");
        }
        if (e.getSource().equals(producto.getListar2())) {
            try {
                int fila = producto.getTabla().getRowCount();
                for (int i = 0; fila > 0; i++) {

                    producto.getModelo().removeRow(0);
                }
            } catch (Exception E) {
                JOptionPane.showMessageDialog(null, "Se Limpio la tabla.");
            }

            for (Productos ducto : ducto.RecuperarProductos()) {
                producto.getModelo().addRow(
                        new Object[]{ducto.getNombre(),
                            ducto.getPrecio(),
                            ducto.getCantidad(),});
            }

        }
        if (e.getSource().equals(producto.getActulizar2())) {
            ducto.ActualizarProductos();
        }
        if (e.getSource().equals(producto.getEliminar2())) {
            ducto.EliminarProductos();
        }

    }

    @Override
    public void caretUpdate(CaretEvent e) {

        if (e.getSource().equals(proveedor.getSearch())) {
            edor.Buscar();
        }

        if (e.getSource().equals(cliente.getBuscar1())) {
            ente.Buscar();
        }
       

    }

    @Override

    public void stateChanged(ChangeEvent e) {

        if (e.getSource().equals(venta.getStock1())) {
            enta.AgregarVentas();
            //ente.Comparar();
        }
        if (e.getSource().equals(compra.getStock1())) {
            pra.AgregarVentas();

        }

    }

    @Override

    public void keyTyped(KeyEvent e) {
        if (e.getSource().equals(cliente.getNombreuno())) {
            if (cliente.getNombreuno().getText().length() >= 10) {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            char carater = e.getKeyChar();
            if (!Character.isAlphabetic(carater)) {
                e.consume();
            }
        } else if (e.getSource().equals(cliente.getApellidouno())) {
            if (cliente.getApellidouno().getText().length() >= 10) {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            char carater = e.getKeyChar();
            if (!Character.isAlphabetic(carater)) {
                e.consume();
            }
        } else if (e.getSource().equals(cliente.getId())) {
            if (cliente.getId().getText().length() >= 10) {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            char carater = e.getKeyChar();
            if (!Character.isDigit(carater)) {
                e.consume();
            }
        } else if (e.getSource().equals(proveedor.getCodigo1())) {
            if (proveedor.getCodigo1().getText().length() >= 10) {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            char carater = e.getKeyChar();
            if (!Character.isDigit(carater)) {
                e.consume();
            }
        } else if (e.getSource().equals(proveedor.getRuc1())) {
            if (proveedor.getRuc1().getText().length() >= 10) {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            char carater = e.getKeyChar();
            if (!Character.isDigit(carater)) {
                e.consume();
            }
        } else if (e.getSource().equals(proveedor.getNombre1())) {
            if (proveedor.getNombre1().getText().length() >= 10) {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            char carater = e.getKeyChar();
            if (!Character.isAlphabetic(carater)) {
                e.consume();
            }
        } else if (e.getSource().equals(proveedor.getCiudad1())) {
            if (proveedor.getCiudad1().getText().length() >= 10) {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            char carater = e.getKeyChar();
            if (!Character.isAlphabetic(carater)) {
                e.consume();
            }
        } else if (e.getSource().equals(proveedor.getTelefono1())) {
            if (proveedor.getTelefono1().getText().length() >= 10) {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            char carater = e.getKeyChar();
            if (!Character.isDigit(carater)) {
                e.consume();
            }
        } 
        else if (e.getSource().equals(venta.getCodigo1())) {
            if (venta.getCodigo1().getText().length() >= 10) {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            char carater = e.getKeyChar();
            if (!Character.isDigit(carater)) {
                e.consume();
            }
        } else if (e.getSource().equals(venta.getNombre1())) {
            if (venta.getNombre1().getText().length() >= 10) {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            char carater = e.getKeyChar();
            if (!Character.isAlphabetic(carater)) {
                e.consume();
            }
        } 
        else if (e.getSource().equals(compra.getCodigo1())) {
            if (compra.getCodigo1().getText().length() >= 10) {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            char carater = e.getKeyChar();
            if (!Character.isDigit(carater)) {
                e.consume();
            }
        } else if (e.getSource().equals(compra.getNombre1())) {
            if (compra.getNombre1().getText().length() >= 10) {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            char carater = e.getKeyChar();
            if (!Character.isAlphabetic(carater)) {
                e.consume();
            }
        } else if (e.getSource().equals(producto.getNombreuno())) {
            if (producto.getNombreuno().getText().length() >= 10) {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            char carater = e.getKeyChar();
            if (!Character.isAlphabetic(carater)) {
                e.consume();
            }
         }
        else if (e.getSource().equals(producto.getPrecioouno())) {
            if (producto.getPrecioouno().getText().length() >= 10) {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            char carater = e.getKeyChar();
            if (!Character.isDigit(carater)) {
                e.consume();
            }
        } 
           else if (e.getSource().equals(producto.getCantidaduno())) {
            if (producto.getCantidaduno().getText().length() >= 10) {
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
            char carater = e.getKeyChar();
            if (!Character.isDigit(carater)) {
                e.consume();
            }
        } 
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
