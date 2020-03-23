package prvi;

import java.util.*;
import java.util.Date;
import java.text.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import java.sql.*;
import javax.swing.ImageIcon;
import java.awt.*;
public class GUIUclaniSe extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIme;
	private JTextField textFieldAdresa;
	private JTextField txtBroj;
	private JTextField txtDatumOtvaranja;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIUclaniSe frame = new GUIUclaniSe();
					frame.setVisible(true);
					
					System.out.println("==================");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public static ArrayList<ClanskaKarta>getLista_Karta()throws ClassNotFoundException, SQLException
	{
		ArrayList<ClanskaKarta>lista=new ArrayList<>();
		Connection con=null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con=GUIKnjiga.openConnection();
			st=con.createStatement();
			String q="SELECT ID,Broj,DatumOtvaranja FROM CLANSKA_KARTA";
			rs=st.executeQuery(q);
			while(rs.next()) {
				ClanskaKarta c = new ClanskaKarta(rs.getInt("ID"),rs.getInt("Broj"),rs.getString("DatumOtvaranja"));
				lista.add(c);
			}
		} catch(Exception ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(null,"Greska "+ex);
		} finally {
			con.close();
		}
		return lista;
	}
	
	public static ArrayList<Clan>getLista()throws ClassNotFoundException, SQLException{
		ArrayList<Clan>lista=new ArrayList<>();
		Connection con=null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con=GUIKnjiga.openConnection();
			st=con.createStatement();
			String q="SELECT ID,Ime,Adresa FROM CLAN";
			rs=st.executeQuery(q);
			while(rs.next()) {
				Clan c = new Clan(rs.getInt("ID"),rs.getString("Ime"),rs.getString("Adresa"));
				lista.add(c);
			}
		} catch(Exception ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(null,"Greska "+ex);
		} finally {
			con.close();
		}
		return lista;
	}
	public String nepoklapaj()throws ClassNotFoundException,SQLException
	{
		String temp="";
		int broj=Integer.parseInt(txtBroj.getText());
			for(ClanskaKarta pom2:getLista_Karta())
	       if(pom2.getBroj()==broj)
	    	   temp="Da";
			return temp;
	}
	public GUIUclaniSe() {
		setResizable(false);
		setBackground(new Color(0, 0, 204));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 423, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 417, 45);
		panel.setBackground(new Color(0, 128, 128));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewbutton = new JLabel("UNESITE LICNE PODATKE");
		lblNewbutton.setBounds(114, 11, 210, 20);
		panel.add(lblNewbutton);
		lblNewbutton.setBackground(Color.BLACK);
		lblNewbutton.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewbutton.setForeground(Color.WHITE);
		lblNewbutton.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		textFieldIme = new JTextField();
		textFieldIme.setBounds(198, 66, 116, 20);
		contentPane.add(textFieldIme);
		textFieldIme.setColumns(10);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdresa.setBounds(82, 96, 65, 20);
		contentPane.add(lblAdresa);
		
		JLabel lblIme = new JLabel("Ime");
		lblIme.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIme.setBounds(82, 65, 65, 20);
		contentPane.add(lblIme);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBackground(Color.GREEN);
		btnDodaj.setBounds(283, 235, 76, 23);
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con=null;
				
				try {
					if(nepoklapaj()!="Da") {
					con=GUIKnjiga.openConnection();
					Statement stmt=con.createStatement();
					String ime=textFieldIme.getText();
					String adresa = textFieldAdresa.getText();
					int broj=Integer.parseInt(txtBroj.getText());
					int clanID = 	(int)(Math.random() * ((1000 - 0) + 1)) + 0;
				// datum=
					DateFormat df = new SimpleDateFormat("dd/MM/yy");
					Date dateobj = new Date();
					String datumUclan = df.format(dateobj);
				    String datum=txtDatumOtvaranja.getText();
					String q1 = "insert into CLAN(Ime,Adresa)values('" +ime+"','"+adresa+ "')";
				String q2 = "insert into CLANSKA_KARTA(Broj,DatumOtvaranja)values('" +broj+"','"+ datum+"')";
				         	 int x=stmt.executeUpdate(q1);
				         	 int y=stmt.executeUpdate(q2);
				         	 
				   	  if(x>0 && y>0) {
				   		  System.out.println("Uspesan unos!");
				   		  JOptionPane.showMessageDialog(null, "Uspesan unos!");
				   	  } else 
				   		  System.out.println("Greska!");}
					else JOptionPane.showMessageDialog(null, "Greska, takav clan vec postoj!");
				   	  con.close();
				} catch(Exception e) {
					System.out.println(e);
					JOptionPane.showMessageDialog(null, "Greska "+e);
				}
				textFieldIme.setText("");
				textFieldAdresa.setText("");
				txtBroj.setText("");
				txtDatumOtvaranja.setText("");
				
				
			}
		});
		contentPane.add(btnDodaj);
		
		JButton btnOtkazi = new JButton("Otkazi");
		btnOtkazi.setBackground(Color.RED);
		btnOtkazi.setBounds(43, 235, 76, 23);
		btnOtkazi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1) {
				brnPocetna(arg1);
			
			}
		});
		contentPane.add(btnOtkazi);
		
		textFieldAdresa = new JTextField();
		textFieldAdresa.setBounds(198, 97, 116, 20);
		contentPane.add(textFieldAdresa);
		textFieldAdresa.setColumns(10);
		
		txtBroj = new JTextField();
		txtBroj.setColumns(10);
		txtBroj.setBounds(198, 128, 116, 20);
		contentPane.add(txtBroj);
		
		JLabel lblBrojClanskeKarte = new JLabel("Broj clanske karte");
		lblBrojClanskeKarte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBrojClanskeKarte.setBounds(82, 127, 116, 20);
		contentPane.add(lblBrojClanskeKarte);
		
		JLabel lblDatumOtvaranja = new JLabel("Datum otvaranja");
		lblDatumOtvaranja.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDatumOtvaranja.setBounds(82, 158, 100, 20);
		contentPane.add(lblDatumOtvaranja);
		
		txtDatumOtvaranja = new JTextField();
		txtDatumOtvaranja.setColumns(10);
		txtDatumOtvaranja.setBounds(198, 159, 116, 20);
		contentPane.add(txtDatumOtvaranja);}
	  private void brnPocetna(ActionEvent ev)
	   {
		   Biblioteka k=new Biblioteka();
		   k.setVisible(!true);
		   this.setVisible(false);
		   k.setExtendedState(k.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	   }
	}


























