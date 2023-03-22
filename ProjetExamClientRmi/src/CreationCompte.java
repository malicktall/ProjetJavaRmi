//package Gestion_des_cours;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.ConnexionBD;

public class CreationCompte implements ActionListener {
	

	Connection conn = null;
    ResultSet rs ;
    PreparedStatement ps = null;
    
	
	JFrame frame = new JFrame("Creation de compte");
	JButton valider = new JButton("Creer ");
	JButton quitter = new JButton("Quitter");
	JButton retour = new JButton("Retour");
	JTextField userIDField = new JTextField();
	JTextField nom = new JTextField();
	JTextField username = new JTextField();
	JTextField email = new JTextField();
	JPasswordField password = new JPasswordField();
	JPasswordField password2 = new JPasswordField();
	JLabel nomlabel = new JLabel("Nom: ");
	JLabel usernamelabel = new JLabel("username: ");
	JLabel emaillabel = new JLabel("Email: ");
	JLabel passwordlabel = new JLabel("Mot de passe: ");
	JLabel passwordlabel21 = new JLabel("Confirmer le ");
	JLabel passwordlabel22 = new JLabel("mot de passe: ");
	String temoin=null;
	 String nom2; String id;
	JComboBox<String> typeCour = new JComboBox<String>();

	public CreationCompte(String temoin, String nom2, String id) {
        this.temoin = temoin;
        this.id = id;
        this.nom2 = nom2;

		ConnexionBD  connect = new ConnexionBD();
        conn = connect.connecter();
		

		nomlabel.setBounds(120, 70, 150, 25);
		nomlabel.setFont(new Font("MV Boli",Font.PLAIN,15));
		nomlabel.setForeground(Color.WHITE);
		nom.setBounds(230, 70, 170,25);
		nom.setBackground(null);
		nom.setForeground(Color.WHITE);
		
		usernamelabel.setBounds(120, 130, 150, 25);
		usernamelabel.setFont(new Font("MV Boli",Font.PLAIN,15));
		usernamelabel.setForeground(Color.WHITE);
		username.setBounds(230, 130, 170, 25);
		username.setBackground(null);
		username.setForeground(Color.WHITE);
		
		emaillabel.setBounds(120, 190, 150, 25);
		emaillabel.setFont(new Font("MV Boli",Font.PLAIN,15));
		emaillabel.setForeground(Color.WHITE);
		email.setBounds(230, 190, 170, 25);
		email.setBackground(null);
		email.setForeground(Color.WHITE);
		
		
		passwordlabel.setBounds(120, 190, 150,25);
		passwordlabel.setFont(new Font("MV Boli",Font.PLAIN,15));
		passwordlabel.setForeground(Color.WHITE);
    	password.setBounds(230,190,170, 25);
    	password.setBackground(null);
		password.setForeground(Color.WHITE);
    	
    	passwordlabel21.setBounds(120, 250, 150,25);
    	passwordlabel21.setFont(new Font("MV Boli",Font.PLAIN,15));
    	passwordlabel21.setForeground(Color.WHITE);
    	passwordlabel22.setBounds(120, 265, 150,25);
    	passwordlabel22.setFont(new Font("MV Boli",Font.PLAIN,15));
    	passwordlabel22.setForeground(Color.WHITE);
    	password2.setBounds(230,260,170, 25);
    	password2.setBackground(null);
		password2.setForeground(Color.WHITE);
		

		
		typeCour.setBounds(250,350,100,25);
		typeCour.setBackground(null);
		typeCour.addActionListener(this);
		
		String[] Profession = {"SELECT","Gestion de projet", "Technologies de XML","R�seau","S�curit�"};
		
		for(String profession: Profession) {
			typeCour.addItem(profession);
		}
		
		valider.setBounds(145, 410, 100,25);
	    valider.addActionListener(this);
     	valider.setFocusable(false);
     	valider.setBackground(new Color(40,180,99));
     	valider.setFont(new Font("MV Boli",Font.PLAIN,15));
     	valider.setForeground(Color.WHITE);
		
		quitter.setBounds(355, 410, 100,25);
		quitter.addActionListener(this);
		quitter.setFocusable(false);
		quitter.setBackground(new Color(255,102,102,255));
		quitter.setFont(new Font("MV Boli",Font.PLAIN,15));
		quitter.setForeground(Color.WHITE);
		
		retour.setBounds(355, 410, 100,25);
		retour.addActionListener(this);
		retour.setFocusable(false);
		retour.setBackground(new Color(255,102,102,255));
		retour.setFont(new Font("MV Boli",Font.PLAIN,15));
		retour.setForeground(Color.WHITE);
		
        
        frame.add(retour);
        
		frame.add(passwordlabel);
		frame.add(passwordlabel21);
		frame.add(passwordlabel22);
//		frame.add(nomlabel);
     	frame.add(password);
     	frame.add(password2);
//		frame.add(nom);
		frame.add(username);
		frame.add(usernamelabel);
//		frame.add(emaillabel);
//		frame.add(email);
		frame.add(valider);
//		frame.add(typeCour);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		frame.setSize(600, 500);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		frame.getContentPane().setBackground(new Color(52,73,94));


	}

	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	public void actionPerformed(ActionEvent e) {

		

		if(e.getSource()==valider) {
			JOptionPane.showConfirmDialog(email, "Vous voulez confirmer ", "CONFIRMATION",JOptionPane.YES_NO_OPTION);
			   String choice = null;
			   try{
		    	    if(username.getText().isEmpty()) {
		    	    	JOptionPane.showMessageDialog(null, "le champs username ne doit pas etre vide");
		    	    }
		    	    else  if(password.getText().isEmpty()) {
		    	    	JOptionPane.showMessageDialog(null, "le champs mot de passe ne doit pas etre vide");
		    	    }else if(!password.getText().equals(password2.getText())) {
		    	    	JOptionPane.showMessageDialog(null, "Les mots de passe ne corresponds pas!","ERREUR de mot de passe",JOptionPane.ERROR_MESSAGE);
		    	    }else {
		    	    
		    	    System.out.println("Creation de compte...");
		            String requete = "insert into user(username,password) values (?,?)";
		            ps = conn.prepareStatement(requete);
		            
		            ps.setString(1,username.getText());
		            ps.setString(2,password2.getText());
		            System.out.println(username.getText()+password.getText());
//		            ps.setString(3,email.getText());
//		            ps.setString(4,password2.getText());
//		            ps.setString(5,typeCour.getSelectedItem().toString());

		            
		            
		            ps.execute();
		            
		            frame.dispose();					
		            JOptionPane.showMessageDialog(null, "Vous etes un(e) nouveau(lle) utilisateur(trice)");
//		           if(temoin.equals("login")) {
		        	   LoginPage p = new LoginPage();
//		           }else {
//		        	   PageChef p = new PageChef(this.nom2,this.id);
//		           }
		                   
		           
		            
			      }
		        }catch(Exception R){
		            R.getMessage();
		        }finally{
		        
		            try{
		                ps.close();
		                rs.close();
		            }catch(Exception R){
		            R.getMessage();
		        }
		    }
			   
		}
		
		if(e.getSource()==quitter) {
			
			frame.dispose();
		}
		if(e.getSource()==retour) {
//			 PageChef sup = new PageChef(this.nom2,this.id);
			LoginPage lp = new LoginPage();
			 frame.dispose();
		 }
		
	}

}
