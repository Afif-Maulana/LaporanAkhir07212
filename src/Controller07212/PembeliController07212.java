package Controller07212;

import Entity07212.PembeliEntity07212;
import Entity07212.DaftarEntity07212;
import javax.swing.table.DefaultTableModel;

public class PembeliController07212 implements ControllerInterface07212{
    int indexLogin = 0;
    
    public PembeliController07212(){
        
    }
    public PembeliEntity07212 getData() {
        return  AllObjectModel07212.pembeli.getPembeliEntity07212ArrayList(indexLogin);
    }
    public DefaultTableModel daftarpembeli() {
        DefaultTableModel dtmdaftarpembeli = new DefaultTableModel() ;
        Object[] kolom = {"nama","password","kue","verifikasi"};
        dtmdaftarpembeli.setColumnIdentifiers(kolom);
        int size = AllObjectModel07212.daftar.alldatapembeli().size();
        String verif = null;
        for(int i=0; i<size;i++){
            if(AllObjectModel07212.daftar.alldatapembeli().get(i).isIsVerified()==false) {
                verif = "no";
            } else {
                verif = "yes";
            }
            Object [] data = new Object[5];
            data[0] = AllObjectModel07212.daftar.alldatapembeli().get(i).getPembeli().getNama();
            data[1] = AllObjectModel07212.daftar.alldatapembeli().get(i).getPembeli().getPassword();
            data[3] = AllObjectModel07212.daftar.alldatapembeli().get(i).getIndexKue();
            data[4] = verif;
            dtmdaftarpembeli.addRow(data);
        } 
        return dtmdaftarpembeli;
    }
    public int cekPesanan(String nama, String password){
        int cekpesanan = AllObjectModel07212.pembeli.cekPesanan(nama, password);
        return cekpesanan;
    }
    public void daftarkue(int indexKue,PembeliEntity07212 pembeliEntity,boolean isVerified) {
        AllObjectModel07212.daftar.insertDataDaftar(new DaftarEntity07212 ( pembeliEntity,  isVerified,  indexKue));
}

    @Override
    public void login(String nama, String password) {
        indexLogin = AllObjectModel07212.pembeli.cekPesanan(nama, password);
    }
    public void insert (String nama,String password){
    AllObjectModel07212.pembeli.insertPembeli(new PembeliEntity07212(nama,password));
    }
    public PembeliEntity07212 pembeliEntity() {
        return AllObjectModel07212.pembeli.getPembeliEntity07212ArrayList(indexLogin);
    }
    public int cekDaftarPembeli(String nama) {
        int cek = AllObjectModel07212.daftar.cekPesanan(nama, null);
        return cek;
    }
    public DaftarEntity07212 showDaftarPembeli(int index) {
        return AllObjectModel07212.daftar.showDaftarPembeli(index);
    }
    public void update(String Kue, int Update) {
        AllObjectModel07212.daftar.update(Kue, Update);
    }
    
    public void deleteDatapembeli(int index) {
        AllObjectModel07212.daftar.hapuspembeliModel(index);
    }
    
    
}
