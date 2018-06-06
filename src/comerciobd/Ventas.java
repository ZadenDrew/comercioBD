package comerciobd;

/**
 *
 * @author acabezaslopez
 */
public class Ventas {

    private int nv;
    private String refproducto;
    private float cantidade;

    public Ventas() {
    }

    public Ventas(int nv, String refproducto, float cantidade) {
        this.nv = nv;
        this.refproducto = refproducto;
        this.cantidade = cantidade;
    }

    public int getNv() {
        return nv;
    }

    public void setNv(int nv) {
        this.nv = nv;
    }


    public String getRefproducto() {
        return refproducto;
    }

    public void setRefproducto(String refproducto) {
        this.refproducto = refproducto;
    }

    public float getCantidade() {
        return cantidade;
    }

    public void setCantidade(float cantidade) {
        this.cantidade = cantidade;
    }

    @Override
    public String toString() {
        return (nv +"\t"+ refproducto+ "\t"+ cantidade +"\n");
    }

}
