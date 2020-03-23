package prvi;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIVratiKnjigu extends JFrame {

	private JPanel contentPane;
	private JTextField txtBroj;
	private JTextField txtIme;
	private JTextField txtRbr;
	private JTextField txtNaziv;
	private JTextField txtVrati;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIVratiKnjigu frame = new GUIVratiKnjigu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public boolean provera()throws ClassNotFoundException, SQLException
	{
		boolean Da_Ne=false;
		int broj=Integer.parseInt(txtBroj.getText());
		int id=Integer.parseInt(txtRbr.getText());
		for(int i=0;i<GUIIzdaj.getListIzdaj().size();i++)
			if(GUIIzdaj.getListIzdaj().get(i).getBroj()==broj&&GUIIzdaj.getListIzdaj().get(i).getIme().equals(txtIme.getText()))
			if(GUIIzdaj.getListIzdaj().get(i).getNaziv().equals(txtNaziv.getText())&&GUIIzdaj.getListIzdaj().get(i).getId()==id)
				Da_Ne=true;
		return Da_Ne;
	}
	
	public GUIVratiKnjigu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 615, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 609, 45);
		contentPane.add(panel);
		
		JLabel lblVratiKnjigu = new JLabel("VRATI KNJIGU");
		lblVratiKnjigu.setHorizontalAlignment(SwingConstants.CENTER);
		lblVratiKnjigu.setForeground(Color.WHITE);
		lblVratiKnjigu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVratiKnjigu.setBackground(Color.BLACK);
		lblVratiKnjigu.setBounds(182, 11, 210, 20);
		panel.add(lblVratiKnjigu);
		
		JLabel label = new JLabel("Broj clanske karte");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(121, 82, 106, 14);
		contentPane.add(label);
		
		txtBroj = new JTextField();
		txtBroj.setColumns(10);
		txtBroj.setBounds(237, 80, 86, 20);
		contentPane.add(txtBroj);
		
		JLabel label_1 = new JLabel("Ime clana");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(121, 113, 74, 14);
		contentPane.add(label_1);
		
		txtIme = new JTextField();
		txtIme.setColumns(10);
		txtIme.setBounds(237, 111, 155, 20);
		contentPane.add(txtIme);
		
		JLabel lblRbrKnjige = new JLabel("Rbr knjige");
		lblRbrKnjige.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRbrKnjige.setBounds(121, 145, 106, 14);
		contentPane.add(lblRbrKnjige);
		
		txtRbr = new JTextField();
		txtRbr.setColumns(10);
		txtRbr.setBounds(237, 143, 86, 20);
		contentPane.add(txtRbr);
		
		JLabel label_2 = new JLabel("Naziv knjige");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(121, 176, 74, 14);
		contentPane.add(label_2);
		
		txtNaziv = new JTextField();
		txtNaziv.setColumns(10);
		txtNaziv.setBounds(237, 174, 155, 20);
		contentPane.add(txtNaziv);
		
		JLabel lblDatumVracanja = new JLabel("Datum vracanja");
		lblDatumVracanja.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDatumVracanja.setBounds(121, 207, 86, 14);
		contentPane.add(lblDatumVracanja);
		
		txtVrati = new JTextField();
		txtVrati.setColumns(10);
		txtVrati.setBounds(237, 205, 155, 20);
		contentPane.add(txtVrati);
		
		JButton button = new JButton("Otkazi");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brtPocetna(e);
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(Color.RED);
		button.setBounds(121, 254, 89, 23);
		contentPane.add(button);
		
		JButton btnVrati = new JButton("Vrati");
		btnVrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  
				  Connection con=null;
			        try {
			        	if(provera()==true) {
			        	int id=Integer.parseInt(txtRbr.getText());
			        	con=GUIKnjiga.openConnection();
			        	String sql = "DELETE FROM IZDATE_KNJIGE WHERE ID = ?";
			        PreparedStatement pstmt = con.prepareStatement(sql); 
			        pstmt.setInt(1, id);
			            
			        pstmt.executeUpdate();
			           JOptionPane.showMessageDialog(null, "Knjiga je vracena");
			        	}else
			        	JOptionPane.showMessageDialog(null, "Pogresni podaci pokusaj ponovo!");
			 
			        } catch (Exception e) {
			            System.out.println(e.getMessage());
			        }
			        txtIme.setText("");
			        txtRbr.setText("");
			        txtBroj.setText("");
			        txtVrati.setText("");
			        txtNaziv.setText("");
			        
			        
			}
		});
		btnVrati.setForeground(Color.WHITE);
		btnVrati.setBackground(Color.GREEN);
		btnVrati.setBounds(318, 254, 89, 23);
		contentPane.add(btnVrati);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 381, 599, 43);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		
		JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				brtPocetna(arg0);
			}
		});
		button_1.setText("Pocetna");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setBackground(new Color(0, 102, 102));
		
		JButton button_2 = new JButton();
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDetalji(e);
			}
		});
		button_2.setText("Detalji o knjizi");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_2.setBackground(new Color(0, 102, 102));
		
		JButton btnIzdajKnjigu = new JButton();
		btnIzdajKnjigu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnIzdaj(e);
			}
		});
		btnIzdajKnjigu.setText("Izdaj knjigu");
		btnIzdajKnjigu.setForeground(Color.WHITE);
		btnIzdajKnjigu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnIzdajKnjigu.setBackground(new Color(0, 102, 102));
		
		JButton button_4 = new JButton();
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUclaniSe(e);
			}
		});
		button_4.setText("Ucalni se");
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_4.setBackground(new Color(0, 102, 102));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 535, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(21)
					.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addGap(31)
					.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(btnIzdajKnjigu, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(41)
					.addComponent(button_4, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
					.addGap(36))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 37, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(1)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(2)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(2)
					.addComponent(btnIzdajKnjigu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGap(24)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(136, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
	}
	private void btnUclaniSe(ActionEvent e)
    {
    	GUIUclaniSe uc=new GUIUclaniSe();
    	this.setVisible(true);
    	uc.setVisible(true);
    }
  
    private void btnIzdaj(ActionEvent ev)
    {
    	GUIIzdaj i=new GUIIzdaj();
    	this.setVisible(true);
    	i.setVisible(true);
    	
    }
    
   private void brtPocetna(ActionEvent ev)
   {
	   Biblioteka k=new Biblioteka();
	   k.setVisible(!true);
	   this.setVisible(false);
	   k.setExtendedState(k.getExtendedState() | JFrame.MAXIMIZED_BOTH);
   }
   private void btnDetalji(ActionEvent evt)
   {
	   GUIDetaljiKnjiga v=new GUIDetaljiKnjiga();
	  
	   this.setVisible(true);
	   v.setVisible(true);
	   
   }
}
