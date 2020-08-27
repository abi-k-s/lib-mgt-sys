package trial;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReturnBook extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JFrame f;
	JLabel sl, stid;
	JTextField sl1, stid1;
	JButton returnbook, back;

	ReturnBook() {
		f = new JFrame("Return Book");
		sl = new JLabel("Serial NO:");
		stid = new JLabel("Student ID:");
		sl1 = new JTextField();
		stid1 = new JTextField();
		returnbook = new JButton("Return Book");
		back = new JButton("Back");

		sl.setBounds(100, 150, 100, 30);
		stid.setBounds(100, 200, 100, 30);
		sl1.setBounds(250, 150, 100, 30);
		stid1.setBounds(250, 200, 100, 30);

		returnbook.setBounds(180, 250, 150, 30);
		back.setBounds(300, 300, 100, 30);
		f.add(sl);
		f.add(stid);
		f.add(sl1);
		f.add(stid1);
		f.add(returnbook);
		f.add(back);
		returnbook.addActionListener(this);
		back.addActionListener(this);

		f.setSize(500, 500);
		f.setLayout(null);
		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == returnbook) {
			if (sl1.getText().isEmpty()|| stid1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Sorry Fil all fields");
			}
			else {
			
			String sr = sl1.getText();
			int sr1 = Integer.parseInt(sr);
			String id = stid1.getText();
			int id1 = Integer.parseInt(id);
			boolean status = false;

			try {
				Connection con = MYSQL.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from issuebooks where serialno=? and stid=?");
				ps.setInt(1,sr1);
				ps.setInt(2,id1);
				ResultSet rs = ps.executeQuery();
				status = rs.next();

				if (status == false) {
					JOptionPane.showMessageDialog(this, "Sorry,Can't Return book.Check SerialNo and ID");
					
					con.close();
				} else {

				   ps = con.prepareStatement("delete from issuebooks where serialno =? and stid= ?");

					ps.setInt(1, sr1);
					ps.setInt(2, id1);
					ps.executeUpdate();

					ps = con.prepareStatement("update books set quantity= quantity+1 where slno=? ");
					ps.setInt(1, sr1);
					ps.executeUpdate();

					ps = con.prepareStatement("update books set issued= issued-1 where slno=? ");
					ps.setInt(1, sr1);
					ps.executeUpdate();

					JOptionPane.showMessageDialog(this, "Book returned successfully!");
					sl1.setText("");
					stid1.setText("");
				}
			} catch (Exception c) {
				System.out.println(c);
			}

		}}
		if (e.getSource() == back) {
			LibSection.main(new String[] {});
			f.dispose();
		}
	}

	public static void main(String[] args) {
		new ReturnBook();

	}

}
