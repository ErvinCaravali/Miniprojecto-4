/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Compra;
import Modelo.Productos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ervin
 */
public class CompraVisual extends JFrame {

    private JButton agregar2, actulizar2, eliminar2, listar2, atras2, proveedor;
    private JPanel crud2, pDatos2, ti, pb2;
    private Compra pra;

    private Productos to;
    private JLabel codigo, nombre, precio, stock, tipo, proveedor1;
    private JTextField codigo1, nombre1, precio1, tipo1;
    private JComboBox<String> combo1;
    private DefaultTableModel Modelo;

    private JTable tabla;

    private JSpinner stock1;
    private SpinnerNumberModel stock2;

    public Compra getPra() {
        return pra;
    }

    public Productos getTo() {
        return to;
    }

    public JButton getAgregar2() {
        return agregar2;
    }

    public JButton getActulizar2() {
        return actulizar2;
    }

    public JButton getEliminar2() {
        return eliminar2;
    }

    public JButton getListar2() {
        return listar2;
    }

    public JButton getAtras2() {
        return atras2;
    }

    public JButton getProveedor() {
        return proveedor;
    }

    ///
    public JTextField getCodigo1() {
        return codigo1;
    }

    public void setCodigo1(JTextField codigo1) {
        this.codigo1 = codigo1;
    }

    public JTextField getNombre1() {
        return nombre1;
    }

    public void setNombre1(JTextField nombre1) {
        this.nombre1 = nombre1;
    }

    public JTextField getPrecio1() {
        return precio1;
    }

    public void setPrecio1(JTextField precio1) {
        this.precio1 = precio1;
    }

    public JSpinner getStock1() {
        return stock1;
    }

    public void setStock1(JSpinner stock1) {
        this.stock1 = stock1;
    }

    public JTextField getTipo1() {
        return tipo1;
    }

    public void setTipo1(JTextField tipo1) {
        this.tipo1 = tipo1;
    }

    public JComboBox<String> getCombo1() {
        return combo1;
    }

    public void setCombo1(JComboBox<String> combo1) {
        this.combo1 = combo1;
    }

    public DefaultTableModel getModelo() {
        return Modelo;
    }

    public void setModelo(DefaultTableModel Modelo) {
        this.Modelo = Modelo;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public SpinnerNumberModel getStock2() {
        return stock2;
    }

    public void setStock2(SpinnerNumberModel stock2) {
        this.stock2 = stock2;
    }

    private void initGUI2() {

        pra = new Compra();
        to = new Productos();
        pb2 = new JPanel(new GridLayout(1, 1));
        proveedor1 = new JLabel("Abrir a Registro de Proveedores :");
        proveedor = new JButton();
        Image img = new ImageIcon(getClass().getResource("/Sources/proveedores.png")).getImage();
        ImageIcon imga = new ImageIcon(img.getScaledInstance(10, 10, Image.SCALE_SMOOTH));
        proveedor.setIcon(imga);
        pb2.add(proveedor1);
        pb2.add(proveedor);
        pb2.setBackground(Color.getHSBColor(178, 57, 100));
        pDatos2 = new JPanel(new GridLayout(7, 2));

        codigo = new JLabel("Codigo");
        codigo1 = new JTextField(12);
        nombre = new JLabel("Nombre");
        nombre1 = new JTextField(12);
        precio = new JLabel("Precio");
        precio1 = new JTextField(12);
       stock = new JLabel("Stock");
        stock1 = new JSpinner();

        tipo = new JLabel("Tipo");
        tipo1 = new JTextField(12);
        combo1 = new JComboBox();

        combo1.setModel(new DefaultComboBoxModel<>(pra.getProductos()));

        int selection = getCombo1().getSelectedIndex();
        switch (selection) {

            case 0:
                for (int i = 0; i < to.RecuperarCantidades().size(); i++) {
                    stock2 = new SpinnerNumberModel(0, 0, (to.RecuperarCantidades().get(0).getCantidad()), 1);
                }
                break;
            case 1:
                for (int i = 0; i < to.RecuperarCantidades().size(); i++) {
                    stock2 = new SpinnerNumberModel(0, 0, (to.RecuperarCantidades().get(1).getCantidad()), 1);
                }
                break;
            case 2:
                for (int i = 0; i < to.RecuperarCantidades().size(); i++) {
                    stock2 = new SpinnerNumberModel(0, 0, (to.RecuperarCantidades().get(2).getCantidad()), 1);
                }
                break;
            case 3:
                for (int i = 0; i < to.RecuperarCantidades().size(); i++) {
                    stock2 = new SpinnerNumberModel(0, 0, (to.RecuperarCantidades().get(3).getCantidad()), 1);
                }
                break;
            case 4:
                for (int i = 0; i < to.RecuperarCantidades().size(); i++) {
                    stock2 = new SpinnerNumberModel(0, 0, (to.RecuperarCantidades().get(4).getCantidad()), 1);
                }
                break;
            case 5:
                for (int i = 0; i < to.RecuperarCantidades().size(); i++) {
                    stock2 = new SpinnerNumberModel(0, 0, (to.RecuperarCantidades().get(5).getCantidad()), 1);
                }
                break;
            case 6:
                for (int i = 0; i < to.RecuperarCantidades().size(); i++) {
                    stock2 = new SpinnerNumberModel(0, 0, (to.RecuperarCantidades().get(6).getCantidad()), 1);
                }
                break;
            case 7:
                for (int i = 0; i < to.RecuperarCantidades().size(); i++) {
                    stock2 = new SpinnerNumberModel(0, 0, (to.RecuperarCantidades().get(7).getCantidad()), 1);
                }
                break;
            case 8:
                for (int i = 0; i < to.RecuperarCantidades().size(); i++) {
                    stock2 = new SpinnerNumberModel(0, 0, (to.RecuperarCantidades().get(8).getCantidad()), 1);
                }
                break;
            case 9:
                for (int i = 0; i < to.RecuperarCantidades().size(); i++) {
                    stock2 = new SpinnerNumberModel(0, 0, (to.RecuperarCantidades().get(9).getCantidad()), 1);
                }
                break;
            case 10:
                for (int i = 0; i < to.RecuperarCantidades().size(); i++) {
                    stock2 = new SpinnerNumberModel(0, 0, (to.RecuperarCantidades().get(10).getCantidad()), 1);
                }
                break;
            case 11:
                for (int i = 0; i < to.RecuperarCantidades().size(); i++) {
                    stock2 = new SpinnerNumberModel(0, 0, (to.RecuperarCantidades().get(11).getCantidad()), 1);
                }
                break;
            case 12:
                for (int i = 0; i < to.RecuperarCantidades().size(); i++) {
                    stock2 = new SpinnerNumberModel(0, 0, (to.RecuperarCantidades().get(12).getCantidad()), 1);
                }
                break;

            case 13:
                for (int i = 0; i < to.RecuperarCantidades().size(); i++) {
                    stock2 = new SpinnerNumberModel(0, 0, (to.RecuperarCantidades().get(13).getCantidad()), 1);
                }
                break;
            case 14:
                for (int i = 0; i < to.RecuperarCantidades().size(); i++) {
                    stock2 = new SpinnerNumberModel(0, 0, (to.RecuperarCantidades().get(14).getCantidad()), 1);
                }
                break;
            case 15:
                for (int i = 0; i < to.RecuperarCantidades().size(); i++) {
                    stock2 = new SpinnerNumberModel(0, 0, (to.RecuperarCantidades().get(15).getCantidad()), 1);
                }
                break;
            case 16:
                for (int i = 0; i < to.RecuperarCantidades().size(); i++) {
                    stock2 = new SpinnerNumberModel(0, 0, (to.RecuperarCantidades().get(16).getCantidad()), 1);
                }
                  break;
            default:
        }

        stock1.setModel(stock2);

        pDatos2.add(codigo);
        pDatos2.add(codigo1);
        pDatos2.add(nombre);
        pDatos2.add(nombre1);
        pDatos2.add(precio);
        pDatos2.add(precio1);
        pDatos2.add(stock);
        pDatos2.add(stock1);
        pDatos2.add(tipo);
        pDatos2.add(combo1);
        pDatos2.add(pb2);
        pDatos2.setBackground(Color.getHSBColor(178, 57, 100));

        add(pDatos2, BorderLayout.NORTH);

        ti = new JPanel();
        Modelo = new DefaultTableModel();
        Modelo.addColumn("Codigo");
        Modelo.addColumn("Nombre");
        Modelo.addColumn("Precio");
        Modelo.addColumn("Stock");
       Modelo.addColumn("Tipo");
        tabla = new JTable(Modelo);

        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setPreferredSize(new Dimension(1100, 500));
        ti.add(scrollPane);
        tabla.setBackground(Color.getHSBColor(178, 57, 100));
        ti.setBackground(Color.getHSBColor(178, 57, 100));
        add(ti, BorderLayout.CENTER);

        crud2 = new JPanel();
        agregar2 = new JButton("Agregar");
        actulizar2 = new JButton("Actualizar");
        eliminar2 = new JButton("Eliminar");
        listar2 = new JButton("Listar");
        atras2 = new JButton("Retroceder");

        crud2.add(atras2);
        crud2.add(agregar2);
        crud2.add(actulizar2);
        crud2.add(eliminar2);
        crud2.add(listar2);
        crud2.setBackground(Color.getHSBColor(178, 57, 100));
        add(crud2, BorderLayout.SOUTH);

    }

    public CompraVisual() {
        initGUI2();
        this.setTitle("Registro de  Compra de Productos");
        this.setSize(1200, 600);
        this.setVisible(false);
        this.getContentPane().setBackground(Color.getHSBColor(178, 57, 100));
        this.setLocationRelativeTo(null);
        this.setResizable(true);
    }

}
