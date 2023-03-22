//package Gestion_des_cours;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.ConnexionBD;

public class LoginPage implements ActionListener, MouseListener {

	JFrame frame = new JFrame("Bienvenue, veuillez-vous connecter");
	JButton loginButton = new JButton("Connecter");
	JTextField email = new JTextField();
	JPasswordField password = new JPasswordField();
	JLabel emaillabel = new JLabel("Login: ");
	JLabel passwordlabel = new JLabel("Password: ");
	JCheckBox checkBox = new JCheckBox("Voir mot de passe");
	JLabel creerCompte = new JLabel("Creer un Compte");
	JLabel effacer = new JLabel("Effacer?");
	String temoin="login";
	
	Connection conn = null;
    ResultSet rs ;
    PreparedStatement ps = null;
	

	
	public LoginPage() {
	
		
		
		ConnexionBD  connect = new ConnexionBD();
        conn = connect.connecter();
		
		emaillabel.setBounds(50, 100, 125,25);
		emaillabel.setFont(new Font("MV Boli",Font.PLAIN,15));
		emaillabel.setForeground(Color.WHITE);
		emaillabel.addMouseListener(this);
		passwordlabel.setBounds(50, 150, 125,25);
		passwordlabel.setFont(new Font("MV Boli",Font.PLAIN,15));
		passwordlabel.setForeground(Color.WHITE);
		
		
		email.setBounds(155,100,200, 30);
		email.setBackground(null);
		email.setForeground(Color.WHITE);
		email.addMouseListener(this);
		password.setBounds(155,150,200, 30);
		password.addMouseListener(this);
		password.setBackground(null);
		password.setForeground(Color.WHITE);
		
		
		loginButton.setBounds(180, 290, 120,25);
		loginButton.addActionListener(this);
		loginButton.setFocusable(false);
		loginButton.setBackground(new Color(255,102,102,255));
		loginButton.setFont(new Font("MV Boli",Font.PLAIN,15));
		loginButton.setForeground(Color.WHITE);
		
		checkBox.setBounds(155,200,200,25);
		checkBox.addActionListener(this);
		checkBox.setBackground(null);
		checkBox.setFont(new Font("MV Boli",Font.PLAIN,15));
		checkBox.setForeground(Color.WHITE);
		
		creerCompte.setBounds(180, 250, 225,25);
     	creerCompte.setFont(new Font("MV Boli",Font.PLAIN,15));
     	creerCompte.setForeground(new Color(151,154,125));
     	creerCompte.addMouseListener(this);
     	
     	effacer.setBounds(300, 180, 125,25);
     	effacer.addMouseListener(this);
     	effacer.setFont(new Font("MV Boli",Font.PLAIN,15));
     	effacer.setForeground(new Color(217,136,128));
     	
		frame.add(emaillabel);
		frame.add(passwordlabel);
		frame.add(email);
		frame.add(password);
		frame.add(loginButton);
		frame.add(checkBox);
		frame.add(creerCompte);
		frame.add(effacer);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		frame.setSize(500, 420);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	
		frame.getContentPane().setBackground(new Color(52,73,94));
	}

	
	@SuppressWarnings({  "deprecation" })
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String userlogin = email.getText();
		String userpassword  = password.getText();
		
		if(e.getSource()==loginButton) {
			
			if(userlogin.isEmpty()) {
    	    	JOptionPane.showMessageDialog(null, "le champs login ne doit pas etre vide","Veillez remplir les champs",JOptionPane.WARNING_MESSAGE);
    	    }
    	    else if(userpassword.isEmpty()) {
    	    	JOptionPane.showMessageDialog(null, "le champs de mot de passe ne doit pas etre vide","Veillez remplir les champs",JOptionPane.WARNING_MESSAGE);
    	    }
    	    else {
    	    	
    	    	userLogin(userlogin, userpassword);
	            
    	    }
			
		}
		
			if(checkBox.isSelected()) {
				password.setEchoChar((char)0);
			}else {
				password.setEchoChar('\u25cf');
			}
		
	}


	@SuppressWarnings("unused")
	private void userLogin(String userlogin, String userpassword) {


        try {
        	String profession = "etudiant" ;
        	String nom = null;
        	String id = null;
        	String requete = "select * from user where username = ? and  password = ? ";
        	ps = conn.prepareStatement(requete);
            ps.setString(1, userlogin);
            ps.setString(2, userpassword);
            
        	
            rs = ps.executeQuery();

            if(rs.next()) {
            	
            	nom = rs.getString(2);
            	id = String.valueOf(rs.getInt(1));
//                profession = rs.getString(7);
                frame.dispose();
                // tester pour voir l'etat du profession
                Index index = new Index(nom, id);
//                JOptionPane.showMessageDialog(null, "Bienvenue "+nom,"connexion reussi",JOptionPane.WARNING_MESSAGE);
//                if(profession.equalsIgnoreCase("ChefDepartement")) {
////                      PageChef pageChefDepartement = new PageChef(nom,id);
//                }
               
//                if(profession.equalsIgnoreCase("Professeur")) {
////                    PageProfesseur pageProfesseur = new PageProfesseur(nom,id,temoin);
//              }

            } else {
            	JOptionPane.showMessageDialog(null, "Login ou mot de passe incorrect!","ERREUR de connexion",JOptionPane.ERROR_MESSAGE);
            	password.setText("");
            	frame.dispose();
            	frame.setVisible(true);
            } 
          
            
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

  



	@Override
	public void mousePressed(MouseEvent e) {

		if (e.getSource()==email){
			email.setBounds(140,100,250, 30);
		}
		if (e.getSource()==password){
			password.setBounds(140,150,250, 30);
		}
		if (e.getSource()==creerCompte){
			creerCompte.setForeground(Color.BLUE);
			
			frame.dispose();
			@SuppressWarnings("unused")
			CreationCompte creationCompte = new CreationCompte(temoin,null, null);
	
				
			}
                            
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {

		if (e.getSource()==creerCompte){
			creerCompte.setForeground(Color.BLUE);
			creerCompte.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
		}
		
		if(e.getSource()==effacer) {
			effacer.setForeground(Color.red);
		} 
	}


	@Override
	public void mouseExited(MouseEvent e) {
	
		if (e.getSource()==creerCompte){
			creerCompte.setForeground(Color.white);}
		if(e.getSource()==effacer) {
			effacer.setForeground(new Color(217,136,128));
		} 
		if (e.getSource()==email){
			email.setBounds(155,100,200, 30);
		}
		if (e.getSource()==password){
			password.setBounds(155,150,200, 30);
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {

		
		if(e.getSource()==effacer) {
			email.setText("");
			password.setText("");
		} 
		
	}


	
}
