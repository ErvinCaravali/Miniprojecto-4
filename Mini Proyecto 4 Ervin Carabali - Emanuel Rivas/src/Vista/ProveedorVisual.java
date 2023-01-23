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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class ProveedorVisual extends JFrame {
    private JButton  agregar2, actulizar2, eliminar2, listar2, atras2;
    private JPanel crud2, pDatos2, ti, buscador;

    private JLabel codigo,ruc ,nombre,direccion ,ciudad ,telefono,email,buscar;
    private JTextField codigo1,ruc1 ,nombre1,direccion1 ,ciudad1 ,telefono1,email1,busca1,search;
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

    
    
    /////

    public JTextField getCodigo1() {
        return codigo1;
    }

    public void setCodigo1(JTextField codigo1) {
        this.codigo1 = codigo1;
    }

    public JTextField getRuc1() {
        return ruc1;
    }

    public void setRuc1(JTextField ruc1) {
        this.ruc1 = ruc1;
    }

    public JTextField getNombre1() {
        return nombre1;
    }

    public void setNombre1(JTextField nombre1) {
        this.nombre1 = nombre1;
    }

    public JTextField getDireccion1() {
        return direccion1;
    }

    public void setDireccion1(JTextField direccion1) {
        this.direccion1 = direccion1;
    }

    public JTextField getCiudad1() {
        return ciudad1;
    }

    public void setCiudad1(JTextField ciudad1) {
        this.ciudad1 = ciudad1;
    }

    public JTextField getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(JTextField telefono1) {
        this.telefono1 = telefono1;
    }

    public JTextField getEmail1() {
        return email1;
    }

    public void setEmail1(JTextField email1) {
        this.email1 = email1;
    }

    public JTextField getBusca1() {
        return busca1;
    }

    public void setBusca1(JTextField busca1) {
        this.busca1 = busca1;
    }

    public JTextField getSearch() {
        return search;
    }

    public void setSearch(JTextField search) {
        this.search = search;
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
    
    
    

    private void initGUI2() {
        pDatos2 = new JPanel(new GridLayout(8, 2));
        codigo = new JLabel("Codigo");
        codigo1 = new JTextField(12);
        ruc = new JLabel("RUT");
        ruc1 = new JTextField(12);
        nombre = new JLabel("Nombre");
        nombre1 = new JTextField(12);
        direccion = new JLabel("Direccion");
        direccion1 = new JTextField(12);
        ciudad = new JLabel("Ciudad");
        ciudad1 = new JTextField(12);
        telefono= new JLabel("Telefono");
        telefono1 = new JTextField(12);
        email = new JLabel("Email");
        email1 = new JTextField(4);
       
      
         buscador = new JPanel(new GridLayout(1, 3));
         buscar = new JLabel("Buscar por RUT");
         search= new JTextField(7);
        
       
        pDatos2.add(codigo);
        pDatos2.add(codigo1);
        pDatos2.add(ruc);
        pDatos2.add(ruc1);
        pDatos2.add(nombre);
        pDatos2.add(nombre1);
        pDatos2.add(direccion);
        pDatos2.add(direccion1);
        pDatos2.add(ciudad);
        pDatos2.add(ciudad1);
        pDatos2.add(telefono);
        pDatos2.add(telefono1);
        pDatos2.add(email);
        pDatos2.add(email1);
        buscador.add(search);
        pDatos2.add(buscar);
        pDatos2.add(buscador);
        
        pDatos2.setBackground(Color.getHSBColor(178, 57, 100));
        add(pDatos2, BorderLayout.NORTH);

        ti = new JPanel();
        Modelo = new DefaultTableModel();
        Modelo.addColumn("Codigo");
        Modelo.addColumn("RUT");
        Modelo.addColumn("Nombre");
        Modelo.addColumn("Direccion");
        Modelo.addColumn("Ciudad");
        Modelo.addColumn("Telefono");
        Modelo.addColumn("Email");
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

    public ProveedorVisual() {
        initGUI2();
        this.setTitle("Registro de Proveedores");
        this.setSize(1200,600);
        this.setVisible(false);
        this.getContentPane().setBackground(Color.getHSBColor(178, 57, 100));
        this.setLocationRelativeTo(null);
        this.setResizable(true);
    }
    
}
