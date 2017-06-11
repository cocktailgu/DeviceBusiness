package com.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

import com.common.LoginControlOper;
import com.msdatabase.obj.UserAndColumn;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import com.controlnel.ConnectCtrlSystem;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginForm {

	protected JFrame Loginframe;
	private JTextField loginname;
	private JComboBox comboBox;
	private JPasswordField passwordField;
	
	private int selectcolumn;
	private boolean firstlost = false;
	private List<UserAndColumn> column = null;
	private String username = "";
	private String usernamechs = "";
	private int[] columnid ;
	private String usercode;
	private JButton comeButton;
	private JLabel labelstatus;
	private int hostcode;
	
	private ConnectCtrlSystem connectsystem = null;
	
	public static Long dduseid = null;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.Loginframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	
	/*public LoginForm() {
		
		initialize();
	}*/
	
	public LoginForm(int hostcd,JButton xButton ,JLabel labelstat) {
		comeButton = xButton;
		hostcode = hostcd;
		labelstatus = labelstat;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Loginframe = new JFrame();
		Loginframe.setBounds(100, 100, 450, 300);
		//Loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Loginframe.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 262);
		Loginframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		loginname = new JTextField();
		loginname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==10 && !loginname.getText().isEmpty()){
					GetColumn();
				}
			}
		});
		
		loginname.setBounds(177, 42, 152, 27);
		panel.add(loginname);
		loginname.setColumns(10);
		
		/*passwordField = new JPasswordField();
		passwordField.setBounds(177, 86, 152, 27);
		panel.add(passwordField);*/
		
		comboBox = new JComboBox();
		
		comboBox.setBounds(177, 133, 152, 21);
		panel.add(comboBox);
		
		JLabel label = new JLabel("\u767B\u5F55\u7801:");
		label.setLabelFor(loginname);
		label.setBounds(113, 48, 54, 15);
		panel.add(label);
		
		/*JLabel label_1 = new JLabel("\u5BC6\u7801:");
		label_1.setLabelFor(passwordField);
		label_1.setBounds(113, 92, 54, 15);
		panel.add(label_1);*/
		
		JLabel label_2 = new JLabel("\u680F\u76EE:");
		label_2.setLabelFor(comboBox);
		label_2.setBounds(113, 136, 54, 15);
		panel.add(label_2);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(loginname.getText().toString());
				if (loginname.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(Loginframe,"请输入用户号");
					return ;
				}
				if ( selectcolumn ==0 ){
					JOptionPane.showMessageDialog(Loginframe,"栏目未选择");
					return ;
				}
				int relogin = LoginControlOper.JudgeReLogin(usercode);
				if (relogin == 0 ){
					int insersig = LoginControlOper.InsertDDuser(IndexForm.hostname[hostcode], usercode, selectcolumn);
					if (insersig == 1){
						IndexForm.hoststatus[hostcode]=1;
						IndexForm.DDuserId[hostcode]=dduseid;
						//System.out.println(IndexForm.DDuserId[hostcode]);
						LoginControlOper.SetdeviceStatusUp(IndexForm.hostname[hostcode]);
						IndexForm.DeviceUser[hostcode]=usernamechs;
						
						connectsystem = new ConnectCtrlSystem();
						int flag = connectsystem.GetConnectCtrl("hd", IndexForm.hostname[hostcode], "1");
						if (flag == 1){
							JOptionPane.showMessageDialog(Loginframe,"登录成功");
						} else {
							JOptionPane.showMessageDialog(Loginframe,"登录成功,但设备开启失败，请联系管理员");
						}
						labelstatus.setText(usernamechs);
						comeButton.setText("注销");
						Loginframe.setVisible(false);
					}
				} else {
					JOptionPane.showMessageDialog(Loginframe,"该用户名已登录");
				}
			}
		});
		button.setBounds(74, 188, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loginframe.setVisible(false);
			}
		});
		button_1.setBounds(236, 188, 93, 23);
		panel.add(button_1);
		
		loginname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				GetColumn();				
			}
		});
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//selectcolumn = 
				int x= comboBox.getSelectedIndex();
				if (columnid[x]!=0){
					selectcolumn = columnid[x];
				}
				
				//System.out.println(selectcolumn);
				//System.out.println(usercode);
				//System.out.println(comboBox.getSelectedItem().toString());
			}
		});
	}
	
	private void GetColumn(){
		if (!username.equals(loginname.getText())){
			//System.out.println("username:"+username);
			//System.out.println("loginname:"+loginname.getText());
			
			username = loginname.getText();
			column = LoginControlOper.FindColumnByName(loginname.getText());
			if (column.size() >0){
				usernamechs = column.get(0).getC_user_name();
				selectcolumn = column.get(0).getColumnid();
				usercode = column.get(0).getUserid();
				columnid = new int[column.size()];
				comboBox.removeAllItems();
				for (int i=0;i<column.size();i++){
					comboBox.addItem((column.get(i).getColumnname()));
					columnid[i]=column.get(i).getColumnid();
				}
			} else {
				comboBox.removeAllItems();
			}	
		}
	}
}
