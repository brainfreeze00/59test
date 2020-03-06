package book.chap07;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BacteriaFrame extends JFrame {
	
	String cols[] = {"미생물단백질","미생물지방"};
	String data[][] = new String[0][2];
	DefaultTableModel   dtm_bacteria = new DefaultTableModel(data, cols);
	JTable jtb_book = new JTable(dtm_bacteria);
	JScrollPane jsp_book = new JScrollPane(jtb_book);
	
	public BacteriaFrame() {
		//어레이 리스트 ecoli
		ArrayList<ecoli> gramnegative = new ArrayList<ecoli>();
		ecoli e = new ecoli();
		e.e_protein = "beta-lactamase";
		e.e_lipid = "Lipopolysaccharide";
		gramnegative.add(e);
		e = new ecoli();
		e.e_protein = "Ribosome";
		e.e_lipid = "CellMembrane";
		gramnegative.add(e);
		System.out.println("size : " + gramnegative.size());
		Vector<String> v = new Vector<String>();
		v.add(gramnegative.get(0).e_protein);
		v.add(gramnegative.get(0).e_lipid);
		dtm_bacteria.addRow(v);
		v = new Vector<String>();
		v.add(gramnegative.get(1).e_protein);
		v.add(gramnegative.get(1).e_lipid);
		dtm_bacteria.addRow(v);
		this.add("Center", jsp_book);
		this.setVisible(true);
		this.setSize(500, 400);
	}
	
	public static void main(String[] args) {
		new BacteriaFrame();
	}

}
