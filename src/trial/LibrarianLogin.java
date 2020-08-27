package trial;

import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LibrarianLogin extends JFrame implements ActionListener {
	private static final long serialVersionUID=1L;
	JFrame f;

	JLabel l1, l2;
	JTextField t;
	JPasswordField p;
	JButton l;
	
	LibrarianLogin() {
		f=new JFrame("Librarian LOgin");
		l1 = new JLabel("ENTER NAME");
		l2 = new JLabel("ENTER PASSWORD");
		t = new JTextField();
		p = new JPasswordField();
		l = new JButton("LOGIN");
		l1.setBounds(100, 150, 100, 30);
		l2.setBounds(100, 200, 200, 30);
		t.setBounds(250, 150, 100, 30);
		p.setBounds(250, 200, 100, 30);
		l.setBounds(180, 250, 100, 30);
		f.add(l1);
		f.add(l2);
		f.add(t);
		f.add(p);
		f.add(l);
		f.setSize(500, 500);
		f.setLayout(null);
		f.setVisible(true);
		l.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		String name = t.getText();
		String pass = String.valueOf(p.getPassword());
		boolean status=false;
		try {

			Connection con= MYSQL.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from librarian where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
	
			}catch (Exception x) {
				System.out.println(x);
			}
			if (status==true) {
			LibSection.main(new String[] {});
			f.dispose();
			
			}
			else {
			JOptionPane.showMessageDialog(this,"Sorry,Name or Password wrong..");
			t.setText("");
			p.setText("");
			}
		
		}

	public static void main(String[] args) {
		
		new LibrarianLogin();

	}

}
