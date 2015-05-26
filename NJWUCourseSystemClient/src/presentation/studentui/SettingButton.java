package presentation.studentui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import businesslogic.studentbl.StudentInfo;
import businesslogicservice.studentblservice.StudentInfoBLService;

public class SettingButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6681747904021025682L;

	public JButton getSettingButton(final String student_id){
//		this.setIcon(new ImageIcon(Tool.settingimage));
		this.setSize(50, 50);

		Tool.setIcon(Tool.settingimage, this);
//		this.setText("修改密码");
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JFrame settingpassword = getChangePassWordFrame(student_id);
				new Tool().setMiddle(settingpassword);
				settingpassword.setVisible(true);
				settingpassword.repaint();
			}
		});
		
		return this;
	}
	
	public JFrame getChangePassWordFrame(final String student_id){
		
		final JFrame mainframe = new JFrame("修改密码");
		Container c= mainframe.getContentPane();
		
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(null);
		JLabel label1= new JLabel("ID : ");
		JLabel label2= new JLabel("Old Password : ");
		JLabel label3= new JLabel("New Password :");
		JLabel label4= new JLabel("New Password : ");
		
		
		
		final JTextField user_id = new JTextField();
		final JPasswordField oldpasswrod = new JPasswordField();
		final JPasswordField newpassword = new JPasswordField();
		final JPasswordField newpassword2 = new JPasswordField();
		
		user_id.setText(student_id);
		user_id.setEditable(false);
		
		mainpanel.add(label1);
		mainpanel.add(label2);
		mainpanel.add(label3);
		mainpanel.add(label4);
		
		mainpanel.add(user_id);
		mainpanel.add(oldpasswrod);
		mainpanel.add(newpassword);
		mainpanel.add(newpassword2);
		
		int width = 100;
		int height = 25;
		
		label1.setBounds(10, 10, width, height);
		label2.setBounds(10, 15+height, width, height);
		label3.setBounds(10, 20+height*2, width, height);
		label4.setBounds(10, 25+height*3, width, height);
		
		user_id.setBounds(10+width, 10, width, height);
		oldpasswrod.setBounds(10+width, 15+height, width, height);
		newpassword.setBounds(10+width, 20+height*2, width, height);
		newpassword2.setBounds(10+width, 25+height*3, width, height);
		
		JButton confirmchange = new JButton("确认修改");
		
		
		mainpanel.add(confirmchange);
		confirmchange.setBounds(10, 30+height*4, 100, height);
//		StudentGUITool tools = new StudentGUITool();
		
		mainframe.setSize(width*2+50, height*6+50);
		
		
		c.add(mainpanel);
		mainpanel.setBounds(0, 0, width*2+50, height*6+50);
		mainframe.repaint();
		mainframe.setVisible(true);
	
		
		confirmchange.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//StudentInfo 的方法修改密码；
				 
				user_id.setText(student_id);
				user_id.setEditable(false);
				char[] oldpass = oldpasswrod.getPassword();
				char[] newpass1 = newpassword.getPassword();
				char[] newpass2 = newpassword2.getPassword();
				
				boolean  newpassvalid = true;
				for(int i=0;i<newpass1.length;i++){
					if(newpass1[i]!=newpass2[i]){
						newpassvalid=false;
						break;
					}
				}
				
				if(newpass1.length!=newpass2.length){
					newpassvalid =false;
				}
				
				if(newpassvalid){
					StudentInfoBLService si = new StudentInfo();
					si.changePassWord(student_id, oldpass, newpass1);
					mainframe.setVisible(false);
					JOptionPane.showMessageDialog(null, "成功修改密码");
				}else{
					JOptionPane.showMessageDialog(null, "两次密码输入不一致");
				}
				
				
			}
		});

		return mainframe;
	}
	
}
