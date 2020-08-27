package trial;

import javax.swing.*;
import java.awt.event.*;

public class LOGIN extends JFrame implements ActionListener {
	private static final long serialVersionUID=1L;

	JButton adm, lib;
	JLabel l;

	LOGIN() {

		adm = new JButton("ADMIN");
		adm.setBounds(180, 150, 100, 30);
		lib = new JButton("LIBRARIAN");
		lib.setBounds(180, 200, 100, 30);
		add(lib);
		add(adm);
		l = new JLabel();
		l.setBounds(180, 250, 100, 30);

		add(l);

		setSize(500, 500);
		setLayout(null);
		setVisible(true);
		adm.addActionListener(this);
		lib.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == adm) {
			AdminLogin.main(new String[]{});
			dispose();
		}
        if (e.getSource() ==lib){
			LibrarianLogin.main(new String[] {});
			dispose();
		}

	}

	public static void main(String args[]) {
		
		new LOGIN();
	}

}
