import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class AfficheSalle extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficheSalle ic;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AfficheSalle(Salle s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Salle N° " + s.getId() + " : " );
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		lblNewLabel.setBounds(30, 10, 220, 15);
		contentPane.add(lblNewLabel);
		
		JLabel nom = new JLabel("Nom de le salle : " + s.getNom());
		nom.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		nom.setBounds(30, 40, 220, 15);
		contentPane.add(nom);
		
		JLabel prenom = new JLabel("Code de la salle : " + s.getDigicode());
		prenom.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		prenom.setBounds(30, 70, 220, 15);
		contentPane.add(prenom);
		
		JLabel specialite = new JLabel("Type de salle : " + s.getType());
		specialite.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		specialite.setBounds(30, 100, 220, 15);
		contentPane.add(specialite);
		
		JLabel service = new JLabel("Adresse : " + s.getAdresse());
		service.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		service.setBounds(30, 130, 220, 15);
		contentPane.add(service);
		
		JLabel label_2 = new JLabel("Etage : " + s.getEtage());
		label_2.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		label_2.setBounds(30, 220, 220, 15);
		contentPane.add(label_2);
		setVisible(true);
	}
}
