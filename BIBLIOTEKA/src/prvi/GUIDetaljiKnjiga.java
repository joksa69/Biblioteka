package prvi;
import  javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.GroupLayout.Alignment;
import java.util.*;

import javax.swing.LayoutStyle.ComponentPlacement;

public class GUIDetaljiKnjiga extends JFrame {
    Connection con=null;
    Statement stmt;
    ResultSet rs;
    String query;
    
    
    
    
    
    
    public GUIDetaljiKnjiga() {
    	//setIconImage(Toolkit.getDefaultToolkit().getImage("/knjiga.png"));
        initComponents();
    }

   
    
 
    private void initComponents() {

        b1 = new ButtonGroup();
        jScrollPane2 = new JScrollPane();
        jScrollPane2.addAncestorListener(new AncestorListener() {
        	public void ancestorAdded(AncestorEvent arg0) {
        		try {
					Tabela tabela=new Tabela(GUIKnjiga.getLista());
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
        table = new JTable();
        jButton1 = new JButton();
         
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        table.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
            		"ID", "BarCod", "Autor", "BrojStrana", "DatumPublikovanja", "ISBN", "Naziv", "Izdavac", "Jezik", "Opis","TipKnjige"
            }
           
        ));
      
     DefaultTableModel model=(DefaultTableModel)table.getModel();
        try {
			model.addRow(GUIKnjiga.getLista().toArray());
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(table);
       
             
        jButton1.setBackground(new Color(0, 102, 102));
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setText("Dodaj novu knjigu\r\n");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	btnDodajKnjigu(evt);
            }
        });
        
        JComboBox comboIzbor = new JComboBox();
        comboIzbor.setModel(new DefaultComboBoxModel(new String[] {"Nazivu", "Autoru", "Izdavacu", "BarCodu"}));
        
        txt2 = new JTextField();
        ///pretraga 
        txt2.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent arg0) {
        		try
        		{
        			Tabela model;
        	String izbor=comboIzbor.getSelectedItem().toString();
        		ArrayList<Knjiga>nova=new ArrayList<>();
        			
        			con=GUIKnjiga.openConnection();
        		 switch(izbor)
        		 {
        		 case "Nazivu":
        			 for(Knjiga pom:GUIKnjiga.getLista())
         				if(pom.getNaziv().equals(txt2.getText())||txt2.getText().equals(""))
         					nova.add(pom);break;
        		 case "Autoru":
        			
        			 for(Knjiga pom:GUIKnjiga.getLista())
          				if(pom.getAutor().equals(txt2.getText())||txt2.getText().equals(""))
          					nova.add(pom);break;
        		 case "BarCodu":
        			
        			 for(Knjiga pom:GUIKnjiga.getLista())
          				if(pom.getBarcod().equals(txt2.getText())||txt2.getText().equals(""))
          					nova.add(pom);break;
        		 case "Izdavacu":
        			
        			 for(Knjiga pom:GUIKnjiga.getLista())
          				if(pom.getIzdavac().equals(txt2.getText())||txt2.getText().equals(""))
          					nova.add(pom);break;
        		
        		 
        		 }
        			
        			model=new Tabela(nova);
        			table.setModel(model);
        	
        			
        		    con.close();
        		}
              catch(Exception e) {
            	 System.out.println(e);
            	 
              }
        		
        	}
        });
        txt2.setColumns(10);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 128));
        
        JLabel label = new JLabel("DETALJI O KNJIZI");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma", Font.BOLD, 27));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 925, Short.MAX_VALUE)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGap(308)
        			.addComponent(label, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
        			.addGap(335))
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 59, Short.MAX_VALUE)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGap(11)
        			.addComponent(label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
        );
        panel.setLayout(gl_panel);
        
        panel_1 = new JPanel();
        
        JLabel lblPretraga = new JLabel("Pretraga");
        lblPretraga.setFont(new Font("Tahoma", Font.BOLD, 13));
      

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(39)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblPretraga)
        					.addGap(49)
        					.addComponent(comboIzbor, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
        					.addGap(56)
        					.addComponent(txt2, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        					.addGap(89)
        					.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
        			.addGap(39))
        		.addComponent(panel, GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(213)
        			.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
        			.addGap(197))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPretraga)
        				.addComponent(comboIzbor, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txt2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
        			.addGap(27)
        			.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
        			.addGap(73)
        			.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jButton5 = new JButton();
        
                jButton5.setBackground(new Color(0, 102, 102));
                jButton5.setFont(new Font("Tahoma", 0, 12)); 
                jButton5.setForeground(new Color(255, 255, 255));
                jButton5.setText("Ucalni se");
                jButton4 = new JButton();
                
                        jButton4.setBackground(new Color(0, 102, 102));
                        jButton4.setFont(new Font("Tahoma", 0, 12)); 
                        jButton4.setForeground(new Color(255, 255, 255));
                        jButton4.setText("Vrati knjigu");
                        jButton3 = new JButton();
                        
                                jButton3.setBackground(new Color(0, 102, 102));
                                jButton3.setFont(new Font("Tahoma", 0, 12)); 
                                jButton3.setForeground(new Color(255, 255, 255));
                                jButton3.setText("Izdaj Knjigu");
                                jButton2 = new JButton();
                                

                                jButton2.setBackground(new Color(0, 102, 102));
                                jButton2.setFont(new Font("Tahoma", 0, 12)); 
                                jButton2.setForeground(new Color(255, 255, 255));
                                jButton2.setText("Pocetna");
                                GroupLayout gl_panel_1 = new GroupLayout(panel_1);
                                gl_panel_1.setHorizontalGroup(
                                	gl_panel_1.createParallelGroup(Alignment.LEADING)
                                		.addGroup(gl_panel_1.createSequentialGroup()
                                			.addGap(21)
                                			.addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                			.addGap(31)
                                			.addComponent(jButton3, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                			.addGap(27)
                                			.addComponent(jButton4, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                			.addGap(41)
                                			.addComponent(jButton5, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                			.addGap(36))
                                );
                                gl_panel_1.setVerticalGroup(
                                	gl_panel_1.createParallelGroup(Alignment.LEADING)
                                		.addGroup(gl_panel_1.createSequentialGroup()
                                			.addGap(1)
                                			.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                		.addGroup(gl_panel_1.createSequentialGroup()
                                			.addGap(2)
                                			.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                		.addGroup(gl_panel_1.createSequentialGroup()
                                			.addGap(2)
                                			.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                		.addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                );
                                panel_1.setLayout(gl_panel_1);
                                jButton2.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent evt) {
                                        brnPocetna(evt);
                                    }
                                });
                                jButton3.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent evt) {
                                     btnIzdaj(evt);
                                    }
                                });
                        jButton4.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                              btnVratiKnjigu(evt);
                            }
                        });
                jButton5.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                      btnUclaniSe(evt);
                    }
                });
        getContentPane().setLayout(layout);

        pack();
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
    private void btnDodajKnjigu(ActionEvent ev)
    {
    	GUIKnjiga k=new GUIKnjiga();
     
      	this.setVisible(!false);
     	k.setVisible(true);
    }
   private void brnPocetna(ActionEvent ev)
   {
	   Biblioteka k=new Biblioteka();
	   k.setVisible(!true);
	   this.setVisible(false);
	   k.setExtendedState(k.getExtendedState() | JFrame.MAXIMIZED_BOTH);
   }
   private void btnVratiKnjigu(ActionEvent evt)
   {
	   GUIVratiKnjigu v=new GUIVratiKnjigu();
	   v.setVisible(true);
	   this.setVisible(false);
	   
   }
  
    public static void main(String args[]) {
       
      
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	GUIDetaljiKnjiga k;
				try {
					k = new GUIDetaljiKnjiga();
					  k.setVisible(true);
					  
						 k.setExtendedState(k.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
             
            }
        });
    }
   
    private ButtonGroup b1;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JScrollPane jScrollPane2;
    private JTable table;
    private JTextField txt2;
    private JPanel panel_1;
}
