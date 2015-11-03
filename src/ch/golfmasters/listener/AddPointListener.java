package ch.golfmasters.listener;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ch.golfmasters.model.Runde;
import ch.golfmasters.model.Spiel;
import ch.golfmasters.model.Spieler;

/**
 * ActionListener um Punkte in Punkte Array hinzuzufügen
 * @author Chiramed Phong Penglerd, Elia Perenzin
 * @version 0.5
 *
 */
public class AddPointListener implements ActionListener {

	private Spiel spiel;
	private JTextField punkte;
	private int spielerListNr;
	private JTextArea textArea;
	private Runde runde;
	private JTextField nachname;
	private JTextField vorname;
	private JButton add;
	private JButton next;
	private JButton end;

	/**
	 * Konstruktor der Klasse AddPointListener
	 * @param spiel
	 * @param punkte
	 * @param spielerListNr
	 * @param textArea
	 * @param runde
	 * @param nachnameText
	 * @param vornameText
	 * @param add
	 * @param next
	 * @param end
	 */
	public AddPointListener(Spiel spiel, JTextField punkte, int spielerListNr,
			JTextArea textArea, Runde runde, JTextField nachnameText,
			JTextField vornameText, JButton add, JButton next, JButton end) {
		this.spiel = spiel;
		this.punkte = punkte;
		this.spielerListNr = spielerListNr;
		this.textArea = textArea;
		this.runde = runde;
		this.nachname = nachnameText;
		this.vorname = vornameText;
		this.add = add;
		this.next = next;
		this.end = end;
	}

	//ToDo
	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Spieler> spielern = spiel.getSpielern();
		if(checkInput(punkte.getText())){
			this.runde.getPunkte().put(spielern.get(spielerListNr).getSpielerNr(),Integer.parseInt(punkte.getText()));
	
			String currentText = textArea.getText();
			String newText = currentText + "\nNr: "
					+ spielern.get(spielerListNr).getSpielerNr() + "  Name: "
					+ this.nachname.getText() + "  Vorname: "
					+ this.vorname.getText() + "  Punkte: " + this.punkte.getText();
			textArea.setText(newText);
			punkte.setText("");
	
			if (spiel.getSpielern().size() == spielerListNr + 1) {
				end.setEnabled(true);
				next.setEnabled(true);
				add.setEnabled(false);
				spiel.getRunden().add(runde);
	
			} else if (spiel.getSpielern().size() != spielerListNr + 1) {
				nachname.setText(spielern.get(spielerListNr + 1).getName());
				vorname.setText(spielern.get(spielerListNr + 1).getVorname());
	
				this.spielerListNr = this.spielerListNr + 1;
			}
		}
	}
	
	public boolean checkInput(String input){
		int inputInt = 0;
		try{
			inputInt = Integer.parseInt(input);
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Eingabe ist keine Zahl","Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if(inputInt <= 7 && inputInt > 0){
			return true;
		}else{
			JOptionPane.showMessageDialog(null, "Die Zahl ist ung�ltig","Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

}
