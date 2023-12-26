package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Toolkit;

/**
 * Notes:
 * interface utilisateur sans aucune actions.
 * @author Abid Siwar
 *
 */
public class SignIn extends JFrame {

	private JPanel contentPane;
	private JTextField zTextNomUser;
	private JPasswordField zPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignIn() {
		setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		setBounds(new Rectangle(50, 50, 50, 50));
		setBackground(new Color(0, 255, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1055, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(225, 254, 209));
		contentPane.setForeground(new Color(128, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Connexion");
		title.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 19));
		title.setBounds(410, 62, 195, 48);
		contentPane.add(title);
		
		JLabel icoTitle = new JLabel("");
		icoTitle.setIcon(new ImageIcon("C:\\Users\\abids\\Downloads\\Mon projet-modified.png"));
		icoTitle.setBounds(348, 62, 67, 48);
		contentPane.add(icoTitle);
		
		JLabel nomUtilisateur = new JLabel("Nom du utilisateur :");
		nomUtilisateur.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		nomUtilisateur.setBounds(216, 173, 218, 13);
		contentPane.add(nomUtilisateur);
		
		zTextNomUser = new JTextField();
		zTextNomUser.setBounds(426, 173, 179, 19);
		contentPane.add(zTextNomUser);
		zTextNomUser.setColumns(10);
		
		JLabel motDePasse = new JLabel("Mot de passe :");
		motDePasse.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		motDePasse.setBounds(216, 231, 162, 24);
		contentPane.add(motDePasse);
		
		zPassword = new JPasswordField();
		zPassword.setBounds(426, 231, 179, 19);
		contentPane.add(zPassword);
		
		JButton bConnecter = new JButton("Se connecter");
		bConnecter.setFont(new Font("SimSun-ExtB", Font.BOLD, 14));
		bConnecter.setBounds(184, 332, 149, 62);
		contentPane.add(bConnecter);
		
		JButton bInsecrire = new JButton("S'inscrire");
		bInsecrire.setFont(new Font("SimSun-ExtB", Font.BOLD, 14));
		bInsecrire.setBounds(410, 332, 126, 62);
		contentPane.add(bInsecrire);
		
		JButton bQuitter = new JButton("Quitter");
		bQuitter.setFont(new Font("SimSun-ExtB", Font.BOLD, 14));
		bQuitter.setBounds(634, 332, 126, 62);
		contentPane.add(bQuitter);
		
		JCheckBox memoriseBox = new JCheckBox("Mémoriser le nom du utilisateur");
		memoriseBox.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 10));
		memoriseBox.setBounds(494, 270, 218, 21);
		contentPane.add(memoriseBox);
	}
}
