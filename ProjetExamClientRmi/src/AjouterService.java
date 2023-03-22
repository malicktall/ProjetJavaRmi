//package Gestion_des_cours;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
//import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JlibelleField;
import javax.swing.JTextField;

import Model.ConnexionBD;
import rmi.IServiceRemote;

public class AjouterService implements ActionListener, MouseListener {

	JFrame frame = new JFrame("Page d'ajout de service");
	JButton valider = new JButton("Valider");
	JTextField code = new JTextField();
	JTextField libelle = new JTextField();
	JLabel codelabel = new JLabel("Code: ");
	JLabel libellelabel = new JLabel("Libelle: ");
	JButton retour = new JButton("Retour");


	String temoin="login";
	
	Connection conn = null;
    ResultSet rs ;
    PreparedStatement ps = null;
	
    String nom;
	String id;
	
	public AjouterService(String temoin, String nom, String id) {
		this.nom = nom;
		this.id = id;
		
		
		ConnexionBD  connect = new ConnexionBD();
        conn = connect.connecter();
		
		codelabel.setBounds(50, 100, 125,25);
		codelabel.setFont(new Font("MV Boli",Font.PLAIN,15));
		codelabel.setForeground(Color.WHITE);
		codelabel.addMouseListener(this);
		libellelabel.setBounds(50, 175, 125,25);
		libellelabel.setFont(new Font("MV Boli",Font.PLAIN,15));
		libellelabel.setForeground(Color.WHITE);
		
		
		code.setBounds(155,100,250, 35);
		code.setBackground(null);
		code.setForeground(Color.WHITE);
		code.addMouseListener(this);
		libelle.setBounds(155,160,250, 70);
		libelle.addMouseListener(this);
		libelle.setBackground(null);
		libelle.setForeground(Color.WHITE);
		
		
		valider.setBounds(85, 310, 100,25);
	    valider.addActionListener(this);
     	valider.setFocusable(false);
     	valider.setBackground(new Color(40,180,99));
     	valider.setFont(new Font("MV Boli",Font.PLAIN,15));
     	valider.setForeground(Color.WHITE);
		
     	
     	retour.setBounds(255, 310, 100,25);
		retour.addActionListener(this);
		retour.setFocusable(false);
		retour.setBackground(new Color(255,102,102,255));
		retour.setFont(new Font("MV Boli",Font.PLAIN,15));
		retour.setForeground(Color.WHITE);
		

     	
		frame.add(codelabel);
		frame.add(libellelabel);
		frame.add(code);
		frame.add(libelle);
		frame.add(valider);
		frame.add(retour);

	
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		frame.setSize(500, 420);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	
		frame.getContentPane().setBackground(new Color(52,73,94));
	}

	
//	@SuppressWarnings({  "deprecation" })
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String newCode = code.getText();
		String newLibelle  = libelle.getText();
		
		if(e.getSource()==valider) {
			
			if(newCode.isEmpty()) {
    	    	JOptionPane.showMessageDialog(null, "le champs code ne doit pas etre vide","Veillez remplir les champs",JOptionPane.WARNING_MESSAGE);
    	    }
    	    else if(newLibelle.isEmpty()) {
    	    	JOptionPane.showMessageDialog(null, "le champs de Libelle ne doit pas etre vide","Veillez remplir les champs",JOptionPane.WARNING_MESSAGE);
    	    }
    	    else {
//    	    	System.out.println(newCode + " " + newLibelle);
    	    	try {
    	            // Recherche du serveur RMI
    	            IServiceRemote service = (IServiceRemote) Naming.lookup("rmi://localhost:1099/Service");
	        
    	            // Appel de la méthode ServiceInsert pour insérer un service dans la base de données
    	            service.ServiceInsert(newCode, newLibelle);
    	            
    	            JOptionPane.showMessageDialog(null, "Service ajouté avec succès",
    	            		"Service",JOptionPane.INFORMATION_MESSAGE);
    	            System.out.println("Insersion avec success");
    	            frame.dispose();
//    	            AjouterService ad = new AjouterServ
    	            frame.setVisible(true);
    	        } catch (Exception ex) {
    	            ex.printStackTrace();
    	        }
	            
    	    }
			
		}
		
		if(e.getSource()==retour) {
//			 PageChef sup = new PageChef(this.nom2,this.id);
			Index lp = new Index(this.nom, this.id);
			 frame.dispose();
		 }
		
//			if(checkBox.isSelected()) {
//				libelle.setEchoChar((char)0);
//			}else {
//				libelle.setEchoChar('\u25cf');
//			}
		
	}




	@Override
	public void mousePressed(MouseEvent e) {

		if (e.getSource()==code){
			code.setBounds(135,100,300, 35);
		}
		if (e.getSource()==libelle){
			libelle.setBounds(135,160,300, 70);
		}
		
                            
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {

		
		
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
	
		
		 
		if (e.getSource()==code){
			code.setBounds(155,100,250, 35);
		}
		if (e.getSource()==libelle){
			libelle.setBounds(155,160,250, 70);
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {

		
//		if(e.getSource()==effacer) {
//			code.setText("");
//			libelle.setText("");
//		} 
		
	}


	
}
