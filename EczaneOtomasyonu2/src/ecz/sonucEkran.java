package ecz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import java.awt.event.InputMethodListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.InputMethodEvent;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.UIManager;

public class sonucEkran extends JFrame  {
	

	private JPanel contentPane;
	private JTextField isimtxt;
	private JTextField tcnext;
	private JTextField notext;
	private JTextField firstPriceLabel;
	private JTextField secPriceLabel;
	private JTextField thirdPriceLabel;
	private JTextField tutartxt;
	static String tc;
	static String hastaismi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { //try catch içine sonuç ekran frame i oluşturuldu setvisible ile true döndürüp görünür hale getirildi
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sonucEkran frame = new sonucEkran();
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
	public sonucEkran() {
		
		
		
		setForeground(UIManager.getColor("Button.shadow"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 582);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 19, 88));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel isimlabel = new JLabel("Hasta İsmi:");
		isimlabel.setBounds(26, 28, 109, 44);//size
		isimlabel.setIcon(null);
		isimlabel.setForeground(new Color(255, 255, 255));
		isimlabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));//font
		isimlabel.setBackground(new Color(255, 255, 255));
		contentPane.add(isimlabel);
		
		isimtxt = new JTextField();
		isimtxt.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		isimtxt.setBounds(158, 38, 141, 29);
		isimtxt.setEditable(false);
		
		hastaismi = Connect.StringGetSQL("SELECT hastaismi FROM grs WHERE id=" + girisEkran.id, "hastaismi");//connect sınıfıyla veri tabanına bağlanıldı  veri tabanındaki hasta ismi çekildi
		isimtxt.setText(hastaismi);
		contentPane.add(isimtxt);
		isimtxt.setColumns(10);
		
		
		
		JLabel tclabel = new JLabel("Hasta TC:");
		tclabel.setForeground(new Color(255, 255, 255));
		tclabel.setBounds(26, 103, 109, 44);
		tclabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(tclabel);
		
		tcnext = new JTextField();
		tcnext.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		tcnext.setBounds(158, 113, 141, 29);
		tcnext.setEditable(false);
		contentPane.add(tcnext);
		tcnext.setColumns(10);
		
		JLabel nolabel = new JLabel("Reçete No:");
		nolabel.setForeground(new Color(255, 255, 255));
		nolabel.setBounds(494, 28, 109, 44);
		nolabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(nolabel);
		
		notext = new JTextField();
		notext.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		notext.setBounds(624, 38, 103, 29);
		notext.setEditable(false);
		contentPane.add(notext);
		notext.setColumns(10);
		
		
		
		JLabel teslimlabel = new JLabel("Reçeteyi Teslim Alan:");
		teslimlabel.setForeground(new Color(255, 255, 255));
		teslimlabel.setBounds(494, 79, 244, 44);
		teslimlabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(teslimlabel);
		
		String arr[] = {"Yakını","Kendisi","Diğer"}; // Reçetenin kim tarafından alındığını seçmek için combobox kullandık.
		JComboBox secimbox = new JComboBox(arr);
		secimbox.setFont(new Font("Arial Black", Font.BOLD, 12));
		secimbox.setBounds(500, 141, 89, 21);
		secimbox.setMaximumRowCount(3);
		JButton secbox = new JButton("Seçiniz");
		secbox.setFont(new Font("Arial Black", Font.BOLD, 12));
		secbox.setBounds(624, 141, 99, 21);
		secbox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = "İlacı alan: " + secimbox.getSelectedItem();
				System.out.println(text);
				
			}
			
		}
				
				); 
		
		contentPane.add(secimbox); 
		contentPane.add(secbox);
		
		JLabel ilaclabel = new JLabel("İlaçlar:");
		ilaclabel.setForeground(new Color(255, 255, 255));
		ilaclabel.setBounds(29, 199, 96, 34);
		ilaclabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(ilaclabel);
		
		String drugOne = Connect.StringGetSQL("SELECT ilaclar1 FROM grs WHERE id=" + girisEkran.id, "ilaclar1"); //Connect sınıfından database
		JCheckBox ilactxt1 = new JCheckBox(drugOne);                                                            //ile bağlantı kurduk ve ilaçları ekran classına çektik
		
		ilactxt1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 10));
		ilactxt1.setBounds(26, 273, 141, 21);
	
		contentPane.add(ilactxt1);
		
		
		String drugTwo = Connect.StringGetSQL("SELECT ilaclar2 FROM grs WHERE id=" + girisEkran.id, "ilaclar2");
		JCheckBox ilactxt2 = new JCheckBox(drugTwo);
		ilactxt2.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 10));
		ilactxt2.setBounds(26, 316, 141, 21);
		contentPane.add(ilactxt2);
		
		String drugThree = Connect.StringGetSQL("SELECT ilaclar3 FROM grs WHERE id=" + girisEkran.id, "ilaclar3");
		JCheckBox ilactxt3 = new JCheckBox(drugThree);
		ilactxt3.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 10));
		ilactxt3.setBounds(26, 360, 141, 21);
		contentPane.add(ilactxt3);
		
		String drugThird = Connect.StringGetSQL("SELECT ilaclar4 FROM grs WHERE id=" + girisEkran.id, "ilaclar4");
		
		JButton tn = new JButton("Kaydet");  
		tn.setBounds(441, 488, 148, 21);
		tn.setFont(new Font("Arial Black", Font.BOLD, 12));
		tn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {   //kaydet butonu olusturduk ve tıklandığında mesaj getirdik.
				JOptionPane.showMessageDialog(contentPane, "Reçete başarıyla kaydedildi.\n" +  "Sağlıklı günler dileriz :)");
				
			}
			
		}
				
				
				);
		
		contentPane.add(tn);
		
		
	
		firstPriceLabel = new JTextField(String.valueOf(Connect.IntGetSQL("SELECT price FROM drugs WHERE name='" + drugOne + "'", "price"))); //databasedenfiyatları çektik
		firstPriceLabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 10));
		firstPriceLabel.setBounds(225, 273, 96, 19);
		firstPriceLabel.setEditable(false);
		contentPane.add(firstPriceLabel);
		firstPriceLabel.setColumns(10);
		
		
		secPriceLabel = new JTextField(String.valueOf(Connect.IntGetSQL("SELECT price FROM drugs WHERE name='" + drugTwo + "'", "price")));
		secPriceLabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 10));
		secPriceLabel.setBounds(225, 316, 96, 19);
		secPriceLabel.setEditable(false);
		contentPane.add(secPriceLabel);
		secPriceLabel.setColumns(10);
		
		thirdPriceLabel = new JTextField(String.valueOf(Connect.IntGetSQL("SELECT price FROM drugs WHERE name='" + drugThree + "'", "price")));
		thirdPriceLabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 10));
		thirdPriceLabel.setBounds(225, 360, 96, 19);
		thirdPriceLabel.setEditable(false);
		contentPane.add(thirdPriceLabel);
		thirdPriceLabel.setColumns(10);
		
		JLabel fiyatlabel = new JLabel("Fiyat (TL):");
		fiyatlabel.setForeground(new Color(255, 255, 255));
		fiyatlabel.setBounds(225, 202, 96, 29);
		fiyatlabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(fiyatlabel);
		
		JLabel sumText = new JLabel("Ödenecek Tutar (TL):");
		sumText.setForeground(new Color(255, 255, 255));
		sumText.setBounds(455, 250, 167, 44);
		sumText.setFont(new Font("Arial Black", Font.BOLD, 12));
		contentPane.add(sumText);
		
		tutartxt = new JTextField();
		tutartxt.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 10));
		tutartxt.setForeground(new Color(0, 64, 0));
		tutartxt.setBounds(455, 340, 118, 20);
		contentPane.add(tutartxt);
		tutartxt.setColumns(10);
		tutartxt.setEditable(false);
		
		JButton sumButton = new JButton("Toplam");    //Toplam butonu olusturduk. Basıldığında ilaçların fiyatlarını topladı.
		sumButton.setBounds(455, 294, 118, 21);
		sumButton.setFont(new Font("Arial Black", Font.BOLD, 12));
		contentPane.add(sumButton);
		
		sumButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				int f = 0;
				if(ilactxt1.isSelected()) f += Integer.parseInt(firstPriceLabel.getText());
				if(ilactxt2.isSelected()) f += Integer.parseInt(secPriceLabel.getText());
				if(ilactxt3.isSelected()) f += Integer.parseInt(thirdPriceLabel.getText());
				
				
				
				
	
				String toplam = String.valueOf(f);
				tutartxt.setText(toplam);
				
			}
			
			
		}
				
				);
		
		
		
		tcnext.setText(girisEkran.tc);
		notext.setText(girisEkran.receteno);
		
		JButton geribtn = new JButton("GERİ DÖN");  //geri dön butonu oluşturduk. tıklandığında giris ekranını set Visible ile görünür hale getird.
		geribtn.setBounds(26, 487, 141, 22);
		geribtn.setFont(new Font("Arial Black", Font.BOLD, 12));
		geribtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				girisEkran f = new girisEkran();
				f.setVisible(true);
				
				JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
                
			}
		});
		contentPane.add(geribtn);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Gulçebi\\Desktop\\img.jpg"));
		lblNewLabel_6.setBounds(10, 0, 868, 536);
		contentPane.add(lblNewLabel_6);
		
		
		
	}
}
