package Entity07212;

public abstract class KekkiKukkiAbstractEntity07212 {
    protected String nama,password;
    
    public KekkiKukkiAbstractEntity07212(String nama,String password){
        this.nama = nama;
        this.password = password;
    }
    public KekkiKukkiAbstractEntity07212 (){
    }
    public abstract String getNama();
    
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
