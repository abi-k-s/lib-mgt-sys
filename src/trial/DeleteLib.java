package trial;

import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteLib extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JFrame f;
	JLabel l;
	JTextField t;
	JButton d, b;

	DeleteLib() {
		f = new JFrame("DELETE LIBRARIAN");
		l = new JLabel("Enter ID");
		t = new JTextField();
		d = new JButton("Delete");
		b = new JButton("Back");
		l.setBounds(100, 100, 100, 30);
		t.setBounds(200, 100, 100, 25);
		d.setBounds(150, 150, 100, 20);
		b.setBounds(250, 200, 100, 15);
		f.add(l);
		f.add(t);
		f.add(d);
		f.add(b);
		f.setSize(500, 500);
		f.setLayout(null);
		f.setVisible(true);
		d.addActionListener(this);
		b.addActionListener(this);
		


	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == d) {
			if (t.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "ID can't be blank");
			}
			else 
			{

			String delete = t.getText();
			int del = Integer.parseInt(delete);
			int i = 0;
			try {
				
				Connection con =MYSQL.getConnection();
				PreparedStatement ps = con.prepareStatement("delete from librarian where id=?");
				ps.setInt(1, del);

				i = ps.executeUpdate();
				con.close();

			
			
			 if (i > 0) {
				JOptionPane.showMessageDialog(this, "Record deleted successfully");
			} else  {
				JOptionPane.showMessageDialog(this, " Unable to delete given id!Check ID");
				t.setText("");
			}
		} catch (Exception c) {
			System.out.println(c);
		}
		}}
		if (e.getSource() == b) {
			AdminSection.main(new String[] {});
			f.dispose();
		}
	}

	public static void main(String[] args) {
		new DeleteLib();

	}

}
