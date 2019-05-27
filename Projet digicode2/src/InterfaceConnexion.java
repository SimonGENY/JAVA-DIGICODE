import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class InterfaceConnexion extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	JPanel panelHaut, panelBas, panelGauche, panelDroite, panelCentre, panelConnexion;
	
	JLabel login = new JLabel("Login");
	JLabel pswd = new JLabel("Mot de passe");
	JButton valider = new JButton("Valider");
	JButton annuler = new JButton("Annuler");
	
	private JTextField log, motdepasse;
	private ListeSalles ListeSalles;
	    
	    public InterfaceConnexion() {
	
	super();
	
	/*Initialisation du JFrame*/
	this.setSize (new Dimension (600,400));
	//On ne pourra pas agrandir la fenetre intitulée.
	this.setResizable (false);
	
	/*Récupération du ContentPane*/
	Container contenu = this.getContentPane();
	
	/*Création des JPanel avec leur Layout Manager*/
	panelHaut = new JPanel(new GridLayout (1,1));
	panelBas = new JPanel(new GridLayout (1,1));
	panelGauche = new JPanel(new GridLayout (1,1));
	panelDroite = new JPanel(new GridLayout (1,1));
	panelCentre = new JPanel(new GridLayout (0,1));
	panelConnexion = new JPanel();
	
	/*Ajout des panneaux au ContentPane*/
	    contenu.add(panelHaut, BorderLayout.NORTH);
	    contenu.add(panelBas, BorderLayout.SOUTH);
	    contenu.add(panelGauche, BorderLayout.EAST);
	    contenu.add(panelDroite, BorderLayout.WEST);
	    contenu.add(panelCentre, BorderLayout.CENTER);
	
	    /*Ajout du formulaire de connexion à panelCentre*/
	    panelCentre.setBorder(new TitledBorder("Connexion"));
	    panelCentre.add(panelConnexion);
	    
	    panelCentre.add(login);
	    log = new JTextField();
	    panelCentre.add(log);
	    
	    panelCentre.add(pswd);
	    motdepasse = new JTextField();
	    panelCentre.add(motdepasse);
	    
	    panelCentre.add(valider);
	    valider.addActionListener(this);
	    
	   
	    //panelCentre.add(annuler);
	    //annuler.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    /*Ajout du texte de panelConnexion*/
	    panelConnexion.add(new JLabel ("CONNEXION"));
	}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String login = log.getText();
	        String mdp = motdepasse.getText();
	        
	        ArrayList<User> users = new ArrayList<User>();
	        Base c = new Base();
	        
	            boolean userFound = c.verifUser(login,mdp);
	            boolean userAdmin = c.verifAdmin(login,mdp);
	            
				if(userFound) {
					
					if(userAdmin) {
						//InterfaceInscription in = new InterfaceInscription();
						//in.setVisible(true);
						
						AdminPannel ic = new AdminPannel();
						ic.setVisible(true);
					} else {
						
						// L'user se connecte on remplis la table connexion avec lheure du log //
						
						Base c1 = new Base();
						
						String query = "insert into connexion values (null,'login',NOW(),'')";
						ResultSet r = c1.executeRequete(query);
						
				
						ListeSalles ic = new ListeSalles();
						ic.setVisible(true);
					}

				} else {
					JOptionPane.showMessageDialog(null,"user found not ok", "Error", JOptionPane.ERROR_MESSAGE);			
				}
	            
		}
			
		}
		
	
	
	
	

