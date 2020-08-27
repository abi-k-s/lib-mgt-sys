package trial;

import javax.swing.*;

import java.awt.event.*;
import java.sql.*;

;

public class AddLib extends JFrame implements ActionListener {
	private static final long serialVersionUID=1L;

	JFrame f;
	JLabel id, name, email, pass, phno;
	JPasswordField p;
	JTextField l1, l2, l3, l4;
	JButton add, back;

	AddLib() {

		f = new JFrame("ADD LIBRARIAN");
		id = new JLabel("ID");
		name = new JLabel("Name");
		pass = new JLabel("Password");
		email = new JLabel("Email");
		phno = new JLabel("PhoneNo");

		l1 = new JTextField();
		l2 = new JTextField();
		l3 = new JTextField();
		l4 = new JTextField();
		p = new JPasswordField();

		id.setBounds(100, 100, 100, 30);
		name.setBounds(100, 150, 100, 30);
		pass.setBounds(100, 200, 100, 30);
		email.setBounds(100, 250, 100, 30);
		phno.setBounds(100, 300, 100, 30);

		l1.setBounds(250, 100, 100, 30);
		l2.setBounds(250, 150, 100, 30);
		p.setBounds(250, 200, 100, 30);
		l3.setBounds(250, 250, 100, 30);
		l4.setBounds(250, 300, 100, 30);

		add = new JButton("ADD LIBRARIAN");
		back = new JButton("Back");

		add.setBounds(180, 350, 150, 30);
		back.setBounds(300, 400, 100, 30);

		add.addActionListener(this);
		back.addActionListener(this);

		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(p);
		f.add(add);
		f.add(back);
		f.add(id);
		f.add(name);
		f.add(pass);
		f.add(email);
		f.add(phno);
		f.setSize(500, 500);
		f.setLayout(null);
		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			if(l1.getText().equals("")||l2.getText().equals("")||l3.getText().equals("")|| l4.getText().equals("")||p.getPassword().equals(null)) {
				JOptionPane.showMessageDialog(this, "Something went wrong..Fill all fileds");
				

			}
			else {

			String lid = String.valueOf(l1.getText());
			int lidd = Integer.parseInt(lid);
			String l22 = l2.getText();
			String lp = String.valueOf(p.getPassword());
			String l23 = l3.getText();
			String l24 = l4.getText();
			try {
				
				Connection con = MYSQL.getConnection();
				PreparedStatement ps = con.prepareStatement("insert into librarian values(?,?,?,?,?)");

				ps.setInt(1, lidd);
				ps.setString(2, l22);
				ps.setString(3, lp);
				ps.setString(4, l23);
				ps.setString(5, l24);
				ps.executeUpdate();

				con.close();

			} catch (Exception c) {
				System.out.println(c);
			}

			JOptionPane.showMessageDialog(this, "Librarian added successfully!");

			l1.setText("");
			l2.setText("");
			p.setText("");
			l3.setText("");
			l4.setText("");

		}}
		if (e.getSource() == back) {
			AdminSection.main(new String[] {});
			f.dispose();
		}

	}

	public static void main(String ags[]) {
		new AddLib();
		
	}
}
