package Model07212;

import Entity07212.DaftarEntity07212;
import Entity07212.KekkiKukkiEntity07212;
import java.text.ParseException;
import java.util.ArrayList;

public class DaftarModel07212 implements KekkiInterface07212 {
   private ArrayList <DaftarEntity07212> DaftarEntity07212ArrayList; 
   
       public DaftarModel07212(){
           DaftarEntity07212ArrayList = new ArrayList<DaftarEntity07212>();
   }
       public void insertDataDaftar (DaftarEntity07212 daftar){
           DaftarEntity07212ArrayList.add(daftar);
       }
       public DaftarEntity07212 getKekkiKukkiEntityArrayList(int index){
           return DaftarEntity07212ArrayList.get(index);
       }
       public ArrayList<DaftarEntity07212>getDaftarArrayList() {
        return DaftarEntity07212ArrayList;
    }
    public int size() {
        return DaftarEntity07212ArrayList.size();
    }
    @Override
    public void view() {
 for (DaftarEntity07212 daftar : DaftarEntity07212ArrayList) {
            System.out.println("==============================================");
            System.out.println("nama : " + daftar.getPembeli().getNama()
                    +"\nPassword : " + daftar.getPembeli().getPassword() 
                    +"\n Kue : "+KekkiKukkiEntity07212.nama[daftar.getIndexKue()] 
                    + "\n isVerified : ");
            if(daftar.isIsVerified()==false) {
                System.out.println("Belum Di Verifikasi Penjual");
            } else {
                System.out.println("Sudah Di Verifikasi Penjual");
            }
            System.out.println("==============================================");
        }    }

    @Override
    public int cekPesanan(String nama, String password) {
int loop = 0;
        if(DaftarEntity07212ArrayList.size() == 0) {
            loop = -1;
        } else {
            for (int i=0; i<DaftarEntity07212ArrayList.size(); i++) {
                if (DaftarEntity07212ArrayList.get(i).getPembeli().getNama().equals(nama)) {
                    loop = i;
                    break;
                } else {
                    loop = -2;
                }
            }
        }
        return loop;
    }
    
    public DaftarEntity07212 showDaftarPembeli(int index) {
        return DaftarEntity07212ArrayList.get(index);
    }
    public void updateIsVerified(int index,DaftarEntity07212 DaftarPembeli) {
        DaftarEntity07212ArrayList.set(index, DaftarPembeli);
    }
    public void hapuspembeliModel(int index) {
        DaftarEntity07212ArrayList.remove(DaftarEntity07212ArrayList.get(index));
    }
            
    public ArrayList <DaftarEntity07212> alldatapembeli() {
        return DaftarEntity07212ArrayList;
    }
    
    private int cari(String Kue){
        int index=-1;
        for(int i=0;i <DaftarEntity07212ArrayList.size();i++) {
           if(Kue.equals(DaftarEntity07212ArrayList.get(i).getPembeli().getNama()))
               index=i;
       }
       return index;
    }
    
    public void update(String Kue, int update){
            int data;
        if(cari(Kue)!=-1){
            DaftarEntity07212ArrayList.get(cari(Kue)).setIndexKue(update);
            data = 1;
        }
        else {
            data = 0;
           
        }
    } 
        }

