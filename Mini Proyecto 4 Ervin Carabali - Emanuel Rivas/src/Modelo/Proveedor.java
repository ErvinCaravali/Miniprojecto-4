/*
    Mini Proyecto 4
    Integrantes: Ervin Carabali 1925648-3743 Grupo 02
                 Emanuel Rivas 2127706-3743 Grupo 01
    Profesor: Luis Yovany Romo 
*/


package Modelo;

import Vista.ProveedorVisual;
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
public class Proveedor {

    private String codigo, rut, telefono;
    private String nombre, direccion, ciudad, email;
    private ProveedorVisual proveedor;

    public Proveedor(String codigo, String rut, String nombre, String direccion, String ciudad, String telefono, String email, ProveedorVisual proveedor) {
        this.codigo = codigo;
        this.rut = rut;
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.email = email;
        this.proveedor = proveedor;
    }

    public Proveedor(String codigo, String rut, String nombre, String direccion, String ciudad, String telefono, String email) {
        this.codigo = codigo;
        this.rut = rut;
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    ///
    public void Buscar() {

        String dato = proveedor.getSearch().getText();
        if (dato.isEmpty()) {
            proveedor.getTabla().clearSelection();
        } else {
            for (int i = 0; i < proveedor.getTabla().getRowCount(); i++) {

                if (proveedor.getTabla().getValueAt(i, 1).equals(dato)) {
                    proveedor.getTabla().changeSelection(i, 1, false, false);
                    proveedor.getModelo().isCellEditable(i, 1);

                }
            }
        }
    }

    public void AgregarProveedores() {
        String codigo = (proveedor.getCodigo1().getText());
        String rut = (proveedor.getRuc1().getText());
        String nombre = proveedor.getNombre1().getText();
        String direccion = proveedor.getDireccion1().getText();
        String ciudad = proveedor.getCiudad1().getText();
        String telefono = (proveedor.getTelefono1().getText());
        String email = proveedor.getEmail1().getText();

        ArrayList<Proveedor> proveedor1 = new ArrayList<Proveedor>();
        Proveedor pro = new Proveedor(codigo, rut, nombre, direccion, ciudad, telefono, email, proveedor);
        proveedor1.add(pro);

        for (int i = 0; i < proveedor1.size(); i++) {
            proveedor.getModelo().addRow(new Object[]{
                proveedor1.get(i).getCodigo(),
                proveedor1.get(i).getRut(),
                proveedor1.get(i).getNombre(),
                proveedor1.get(i).getDireccion(),
                proveedor1.get(i).getCiudad(),
                proveedor1.get(i).getTelefono(),
                proveedor1.get(i).getEmail(),});
        }
    }

    public void GuardarDatosProveedores() {

        FileWriter flwriter = null;

        try {

            flwriter = new FileWriter("src/ArchivosTexto/proveedor.txt", true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            String codigo = (proveedor.getCodigo1().getText());
            String rut = (proveedor.getRuc1().getText());
            String nombre = proveedor.getNombre1().getText();
            String direccion = proveedor.getDireccion1().getText();
            String ciudad = proveedor.getCiudad1().getText();
            String telefono = (proveedor.getTelefono1().getText());
            String email = proveedor.getEmail1().getText();
            ArrayList<Proveedor> proveedor1 = new ArrayList<Proveedor>();
            Proveedor pro = new Proveedor(codigo, rut, nombre, direccion, ciudad, telefono, email, proveedor);
            proveedor1.add(pro);

            for (int i = 0; i < proveedor1.size(); i++) {
                bfwriter.write(
                        proveedor1.get(i).getCodigo() + ";"
                        + proveedor1.get(i).getRut() + ";"
                        + proveedor1.get(i).getNombre() + ";"
                        + proveedor1.get(i).getDireccion() + ";"
                        + proveedor1.get(i).getCiudad() + ";"
                        + proveedor1.get(i).getTelefono() + ";"
                        + proveedor1.get(i).getEmail() + ";" + "\n");
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

    public ArrayList<Proveedor> RecuperarProveedores() {
        ArrayList<Proveedor> proveedor1 = new ArrayList<Proveedor>();

        File file = new File("src/ArchivosTexto/proveedor.txt");
        proveedor1 = new ArrayList<Proveedor>();
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
                delimitar.useDelimiter("\\s*;\\s*");
                String nombre = "";
                String direccion = "";
                String ciudad = "";
                String email = "";
                String codigo = "";
                String rut = "";
                String telefono = "";

                Proveedor e = new Proveedor(codigo, rut, nombre, direccion, ciudad, telefono, email, proveedor);
                e.setCodigo(delimitar.next());
                e.setRut(delimitar.next());
                e.setNombre(delimitar.next());
                e.setDireccion(delimitar.next());
                e.setCiudad(delimitar.next());
                e.setTelefono(delimitar.next());
                e.setEmail(delimitar.next());
                proveedor1.add(e);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return proveedor1;
    }

    public void ActualizarProveedores() {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            Proveedor[] a = GuardarAfiliados();
            ArrayList<Proveedor> sublist = new ArrayList<Proveedor>(Arrays.asList(a));
            fw = new FileWriter("src/ArchivosTexto/proveedor.txt", true);
            bw = new BufferedWriter(fw);

            for (Proveedor proveedor : sublist) {

                bw.write(proveedor.getCodigo() + ";" + proveedor.getRut() + ";" + proveedor.getNombre() + ";" + proveedor.getDireccion() + ";"
                        + proveedor.getCiudad() + ";" + proveedor.getTelefono() + ";" + proveedor.getEmail() + ";" + "\n");
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

    public Proveedor[] GuardarAfiliados() throws IOException {
        FileReader fr = new FileReader("src/ArchivosTexto/proveedor.txt");
        BufferedReader br = new BufferedReader(fr);
        //ArrayList<Afiliados1>a;
        Proveedor[] a = new Proveedor[TotalAfiliados(br)];
        fr = new FileReader("src/ArchivosTexto/proveedor.txt");
        br = new BufferedReader(fr);

        int poselemento = 0;
        String dAfiliado;
        String cedulaAfiliado = JOptionPane.showInputDialog("Ingrese el codigo del proveedor");
        while (((dAfiliado = br.readLine()) != null)) {

            if (dAfiliado.split("\\s*;\\s*")[0].equalsIgnoreCase(cedulaAfiliado)) {
                String codigo = JOptionPane.showInputDialog("Ingrese el nuevo  codigo del proveedor");
                String rut = JOptionPane.showInputDialog("Ingrese el nuevo  RUT del proveedor");
                String nombre = JOptionPane.showInputDialog("Ingrese el nuevo  Nombre del proveedor");
                String direccion = JOptionPane.showInputDialog("Ingrese la nueva  Direccion del proveedor");
                String ciudad = JOptionPane.showInputDialog("Ingrese la nueva  Ciudad del proveedor");
                String telefono = JOptionPane.showInputDialog("Ingrese el nuevo  Telefono del proveedor");
                String email = JOptionPane.showInputDialog("Ingrese el nuevo  Email del proveedor");

                a[poselemento] = new Proveedor(codigo, rut, nombre, direccion, ciudad, telefono, email, proveedor);
            } else {
                a[poselemento] = new Proveedor(dAfiliado.split("\\s*;\\s*")[0],
                        dAfiliado.split("\\s*;\\s*")[1], dAfiliado.split("\\s*;\\s*")[2], dAfiliado.split("\\s*;\\s*")[3],
                        dAfiliado.split("\\s*;\\s*")[4], dAfiliado.split("\\s*;\\s*")[5],
                        dAfiliado.split("\\s*;\\s*")[6]);

            }
            poselemento++;

        }

        new PrintWriter("src/ArchivosTexto/proveedor.txt").write("");
        new PrintWriter("src/ArchivosTexto/proveedor.txt").close();
        br.close();
        fr.close();
        return a;
    }

    ///
    public void EliminarProveedores() {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            Proveedor[] a = EliminarProveedores1();
            ArrayList<Proveedor> sublist = new ArrayList<Proveedor>(Arrays.asList(a));
            fw = new FileWriter("src/ArchivosTexto/proveedor.txt", true);
            bw = new BufferedWriter(fw);

            for (Proveedor proveedor : sublist) {
                if (proveedor != null) {
                    bw.write(proveedor.getCodigo() + ";" + proveedor.getRut() + ";" + proveedor.getNombre() + ";" + proveedor.getDireccion() + ";"
                            + proveedor.getCiudad() + ";" + proveedor.getTelefono() + ";" + proveedor.getEmail() + ";" + "\n");
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

    public Proveedor[] EliminarProveedores1() throws IOException {
        FileReader fr = new FileReader("src/ArchivosTexto/proveedor.txt");
        BufferedReader br = new BufferedReader(fr);
        Proveedor[] a = new Proveedor[TotalAfiliados(br)];
        fr = new FileReader("src/ArchivosTexto/proveedor.txt");
        br = new BufferedReader(fr);

        int poselemento = 0;
        String dAfiliado;
        String cedulaAfiliado = JOptionPane.showInputDialog("Ingrese el codigo del Proveedor a Editar");
        while (((dAfiliado = br.readLine()) != null)) {

            if (dAfiliado.split(";")[0].equalsIgnoreCase(cedulaAfiliado)) {
                continue;

            } else {

                a[poselemento] = new Proveedor(dAfiliado.split(";")[0],
                        dAfiliado.split(";")[1], dAfiliado.split(";")[2], dAfiliado.split(";")[3],
                        dAfiliado.split(";")[4], dAfiliado.split(";")[5],
                        dAfiliado.split(";")[6]);
            }
            poselemento++;

        }

        new PrintWriter("src/ArchivosTexto/proveedor.txt").write("");
        new PrintWriter("src/ArchivosTexto/proveedor.txt").close();
        br.close();
        fr.close();
        return a;
    }

    public void Comparar() {
        boolean bandera = false;
        for (int i = 0; i < RecuperarProveedores().size(); i++) {
            if (RecuperarProveedores().get(i).codigo.equals(proveedor.getCodigo1().getText())) {
                bandera = true;

                JOptionPane.showMessageDialog(null, "El Proveedor esta en la base de datos ");

            }

        }
        if (bandera == false) {
            AgregarProveedores();
            GuardarDatosProveedores();
        }

    }

    @Override
    public String toString() {
        return "Proveedor{" + "codigo=" + codigo + ", rut=" + rut + ", telefono=" + telefono + ", nombre=" + nombre + ", direccion=" + direccion + ", ciudad=" + ciudad + ", email=" + email + '}';
    }

}
