import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class AdminPannel extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	JPanel panelHaut, panelBas, panelGauche, panelDroite, panelCentre, panelAdmin;
	
	JLabel Debut = new JLabel("Debut");
	JLabel Fin = new JLabel("Fin");
	JButton valider = new JButton("Valider");
	
	private JTextField heured, heuref;
	//private ListeSalles ListeConnexions;
	    
	    public AdminPannel() {
	
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
	panelAdmin = new JPanel();
	
	/*Ajout des panneaux au ContentPane*/
	    contenu.add(panelHaut, BorderLayout.NORTH);
	    contenu.add(panelBas, BorderLayout.SOUTH);
	    contenu.add(panelGauche, BorderLayout.EAST);
	    contenu.add(panelDroite, BorderLayout.WEST);
	    contenu.add(panelCentre, BorderLayout.CENTER);
	
	    /*Ajout du formulaire de connexion à panelCentre*/
	    panelCentre.setBorder(new TitledBorder("Administrator Pannel"));
	    panelCentre.add(panelAdmin);
	    
	    panelCentre.add(Debut);
	    heured = new JTextField();
	    panelCentre.add(heured);
	    
	    panelCentre.add(Fin);
	    heuref = new JTextField();
	    panelCentre.add(heuref);
	    
	    panelCentre.add(valider);
	    valider.addActionListener(this);
	    
	   
	    //panelCentre.add(annuler);
	    //annuler.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    /*Ajout du texte de panelConnexion*/
	    panelAdmin.add(new JLabel ("ADMIN"));
	}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String deb = Debut.getText();
	        String fin = Fin.getText();
	        
	        //ArrayList<User> users = new ArrayList<User>();
	        Base c = new Base();
	        
	            boolean userLog = c.verifLog(deb, fin);
	            //boolean userAdmin = c.verifAdmin(login,mdp);
	            
				if(userLog) {
					
					 ///// CREER LISTE DES CONNEXION /////
					
					//AdminPannel = new ListeLog

				} else {
					JOptionPane.showMessageDialog(null,"user found not ok", "Error", JOptionPane.ERROR_MESSAGE);			
				}
	            
		}
			
		}
		
	
	
	
	

