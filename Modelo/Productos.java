/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.ProductoVisual;
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
import javax.swing.JOptionPane;

/**
 *
 * @author ervin
 */
public class Productos {

    private String nombre;
    private String precio;
    private int cantidad;
    
    private ProductoVisual ducto;

    public Productos() {
    }

    public Productos(String nombre, String precio, int cantidad, ProductoVisual ducto) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
       
        this.ducto = ducto;
    }

    public Productos(String nombre, String precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
  

    public void AgregarProductos() {
        String nombre = ducto.getNombreuno().getText();
        double precio = Double.parseDouble(ducto.getPrecioouno().getText());
        int cantidad = Integer.parseInt(ducto.getCantidaduno().getText());
        ducto.getPrecioouno().setText(String.valueOf((precio * cantidad)));
        String precioi = ducto.getPrecioouno().getText();
        ArrayList<Productos> producto = new ArrayList<Productos>();
        Productos cli = new Productos(nombre, precioi, cantidad, ducto);
        producto.add(cli);

        for (int i = 0; i < producto.size(); i++) {

            ducto.getModelo().addRow(new Object[]{
                producto.get(i).getNombre(),
                producto.get(i).getPrecio(),
                producto.get(i).getCantidad(),});
        }

    }

    public void GuardarDatosProductos() {

        FileWriter flwriter = null;

        try {

            flwriter = new FileWriter("src/ArchivosTexto/productos.txt", true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);

            String nombre = ducto.getNombreuno().getText();
            double precio = Double.parseDouble(ducto.getPrecioouno().getText());
            int cantidad = Integer.parseInt(ducto.getCantidaduno().getText());
           
            String precioi = ducto.getPrecioouno().getText();
             ducto.getPrecioouno().setText(String.valueOf((precio * cantidad)));
            ArrayList<Productos> producto = new ArrayList<Productos>();
            Productos cli = new Productos(nombre, precioi, cantidad, ducto);
            producto.add(cli);

            for (int i = 0; i < producto.size(); i++) {

                bfwriter.write(
                        producto.get(i).getNombre() + ";"
                        + producto.get(i).getPrecio() + ";"
                        + producto.get(i).getCantidad() + ";" + "\n");
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

    public ArrayList<Productos> RecuperarProductos() {
        ArrayList<Productos> producto = new ArrayList<Productos>();

        File file = new File("src/ArchivosTexto/productos.txt");
        producto= new ArrayList<Productos>();
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
                delimitar.useDelimiter("\\s*;\\s*");
                String nombre = "";
                String precio = "";
                int cantidad = 0;
                Productos e = new Productos(nombre, precio, cantidad, ducto);
                e.setNombre(delimitar.next());
                e.setPrecio(delimitar.next());
                e.setCantidad(delimitar.nextInt());
                producto.add(e);

            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return producto;
    }
    
    
     public void ActualizarProductos() {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            Productos[] a = GuardarAfiliados();
            ArrayList<Productos> sublist = new ArrayList<Productos>(Arrays.asList(a));
            fw = new FileWriter("src/ArchivosTexto/productos.txt", true);
            bw = new BufferedWriter(fw);

            for (Productos cliente : sublist) {

                bw.write(cliente.getNombre() + ";" + cliente.getPrecio() + ";" + cliente.getCantidad() + ";" + "\n");
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

    public Productos[] GuardarAfiliados() throws IOException {
        FileReader fr = new FileReader("src/ArchivosTexto/productos.txt");
        BufferedReader br = new BufferedReader(fr);
        Productos[] a = new Productos[TotalAfiliados(br)];
        fr = new FileReader("src/ArchivosTexto/productos.txt");
        br = new BufferedReader(fr);

        int poselemento = 0;
        String dAfiliado;
        String cedulaAfiliado = JOptionPane.showInputDialog("Ingrese El  Nombre del producto a Editar");
        while (((dAfiliado = br.readLine()) != null)) {

            if (dAfiliado.split(";")[0].equalsIgnoreCase(cedulaAfiliado)) {
                String Nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del producto");
                String Precio = JOptionPane.showInputDialog("Ingrese el nuevo precio del producto");
                int Cantidad =0;
                Cantidad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de poductos"));
                a[poselemento] = new Productos(Nombre, Precio, Cantidad);
                
                
            } else {

                a[poselemento] = new Productos(dAfiliado.split(";")[0],
                        dAfiliado.split(";")[1], dAfiliado.split(";")[2].charAt(cantidad));

            }
            poselemento++;

        }

        new PrintWriter("src/ArchivosTexto/productos.txt").write("");
        new PrintWriter("src/ArchivosTexto/productos.txt").close();
        br.close();
        fr.close();
        return a;
    }
    
    //////////
    public void EliminarProductos() {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            Productos[] a = EliminarClientes1();
            ArrayList<Productos> sublist = new ArrayList<Productos>(Arrays.asList(a));
            fw = new FileWriter("src/ArchivosTexto/productos.txt", true);
            bw = new BufferedWriter(fw);

            for (Productos cliente : sublist) {
                if (cliente != null) {
                    bw.write(cliente.getNombre() + ";" + cliente.getPrecio() + ";" + cliente.getCantidad() + ";" + "\n");
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

    public Productos[] EliminarClientes1() throws IOException {
        FileReader fr = new FileReader("src/ArchivosTexto/productos.txt");
        BufferedReader br = new BufferedReader(fr);
        Productos[] a = new Productos[TotalAfiliados(br)];
        fr = new FileReader("src/ArchivosTexto/productos.txt");
        br = new BufferedReader(fr);

        int poselemento = 0;
        String dAfiliado;
        String cedulaAfiliado = JOptionPane.showInputDialog("Ingrese el Nombre del Producto a Eliminar");
        while (((dAfiliado = br.readLine()) != null)) {

            if (dAfiliado.split(";")[0].equalsIgnoreCase(cedulaAfiliado)) {
                continue;

            } else {

                a[poselemento] = new Productos(dAfiliado.split(";")[0],
                        dAfiliado.split(";")[1], dAfiliado.split(";")[2].charAt(cantidad));
            }
            poselemento++;

        }

        new PrintWriter("src/ArchivosTexto/productos.txt").write("");
        new PrintWriter("src/ArchivosTexto/productos.txt").close();
        br.close();
        fr.close();
        return a;
    }
    
    
      public ArrayList<Productos>RecuperarNombreProductos(){
           ArrayList<Productos> producto = new ArrayList<Productos>();
          
          producto= RecuperarProductos();
          for (int i = 0; i < producto.size(); i++) {
              producto.get(i).getNombre();
        
          }
          
          
          return  producto;
      }
      
      public ArrayList<Productos>RecuperarPreciosProductos(){
           ArrayList<Productos> precios = new ArrayList<Productos>();
          
          precios= RecuperarProductos();
          for (int i = 0; i < precios.size(); i++) {
             precios.get(i).getPrecio();
      
          }
          
          
          return  precios;
      }

    public boolean vendido(int numero) {
        if (numero <= cantidad) {
            numero -= cantidad;

        } else {
            System.out.println("No hay suficientes unidades");
            return false;
        }
        return true;
    }

    public double Moneda(double precio) {
        return  Math.round(precio * 100) / 100 ;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Productos{" + "nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }

}
