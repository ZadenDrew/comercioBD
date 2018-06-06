package comerciobd;

/**
 *
 * @author acabezaslopez
 */
public class Ticket {

    private int[] nv = {1, 2, 3};
    private String[] nome = {"uvas", "peras", "patacas"};
    private float[] prezoTotal;

    public Ticket() {
    }

    public Ticket(float[] prezoTotal) {
        this.prezoTotal = prezoTotal;
    }

    public int[] getNv() {
        return nv;
    }

    public void setNv(int[] nv) {
        this.nv = nv;
    }

    public String[] getNome() {
        return nome;
    }

    public void setNome(String[] nome) {
        this.nome = nome;
    }

    public float[] getPrezoTotal() {
        return prezoTotal;
    }

    public void setPrezoTotal(float[] prezoTotal) {
        this.prezoTotal = prezoTotal;
    }
    public void calcularTotal(){
    
        
    }
}
