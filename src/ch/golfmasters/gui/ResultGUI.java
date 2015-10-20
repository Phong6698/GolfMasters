package ch.golfmasters.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;

public class ResultGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultGUI frame = new ResultGUI();
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
	public ResultGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResultat = new JLabel("Resultat");
		lblResultat.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblResultat.setBackground(SystemColor.window);
		lblResultat.setBounds(22, 24, 146, 16);
		contentPane.add(lblResultat);
		
		JLabel lblGewinner = new JLabel("Rangliste");
		lblGewinner.setBounds(22, 52, 61, 16);
		contentPane.add(lblGewinner);
		
		table = new JTable();
		table.setBounds(22, 229, 399, -127);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(20, 222, 408, -127);
		contentPane.add(table_1);
		
		JButton btnBeenden = new JButton("Beenden");
		btnBeenden.setBounds(327, 243, 117, 29);
		contentPane.add(btnBeenden);
		
		JButton btnNeuesSpiel = new JButton("Neues Spiel");
		btnNeuesSpiel.setBounds(174, 243, 117, 29);
		contentPane.add(btnNeuesSpiel);
	}

}