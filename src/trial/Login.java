package trial;

import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JButton adm, lib;

	Login() {

		adm = new JButton("ADMIN");
		adm.setBounds(180, 150, 100, 30);
		add(adm);
		adm.addActionListener(this);
		lib = new JButton("LIBRARIAN");
		lib.setBounds(180, 200, 100, 30);
		add(lib);
		lib.addActionListener(this);

		setSize(500, 500);
		setLayout(null);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == adm) {
			AdminLogin.main(new String[] {});
			dispose();
		}
		if (e.getSource() == lib) {
			LibrarianLogin.main(new String[] {});
			dispose();
		}

	}

	public static void main(String args[]) {

		new Login();
	}

}
