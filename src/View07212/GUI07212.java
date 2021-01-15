package View07212;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
public class GUI07212 {
    JFrame LogReg = new JFrame();
    JLabel login,daftar,top;
    JRadioButton radiokasir,radiopembeli;
    JTextField textnamalogin,textnama,textnamadaftar;
    JLabel labelnamalogin,labelpassword,labelpasswordlogin,labelnamadaftar,labelpassworddaftar;
    JButton check,reg;
    JPasswordField passwordlogin,passworddaftar;
    private boolean ceklogin = false;
    
    public GUI07212(){
        LogReg.setSize(700,630);
        LogReg.setLayout(null);
        LogReg.getContentPane().setBackground(Color.LIGHT_GRAY);
        top = new JLabel("Kekki Kukki");
        top.setBounds(250, 20, 600, 50);
        top.setFont(new Font("Times New Roman",Font.BOLD,40));
        LogReg.add(top);
        login = new JLabel("login");
        login.setBounds(100, 50, 100, 100);
        login.setFont(new Font("Times New Roman",Font.BOLD,30));
        LogReg.add(login);
        radiokasir = new JRadioButton("Admin");
        login.setBounds(100, 50, 100, 100);
        
        radiokasir.setBounds (30, 150, 100, 30);
        radiokasir.setBackground(Color.GRAY);
        LogReg.add(radiokasir);
        radiopembeli = new JRadioButton("Pembeli");
        radiopembeli.setBounds(149, 150, 100, 30);
        radiopembeli.setBackground(Color.GRAY);
        LogReg.add(radiopembeli);
        labelnamalogin = new JLabel("Nama");
        labelnamalogin.setBounds (39,180,100,30);
        LogReg.add(labelnamalogin);
        textnamalogin = new JTextField();
        textnamalogin.setBounds (30,210,280,36);
        LogReg.add(textnamalogin);
        labelpasswordlogin = new JLabel("Password");
        labelpasswordlogin.setBounds (39, 250, 100, 30);
        LogReg.add(labelpasswordlogin);
        passwordlogin = new JPasswordField();
        passwordlogin.setBounds (30,279, 280,36);
        LogReg.add(passwordlogin);
        check = new JButton("login");
        check.setBounds (80, 320, 180, 40);
        check.setBackground(Color.GRAY);
        LogReg.add(check);
        daftar = new JLabel("Daftar Akun");
        daftar.setFont(new Font("Times New Roman", Font.BOLD, 30));
        daftar.setBounds (420, 80, 180, 100);
        LogReg.add(daftar);
        labelnamadaftar = new JLabel("Nama");
        labelnamadaftar.setBounds(405,150,100,30);
        LogReg.add(labelnamadaftar);
        textnamadaftar = new JTextField();
        textnamadaftar.setBounds (400, 180, 200, 30);
        LogReg.add(textnamadaftar);
        labelpassworddaftar = new JLabel("Password");
        labelpassworddaftar.setBounds (405, 210, 100, 30);
        LogReg.add(labelpassworddaftar);
        passworddaftar = new JPasswordField();
        passworddaftar.setBounds(400, 240, 200, 30);
        LogReg.add(passworddaftar);
        
        reg = new JButton("Daftar");
        reg.setBounds (450, 280, 100,30);
        reg.setBackground(Color.GRAY);
        LogReg.add(reg);
        
        LogReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogReg. setVisible(true);
        LogReg.setLocationRelativeTo(null);
        radiokasir.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed (ActionEvent ae) {
        if(radiokasir.isSelected()) {
        radiopembeli.setSelected(false);
        ceklogin = true;
        }
    }
});
        radiopembeli. addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed (ActionEvent ae){
        if(radiopembeli.isSelected()) {
        radiokasir.setSelected(false);
        ceklogin = false;
        }
    }
});
        check.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed (ActionEvent ae){
        if(ceklogin==true) {
        try{
        Allobjctrl07212.kasir.dataKasir();
        Allobjctrl07212.kasir.login(textnamalogin.getText(), passwordlogin.getText());
        String nama = Allobjctrl07212.kasir.penjualEntity().getNama();
        JOptionPane.showMessageDialog(null,"selamat datang "+nama,"information", JOptionPane. INFORMATION_MESSAGE);
        KasirGUI07212 kasir = new KasirGUI07212();
        LogReg.dispose();
        }catch(Exception exception) {
        JOptionPane.showMessageDialog(
        null,"nama atau password salah", "information", JOptionPane. INFORMATION_MESSAGE);
                kosong();
        }
        }else{
        try{
        Allobjctrl07212.pembeli.cekPesanan(textnamalogin.getText(), passwordlogin.getText());
        String nama = Allobjctrl07212.pembeli.pembeliEntity().getNama();
        JOptionPane.showMessageDialog(null,"Selamat Datang "+nama, "information",JOptionPane. INFORMATION_MESSAGE);
        PembeliGUI07212 prak = new PembeliGUI07212();
                LogReg.dispose();
        }catch(Exception exception){
        JOptionPane.showMessageDialog(null,"Nama atau password salah", " information",JOptionPane. INFORMATION_MESSAGE);
                kosong();
            }
        }
    }
});
        reg.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(ActionEvent ae){
        try{
        String nama = textnamadaftar.getText();
        String pass = passworddaftar.getText();
        Allobjctrl07212.pembeli.insert(nama, pass);
        JOptionPane.showMessageDialog(null,"Pendaftaran Berhasil", "information", JOptionPane. INFORMATION_MESSAGE);
                kosong();
        }catch(Exception exception) {
        JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Pendaftaran Gagal",JOptionPane. INFORMATION_MESSAGE);
            }
        }
    });
}
         void kosong(){
        textnamadaftar.setText(null);
        passworddaftar.setText(null);
        textnamalogin.setText(null);
        passwordlogin.setText(null);
       
    }
}

