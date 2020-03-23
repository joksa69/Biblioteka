package prvi;
import java.sql.*;

import java.io.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
public class GUIKnjiga extends JFrame {

	
  
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIKnjiga frame = new GUIKnjiga();
					frame.setVisible(true);
					
					System.out.println("=============");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static Connection openConnection() {
	
		   String databaseURL = "jdbc:ucanaccess://Baza1//BAZA.accdb";
		   Connection con=null;
			try
			{
				con = DriverManager.getConnection(databaseURL);
			} catch(SQLException e) {
		    	JOptionPane.showMessageDialog(null, "Greska "+e);
		    }
		  return con;
	   }
	public static ArrayList<Knjiga>getLista()throws ClassNotFoundException, SQLException
	{
		
		ArrayList<Knjiga>lista=new ArrayList<>();
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
			con=openConnection();
			st=con.createStatement();
			String q="select  * from  KNJIGA";
			rs=st.executeQuery(q);
			while(rs.next()) {
	     Knjiga k=new Knjiga(rs.getInt("ID"),rs.getString("BarCod"),rs.getString("Autor"),rs.getInt("BrojStrana"),
	    		 rs.getString("DatumPublikovanja"),rs.getString("ISBN"),rs.getString("Naziv"),rs.getString("Izdavac"),rs.getString("Jezik"),rs.getString("Opis"),rs.getString("TipKnjige"));
			lista.add(k);
			}
		}catch(Exception ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(null, "Greska "+ex);
		}
		finally {
			con.close();
		}
	return lista;
	}
	
	public GUIKnjiga() {
		setResizable(false);
		setBackground(new Color(0, 0, 204));
		setIconImage(Toolkit.getDefaultToolkit().getImage("/slike/knjiga.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 613, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("ID knjige:");
		lblNewLabel_1.setBounds(163, 74, 59, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtIDKnjige = new JTextField();
		txtIDKnjige.setBounds(289, 72, 80, 20);
		txtIDKnjige.setColumns(10);
		
		txtBarCod = new JTextField();
		txtBarCod.setBounds(289, 134, 125, 20);
		txtBarCod.setColumns(10);
		
		lblBarcod = new JLabel("BarCod:");
		lblBarcod.setBounds(163, 136, 59, 14);
		lblBarcod.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtBrojStranica = new JTextField();
		txtBrojStranica.setBounds(289, 165, 125, 20);
		txtBrojStranica.setColumns(10);
		
		lblBrojStranica = new JLabel("Broj Stranica:");
		lblBrojStranica.setBounds(163, 167, 105, 14);
		lblBrojStranica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtDatumPublikovanja = new JTextField();
		txtDatumPublikovanja.setBounds(289, 196, 125, 20);
		txtDatumPublikovanja.setColumns(10);
		
		lblDatumPublikovanja = new JLabel("Datum Publikovanja:");
		lblDatumPublikovanja.setBounds(163, 198, 116, 14);
		lblDatumPublikovanja.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtISBN = new JTextField();
		txtISBN.setBounds(289, 227, 125, 20);
		txtISBN.setColumns(10);
		
		lblIsbn = new JLabel("ISBN:");
		lblIsbn.setBounds(163, 229, 59, 14);
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtIzdavac = new JTextField();
		txtIzdavac.setBounds(289, 258, 125, 20);
		txtIzdavac.setColumns(10);
		
		lblIzdavac = new JLabel("Izdavac:");
		lblIzdavac.setBounds(163, 260, 59, 14);
		lblIzdavac.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtJezik = new JTextField();
		txtJezik.setBounds(289, 289, 125, 20);
		txtJezik.setColumns(10);
		
		lblJezik = new JLabel("Jezik:");
		lblJezik.setBounds(163, 291, 59, 14);
		lblJezik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtNaziv = new JTextField();
		txtNaziv.setBounds(289, 320, 125, 20);
		txtNaziv.setColumns(10);
		
		lblNaziv = new JLabel("Naziv:");
		lblNaziv.setBounds(163, 322, 59, 14);
		lblNaziv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtOpis = new JTextField();
		txtOpis.setBounds(289, 351, 125, 20);
		txtOpis.setColumns(10);
		
		lblOpis = new JLabel("Opis:");
		lblOpis.setBounds(163, 353, 59, 14);
		lblOpis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtTipKnjige = new JTextField();
		txtTipKnjige.setBounds(289, 382, 125, 20);
		txtTipKnjige.setColumns(10);
		
		lblTipKnjige = new JLabel("Tip Knjige:");
		lblTipKnjige.setBounds(155, 389, 59, 14);
		lblTipKnjige.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnOtkazi = new JButton("Otkazi");
		btnOtkazi.setBounds(71, 421, 103, 26);
		
		btnOtkazi.setBackground(Color.RED);
		btnOtkazi.setForeground(Color.WHITE);
		btnOtkazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				brnPocetna(arg1);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 607, 51);
		panel.setBackground(new Color(0, 128, 128));
		
		JLabel lblNewLabel = new JLabel("UNESTITE PODATKE O KNJIZI\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnPrihvati = new JButton("Dodaj");
		btnPrihvati.setBounds(439, 421, 105, 28);
		btnPrihvati.setBackground(Color.green);
		btnPrihvati.setForeground(Color.WHITE);
		btnPrihvati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
			
	      Connection con=null;
	        try
	        {
	        	
	        	con=openConnection();
	        	Statement stmt=con.createStatement();
	        String tip_knjige=txtTipKnjige.getText();
	        String datum=txtDatumPublikovanja.getText();
	        	int id=Integer.parseInt(txtIDKnjige.getText());
	   	     String bar=txtBarCod.getText();
	   	     String autor=txtAutor.getText();
	   	     int broj_str=Integer.parseInt(txtBrojStranica.getText());
	   	     String isbn=txtISBN.getText();
	   	     String naziv=txtNaziv.getText();
	   	     String izdavac=txtIzdavac.getText();
	   	     String jezik=txtJezik.getText();
	   	     String  opis=txtOpis.getText();
	   	  String q1 = "insert into KNJIGA(ID, BarCod, Autor, BrojStrana, DatumPublikovanja, ISBN, Naziv, Izdavac, Jezik, Opis, TipKnjige)values('" +id+ "', '" +bar+  
                  "', '" +autor+"', '"+broj_str+"', '"+datum+"', '"+isbn+"', '"+naziv+"','"+izdavac+"','"+jezik+"', '"+opis+"', '"+tip_knjige+"')";
	         	 int x=stmt.executeUpdate(q1);
	   	  if(x>0)
	   	  {
	   		System.out.println("Uspesn unos");
	   		JOptionPane.showMessageDialog(null, "Uspesan unos :)");
	   	  }
	   	  else
	   		  System.out.println("Greska");
	   	  con.close();
	   	 
	        }catch(Exception e) {
	        	System.out.println(e);
	        	JOptionPane.showMessageDialog(null, "Greska "+e);
	        }
	        txtISBN.setText("");
	        txtIzdavac.setText("");
	        txtNaziv.setText("");
	        txtJezik.setText("");
	        txtOpis.setText("");
	        txtBrojStranica.setText("");
	        txtAutor.setText("");
	        txtBarCod.setText("");
	        txtIDKnjige.setText("");
	        txtDatumPublikovanja.setText("");
	        txtTipKnjige.setText("");
	        
	        
	        
			}
			
		});
		
		txtAutor = new JTextField();
		txtAutor.setBounds(289, 103, 126, 20);
		txtAutor.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Autor:");
		lblPrezime.setBounds(163, 105, 74, 14);
		lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(185)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(178))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_1);
		contentPane.add(txtIDKnjige);
		contentPane.add(lblPrezime);
		contentPane.add(txtAutor);
		contentPane.add(lblBarcod);
		contentPane.add(txtBarCod);
		contentPane.add(lblBrojStranica);
		contentPane.add(txtBrojStranica);
		contentPane.add(lblDatumPublikovanja);
		contentPane.add(txtDatumPublikovanja);
		contentPane.add(lblIsbn);
		contentPane.add(txtISBN);
		contentPane.add(lblIzdavac);
		contentPane.add(txtIzdavac);
		contentPane.add(lblJezik);
		contentPane.add(txtJezik);
		contentPane.add(lblNaziv);
		contentPane.add(txtNaziv);
		contentPane.add(lblOpis);
		contentPane.add(txtOpis);
		contentPane.add(lblTipKnjige);
		contentPane.add(txtTipKnjige);
		contentPane.add(btnOtkazi);
		contentPane.add(btnPrihvati);
		contentPane.add(panel);
		
	}
	  private void brnPocetna(ActionEvent ev)
	   {
		   Biblioteka k=new Biblioteka();
		   k.setVisible(!true);
		   this.setVisible(false);
		   k.setExtendedState(k.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	   }
	private JPanel contentPane;
	private JTextField txtIDKnjige;
	private JTextField txtBarCod;
	private JLabel lblBarcod;
	private JTextField txtBrojStranica;
	private JLabel lblBrojStranica;
	private JTextField txtDatumPublikovanja;
	private JLabel lblDatumPublikovanja;
	private JTextField txtISBN;
	private JLabel lblIsbn;
	private JTextField txtIzdavac;
	private JLabel lblIzdavac;
	private JTextField txtJezik;
	private JLabel lblJezik;
	private JTextField txtNaziv;
	private JLabel lblNaziv;
	private JTextField txtOpis;
	private JLabel lblOpis;
	private JTextField txtTipKnjige;
	private JLabel lblTipKnjige;
	private JTextField txtAutor;
}
