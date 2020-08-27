package trial;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class AddBooks extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JFrame f;
	JLabel s, n, a, p, q;
	JTextField s1, n1, a1, p1, q1;
	JButton add, back;

	AddBooks() {
		f = new JFrame("Add Books");
		s = new JLabel("Serial No");
		n = new JLabel("Name");
		a = new JLabel("Author");
		p = new JLabel("Publisher");
		q = new JLabel("Quantity");
		add = new JButton("Add books");
		back = new JButton("Back");

		s1 = new JTextField();
		n1 = new JTextField();
		a1 = new JTextField();
		p1 = new JTextField();
		q1 = new JTextField();

		s.setBounds(100, 100, 100, 20);
		n.setBounds(100, 150, 100, 20);
		a.setBounds(100, 200, 100, 20);
		p.setBounds(100, 250, 100, 20);
		q.setBounds(100, 300, 100, 20);

		s1.setBounds(250, 100, 100, 20);
		n1.setBounds(250, 150, 100, 20);
		a1.setBounds(250, 200, 100, 20);
		p1.setBounds(250, 250, 100, 20);
		q1.setBounds(250, 300, 100, 20);

		add.setBounds(180, 350, 150, 30);
		back.setBounds(300, 400, 100, 30);

		f.add(s);
		f.add(n);
		f.add(a);
		f.add(p);
		f.add(q);
		f.add(s1);
		f.add(n1);
		f.add(a1);
		f.add(p1);
		f.add(q1);
		f.add(add);
		f.add(back);

		add.addActionListener(this);
		back.addActionListener(this);
		f.setSize(500, 500);
		f.setLayout(null);
		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			if(s1.getText().equals("")||n1.getText().equals("")||a1.getText().equals("")|| p1.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Something went wrong..Fill all fileds");
				AddBooks.main(new String[] {});
				f.dispose();

			}
			String sl=String.valueOf(s1.getText());
			int sl1=Integer.parseInt(sl);
			String nl=n1.getText();
			String al=a1.getText();
			String pl=p1.getText();
			String ql=String.valueOf(q1.getText());
			int ql1=Integer.parseInt(ql);
			
			
			try {
				
				Connection con=MYSQL.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into books(slno,name,author,publisher,quantity) values(?,?,?,?,?)"); 
				
				ps.setInt(1,sl1);
				ps.setString(2,nl);;
				ps.setString(3,al);;
				ps.setString(4,pl);;
				ps.setInt(5,ql1);
										
				
				ps.executeUpdate(); 

				con.close();  
				  
				}catch(Exception c){ System.out.println(c);} 
			
			JOptionPane.showMessageDialog(this, "Books added successfully");

			s1.setText("");
			n1.setText("");
			a1.setText("");
			p1.setText("");
			q1.setText("");


		}
		if (e.getSource() == back) {
			LibSection.main(new String[] {});
			f.dispose();
		}
	}

	public static void main(String[] args) {
		new AddBooks();

	}

}
