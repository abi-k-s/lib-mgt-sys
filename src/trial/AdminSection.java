package trial;

import javax.swing.*;
import java.awt.event.*;


public class AdminSection extends JFrame implements ActionListener {
	JButton add, view, delete, logout;
	private static final long serialVersionUID=1L;

	AdminSection() {
		add = new JButton("Add Librarian");
		view = new JButton("View");
		delete = new JButton("Delete");
		logout = new JButton("Logout");
		add.setBounds(180, 150, 110, 30);
		view.setBounds(180, 200, 110, 30);
		delete.setBounds(180, 250, 110, 30);
		logout.setBounds(180, 300, 110, 30);
		setSize(500, 500);
		setLayout(null);
		setVisible(true);
		add(add);
		add(view);
		add(delete);
		add(logout);
		add.addActionListener(this);
		view.addActionListener(this);
		delete.addActionListener(this);
		logout.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			AddLib.main(new String[] {});
			dispose();

		}
		if (e.getSource() == view) {
			ViewLib.main(new String[] {});
			
		}
		if (e.getSource() == delete) {
			DeleteLib.main(new String[] {});
			dispose();
		}
		if (e.getSource() == logout) {
			dispose();

		}
	}

	public static void main(String args[]) {
		new AdminSection();
	}

}
