package Controller07212;

import Entity07212.KasirEntity07212;
import Entity07212.DaftarEntity07212;
import Entity07212.PembeliEntity07212;
import java.util.ArrayList;

public class KasirController07212 implements ControllerInterface07212 {
    int indexLogin = 0;
    public KasirController07212() {
    }
    
    public void dataKasir() {
        String nama[] = {"Annisa","Arifah"};
        String password[] = {"kekki","kukki"};
        String toko[] = {"Toko Kue 1","toko baju 2","toko baju 3"};
        
        for (int i=0; i<nama.length;i++) {
            AllObjectModel07212.kasir.insertKasir(new KasirEntity07212(nama[i], password[i], toko[i]));
        }
    }
    public void view() {
        AllObjectModel07212.kasir.view();
    }
    
    public void listPembeliKue() {
        AllObjectModel07212.daftar.view();
    }
    
    @Override
    public void login(String nama, String password) {
        indexLogin = AllObjectModel07212.kasir.cekPesanan(nama, password);
    }
    
    public KasirEntity07212 penjualEntity() {
        return AllObjectModel07212.kasir.showDataKasir(indexLogin);
    }
    
    public void updateIsVerified(int index, int indexKue, PembeliEntity07212 pembeliEntity) {
        AllObjectModel07212.daftar.updateIsVerified(index, new DaftarEntity07212(pembeliEntity, true, indexKue));
    }
    
    public ArrayList<DaftarEntity07212> cekDaftarModel() {
        return AllObjectModel07212.daftar.getDaftarArrayList();
    }
   /* public void insert (String nama,String password){
    AllObjectModel07212.kasirModel.insertKasir(new KasirEntity07212(nama,password));
    }
    public int cekPesanan(String nama, String password){
        int cekpesanan = AllObjectModel07212.kasirModel.cekPesanan(nama, password);
        return cekpesanan;
    }*/
}
