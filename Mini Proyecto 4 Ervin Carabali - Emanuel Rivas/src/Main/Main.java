/*
    Mini Proyecto 4
    Integrantes: Ervin Carabali 1925648-3743 Grupo 02
                 Emanuel Rivas 2127706-3743 Grupo 01
    Profesor: Luis Yovany Romo 
*/

package Main;

import Controlador.Controlador;
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
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        Principal mayor = new Principal();
        ClienteVisual client = new ClienteVisual();
        CompraVisual buyout = new CompraVisual();
        ProveedorVisual vendor = new ProveedorVisual();
        VentaVisual sale = new VentaVisual();
        ProductoVisual product= new ProductoVisual();

        String nombre = "";
        String apellido = "";
        String cedula = "";
        Cliente ente = new Cliente(nombre, apellido, cedula, client);
        String codigo1 = "";
        String rut = "";
        String telefono = "";
        String nombre2 = "";
        String direccion = "";
        String ciudad = "";
        String email = "";
        Proveedor edor = new Proveedor(codigo1, rut, telefono, nombre2, direccion, ciudad, email, vendor);
        String cedula1 = "";
        String nombre1 = "";
        String precio = "";
        int stock = 0;
        String tipo = "";
        Venta ale = new Venta(cedula1, nombre1, precio, stock, tipo, sale, ente);
        String nombre4 = "";
        String precio5 = "";
        int cantidad5 = 0;
        Productos ducto = new Productos( nombre4,  precio5, cantidad5,product);
        String cedula2 = "";
        String nombre3 = "";
        String precio2 = "";
        int stock2 = 0;
        String tipo2 = "";
        Compra out = new Compra(cedula2, nombre3, precio2, stock2, tipo2, buyout, edor);
        
        

       Controlador control = new Controlador(ente, edor, mayor, client, vendor, sale, buyout, ale, out,product,ducto);

    }

}
