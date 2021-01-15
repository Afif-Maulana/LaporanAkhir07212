package Entity07212;

public class PembeliEntity07212 extends KekkiKukkiAbstractEntity07212{
    
    public PembeliEntity07212(String nama,String password){
        super (nama,password);
    }
    @Override
     public String getNama(){
         return nama;
     }
}
