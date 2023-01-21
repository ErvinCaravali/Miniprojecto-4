/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.CompraVisual;
import Vista.VentaVisual;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ervin
 */
public class Compra {

    private String cedula, nombre, tipo, ghg;
    private String precio1;
    private int stock;
    private CompraVisual compra;
    private Proveedor proveedor;
    private Productos producto;

    private String productos[];

    private double precios[];

    public Compra(String cedula, String nombre, String precio1, int stock, String tipo, CompraVisual compra, Proveedor proveedor) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.precio1 = precio1;
        this.stock = stock;
        this.compra = compra;
        this.proveedor = proveedor;

        this.tipo = tipo;

    }
    
    public Compra(String cedula, String nombre, String precio1, int stock, String tipo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.precio1 = precio1;
        this.stock = stock;
        this.tipo = tipo;

    }

    public Compra() {

    }

    public Productos getProducto() {
        
        return producto;

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
        producto = new Productos();
        String productos[] = new String[producto.RecuperarNombreProductos().size()];
        for (int i = 0; i < producto.RecuperarNombreProductos().size(); i++) {
            productos[i] = getProducto().RecuperarNombreProductos().get(i).getNombre();
        }

        return productos;
    }

    public void AgregarVentas() {
         precios= getPrecios();
        String codigo = compra.getCodigo1().getText();
        String nombre = compra.getNombre1().getText();
        double precio = precios[compra.getCombo1().getSelectedIndex()];
        int stock1 = Integer.parseInt(compra.getStock1().getValue().toString());
        compra.getPrecio1().setText(Moneda(precio * stock1));
        String precioi = compra.getPrecio1().getText();
        String tipo = compra.getCombo1().getSelectedItem().toString();
        ArrayList<Compra> pra = new ArrayList<Compra>();

        Compra cli = new Compra(codigo, nombre, precioi, stock1, tipo, compra, proveedor);
        pra.add(cli);
        for (int i = 0; i < pra.size(); i++) {
            compra.getModelo().addRow(new Object[]{
                pra.get(i).getCodigo(),
                pra.get(i).getNombre(),
                pra.get(i).getPrecio(),
                pra.get(i).getStock(),
                pra.get(i).getTipo(),});
        }

    }

    public void GuardarDatosVentas() {

        FileWriter flwriter = null;

        try {

            flwriter = new FileWriter("src/ArchivosTexto/compras.txt", true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);

            String codigo = compra.getCodigo1().getText();
            String nombre = compra.getNombre1().getText();
            double precio = precios[compra.getCombo1().getSelectedIndex()];
            int stock1 = Integer.parseInt(compra.getStock1().getValue().toString());
            compra.getPrecio1().setText(Moneda(precio * stock1));
            String precioi = compra.getPrecio1().getText();
            String tipo = compra.getCombo1().getSelectedItem().toString();
            ArrayList<Compra> pra = new ArrayList<Compra>();

            Compra cli = new Compra(codigo, nombre, precioi, stock1, tipo, compra, proveedor);
            pra.add(cli);

            for (int i = 0; i < pra.size(); i++) {
                bfwriter.write(
                        pra.get(i).getCodigo() + ";"
                        + pra.get(i).getNombre() + ";"
                        + pra.get(i).getPrecio() + ";"
                        + pra.get(i).getStock() + ";"
                        + pra.get(i).getTipo() + ";" + "\n");
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

    public ArrayList<Compra> RecuperarVentas() {
        ArrayList<Compra> enta = new ArrayList<>();

        File file = new File("src/ArchivosTexto/compras.txt");
        enta = new ArrayList<Compra>();
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
                Compra e = new Compra(cedula, nombre1, precio1, stock, tipo, compra, proveedor);
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

        for (int i = 0; i < proveedor.RecuperarProveedores().size(); i++) {
            if (proveedor.RecuperarProveedores().get(i).getCodigo().equals(compra.getCodigo1().getText())) {
                System.out.println("El Proveedor esta en la base de datos ");

                GuardarDatosVentas();
            } else {
                System.out.println("El Proveedor no esta en la base de datos");
            }

        }

    }

    /////////////////////
    public void ActualizarVentas() {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            Compra[] a = GuardarAfiliados();
            ArrayList<Compra> sublist = new ArrayList<>(Arrays.asList(a));
            fw = new FileWriter("src/ArchivosTexto/compras.txt", true);
            bw = new BufferedWriter(fw);

            for (Compra enta : sublist) {

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

    public Compra[] GuardarAfiliados() throws IOException {
        FileReader fr = new FileReader("src/ArchivosTexto/compras.txt");
        BufferedReader br = new BufferedReader(fr);
        //ArrayList<Afiliados1>a;
        Compra[] a = new Compra[TotalAfiliados(br)];
        fr = new FileReader("src/ArchivosTexto/compras.txt");
        br = new BufferedReader(fr);

        int poselemento = 0;
        String dAfiliado;
        String cedulaAfiliado = JOptionPane.showInputDialog("Ingrese el codigo del proveedor a Editar");
        while (((dAfiliado = br.readLine()) != null)) {

            if (dAfiliado.split(";")[0].equalsIgnoreCase(cedulaAfiliado)) {
                String cedula = JOptionPane.showInputDialog("Ingrese en  nuevo codigo");
                String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
                String precio = JOptionPane.showInputDialog("Ingrese el nuevo precio");

                int stock = 0;
                //int stock1= Integer.parseInt(stock);
                stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad"));
                String tipo = (String) JOptionPane.showInputDialog(null, "Ingrese el nueevo tipo de producto", "Elegir", JOptionPane.QUESTION_MESSAGE, null, productos, productos[0]);

                a[poselemento] = new Compra(cedula, nombre, precio, stock, tipo, compra, proveedor);

            } else {

                a[poselemento] = new Compra(dAfiliado.split(";")[0],
                        dAfiliado.split(";")[1], dAfiliado.split(";")[2], dAfiliado.split(";")[3].charAt(stock), dAfiliado.split(";")[4]);

            }
            poselemento++;

        }

        new PrintWriter("src/ArchivosTexto/compras.txt").write("");
        new PrintWriter("src/ArchivosTexto/compras.txt").close();
        br.close();
        fr.close();
        return a;
    }

    public void EliminaVentas() {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            Compra[] a = EliminarVentas1();
            ArrayList<Compra> sublist = new ArrayList<Compra>(Arrays.asList(a));
            fw = new FileWriter("src/ArchivosTexto/compras.txt", true);
            bw = new BufferedWriter(fw);

            for (Compra enta : sublist) {
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

    public Compra[] EliminarVentas1() throws IOException {
        FileReader fr = new FileReader("src/ArchivosTexto/compras.txt");
        BufferedReader br = new BufferedReader(fr);
        Compra[] a = new Compra[TotalAfiliados(br)];
        fr = new FileReader("src/ArchivosTexto/compras.txt");
        br = new BufferedReader(fr);

        int poselemento = 0;
        String dAfiliado;
        String cedulaAfiliado = JOptionPane.showInputDialog("Ingrese el codigo del Proveedor a Editar");
        while (((dAfiliado = br.readLine()) != null)) {

            if (dAfiliado.split(";")[0].equalsIgnoreCase(cedulaAfiliado)) {
                continue;

            } else {

                a[poselemento] = new Compra(dAfiliado.split(";")[0],
                        dAfiliado.split(";")[1], dAfiliado.split(";")[2], dAfiliado.split(";")[3].charAt(stock), dAfiliado.split(";")[4]);
            }
            poselemento++;

        }

        new PrintWriter("src/ArchivosTexto/compras.txt").write("");
        new PrintWriter("src/ArchivosTexto/compras.txt").close();
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
