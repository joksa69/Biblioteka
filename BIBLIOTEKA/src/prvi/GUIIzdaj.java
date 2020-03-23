package prvi;
import java.util.*;
import java.awt.*;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class GUIIzdaj extends JFrame {

	private JPanel contentPane;
	private JTextField txtBroj;
	private JTextField txtIme;
	private JTextField txtAutor;
	private JTextField txtNaziv;
	private JTextField txtDatum;
    Connection con=null;
    Statement stmt;
    ResultSet rs;
    private JTable table;
    private JTextField txtPretraga;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIIzdaj frame = new GUIIzdaj();
				
				
					
					
					
					frame.setVisible(true);
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	   public String provera()throws ClassNotFoundException, SQLException
	   {
		   String temp2="",temp3="";
		   int broj=Integer.parseInt(txtBroj.getText());
		   ArrayList<Clan>lista_clan=GUIUclaniSe.getLista();
		   ArrayList<ClanskaKarta>lista_karta=GUIUclaniSe.getLista_Karta();
		   ArrayList<Knjiga>lista_knjiga=GUIKnjiga.getLista();
		 
		   for(int i=0;i<lista_karta.size();++i)
			
		   for(int j=0;j<lista_clan.size();j++)
			   if(lista_clan.get(j).getIme().equals(txtIme.getText())&&lista_clan.get(j).getId()==lista_karta.get(i).getId()&&lista_karta.get(i).getBroj()==broj) temp2="Da";  
		   for(int j=0;j<lista_knjiga.size();j++)
			   if(lista_knjiga.get(j).getAutor().equals(txtAutor.getText())&&lista_knjiga.get(j).getNaziv().equals(txtNaziv.getText()))
		  temp3="Da";
		  return temp2.equals("Da")&&temp3.equals("Da") ? "Da":"Ne";
	   }
	   public static  ArrayList<Izdate>getListIzdaj()throws ClassNotFoundException,SQLException
	   {
		   ArrayList<Izdate>lista=new  ArrayList<>();
			Connection con=null;
			Statement st = null;
			ResultSet rs = null;
			try {
				con=GUIKnjiga.openConnection();
				st=con.createStatement();
				String q="SELECT ID,BrojKarte,Ime,Autor,Naziv,DatumIzdavanja FROM IZDATE_KNJIGE";
				rs=st.executeQuery(q);
				while(rs.next()) {
				Izdate i=new Izdate(rs.getInt("ID"),rs.getInt("BrojKarte"),rs.getString("Ime"),rs.getString("Autor"),rs.getString("Naziv"),rs.getString("DatumIzdavanja"));
			lista.add(i);
				}
			} catch(Exception ex) {
				System.out.println(ex);
				JOptionPane.showMessageDialog(null,"Greska "+ex);
			} finally {
				con.close();
			}
			return lista;
	   }
	   //metoda koji vraca razliku izmelju broja svih knjiga u odnosu na zaduzene
	   public  int broj() throws ClassNotFoundException, SQLException
	   {
		   int brojac=0,k=0;
		    String naziv=txtNaziv.getText();
		    for(int i=0;i<GUIKnjiga.getLista().size();i++)
		    	if(GUIKnjiga.getLista().get(i).getNaziv().equals(naziv))
		    		brojac++;
		    for(int i=0;i<getListIzdaj().size();i++)
		    	if(getListIzdaj().get(i).getNaziv().equals(naziv))
		    		k++;
		    	
		    return brojac-k;
	   }
	   
	   //imali na stanju
	   public boolean stanje()throws ClassNotFoundException, SQLException{
		   return broj()>=1;
		   
	   }
	   public int neViseOdDve()throws ClassNotFoundException, SQLException
	   {
		   int br=0;
		  int broj=Integer.parseInt(txtBroj.getText());
		  String ime=txtIme.getText();
		   
		   ArrayList<Izdate>lista=GUIIzdaj.getListIzdaj();
		 for(int i=0;i<lista.size();i++)
			 if(lista.get(i).getBroj()==broj)
			  br++;
		 return br>=0&&br<2 ? 1:0;
				
		 
	   } 
	   
	   
	public GUIIzdaj() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 894, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 888, 53);
		panel.setBackground(new Color(0, 128, 128));
		
		JLabel lblNewLabel = new JLabel("IZDAJ KNJIGU");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Broj clanske karte");
		lblNewLabel_1.setBounds(46, 117, 106, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtBroj = new JTextField();
		txtBroj.setBounds(162, 115, 86, 20);
		txtBroj.setColumns(10);
		
		JLabel lblImeClana = new JLabel("Ime clana");
		lblImeClana.setBounds(46, 148, 74, 14);
		lblImeClana.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtIme = new JTextField();
		txtIme.setBounds(162, 146, 155, 20);
		txtIme.setColumns(10);
		
		JLabel lblKnjigaId = new JLabel("Autor knjige");
		lblKnjigaId.setBounds(46, 179, 74, 14);
		lblKnjigaId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtAutor = new JTextField();
		txtAutor.setBounds(162, 177, 155, 20);
		txtAutor.setColumns(10);
		
		JLabel lblNazivKnjige = new JLabel("Naziv knjige");
		lblNazivKnjige.setBounds(46, 210, 74, 14);
		lblNazivKnjige.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtNaziv = new JTextField();
		txtNaziv.setBounds(162, 208, 155, 20);
		txtNaziv.setColumns(10);
		
		JLabel lblDatumIzdavanja = new JLabel("Datum izdavanja");
		lblDatumIzdavanja.setBounds(46, 241, 95, 14);
		lblDatumIzdavanja.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtDatum = new JTextField();
		txtDatum.setBounds(162, 239, 155, 20);
		txtDatum.setColumns(10);
		
		JButton btnIzdaj = new JButton("Izdaj");
		btnIzdaj.setBounds(228, 305, 89, 23);
		btnIzdaj.setBackground(Color.green);
		btnIzdaj.setForeground(Color.WHITE);
		btnIzdaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
				
				if(provera()=="Da") {
				if(stanje()==true) {
					if(neViseOdDve()==1) {
					con=GUIKnjiga.openConnection();
					Statement stmt=con.createStatement();
						int broj=Integer.parseInt(txtBroj.getText());
						String ime=txtIme.getText();
						String autor=txtAutor.getText();
						String naziv=txtNaziv.getText();
						String datum=txtDatum.getText();
						
						String q1 = "INSERT INTO IZDATE_KNJIGE (BrojKarte,Ime,Autor,Naziv,DatumIzdavanja) values('" +broj+"','"+ime+"','"+autor+"','"+naziv+"','"+datum+ "')";
						 int x=stmt.executeUpdate(q1);
						 if(x>0)
							 JOptionPane.showMessageDialog(null, "Knjiga je uspesno izdata!");
					}
					else {JOptionPane.showMessageDialog(null, "Ne mozes da zaduzis vise od dve knjige");}
					//else 
					}
					else JOptionPane.showMessageDialog(null, "Knjige nema na stanju !");
				}
						 
				
				else JOptionPane.showMessageDialog(null, "Clan ili knjiga sa tim podacima nepostoji");
				
				 
				con.close();
				} catch (SQLException | ClassNotFoundException e1) {
					
					System.out.println(e1);
				}
				txtBroj.setText("");
				txtNaziv.setText("");
				txtAutor.setText("");
				txtDatum.setText("");
				txtIme.setText("");
				
				
			}
			

		});
		
		JButton btnOtkazi = new JButton("Otkazi");
		btnOtkazi.setBounds(31, 305, 89, 23);
		btnOtkazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brnPocetna(e);
			}
		});
		btnOtkazi.setForeground(Color.WHITE);
		btnOtkazi.setBackground(Color.RED);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(16, 429, 848, 43);
		
		JPanel panel_2 = new JPanel();
		
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				brnPocetna(evt);
			}
		});
		button.setText("Pocetna");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBackground(new Color(0, 102, 102));
		
		JButton btnDetalji = new JButton();
		btnDetalji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDetaljiKnjige(e);
			}
		});
		btnDetalji.setText("Detalji o knjizi");
		btnDetalji.setForeground(Color.WHITE);
		btnDetalji.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDetalji.setBackground(new Color(0, 102, 102));
		
		JButton button_2 = new JButton();
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVratiKnjigu(e);
			}
		});
		button_2.setText("Vrati knjigu");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_2.setBackground(new Color(0, 102, 102));
		
		JButton btnUcalniSe = new JButton();
		btnUcalniSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   btnUclaniSe(e);
			}
		});
		btnUcalniSe.setText("Ucalni se");
		btnUcalniSe.setForeground(Color.WHITE);
		btnUcalniSe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUcalniSe.setBackground(new Color(0, 102, 102));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 535, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(21)
					.addComponent(button, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addGap(31)
					.addComponent(btnDetalji, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(41)
					.addComponent(btnUcalniSe, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
					.addGap(36))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 37, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(1)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(2)
					.addComponent(btnDetalji, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(2)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addComponent(btnUcalniSe, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(163, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)
					.addGap(150))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(null);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(296)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
					.addGap(301))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		contentPane.add(panel);
		contentPane.add(btnOtkazi);
		contentPane.add(btnIzdaj);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblKnjigaId);
		contentPane.add(lblNazivKnjige);
		contentPane.add(lblDatumIzdavanja);
		contentPane.add(lblImeClana);
		contentPane.add(txtDatum);
		contentPane.add(txtBroj);
		contentPane.add(txtNaziv);
		contentPane.add(txtIme);
		contentPane.add(txtAutor);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				try {
					TabelaIzdate tabela=new TabelaIzdate(getListIzdaj());
					table.setModel(tabela);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		scrollPane.setBounds(360, 115, 504, 255);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Rbr", "Naziv", "Autor", "DatumIzdavanja"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("Pretraga");
		lblNewLabel_2.setBounds(360, 85, 68, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboIzbor = new JComboBox();
		comboIzbor.setModel(new DefaultComboBoxModel(new String[] {"Nazivu", "Autoru"}));
		comboIzbor.setBounds(438, 82, 89, 20);
		contentPane.add(comboIzbor);
		
		txtPretraga = new JTextField();
		txtPretraga.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try
        		{
        			TabelaIzdate model;
        	String izbor=comboIzbor.getSelectedItem().toString();
        		ArrayList<Izdate>nova=new ArrayList<>();
        			
        			con=GUIKnjiga.openConnection();
        		 switch(izbor)
        		 {
        		 case "Nazivu":
        			 for(Izdate pom:getListIzdaj())
         				if(pom.getNaziv().equals(txtPretraga.getText())||txtPretraga.getText().equals(""))
         					nova.add(pom);break;
        		 case "Autoru":
        			
        			 for(Izdate pom:getListIzdaj())
          				if(pom.getAutor().equals(txtPretraga.getText())||txtPretraga.getText().equals(""))
          					nova.add(pom);break;
        		
        		 
        		 }
        			
        			model=new TabelaIzdate(nova);
        			table.setModel(model);
        	
        			
        		    con.close();
        		}
              catch(Exception e) {
            	 System.out.println(e);
            	 
              }
        		
			}
		});
		txtPretraga.setBounds(537, 82, 126, 20);
		contentPane.add(txtPretraga);
		txtPretraga.setColumns(10);
		
	}

	public static Connection openConnection() {
		String databaseURL = "jdbc:ucanaccess://Baza1//BAZA.accdb";
		Connection con=null;
		try {
			con=DriverManager.getConnection(databaseURL);
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"Greska "+e);
		}
		return con;
	}
	  private void btnUclaniSe(ActionEvent ev)
	    {
	       GUIUclaniSe k=new GUIUclaniSe();
	     
	      	this.setVisible(!false);
	     	k.setVisible(true);
	    }
	  public void btnDetaljiKnjige(ActionEvent ev)
	  {
		  GUIDetaljiKnjiga k=new GUIDetaljiKnjiga();
		  this.setVisible(true);
		  k.setVisible(true);
		  
	  }
	   private void brnPocetna(ActionEvent ev)
	   {
		   Biblioteka k=new Biblioteka();
		   k.setVisible(false);
		   this.setVisible(false);
		   k.setExtendedState(k.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	   }
	   private void btnVratiKnjigu(ActionEvent evt)
	   {
		   GUIVratiKnjigu v=new GUIVratiKnjigu();
		  
		   this.setVisible(true);
		   v.setVisible(true);
		   
	   }
	   
	   
	   
	  
	   
}
