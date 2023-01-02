package ecz;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JTabbedPane;


		public class girisEkran extends JFrame {
			
		
			
			private JPanel login;
			private JTextField textField;
			private JTextField txt_recete;
			private static JTextField txt_tc; 
			public static int id;
			private int limit;
			
			
			static String tc;
			static String receteno;
			/**
			 * Launch the application.
			 */
			public static void main(String[] args) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							girisEkran frame = new girisEkran();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			
				
				
		

			/**
			 * Create the frame.
			 */
			public girisEkran() {
				setResizable(false);
				setBounds(550, 150, 592, 570);
				login = new JPanel();
				login.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(login);
				
				
				JButton giris = new JButton(" GİRİŞ YAP ");
				giris.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 10));
				giris.setBounds(407, 330, 117, 53);
				giris.setForeground(new Color(0, 0, 0));
				giris.setBackground(new Color(0, 128, 0));
				giris.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						//todo: hastanın veri tabaınında olup olmadığı kontrol edilip id bir int'e atanmalı
						//id, kolaylık iiçin tabloda tinyint tutulabilir, veri tabqanında max 255 kişi varsa
					
						
					   
						tc = txt_tc.getText();//getText()'ler ile veritabanından tc ve recete no çekildi
						receteno = txt_recete.getText();
						
						
						
					
						id = Connect.IntGetSQL("SELECT id FROM grs WHERE tc='"+ tc +"'" , "id"); 
						
						
						String tempRecete = Connect.StringGetSQL("SELECT receteno FROM grs WHERE id='" + id+"'" , "receteno");
						if(id!=0 && tempRecete.equals(receteno)) {//eğer veritabanından çekilen veriler doğruysa sonuc ekranına atadı
						sonucEkran ekr = new sonucEkran();
						JComponent comp = (JComponent) e.getSource();
                        Window win = SwingUtilities.getWindowAncestor(comp);
                        win.dispose();
	
						ekr.setVisible(true);
					
						}
						else {
							JOptionPane.showMessageDialog(null,"Reçete veya TC hatalı.");//
						}
					
			
				
					}});
				login.setLayout(null);
				
				login.add(giris);
				
				
				JLabel tc = new JLabel("T.C. NUMARANIZ:");
				tc.setBounds(81, 116, 130, 40);
				tc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
				tc.setForeground(new Color(255, 255, 255));
				login.add(tc);
				
				JLabel no = new JLabel("RE\u00C7ETE NO:");
				no.setBounds(81, 178, 155, 64);
				no.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
				no.setForeground(new Color(255, 255, 255));
				login.add(no);
				
				
				
				txt_tc = new JTextField();
				txt_tc.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 10));
				txt_tc.setToolTipText("Bu Alan Boş Geçilemez");
				txt_tc.setBounds(276, 123, 170, 30);
				login.add(txt_tc);
				txt_tc.setColumns(10);
				
				
				
				
			
				
				txt_recete = new JTextField();
				txt_recete.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 10));
				txt_recete.setToolTipText("Lütfen REçete No Giriniz");
				txt_recete.setBounds(276, 197, 168, 30);
				login.add(txt_recete);
				txt_recete.setColumns(10);
				
				JButton cikis = new JButton("ÇIKIŞ");
				cikis.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 10));
				cikis.setBounds(48, 330, 122, 53);
				cikis.setBackground(new Color(255, 0, 0));
				login.add(cikis);
				cikis.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						 
						dispose();
					}
					
				});
				
				JLabel girislabel = new JLabel("ECZANE SİSTEMİ");
				girislabel.setBounds(15, -116, 553, 690);
				girislabel.setForeground(new Color(255, 255, 255));
				girislabel.setIcon(new ImageIcon("C:\\Users\\Gulçebi\\Desktop\\icon.jpg"));
				girislabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
				login.add(girislabel);
					}	}
			
			
			
	

	

