/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View07212;
import Controller07212.AllObjectModel07212;
import Controller07212.PembeliController07212;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
/**
 *
 * @author Acer
 */
public class KasirGUI07212 {
    private static PembeliController07212 pembeli = new PembeliController07212();
    JFrame penjual = new JFrame();
    JTable tabelpembeli = new JTable();
    JScrollPane scrollpenjual = new JScrollPane(tabelpembeli);
    JButton back,verif,hapus;
    JLabel Penjual,namalabel,passwordlabel;
    JTextField namatext,passtext;
    
    public KasirGUI07212() {
        penjual.setSize(650,500);
        penjual.setLayout(null);
        penjual.getContentPane().setBackground(Color.CYAN);
        Penjual = new JLabel("PENJUAL");
        Penjual.setBounds(230,30,200,30);
        Penjual.setFont(new Font("Times New Roman",Font.BOLD,40));
        penjual.add(Penjual);
        
        scrollpenjual.setBounds(30,100,570,200);
        tabelpembeli.setModel(pembeli.daftarpembeli());
        penjual.add(scrollpenjual);
        
        namalabel = new JLabel("Nama");
        namalabel.setBounds(50,320,100,30);
        penjual.add(namalabel);
        namatext = new JTextField();
        namatext.setBounds(50,350,100,30);
        penjual.add(namatext);
        
        passwordlabel = new JLabel("Password");
        passwordlabel.setBounds(200,320,100,30);
        penjual.add(passwordlabel);
        passtext = new JTextField();
        passtext.setBounds(200,350,100,30);
        penjual.add(passtext);
        
        verif = new JButton("verif");
        verif.setBounds(350, 350, 100, 30);
        verif.setBackground(Color.GREEN);
        penjual.add(verif);
        
        back = new JButton("back");
        back.setBounds(50, 400, 100, 30);
        back.setBackground(Color.GREEN);
        penjual.add(back);
        
        hapus = new JButton("Hapus");
        hapus.setBounds(350, 400, 100, 30);
        hapus.setBackground(Color.GREEN);
        penjual.add(hapus);
        
        penjual.setLocationRelativeTo(null);
        penjual.setVisible(true);
        penjual.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        back.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                 penjual.dispose();
                GUI07212 men = new GUI07212();
            }
            
        });
        
        verif.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = namatext.getText();
                String password = passtext.getText();
                int index = AllObjectModel07212.daftar.cekPesanan(nama, password);
                Allobjctrl07212.kasir.updateIsVerified(index,Allobjctrl07212.pembeli.showDaftarPembeli(index).getIndexKue(),Allobjctrl07212.pembeli.showDaftarPembeli(index).getPembeli());
                tabelpembeli.setModel(pembeli.daftarpembeli());
            }
            
        });
        
        hapus.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
               Allobjctrl07212.pembeli.deleteDatapembeli(0);
               tabelpembeli.setModel(pembeli.daftarpembeli());
            }
            
        });
        tabelpembeli.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelpembeli.getSelectedRow();
                namatext.setText(Allobjctrl07212.pembeli.daftarpembeli().getValueAt(i, 0).toString());
                passtext.setText(Allobjctrl07212.pembeli.daftarpembeli().getValueAt(i, 1).toString());
            }
        });
    }
}
