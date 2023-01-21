/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.ClienteVisual;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Boolean.parseBoolean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author ervin
 */
public class Cliente {

    private String nombre, apellido;
    private String cedula;
    private ClienteVisual cliente;

    public Cliente(String nombre, String apellido, String cedula, ClienteVisual cliente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.cliente = cliente;
    }

    public Cliente(String nombre, String apellido, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void Buscar() {
        String dato = cliente.getBuscar1().getText();
        if (dato.isEmpty()) {
            cliente.getTabla().clearSelection();
        } else {
            for (int i = 0; i < cliente.getTabla().getRowCount(); i++) {

                if (cliente.getTabla().getValueAt(i, 2).equals(dato)) {
                    cliente.getTabla().changeSelection(i, 2, false, false);
                    cliente.getModelo().isCellEditable(i, 2);

                }
            }
        }
    }

    public void AgregarClientes() {
        String nombre = cliente.getNombreuno().getText();
        String apellido = cliente.getApellidouno().getText();
        String cedula = (cliente.getId().getText());
        ArrayList<Cliente> cliente1 = new ArrayList<Cliente>();
        Cliente cli = new Cliente(nombre, apellido, cedula, cliente);
        cliente1.add(cli);

        for (int i = 0; i < cliente1.size(); i++) {

            cliente.getModelo().addRow(new Object[]{
                cliente1.get(i).getNombre(),
                cliente1.get(i).getApellido(),
                cliente1.get(i).getCedula(),});
        }

    }

    public void GuardarDatosClientes() {

        FileWriter flwriter = null;

        try {

            flwriter = new FileWriter("src/ArchivosTexto/clientes.txt", true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);

            String nombre = cliente.getNombreuno().getText();
            String apellido = cliente.getApellidouno().getText();
            String cedula = (cliente.getId().getText());
            ArrayList<Cliente> cliente1 = new ArrayList<Cliente>();
            Cliente cli = new Cliente(nombre, apellido, cedula, cliente);
            cliente1.add(cli);

            for (int i = 0; i < cliente1.size(); i++) {

                bfwriter.write(
                        cliente1.get(i).getNombre() + ";"
                        + cliente1.get(i).getApellido() + ";"
                        + cliente1.get(i).getCedula() + ";" + "\n");
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

    public ArrayList<Cliente> RecuperarClientes() {
        ArrayList<Cliente> cliente1 = new ArrayList<Cliente>();

        File file = new File("src/ArchivosTexto/clientes.txt");
        cliente1 = new ArrayList<Cliente>();
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
                delimitar.useDelimiter("\\s*;\\s*");
                String nombre = "";
                String apellido = "";
                String cedula = "";
                Cliente e = new Cliente(nombre, apellido, cedula, cliente);
                e.setNombre(delimitar.next());
                e.setApellido(delimitar.next());
                e.setCedula(delimitar.next());

                cliente1.add(e);

            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return cliente1;
    }

    public void ActualizarClientes() {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            Cliente[] a = GuardarAfiliados();
            ArrayList<Cliente> sublist = new ArrayList<Cliente>(Arrays.asList(a));
            fw = new FileWriter("src/ArchivosTexto/clientes.txt", true);
            bw = new BufferedWriter(fw);

            for (Cliente cliente : sublist) {

                bw.write(cliente.getNombre() + ";" + cliente.getApellido() + ";" + cliente.getCedula() + ";" + "\n");
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

    public Cliente[] GuardarAfiliados() throws IOException {
        FileReader fr = new FileReader("src/ArchivosTexto/clientes.txt");
        BufferedReader br = new BufferedReader(fr);
        //ArrayList<Afiliados1>a;
        Cliente[] a = new Cliente[TotalAfiliados(br)];
        fr = new FileReader("src/ArchivosTexto/clientes.txt");
        br = new BufferedReader(fr);

        int poselemento = 0;
        String dAfiliado;
        String cedulaAfiliado = JOptionPane.showInputDialog("Ingrese la cedula del cliente a Editar");
        while (((dAfiliado = br.readLine()) != null)) {

            if (dAfiliado.split(";")[2].equalsIgnoreCase(cedulaAfiliado)) {
                String Nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del Afiliado");
                String Apellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido del Afiliado");
                String cedula = JOptionPane.showInputDialog("Ingrese la nueva cedula  del Afiliado");
                a[poselemento] = new Cliente(Nombre, Apellido, cedula, cliente);
            } else {

                a[poselemento] = new Cliente(dAfiliado.split(";")[0],
                        dAfiliado.split(";")[1], dAfiliado.split(";")[2]);

            }
            poselemento++;

        }

        new PrintWriter("src/ArchivosTexto/clientes.txt").write("");
        new PrintWriter("src/ArchivosTexto/clientes.txt").close();
        br.close();
        fr.close();
        return a;
    }

    ///
    public void EliminarClientes() {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            Cliente[] a = EliminarClientes1();
            ArrayList<Cliente> sublist = new ArrayList<Cliente>(Arrays.asList(a));
            fw = new FileWriter("src/ArchivosTexto/clientes.txt", true);
            bw = new BufferedWriter(fw);

            for (Cliente cliente : sublist) {
                if (cliente != null) {
                    bw.write(cliente.getNombre() + ";" + cliente.getApellido() + ";" + cliente.getCedula() + ";" + "\n");
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

    public Cliente[] EliminarClientes1() throws IOException {
        FileReader fr = new FileReader("src/ArchivosTexto/clientes.txt");
        BufferedReader br = new BufferedReader(fr);
        //ArrayList<Afiliados1>a;
        Cliente[] a = new Cliente[TotalAfiliados(br)];
        fr = new FileReader("src/ArchivosTexto/clientes.txt");
        br = new BufferedReader(fr);

        int poselemento = 0;
        String dAfiliado;
        String cedulaAfiliado = JOptionPane.showInputDialog("Ingrese la cedula del Cliente a Editar");
        while (((dAfiliado = br.readLine()) != null)) {

            if (dAfiliado.split(";")[2].equalsIgnoreCase(cedulaAfiliado)) {
                continue;

            } else {

                a[poselemento] = new Cliente(dAfiliado.split(";")[0],
                        dAfiliado.split(";")[1], dAfiliado.split(";")[2]);
            }
            poselemento++;

        }

        new PrintWriter("src/ArchivosTexto/clientes.txt").write("");
        new PrintWriter("src/ArchivosTexto/clientes.txt").close();
        br.close();
        fr.close();
        return a;
    }

    public void Comparar() {

        boolean bandera = false;

        for (int i = 0; i < RecuperarClientes().size(); i++) {
            if (RecuperarClientes().get(i).getCedula().equals(cliente.getId().getText())) {
                bandera = true;
            JOptionPane.showMessageDialog(null, "El Cliente esta en la base de datos ");
            }
        }
        if (bandera == false) {
            AgregarClientes();
            GuardarDatosClientes();
        }
    }
    
  

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + "apellido=" + apellido + "cedula=" + cedula + '}';
    }

}
