package prvi;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
public class Biblioteka extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[] args) {
		try
		{
			Biblioteka k=new Biblioteka();
			k.setVisible(true);
			 k.setExtendedState(k.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	
	
	

	
	
	public Biblioteka() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1038, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		JLabel lb1 = new JLabel("");
		lb1.setIcon(new ImageIcon(getClass().getResource("/Book Details.png")));
		
		JLabel lb2 = new JLabel("");
        lb2.setIcon(new ImageIcon(getClass().getResource("/detalji.png")));
        
        JButton btn2 = new JButton("IZDAJ KNJIGU");
        btn2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnIzdajActionPerformed(e);
        		
        	}
        });
        btn2.setForeground(Color.WHITE);
        btn2.setFont(new Font("Tahoma", Font.BOLD, 24));
        btn2.setBackground(new Color(0, 102, 102));
        
        JButton btn1 = new JButton("DETALJI O KNJIZI");
        btn1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnDetaljiActionPerformed(e);
        	}
        });
        btn1.setForeground(Color.WHITE);
        btn1.setFont(new Font("Tahoma", Font.BOLD, 24));
        btn1.setBackground(new Color(0, 102, 102));
        
        JButton btn3 = new JButton("VRATI KNJIGU");
        btn3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnVratiKnjigu(e);
        	}
        });
        btn3.setForeground(Color.WHITE);
        btn3.setFont(new Font("Tahoma", Font.BOLD, 24));
        btn3.setBackground(new Color(0, 102, 102));
        
        JLabel lb3 = new JLabel("");
        
        lb3.setIcon(new ImageIcon(getClass().getResource("/vrati.png")));
        
        JButton btnDodajKnjigu = new JButton("DODAJ KNJIGU");
        btnDodajKnjigu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btn1ActionPerformed(e);
        		
        	}
        });
        btnDodajKnjigu.setForeground(Color.WHITE);
        btnDodajKnjigu.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnDodajKnjigu.setBackground(new Color(0, 102, 102));
        
        JButton btnUclaniSe = new JButton("UCLANI SE");
        btnUclaniSe.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ee) {
        		btnUclaniSe(ee);
        	}
        });
        btnUclaniSe.setForeground(Color.WHITE);
        btnUclaniSe.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnUclaniSe.setBackground(new Color(0, 102, 102));
        
        JButton btnPretraga = new JButton("ZADUZENE KNJIGE");
        btnPretraga.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnIzdajKnjigu(e);
        	}
        });
        btnPretraga.setForeground(Color.WHITE);
        btnPretraga.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnPretraga.setBackground(new Color(0, 102, 102));
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 128));
        
        JLabel lbNaslov = new JLabel("BIBLIOTEKA");
        lbNaslov.setFont(new Font("Tahoma", Font.BOLD, 47));
        lbNaslov.setForeground(Color.WHITE);
        lbNaslov.setHorizontalAlignment(SwingConstants.CENTER);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGap(365)
        			.addComponent(lbNaslov, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(365))
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGap(5)
        			.addComponent(lbNaslov))
        );
        panel.setLayout(gl_panel);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGap(27)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addComponent(btn1, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(lb1, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
        					.addGap(7)))
        			.addGap(155)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(38)
        					.addComponent(lb2, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        					.addGap(50))
        				.addComponent(btn2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(149)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(24)
        					.addComponent(lb3, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
        				.addComponent(btn3, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
        			.addGap(10))
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGap(492)
        			.addComponent(btnUclaniSe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(413))
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGap(207)
        			.addComponent(btnDodajKnjigu, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
        			.addGap(341)
        			.addComponent(btnPretraga, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
        			.addGap(120))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
        			.addGap(24)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(29)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
        						.addGroup(gl_contentPane.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
        							.addComponent(btn1))
        						.addComponent(lb1)))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(lb2)
        					.addGap(17)
        					.addComponent(btn2))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(6)
        					.addComponent(lb3, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
        					.addGap(33)
        					.addComponent(btn3)))
        			.addGap(18)
        			.addComponent(btnUclaniSe, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        			.addGap(4)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnDodajKnjigu, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnPretraga, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
        			.addGap(24))
        );
        contentPane.setLayout(gl_contentPane);
        


	}
	private void btnVratiKnjigu(ActionEvent evt)
	{
		GUIVratiKnjigu k=new GUIVratiKnjigu();
		this.setVisible(true);
	      k.setVisible(true);
	}
	private void btnIzdajKnjigu(ActionEvent evt)
	{
		GUIIzdateKnjige s=new GUIIzdateKnjige();
	      this.setVisible(true);
	      s.setVisible(true);
	}
	private void btnUclaniSe(ActionEvent evt) {
		GUIUclaniSe s=new GUIUclaniSe();
		this.setVisible(true);
		
		s.setVisible(true);
		
	}
	 private void btnIzdajActionPerformed(ActionEvent evt) {
	      	GUIIzdaj k=new GUIIzdaj();
	      	
	      	this.setVisible(!false);
	      	k.setVisible(true);
	          
	      }
	  private void btn1ActionPerformed(ActionEvent evt) {
      	GUIKnjiga k=new GUIKnjiga();
    	this.setVisible(!false);
    	k.setVisible(true);
      
          
      }
	  private void btnDetaljiActionPerformed(ActionEvent evt) {
		  GUIDetaljiKnjiga k=new GUIDetaljiKnjiga();
	      	
	      	this.setVisible(!false);
	      	k.setVisible(true);
	      	 k.setExtendedState(k.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	      }
}
