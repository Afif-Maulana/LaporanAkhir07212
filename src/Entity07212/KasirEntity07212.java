package Entity07212;

public class KasirEntity07212 extends KekkiKukkiAbstractEntity07212{
    private String toko;
    public KasirEntity07212(String nama,String password,String toko) {
        super (nama,password);
        this.toko = toko;
    }
    @Override
    public String getNama(){
         return nama;
     }
    public String getToko(){
        return this.toko;
    }
    public void setToko(String toko) {
        this.toko = toko;
    }
}
