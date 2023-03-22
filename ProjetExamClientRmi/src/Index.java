//package Gestion_des_cours;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JPanel;

public class Index implements ActionListener, MouseListener {

	
	JFrame frame = new JFrame("Index");
	JLabel welcome;
	JLabel lab1 = new JLabel();
	JLabel menulabel = new JLabel("Home");
	JLabel ajouter = new JLabel("Ajouter Service");
	JLabel deconnecter = new JLabel("Déconnexion");
	JLabel voirService = new JLabel("voir Service");

	 String nom;
	 String id;
	 String temoin="chef";
	@SuppressWarnings("unused")
	public Index(String nom, String id) {
		this.nom = nom;
		this.id = id;
		welcome = new JLabel("Bonjour "+nom);
		ImageIcon imenu = new ImageIcon("home32.png");
		
		ImageIcon iAjouter = new ImageIcon("add.png");
		ImageIcon ivoirService = new ImageIcon("user-add.png");
		ImageIcon iVoirCour = new ImageIcon("eye.png");
		ImageIcon iListCour = new ImageIcon("list.png");
	
		//   PARTI JLABEL
		
//		lab1.setIcon(imenu1);
		lab1.setHorizontalTextPosition(JLabel.CENTER);
		lab1.setVerticalTextPosition(JLabel.TOP);
		lab1.setIconTextGap(10);
		lab1.setBounds(0,0,200,380);
//		lab1.setText("test");
		lab1.setBackground(new Color(52,73,94));
		lab1.setOpaque(true);
		frame.add(lab1);
		
		
		//   PARTI JPANEL	
		
//		menulabel.setBackground(Color.blue);
//		menulabel.setHorizontalAlignment(JLabel.CENTER);
//		menulabel.setOpaque(true);
		menulabel.setBounds(0,20,200,80);
		menulabel.setIcon(imenu);
		menulabel.addMouseListener(this);
		menulabel.setFont(new Font("MV Boli",Font.PLAIN,15));
		menulabel.setForeground(Color.black);
		
//		ajouter.setBackground(Color.gray);
//		ajouter.setHorizontalAlignment(JLabel.CENTER);
//		ajouter.setOpaque(true);
		ajouter.setBounds(0,130,300,40);
		ajouter.setIcon(iAjouter);
		ajouter.addMouseListener(this);
		ajouter.setFont(new Font("MV Boli",Font.PLAIN,15));
		ajouter.setForeground(Color.black);
		
		
//		voirService.setBackground(Color.yellow);
//		voirService.setHorizontalAlignment(JLabel.CENTER);
//		voirService.setOpaque(true);
		voirService.setBounds(0,170,300,40);
		voirService.setIcon(iVoirCour);
		voirService.addMouseListener(this);
		voirService.setFont(new Font("MV Boli",Font.PLAIN,15));
		voirService.setForeground(Color.black);
		
		
//		deconnecter.setBackground(Color.gray);
//		deconnecter.setHorizontalAlignment(JLabel.CENTER);
//		deconnecter.setOpaque(true);
		deconnecter.setBounds(0,210,300,40);
//		deconnecter.setIcon(iAjouter);
		deconnecter.addMouseListener(this);
		deconnecter.setFont(new Font("MV Boli",Font.PLAIN,15));
		deconnecter.setForeground(Color.black);
		
		
		welcome.setBounds(300,150,200,50);
		welcome.setFont(new Font("MV Boli",Font.PLAIN,15));
		welcome.setForeground(Color.black);
		
		lab1.add(menulabel);
		lab1.add(ajouter);
		lab1.add(voirService);
		lab1.add(deconnecter);

		
		frame.add(welcome);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		frame.setSize(500, 420);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	    
		frame.getContentPane().setBackground(new Color(40,55,71));
	}

	@SuppressWarnings("unused")
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getSource()==ajouter){
		frame.dispose();
		AjouterService add = new AjouterService(this.temoin,this.nom,this.id);
//		AjouterCours ajouterCours = new AjouterCours(this.nom, this.id);
			
		}
		if (e.getSource()==voirService){
			frame.dispose();
//			CreationCompte xml = new CreationCompte(this.temoin,this.nom, this.id);
			VoirService voir = new VoirService(this.nom, this.id,this.temoin);
			
		}
		
		if (e.getSource()==deconnecter){
			frame.dispose();
//			CreationCompte xml = new CreationCompte(this.temoin,this.nom, this.id);
			LoginPage lp = new LoginPage();
			
		}

	} 

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

		if (e.getSource()==ajouter){
			ajouter.setBackground(new Color(255,102,102,255));
			ajouter.setOpaque(true);
			ajouter.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
		}
		if (e.getSource()==voirService){
			voirService.setBackground(new Color(255,102,102,255));
			voirService.setOpaque(true);
			voirService.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
		}
		if (e.getSource()==deconnecter){
			deconnecter.setBackground(new Color(255,102,102,255));
			deconnecter.setOpaque(true);
			deconnecter.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
		}
//		if (e.getSource()==listCour){
//			listCour.setBackground(new Color(255,102,102,255));
//			listCour.setOpaque(true);
//			listCour.setCursor(new Cursor(Cursor.HAND_CURSOR));
//			
//		}
}


	@Override
	public void mouseExited(MouseEvent e) {

		if (e.getSource()==ajouter){
			ajouter.setBackground(null);
			ajouter.setOpaque(true);
			ajouter.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
		}
		if (e.getSource()==voirService){
			voirService.setBackground(null);
			voirService.setOpaque(true);
			voirService.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
		}
		if (e.getSource()==deconnecter){
			deconnecter.setBackground(null);
			deconnecter.setOpaque(true);
			deconnecter.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
		}
//		if (e.getSource()==listCour){
//			listCour.setBackground(null);
//			listCour.setOpaque(true);
//			listCour.setCursor(new Cursor(Cursor.HAND_CURSOR));
//			
//}

}

	@Override
	public void actionPerformed(ActionEvent e) {

		
	}
}
