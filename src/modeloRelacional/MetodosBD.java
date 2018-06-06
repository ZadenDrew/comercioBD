package modeloRelacional;

import comerciobd.Ticket;
import comerciobd.Ventas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.activation.DataSource;
import javax.swing.JOptionPane;

/**
 *
 * @author acabezaslopez
 */
public class MetodosBD {

    public DataSource dataSource;
    public String db = "comercio.db";
    public String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/acabezaslopez/NetBeansProjects/comercioBD/" + db;
//    public String user = "AndreaBase";
//    public String pass = "012345C";
    public Connection conectar;
    public PreparedStatement stmt;
    public ArrayList<Ventas> listaVentas = new ArrayList();

    public MetodosBD() {
    }

    public void connect() {

        try {

            Class.forName("org.sqlite.JDBC");

            conectar = DriverManager.getConnection("jdbc:sqlite:/home/local/DANIELCASTELAO/acabezaslopez/NetBeansProjects/comercioBD/comercio.db");

            if (conectar != null) {
                System.out.println("Conectado.");
            }
        } catch (SQLException exsq) {
            System.out.println("Error: " + exsq);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error : " + ex);
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex);

        }

    }

    public void disconnect() {
        try {

            if (stmt != null) {
                stmt.closeOnCompletion();

            }
            if (conectar != null) {

                conectar.close();
            }

            System.out.println("Conexión cerrada.");

        } catch (SQLException ex) {
            System.out.println("Error:" + ex);
        }
    }

    public void insert(Ventas v) {
        connect();

        try {

            PreparedStatement st = conectar.prepareStatement("insert into Ticket values (?,?,?,?,?)");
            st.setInt(1, v.getNv());
            st.setString(2, v.getRefproducto());
            st.setFloat(3, v.getCantidade());
            st.execute();
            conectar.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ese codigo ya esta repetido");
        }
        disconnect();
        this.mostrarJuegos();
    }

    public ArrayList mostrarJuegos() {
        listaVentas = new ArrayList();
        connect();
        ResultSet result;
        try {

            PreparedStatement st = conectar.prepareStatement("SELECT * FROM Ticket");

            result = st.executeQuery();

            while (result.next()) {
                Ventas v = new Ventas(result.getInt("nv"), result.getString("refproducto"),
                        result.getInt("cantidad"));
                listaVentas.add(v);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        disconnect();

        return listaVentas;

    }

    public void modify(String codigo) {
        connect();
        try {

            String nombre = JOptionPane.showInputDialog("dame la refproducto:");
            String consola = JOptionPane.showInputDialog("dame la cantidad:");
          
            stmt = conectar.prepareStatement("UPDATE Ventas set refproducto = '" + refproducto +  "',unidades = '" + unidades + "' where codigo='" + codigo + "';");
            stmt.executeUpdate();

            System.out.println("La fila ha sido modificada con éxito.");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        disconnect();
    }

    public void venta(String codigo, int unidades) {
        connect();
        try {
            stmt = conectar.prepareStatement("UPDATE Ventas set unidades = '" + unidades + "' where codigo='" + codigo + "';");
            stmt.executeUpdate();
            //link.commit();

            System.out.println("La venta ha sido realizada con éxito.");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        disconnect();
    }

    public void delete(int nv) {
        connect();

        try {

            Statement st = conectar.createStatement();

            String delete = "DELETE from Ventas where nv='" + nv + "';";
            st.executeUpdate(delete);
            conectar.commit();

            System.out.println("Filas borradas con éxito.");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        disconnect();
    }

    public Ventas buscar(int n, int op) {

        connect();
        ResultSet result;
        String busca = null;
        Ventas v = null;
        try {

            Statement st = conectar.createStatement();
            if (op == 1) {
                busca = "SELECT * from Ventas where nv='" + n + "';";
            }

            if (op == 2) {
                busca = "SELECT * from Ventas where refproducto='" + n + "';";
            }

            result = st.executeQuery(busca);
            while (result.next()) {
                v = new Ventas(result.getInt("nv"), result.getString("refproducto"),
                        result.getFloat("cantidad"));
                conectar.commit();

                System.out.println("Filas encontrada con éxito.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Seleccione una venta en la tabla a mostrar .");
        }

        disconnect();
        return v;
    }

}
