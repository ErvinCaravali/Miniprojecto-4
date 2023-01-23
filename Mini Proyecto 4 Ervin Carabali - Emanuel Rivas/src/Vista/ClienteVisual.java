/*
    Mini Proyecto 4
    Integrantes: Ervin Carabali 1925648-3743 Grupo 02
                 Emanuel Rivas 2127706-3743 Grupo 01
    Profesor: Luis Yovany Romo 
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


public class ClienteVisual extends JFrame {
    
    private  JButton agregar2, actulizar2, eliminar2,listar2,atras2;
    private JPanel  crud2,pDatos2,ti;

    private JLabel nombre,apellido,buscartres,cedula,buscar;
    private JTextField nombreuno,apellidouno,id,buscar1;
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

    public JTextField getApellidouno() {
        return apellidouno;
    }

    public void setApellidouno(JTextField apellidouno) {
        this.apellidouno = apellidouno;
    }

    public JTextField getId() {
        return id;
    }

    public void setId(JTextField id) {
        this.id = id;
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
      public JTextField getBuscar1() {
        return buscar1;
    }

    public void setBuscar1(JTextField buscar1) {
        this.buscar1 = buscar1;
    }
    
    
    
    
  
    public void initGUI2() {
        pDatos2 = new JPanel(new GridLayout(4,2));
        nombre = new JLabel("Nombre:");
        nombreuno = new JTextField(12);
        apellido= new JLabel("Apellido:");
        apellidouno = new JTextField(12);
        cedula= new JLabel("Cedula:");
        id = new JTextField(12);
        buscar = new JLabel("Buscar por Cedula:");
        buscar1= new JTextField(12);
        pDatos2.add(nombre);
        pDatos2.add(nombreuno);
        pDatos2.add(apellido);
        pDatos2.add(apellidouno);
        pDatos2.add(cedula);
        pDatos2.add(id);
        pDatos2.add(buscar);
        pDatos2.add(buscar1);
        
        pDatos2.setBackground(Color.getHSBColor(178,57,100));
        add(pDatos2,BorderLayout.NORTH);

        ti = new JPanel();
        Modelo = new DefaultTableModel();
        Modelo.addColumn("Nombre");
        Modelo.addColumn("Apellido");
        Modelo.addColumn("Cedula");
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
    public ClienteVisual() {
        initGUI2();
        this.setTitle("Registro de Clientes");
        this.setSize(1200,600);
        this.setVisible(false);
        this.getContentPane().setBackground(Color.getHSBColor(178,57,100));
        this.setLocationRelativeTo(null);
        this.setResizable(true);
    }
    
}
