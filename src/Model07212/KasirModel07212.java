package Model07212;

import Entity07212.KasirEntity07212;
import java.util.ArrayList;

public class KasirModel07212 implements KekkiInterface07212{
    private ArrayList<KasirEntity07212> kasirEntityArrayList;
    
        public KasirModel07212(){
        kasirEntityArrayList = new ArrayList<KasirEntity07212>();
    }
        public void insertKasir(KasirEntity07212 kasir){
        kasirEntityArrayList.add(kasir);
    }
    @Override
    public int cekPesanan(String nama, String password){
        int loop = 0;
        for(KasirEntity07212 kasir : kasirEntityArrayList){
            if(kasir.getNama().equals(nama) && kasir.getPassword().equals(password)){
            break;
            }else{
                loop++;
            }}
        return loop;
   }
     public KasirEntity07212 showDataKasir(int index) {
        return kasirEntityArrayList.get(index);
    }

    @Override
    public void view() {
        for (KasirEntity07212 kasirEntity07212 : kasirEntityArrayList){
            System.out.println(kasirEntity07212.getNama());
            System.out.println(kasirEntity07212.getPassword());
            System.out.println(kasirEntity07212.getToko());
        }
    }
 }
