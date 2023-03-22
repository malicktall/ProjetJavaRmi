//package Gestion_des_cours;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.ConnexionBD;



public class VoirService implements ActionListener {
	String nom;
    String id;
    String temoin = null;
	JFrame frame = new JFrame("Voir services");
	JButton retour ;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public VoirService(String nom, String id, String temoin) {
		this.nom = nom;
		this.id = id;
		
		JLabel welcome = new JLabel("Bonjour Mr "+nom);
		
		welcome.setBounds(120,150,300,50);
		welcome.setFont(new Font("MV Boli",Font.PLAIN,15));
		welcome.setForeground(Color.WHITE);
		
		retour = new JButton("Retour");
		retour.setBounds(280, 490, 120,25);
		retour.addActionListener(this);
		retour.setFocusable(false);
		retour.setBackground(new Color(255,102,102,255));
		retour.setFont(new Font("MV Boli",Font.PLAIN,15));
		retour.setForeground(Color.WHITE);
//		AFFICHER DES DONNEES DEPUIS LA BASE DE DONNES  
		
		Connection conn = null;
	    ResultSet rs = null ;
	    PreparedStatement ps = null;
		ConnexionBD  connect = new ConnexionBD();
        conn = connect.connecter();
        
        
        try {
        	String requete = "select * from elements "; //where id_prof =? 
        	
			ps = conn.prepareStatement(requete);
//			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			
			
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int nombreColonne = rsmd.getColumnCount();
			Vector column = new Vector(nombreColonne);
			for(int i =1; i<=nombreColonne;i++) {
				column.add(rsmd.getColumnName(i));
				
			}
			Vector data = new Vector();
			Vector row = new Vector();
			while(rs.next()) {
				
				row = new Vector(nombreColonne);
				for(int i =1; i<=nombreColonne;i++) {
					row.add(rs.getString(i));
					
				}
				data.add(row);
			}
			
			
			
			
			
			
			
//			CREATION DE TABLEAU
			
			JPanel panel = new JPanel(new BorderLayout());
		
			panel.setBackground(Color.RED);
			frame.setLayout(new FlowLayout());
			
			JTable table = new JTable(data, column);
			table.setPreferredScrollableViewportSize(new Dimension(443,250));
	        table.setBackground(new Color(52,73,94));
	        table.setForeground(Color.WHITE);
			table.setFillsViewportHeight(true);
			table.getTableHeader().setBackground(new Color(255,102,102,255));

			table.getTableHeader().setForeground(Color.white);
			table.getTableHeader().setOpaque(false);
			JScrollPane scrollPane = new JScrollPane(table);
	        panel.add(scrollPane, BorderLayout.CENTER);

	        frame.add(welcome);
			frame.add(panel);
			
//			if(temoin.equals("chef")) {
			frame.add(retour);
//			}
			frame.setSize(500, 420);
			frame.setResizable(false);
			
			frame.setVisible(true);
			
			frame.setLayout(null);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			
			frame.getContentPane().setBackground(new Color(52,73,94));
			
			
			
			
			
			
			
			
			
		} catch(SQLException R){
            R.printStackTrace();;
        }finally{
        
            try{
                ps.close();
                rs.close();
            }catch(Exception R){
            R.printStackTrace();;
        }
	}
	
	

		
	}
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource()==retour) {
			 Index sup = new Index(this.nom,this.id);
			 frame.dispose();
		 }
		
	}
}

