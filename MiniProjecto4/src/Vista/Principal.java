package  Vista;

import javax.swing.*;
import java.awt.*;

public class Principal extends JFrame {
    private JPanel  menu;
    private  JLabel afiliados0,serviciosSalud0 ,consultorios0, citas0,pruductos1;
    private  JButton  consultorios,serviciosSalud,afiliados,citas,productos;

    public JButton getConsultorios() {
        return consultorios;
    }

  

    public JButton getServiciosSalud() {
        return serviciosSalud;
    }


   

    public JButton getAfiliados() {
        return afiliados;
    }

 

    public JButton getCitas() {
        return citas;
    }

    public JButton getProductos() {
        return productos;
    }

  
    private void initGUI() {
        menu  = new JPanel(new FlowLayout());


        menu.setBackground(Color.getHSBColor(178,57,100));
        
        pruductos1 = new JLabel("Productos:");
        productos = new JButton();
        Image img0= new ImageIcon(getClass().getResource("/Sources/producto.png")).getImage();
        ImageIcon imgz=new ImageIcon(img0.getScaledInstance(45, 40, Image.SCALE_SMOOTH));
        productos.setIcon(imgz);
        menu.add( pruductos1);
        menu.add(productos);
        
        afiliados0 = new JLabel("Proveedores:");
        afiliados = new JButton();
        Image img= new ImageIcon(getClass().getResource("/Sources/proveedores.png")).getImage();
        ImageIcon imga=new ImageIcon(img.getScaledInstance(45, 40, Image.SCALE_SMOOTH));
        afiliados.setIcon(imga);
        menu.add(afiliados0);
        menu.add(afiliados);

        

        serviciosSalud = new JButton();
        serviciosSalud0 = new JLabel("Clientes:");
        Image img2= new ImageIcon(getClass().getResource("/Sources/cliente.png")).getImage();
        ImageIcon imgc=new ImageIcon(img2.getScaledInstance(45, 40, Image.SCALE_SMOOTH));
        serviciosSalud.setIcon(imgc);
        menu.add(serviciosSalud0);
        menu.add(serviciosSalud);


        consultorios = new JButton();
        consultorios0 = new JLabel("Compra de productos:");
        Image img3= new ImageIcon(getClass().getResource("/Sources/compras.png")).getImage();
        ImageIcon imgd=new ImageIcon(img3.getScaledInstance(45, 40, Image.SCALE_SMOOTH));
        consultorios.setIcon(imgd);
        menu.add(consultorios0);
        menu.add(consultorios);

        citas = new JButton();
        citas0 = new JLabel("Venta de productos:");
        Image img4= new ImageIcon(getClass().getResource("/Sources/ventas.png")).getImage();
        ImageIcon imge=new ImageIcon(img4.getScaledInstance(45, 40, Image.SCALE_SMOOTH));
        citas.setIcon(imge);
        menu.add(citas0);
        menu.add(citas);
        add(menu,BorderLayout.NORTH);

    }
    panelImage panel = new panelImage();


    public Principal() {
        initGUI();
        this.setTitle("Supermercado UNIVALLE");
        this.setSize(1200,600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.add(panel, BorderLayout.CENTER);
    }

    public class panelImage extends JPanel{

        @Override
        public void paint(Graphics g){
            Dimension dimension = this.getSize();
            ImageIcon icon = new ImageIcon(getClass().getResource("/Sources/supermercado.jpg"));
            g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
            setOpaque(false);
            super.paintChildren(g);

        }


    }


}

