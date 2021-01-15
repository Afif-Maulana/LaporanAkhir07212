package Model07212;
import Entity07212.KasirEntity07212;
import Entity07212.DaftarEntity07212;
import Entity07212.PembeliEntity07212;
import java.util.ArrayList;

public class PembeliModel07212 implements KekkiInterface07212 {
    
    private ArrayList<PembeliEntity07212> pembeliEntityArrayList;

    public PembeliModel07212() {
        pembeliEntityArrayList = new ArrayList<PembeliEntity07212>();
    }
    public void insertPembeli(PembeliEntity07212 pembeli) {
        pembeliEntityArrayList.add(pembeli);
    }
    @Override
    public int cekPesanan(String nama, String password) {
        int loop = 0;
        while (!pembeliEntityArrayList.get(loop).getNama().equals(nama)
                && !pembeliEntityArrayList.get(loop).getPassword().equals(password)) {
            loop++;
        }return loop;
    }
    public PembeliEntity07212 getPembeliEntity07212ArrayList(int index) {
        return pembeliEntityArrayList.get(index);
    }

    @Override
    public void view() {
        for (PembeliEntity07212 pembeliEntity : pembeliEntityArrayList) {
            System.out.println("==============================================");
            System.out.println("nama : "+ pembeliEntity.getNama()+ 
                                "\nPassword : "+ pembeliEntity.getPassword());
            System.out.println("==============================================");
        }
}
}
