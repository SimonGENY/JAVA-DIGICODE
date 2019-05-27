import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ListeSalles extends JFrame  {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> comboBox;
	private AfficheSalle listeSalles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeSalles ic = new ListeSalles();
					ic.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ArrayList<Salle> alimJCombo()
	{
		Base c = new Base();
		
		ArrayList<Salle> liste = new ArrayList<Salle>();
		ResultSet res = c.executeRequete("select * from salle");
		
		try{
		while(res.next())
		{
			//System.out.println(res.getInt(1)+" "+ res.getString(2)+" "+ res.getString(3)+" "+ res.getString(4)+" "+ res.getString(5)+" "+ res.getString(6));
						//res.getString(3),res.getInt(4),res.getString(5), res.getInt(6));
			Salle sal = new Salle(res.getInt(1), res.getString(2), res.getString(3),res.getString(4),res.getInt(5), res.getInt(6));
			//Salle sal = new Salle(1, "test", "test", 2, "test3", 3);
			liste.add(sal);
			System.out.println(sal);
		}
		
		return liste;
		}catch(Exception e){System.out.println(e.getMessage());return null;}
		
	}
	
	/**
	 * Create the frame.
	 */
	public ListeSalles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Liste des Salles");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblNewLabel.setBounds(115, 11, 207, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Selectionnez : ");
		lblNewLabel_1.setBounds(77, 96, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox(alimJCombo().toArray());
		
		comboBox.setBounds(176, 93, 217, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Afficher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Salle s = (Salle)comboBox.getSelectedItem();
				//JOptionPane.showMessageDialog(null, sal.toString());
				listeSalles = new AfficheSalle(s);
				
			}
		});
		btnNewButton.setBounds(165, 174, 89, 23);
		contentPane.add(btnNewButton);
	}
}
