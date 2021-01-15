package View07212;
import Entity07212.KekkiKukkiEntity07212;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Acer
 */
public class PembeliGUI07212 {
    JFrame pembeli = new JFrame();
    JButton back, daftarbtn;
    JTextArea area = new JTextArea();
    JLabel datadiri,daftarKue;
    JComboBox pilKue = new JComboBox(KekkiKukkiEntity07212.nama);
    int cek = Allobjctrl07212.pembeli.cekDaftarPembeli(Allobjctrl07212.pembeli.getData().getNama());
    
    public PembeliGUI07212() {
        pembeli.setSize(720,600);
        pembeli.setLayout(null);
        pembeli.getContentPane().setBackground(Color.BLUE);
        
        datadiri = new JLabel("Data Pembeli");
        datadiri.setFont(new Font("Timer New Roman",Font.BOLD,30));
        datadiri.setBounds(90, 30, 200, 30);
        pembeli.add(datadiri);
        area.setBounds(30, 90, 400, 300);
        pembeli.add(area);
        
        daftarKue = new JLabel("Menu Kue");
        daftarKue.setBounds(450, 30, 250, 30);
        daftarKue.setFont(new Font("Times New Roman",Font.BOLD,30));
        pembeli.add(daftarKue);
        pilKue.setBounds(450, 90, 230, 30);
        pembeli.add(pilKue);
        
        daftarbtn = new JButton("Daftar");
        daftarbtn.setBounds(500, 200, 100, 30);
        daftarbtn.setBackground(Color.GRAY);
        pembeli.add(daftarbtn);
        
        back = new JButton("Back");
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.GRAY);
        pembeli.add(back);
        
        pembeli.setVisible(true);
        pembeli.setLocationRelativeTo(null);
        pembeli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        if(cek==-1){
             JOptionPane.showMessageDialog(null, "Anda Belum memilih kue", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else if(cek==-2){
            JOptionPane.showMessageDialog(null,"Anda Belum memilih kue", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            area.setText(datapembeli());
        }
        daftarbtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                int indexkue = pilKue.getSelectedIndex();
                Allobjctrl07212.pembeli.daftarkue(indexkue,Allobjctrl07212.pembeli.getData(),false);
                area.setText(datapembeli());
            }
            
        });
        back.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                pembeli.dispose();
                GUI07212 men = new GUI07212();
            }
            
        });
}
    String datapembeli(){
        int cek = Allobjctrl07212.pembeli.cekDaftarPembeli(Allobjctrl07212.pembeli.getData().getNama());
        String cekverif;
        if(Allobjctrl07212.pembeli.showDaftarPembeli(cek).isIsVerified()==false) {
            cekverif = "belum di verifikasi";
        }else{
            cekverif = "Sudah di verifikasi";
        }
        String text = "Nama = "+Allobjctrl07212.pembeli.showDaftarPembeli(cek).getPembeli().getNama()+"\n"
                +"Verifikasi = "+cekverif+"\n"
                +"Kue = "+KekkiKukkiEntity07212.nama[Allobjctrl07212.pembeli.showDaftarPembeli(cek).getIndexKue()];
        return text;
    }
}

