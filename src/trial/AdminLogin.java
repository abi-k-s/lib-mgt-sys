package trial;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//This is admin login page
public class AdminLogin extends JFrame implements ActionListener {
	private static final long serialVersionUID=1L;

	JFrame ad;
	JLabel l1, l2;
	JPasswordField pass;
	JTextField name;
	JButton login;

	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		name=new JTextField();

		ad = new JFrame("ADMINLOGIN");
		l1 = new JLabel("USERNAME");
		l2 = new JLabel("PASSWORD");
		pass = new JPasswordField();
		l1.setBounds(100, 150, 100, 30);
		l2.setBounds(100, 200, 100, 30);
		name.setBounds(250, 150, 100, 30);
		pass.setBounds(250,200,100,30);
		login = new JButton("LOGIN");
		login.setBounds(180, 250, 100, 30);
		ad.add(l1);
		ad.add(l2);
		ad.add(login);
		ad.add(name);
		ad.add(pass);
		ad.setSize(500, 500);
		ad.setLayout(null);
		ad.setVisible(true);
		login.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		
			String user=name.getText();
			String password=String.valueOf(pass.getPassword());
			if(user.equals("admin")&&password.equals("admin")){
				AdminSection.main(new String[] {});
				ad.dispose();
			}
			else {
				JOptionPane.showMessageDialog(this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
				name.setText("");
				pass.setText("");
			}
		

}
	public static void main(String args[]) {

		new AdminLogin();
	}
}