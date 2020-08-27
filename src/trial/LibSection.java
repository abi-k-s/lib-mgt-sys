package trial;
import javax.swing.*;
import java.awt.event.*;


public class LibSection extends JFrame implements ActionListener {
	private static final long serialVersionUID=1L;

	JFrame f;
	JButton adb,vib,isb,viewib,rtb,lo;
	LibSection(){
		f=new JFrame("Librarian Section");
		adb = new JButton("Add Books");
		vib = new JButton("View Books");
		isb = new JButton("Issue Books");
		viewib = new JButton("View Issued Books");
		rtb = new JButton("Return Book");
		lo= new JButton("Logout");
		adb.setBounds(150, 100, 200, 30);
		vib.setBounds(150, 150, 200, 30);
		isb.setBounds(150, 200, 200, 30);
		viewib.setBounds(150, 250, 200, 30);
		rtb.setBounds(150, 300, 200, 30);
		lo.setBounds(150, 350, 200, 30);
		f.add(adb);f.add(vib);f.add(isb);f.add(viewib);f.add(rtb);f.add(lo);
		adb.addActionListener(this);
		vib.addActionListener(this);
		isb.addActionListener(this);
		viewib.addActionListener(this);
		rtb.addActionListener(this);
		lo.addActionListener(this);
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==adb) {
			AddBooks.main(new String[] {});
			f.dispose();
		}
		if(e.getSource()==vib) {
			ViewBooks.main(new String[] {});
			
		}
		if(e.getSource()==isb) {
			IssueBooks.main(new String[] {});
		}
		if(e.getSource()==viewib) {
			ViewIssuedBooks.main(new String[] {});
		}
		if(e.getSource()==rtb) {
	        ReturnBook.main(new String[] {});
	        f.dispose();
		}
		if(e.getSource()==lo) {
			f.dispose();
	
		}

		
	}
	

	public static void main(String[] args) {
		new LibSection();

	}

}
