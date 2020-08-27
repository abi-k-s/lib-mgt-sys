package trial;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IssueBooks extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JFrame f;
	JLabel slno, stid, stname, stphno;
	JTextField slno1, stid1, stname1, stphno1;
	JButton issueb, back;

	IssueBooks() {
		f = new JFrame("ISSUE BOOK");
		slno = new JLabel("Serial NO:");
		stid = new JLabel("Student ID");
		stname = new JLabel("Student Name");
		stphno = new JLabel("Phone no");

		slno1 = new JTextField();
		stid1 = new JTextField();
		stname1 = new JTextField();
		stphno1 = new JTextField();

		slno.setBounds(100, 100, 100, 30);
		stid.setBounds(100, 150, 100, 30);
		stname.setBounds(100, 200, 100, 30);
		stphno.setBounds(100, 250, 100, 30);

		slno1.setBounds(250, 100, 100, 30);
		stid1.setBounds(250, 150, 100, 30);
		stname1.setBounds(250, 200, 100, 30);
		stphno1.setBounds(250, 250, 100, 30);

		issueb = new JButton("Issue Book");
		back = new JButton("Back");

		issueb.setBounds(180, 300, 100, 30);
		back.setBounds(300, 350, 100, 30);

		f.add(slno);
		f.add(stid);
		f.add(stname);
		f.add(stphno);
		f.add(slno1);
		f.add(stid1);
		f.add(stname1);
		f.add(stphno1);
		f.add(issueb);
		f.add(back);
		issueb.addActionListener(this);
		back.addActionListener(this);

		f.setSize(500, 500);
		f.setLayout(null);
		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == issueb) {
			boolean status = false;
			String slnol = slno1.getText();
			int slnol1 = Integer.parseInt(slnol);
			String stidl = String.valueOf(stid1.getText());
			int stidl1 = Integer.parseInt(stidl);
			String stnamel = stname1.getText();
			String stphnol = stphno1.getText();

			try {

				Connection con = MYSQL.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from books where slno=?");
				ps.setInt(1, slnol1);
				ResultSet rs = ps.executeQuery();
				status = rs.next();
				if (status == false) {
					JOptionPane.showMessageDialog(this, "Sorry, SerialNo doesn't exist!");
					LibSection.main(new String[] {});
					f.dispose();
					con.close();
				} else {
					boolean check2 = false;
					ps = con.prepareStatement("select * from books where slno=? and quantity=0");
					ps.setInt(1, slnol1);

					rs = ps.executeQuery();
					check2 = rs.next();
					if (check2 == true) {
						JOptionPane.showMessageDialog(this, " This Book is not available right now!");
						LibSection.main(new String[] {});
						f.dispose();
						con.close();

					} else {

						ps = con.prepareStatement(
								"insert into issuebooks(serialno,stid,stname,stphno) values(?,?,?,?)");

						ps.setInt(1, slnol1);
						ps.setInt(2, stidl1);
						ps.setString(3, stnamel);
						ps.setString(4, stphnol);

						ps.executeUpdate();
						ps = con.prepareStatement("update books set quantity= quantity-1 where slno=? ");
						ps.setInt(1, slnol1);
						ps.executeUpdate();
						ps = con.prepareStatement("update books set issued= issued+1 where slno=? ");
						ps.setInt(1, slnol1);

						ps.executeUpdate();

						JOptionPane.showMessageDialog(this, "Book issued successfully!");
						slno1.setText("");
						stid1.setText("");
						stname1.setText("");
						stphno1.setText("");

					}
				}
			} catch (Exception c) {
				System.out.println(c);

			}
		}

		if (e.getSource() == back) {
			LibSection.main(new String[] {});
			f.dispose();
		}
	}

	public static void main(String[] args) {
		new IssueBooks();

	}

}
