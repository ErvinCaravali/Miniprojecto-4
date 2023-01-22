/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.ClienteVisual;
import Vista.VentaVisual;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ervin
 */
public class Venta {

    private String cedula, nombre, tipo,ghg;
    private String precio1;
    private int stock;
    private VentaVisual venta;
    private Cliente cliente;
    private Proveedor proveedor;
    private Productos producto;
    private Compra compra;
    private String productos[];
    private double precios[];

    public Venta(String cedula, String nombre, String precio1, int stock, String tipo, VentaVisual venta, Cliente cliente) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.precio1 = precio1;
        this.stock = stock;
        this.venta = venta;
        this.cliente = cliente;
        this.tipo = tipo;
    }
  
      public Venta(String cedula, String nombre, String ghg, int stock, String tipo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.ghg= ghg;
        this.stock = stock;
        this.tipo = tipo;
    }

    public Venta() {

    }
   
    public Productos getProducto() {
        return producto;
    }
   

    public Compra getCompra() {
        return compra;
    }
    
    
    
    
     public double[] getPrecios() {
         producto = new Productos();
            double precios[] = new double[producto.RecuperarPreciosProductos().size()];
        for (int i = 0; i < producto.RecuperarPreciosProductos().size(); i++) {
             
                 precios[i]=  Double.parseDouble(getProducto().RecuperarPreciosProductos().get(i).getPrecio());
             
        }
                
        return precios;
    }
   

     
    
      public String[] getProductos() {
        compra = new Compra();
        String productos[] = new String[compra.RecuperarNombreProductos().size()];
        for (int i = 0; i < compra.RecuperarNombreProductos().size(); i++) {
            productos[i] = getCompra().RecuperarNombreProductos().get(i).getTipo();
        }

        return productos;
    }
   
    
    

    public void AgregarVentas() {
         precios= getPrecios();
        String codigo = venta.getCodigo1().getText();
        String nombre = venta.getNombre1().getText();
        double precio = precios[venta.getCombo1().getSelectedIndex()];
        int stock1 = Integer.parseInt(venta.getStock1().getValue().toString());
         venta.getPrecio1().setText(Moneda(precio*stock1));
        String precioi = venta.getPrecio1().getText();
        String tipo = venta.getCombo1().getSelectedItem().toString();
        ArrayList<Venta> enta = new ArrayList<Venta>();
      
        
        Venta cli = new Venta(codigo, nombre, precioi, stock1, tipo, venta,  cliente);
        enta.add(cli);
        for (int i = 0; i < enta.size(); i++) {
            venta.getModelo().addRow(new Object[]{
                enta.get(i).getCodigo(),
                enta.get(i).getNombre(),
                enta.get(i).getPrecio(),
                enta.get(i).getStock(),
                enta.get(i).getTipo(),});
        }

    }

    public void GuardarDatosVentas() {

        FileWriter flwriter = null;

        try {

            flwriter = new FileWriter("src/ArchivosTexto/ventas.txt", true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);

          String codigo = venta.getCodigo1().getText();
        String nombre = venta.getNombre1().getText();
        double precio = precios[venta.getCombo1().getSelectedIndex()];
        int stock1 = Integer.parseInt(venta.getStock1().getValue().toString());
         venta.getPrecio1().setText(Moneda(precio*stock1));
        String precioi = venta.getPrecio1().getText();
        String tipo = venta.getCombo1().getSelectedItem().toString();
        ArrayList<Venta> enta = new ArrayList<Venta>();
        Venta cli = new Venta(codigo, nombre, precioi, stock1, tipo, venta,  cliente);
            enta.add(cli);

            for (int i = 0; i < enta.size(); i++) {
                bfwriter.write(
                        enta.get(i).getCodigo() + ";"
                        + enta.get(i).getNombre() + ";"
                        + enta.get(i).getPrecio() + ";"
                        + enta.get(i).getStock() + ";"
                        + enta.get(i).getTipo() + ";" + "\n");
            }

            bfwriter.close();
            JOptionPane.showMessageDialog(null, "Archivo creado");
        } catch (IOException E) {
            E.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();

                } catch (IOException E) {
                    E.printStackTrace();
                }
            }
        }

    }

    public ArrayList<Venta> RecuperarVentas() {
        ArrayList<Venta> enta = new ArrayList<>();

        File file = new File("src/ArchivosTexto/ventas.txt");
        enta = new ArrayList<Venta>();
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
                delimitar.useDelimiter("\\s*;\\s*");
                String cedula = "";
                String nombre1 = "";
                String precio1 = "";
                int stock = 0;
                String tipo = "";
                Venta e = new Venta(cedula, nombre1, precio1, stock, tipo, venta, cliente);
                e.setCodigo(delimitar.next());
                e.setNombre(delimitar.next());
                e.setPrecio(delimitar.next());
                e.setStock(delimitar.nextInt());
                e.setTipo(delimitar.next());

                enta.add(e);

            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return enta;
    }

    public String Moneda(double precio) {
        return "$" + Math.round(precio * 100) / 100 + " COL";
    }

   

    public void Comparar() {

        for (int i = 0; i < cliente.RecuperarClientes().size(); i++) {
            if (cliente.RecuperarClientes().get(i).getCedula().equals(venta.getCodigo1().getText())) {
                System.out.println("El Cliente esta en la base de datos ");

                GuardarDatosVentas();
            } else {
                System.out.println("El Cliente no esta en la base de datos");
            }

        }

    }

    /////////////////////
    public void ActualizarVentas() {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            Venta[] a = GuardarAfiliados();
            ArrayList<Venta> sublist = new ArrayList<>(Arrays.asList(a));
            fw = new FileWriter("src/ArchivosTexto/ventas.txt", true);
            bw = new BufferedWriter(fw);

            for (Venta enta : sublist) {

                bw.write(enta.getCodigo() + ";" + enta.getNombre() + ";" + enta.getPrecio() + ";" + enta.getStock() + ";" + enta.getTipo() + ";" + "\n");
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "quemas" + ex);

        } finally {
            try {
                bw.close();
                fw.close();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "no funciona" + ex);
            }
        }

    }

    public int TotalAfiliados(BufferedReader br) throws IOException {
        int nAfiliados = 0;
        while ((br.readLine() != null)) {
            nAfiliados++;
        }
        br.close();
        return nAfiliados;
    }

    public Venta[] GuardarAfiliados() throws IOException {
        FileReader fr = new FileReader("src/ArchivosTexto/ventas.txt");
        BufferedReader br = new BufferedReader(fr);
        //ArrayList<Afiliados1>a;
        Venta[] a = new Venta[TotalAfiliados(br)];
        fr = new FileReader("src/ArchivosTexto/ventas.txt");
        br = new BufferedReader(fr);

        int poselemento = 0;
        String dAfiliado;
        String cedulaAfiliado = JOptionPane.showInputDialog("Ingrese la cedula del cliente a Editar");
        while (((dAfiliado = br.readLine()) != null)) {

            if (dAfiliado.split(";")[0].equalsIgnoreCase(cedulaAfiliado)) {
                String cedula = JOptionPane.showInputDialog("Ingrese la nueva cedula");
                String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
                String precio = JOptionPane.showInputDialog("Ingrese el nuevo precio");
                
                int stock =0;
                //int stock1= Integer.parseInt(stock);
                 stock=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad"));
                String tipo = (String) JOptionPane.showInputDialog(null, "Ingrese el nueevo tipo de producto", "Elegir", JOptionPane.QUESTION_MESSAGE, null, productos, productos[0]);

                a[poselemento] = new Venta(cedula, nombre, precio, stock, tipo, venta, cliente);

            } else {

                a[poselemento] = new Venta(dAfiliado.split(";")[0],
                        dAfiliado.split(";")[1], dAfiliado.split(";")[2], dAfiliado.split(";")[3].charAt(stock), dAfiliado.split(";")[4]);

            }
            poselemento++;

        }

        new PrintWriter("src/ArchivosTexto/ventas.txt").write("");
        new PrintWriter("src/ArchivosTexto/ventas.txt").close();
        br.close();
        fr.close();
        return a;
    }

    public void EliminaVentas() {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            Venta[] a = EliminarVentas1();
            ArrayList<Venta> sublist = new ArrayList<Venta>(Arrays.asList(a));
            fw = new FileWriter("src/ArchivosTexto/ventas.txt", true);
            bw = new BufferedWriter(fw);

            for (Venta enta : sublist) {
                if (enta != null) {
                    bw.write(enta.getCodigo() + ";" + enta.getNombre() + ";" + enta.getPrecio() + ";" + enta.getTipo() + ";" + "\n");
                }
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "quemas" + ex);

        } finally {
            try {
                bw.close();
                fw.close();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "no funciona" + ex);
            }
        }

    }

    public Venta[] EliminarVentas1() throws IOException {
        FileReader fr = new FileReader("src/ArchivosTexto/ventas.txt");
        BufferedReader br = new BufferedReader(fr);
        Venta[] a = new Venta[TotalAfiliados(br)];
        fr = new FileReader("src/ArchivosTexto/ventas.txt");
        br = new BufferedReader(fr);

        int poselemento = 0;
        String dAfiliado;
        String cedulaAfiliado = JOptionPane.showInputDialog("Ingrese la cedula del Cliente a Editar");
        while (((dAfiliado = br.readLine()) != null)) {

            if (dAfiliado.split(";")[0].equalsIgnoreCase(cedulaAfiliado)) {
                continue;

            } else {

                a[poselemento] = new Venta(dAfiliado.split(";")[0],
                        dAfiliado.split(";")[1], dAfiliado.split(";")[2], dAfiliado.split(";")[3].charAt(stock), dAfiliado.split(";")[4]);
            }
            poselemento++;

        }

        new PrintWriter("src/ArchivosTexto/ventas.txt").write("");
        new PrintWriter("src/ArchivosTexto/ventas.txt").close();
        br.close();
        fr.close();
        return a;
    }

    

    public String getCodigo() {
        return cedula;
    }

    public void setCodigo(String codigo) {
        this.cedula = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrecio() {
        return precio1;
    }

    public void setPrecio(String precio1) {
        this.precio1 = precio1;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Venta{" + "cedula=" + cedula + ", nombre=" + nombre + "tipo=" + tipo + "precio1=" + precio1 + "stock=" + stock + '}';
    }

}
