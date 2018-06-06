package comerciobd;

import javax.swing.JOptionPane;

/**
 *
 * @author acabezaslopez
 */
public class Metodos {

    Ventas[] listaVentas = new Ventas[3];
    Producto[] listaProducto = new Producto[3];

    public Ventas[] creArrayVentas() {

        for (int i = 0; i < listaVentas.length; i++) {
            int insert1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce nv:"));
            String insert2 = JOptionPane.showInputDialog("Introduce refProducto:");
            float insert3 = Float.parseFloat(JOptionPane.showInputDialog("Introduce cantidade:"));
            listaVentas[i] = new Ventas(insert1, insert2, insert3);
        }
        return listaVentas;
    }

    public Producto[] creArrayProducto() {

        for (int i = 0; i < listaProducto.length; i++) {
            String insert1 = JOptionPane.showInputDialog("Introduce referencia del producto:");
            String insert2 = JOptionPane.showInputDialog("Introduce nome do producto:");
            String insert3 = JOptionPane.showInputDialog("Introduce referencia do prezo:");
            listaProducto[i] = new Producto(insert1, insert2, insert3);
        }
        return listaProducto;
    }

    public Ventas[] amosarVentas(Ventas[] listaVentas) {
        System.out.println("nv  refProducto  cantidade ");
        for (Ventas elemento : listaVentas) {
            System.out.println(elemento);
        }
        return listaVentas;
    }

    public Producto[] amosarProducto(Producto[] listaProducto) {
        System.out.println("Producto");
        for (Producto elemento : listaProducto) {
            System.out.println(elemento);
        }
        return listaProducto;
    }
}
