/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ervin
 */
public class ProductoVisual extends JFrame {
    private  JButton agregar2, actulizar2, eliminar2,listar2,atras2;
    private JPanel  crud2,pDatos2,ti;

    private JLabel nombre,precio,buscartres,cantidad;
    private JTextField nombreuno,preciouno,cantidaduno;
    private DefaultTableModel Modelo;


    private JTable tabla;

   

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

  
    
    
    
    ////

    public JTextField getNombreuno() {
        return nombreuno;
    }

    public void setNombreuno(JTextField nombreuno) {
        this.nombreuno = nombreuno;
    }

    public JTextField getPrecioouno() {
        return preciouno;
    }

    public void setPrecioouno(JTextField preciouno) {
        this.preciouno = preciouno;
    }

    public JTextField getCantidaduno() {
        return cantidaduno;
    }

    public void settCantidaduno(JTextField cantidaduno) {
        this.cantidaduno = cantidaduno;
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
   
    
    
    
    
  
    public void initGUI2() {
        pDatos2 = new JPanel(new GridLayout(4,2));
        nombre = new JLabel("Nombre:");
        nombreuno = new JTextField(12);
        precio= new JLabel("Precio:");
        preciouno = new JTextField(12);
        cantidad= new JLabel("Cantidad:");
        cantidaduno = new JTextField(12);
        pDatos2.add(nombre);
        pDatos2.add(nombreuno);
        pDatos2.add(precio);
        pDatos2.add(preciouno);
        pDatos2.add(cantidad);
        pDatos2.add(cantidaduno);
     
        
        pDatos2.setBackground(Color.getHSBColor(178,57,100));
        add(pDatos2,BorderLayout.NORTH);

        ti = new JPanel();
        Modelo = new DefaultTableModel();
        Modelo.addColumn("Nombre");
        Modelo.addColumn("Precio");
        Modelo.addColumn("Cantidad");
        tabla = new JTable(Modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setPreferredSize(new Dimension(1100, 500));
        ti.add(scrollPane);
        tabla.setBackground(Color.getHSBColor(178,57,100));
        ti.setBackground(Color.getHSBColor(178,57,100));
        add(ti,BorderLayout.CENTER);


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
   
        crud2.setBackground(Color.getHSBColor(178,57,100));
        add(crud2, BorderLayout.SOUTH);

    }
    public ProductoVisual() {
        initGUI2();
        this.setTitle("Registro de Productos");
        this.setSize(1200,600);
        this.setVisible(false);
        this.getContentPane().setBackground(Color.getHSBColor(178,57,100));
        this.setLocationRelativeTo(null);
        this.setResizable(true);
    
}
    
}
