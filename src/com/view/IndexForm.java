package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;

import com.common.*;
import com.controlnel.ConnectCtrlSystem;

public class IndexForm {

	private JFrame frame;
	public String[] btnText = {"登录","注销"};
	private String freestatustext = "空闲";
	static int[] hoststatus;
	public static String[] DeviceUser = new String[14];
	public static Long[] DDuserId = new Long[14];
	public static String[] hostname = new String[] {"HD-1","HD-2","HD-3","HD-4","HD-5","HD-6","HD-7","HD-8","HD-9" 
		,"HD-10","HD-11","HD-12","HD-13","HD-14"};
	
	private ConnectCtrlSystem connectsystem = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IndexForm window = new IndexForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IndexForm() {
		DealDataHD.GetUseDeviceUser();
		initialize();		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 636, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel HD2room = new JPanel();
		HD2room.setBounds(10, 10, 602, 134);
		panel.add(HD2room);
		HD2room.setLayout(null);
		
		JTextPane HD2roomlab = new JTextPane();
		HD2roomlab.setBackground(UIManager.getColor("Button.background"));
		HD2roomlab.setFont(new Font("宋体", Font.PLAIN, 15));
		HD2roomlab.setBounds(10, 10, 93, 21);
		HD2room.add(HD2roomlab);
		HD2roomlab.setText("\u9AD8\u6E05\u4E8C\u5BA4");
		
		JPanel HD1room = new JPanel();
		HD1room.setBounds(10, 154, 602, 203);
		panel.add(HD1room);
		HD1room.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("Button.background"));
		textPane.setForeground(UIManager.getColor("Button.focus"));
		textPane.setText("\u9AD8\u6E05\u4E00\u5BA4");
		textPane.setFont(new Font("宋体", Font.PLAIN, 15));
		textPane.setBounds(10, 10, 78, 21);
		HD1room.add(textPane);
		
		hoststatus = DealDataHD.GetFdd_deviceStatus();
		if (hoststatus== null){
			JOptionPane.showMessageDialog(frame, "数据库错误");
			return ;
		}
		/*for (int l=0;l<hoststatus.length;l++){
			System.out.println(l+":"+hoststatus[l]);
		}*/
		final JButton HD1btn = new JButton();
		MakeBtnText(0,HD1btn);
		HD1btn.setBounds(10, 80, 93, 23);
		HD2room.add(HD1btn);
		final JButton HD2btn = new JButton();
		MakeBtnText(1,HD2btn);
		HD2btn.setBounds(131, 80, 93, 23);
		HD2room.add(HD2btn);
		final JButton HD3btn = new JButton();
		MakeBtnText(2,HD3btn);
		HD3btn.setBounds(250, 80, 93, 23);
		HD2room.add(HD3btn);
		final JButton HD4btn = new JButton();
		MakeBtnText(3,HD4btn);
		HD4btn.setBounds(366, 80, 93, 23);
		HD2room.add(HD4btn);
		final JButton HD5btn = new JButton();
		MakeBtnText(4,HD5btn);
		HD5btn.setBounds(482, 80, 93, 23);
		HD2room.add(HD5btn);
		final JButton HD6btn = new JButton();
		MakeBtnText(5,HD6btn);
		HD6btn.setBounds(10, 74, 93, 23);
		HD1room.add(HD6btn);
		final JButton HD7btn = new JButton();
		MakeBtnText(6,HD7btn);
		HD7btn.setBounds(125, 74, 93, 23);
		HD1room.add(HD7btn);
		final JButton HD8btn = new JButton();
		MakeBtnText(7,HD8btn);
		HD8btn.setBounds(241, 74, 93, 23);
		HD1room.add(HD8btn);
		final JButton HD9btn = new JButton();
		MakeBtnText(8,HD9btn);
		HD9btn.setBounds(359, 74, 93, 23);
		HD1room.add(HD9btn);
		final JButton HD10btn = new JButton();
		MakeBtnText(9,HD10btn);
		HD10btn.setBounds(482, 74, 93, 23);
		HD1room.add(HD10btn);
		final JButton HD11btn = new JButton();
		MakeBtnText(10,HD11btn);
		HD11btn.setBounds(10, 141, 93, 23);
		HD1room.add(HD11btn);
		final JButton HD12btn = new JButton();
		MakeBtnText(11,HD12btn);
		HD12btn.setBounds(125, 140, 93, 23);
		HD1room.add(HD12btn);
		final JButton HD13btn = new JButton();
		MakeBtnText(12,HD13btn);
		HD13btn.setBounds(241, 141, 93, 23);
		HD1room.add(HD13btn);
		final JButton HD14btn = new JButton();
		MakeBtnText(13,HD14btn);
		HD14btn.setBounds(359, 141, 93, 23);
		HD1room.add(HD14btn);
		
		JLabel HD1lab = new JLabel("HD1:");
		HD1lab.setLabelFor(HD1btn);
		HD1lab.setHorizontalAlignment(SwingConstants.CENTER);
		HD1lab.setBounds(10, 41, 50, 29);
		HD2room.add(HD1lab);
		
		JLabel HD2lab = new JLabel("HD2:");
		HD2lab.setLabelFor(HD2btn);
		HD2lab.setBounds(129, 41, 50, 29);
		HD2room.add(HD2lab);
		HD2lab.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel HD3lab = new JLabel("HD3:");
		HD3lab.setLabelFor(HD3btn);
		HD3lab.setHorizontalAlignment(SwingConstants.CENTER);
		HD3lab.setBounds(246, 41, 50, 29);
		HD2room.add(HD3lab);
		
		JLabel HD4lab = new JLabel("HD4:");
		HD4lab.setLabelFor(HD4btn);
		HD4lab.setHorizontalAlignment(SwingConstants.CENTER);
		HD4lab.setBounds(365, 41, 37, 29);
		HD2room.add(HD4lab);
		
		JLabel HD5lab = new JLabel("HD5:");
		HD5lab.setLabelFor(HD5btn);
		HD5lab.setHorizontalAlignment(SwingConstants.CENTER);
		HD5lab.setBounds(480, 41, 37, 29);
		HD2room.add(HD5lab);
		
		JLabel HD6lab = new JLabel("HD6:");
		HD6lab.setLabelFor(HD6btn);
		HD6lab.setHorizontalAlignment(SwingConstants.CENTER);
		HD6lab.setBounds(10, 41, 37, 29);
		HD1room.add(HD6lab);
		
		JLabel HD7lab = new JLabel("HD7:");
		HD7lab.setLabelFor(HD7btn);
		HD7lab.setHorizontalAlignment(SwingConstants.CENTER);
		HD7lab.setBounds(125, 41, 37, 29);
		HD1room.add(HD7lab);
	
		JLabel HD8lab = new JLabel("HD8:");
		HD8lab.setLabelFor(HD8btn);
		HD8lab.setHorizontalAlignment(SwingConstants.CENTER);
		HD8lab.setBounds(241, 41, 37, 29);
		HD1room.add(HD8lab);
		
		JLabel HD9lab = new JLabel("HD9:");
		HD9lab.setLabelFor(HD9btn);
		HD9lab.setHorizontalAlignment(SwingConstants.CENTER);
		HD9lab.setBounds(360, 41, 37, 29);
		HD1room.add(HD9lab);

		JLabel HD10lab = new JLabel("HD10:");
		HD10lab.setLabelFor(HD10btn);
		HD10lab.setHorizontalAlignment(SwingConstants.CENTER);
		HD10lab.setBounds(483, 41, 37, 29);
		HD1room.add(HD10lab);
		
		JLabel HD11lab = new JLabel("HD11:");
		HD11lab.setLabelFor(HD11btn);
		HD11lab.setHorizontalAlignment(SwingConstants.CENTER);
		HD11lab.setBounds(10, 107, 37, 29);
		HD1room.add(HD11lab);
		
		JLabel HD12lab = new JLabel("HD12:");
		HD12lab.setLabelFor(HD12btn);
		HD12lab.setHorizontalAlignment(SwingConstants.CENTER);
		HD12lab.setBounds(125, 107, 37, 29);
		HD1room.add(HD12lab);
		
		JLabel HD13lab = new JLabel("HD13:");
		HD13lab.setLabelFor(HD13btn);
		HD13lab.setHorizontalAlignment(SwingConstants.CENTER);
		HD13lab.setBounds(241, 107, 37, 29);
		HD1room.add(HD13lab);
		
		JLabel HD14lab = new JLabel("HD14:");
		HD14lab.setLabelFor(HD14btn);
		HD14lab.setHorizontalAlignment(SwingConstants.CENTER);
		HD14lab.setBounds(359, 107, 37, 29);
		HD1room.add(HD14lab);
		
		final JLabel HD1status = new JLabel();
		HD1status.setBounds(49, 48, 54, 15);
		MakeStatusLabelText(0,HD1status);
		HD2room.add(HD1status);
		final JLabel HD2status = new JLabel();
		HD2status.setBounds(170, 48, 54, 15);
		MakeStatusLabelText(1,HD2status);
		HD2room.add(HD2status);
		final JLabel HD3status = new JLabel();
		HD3status.setBounds(288, 48, 54, 15);
		MakeStatusLabelText(2,HD3status);
		HD2room.add(HD3status);
		final JLabel HD4status = new JLabel();
		HD4status.setBounds(402, 48, 54, 15);
		MakeStatusLabelText(3,HD4status);
		HD2room.add(HD4status);
		final JLabel HD5status = new JLabel();
		HD5status.setBounds(522, 48, 54, 15);
		MakeStatusLabelText(4,HD5status);
		HD2room.add(HD5status);
		final JLabel HD6status = new JLabel();
		HD6status.setBounds(47, 41, 54, 26);
		MakeStatusLabelText(5,HD6status);
		HD1room.add(HD6status);
		final JLabel HD7status = new JLabel();
		HD7status.setBounds(158, 42, 54, 26);
		MakeStatusLabelText(6,HD7status);
		HD1room.add(HD7status);
		final JLabel HD8status = new JLabel();
		HD8status.setBounds(280, 42, 54, 26);
		MakeStatusLabelText(7,HD8status);
		HD1room.add(HD8status);
		final JLabel HD9status = new JLabel();
		HD9status.setBounds(398, 42, 54, 26);
		MakeStatusLabelText(8,HD9status);
		HD1room.add(HD9status);
		final JLabel HD10status = new JLabel();
		HD10status.setBounds(520, 42, 54, 26);
		MakeStatusLabelText(9,HD10status);
		HD1room.add(HD10status);
		final JLabel HD11status = new JLabel();
		HD11status.setBounds(49, 107, 54, 26);
		MakeStatusLabelText(10,HD11status);
		HD1room.add(HD11status);
		final JLabel HD12status = new JLabel();
		HD12status.setBounds(158, 107, 54, 26);
		MakeStatusLabelText(11,HD12status);
		HD1room.add(HD12status);
		final JLabel HD13status = new JLabel();
		HD13status.setBounds(280, 107, 54, 26);
		MakeStatusLabelText(12,HD13status);
		HD1room.add(HD13status);
		final JLabel HD14status = new JLabel();
		HD14status.setBounds(398, 107, 54, 26);
		MakeStatusLabelText(13,HD14status);
		HD1room.add(HD14status);
		
		/*System.out.println(e);
		System.out.println("what the fuck");
		JOptionPane.showMessageDialog(frame, "同步数据成功");
		HD1btn.setText("asdfa");*/
		
		HD1btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JudgeLoginOrOut(0,HD1btn,HD1status);
			}
		});
		HD2btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JudgeLoginOrOut(1,HD2btn,HD2status);
			}
		});
		HD3btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JudgeLoginOrOut(2,HD3btn,HD3status);
			}
		});
		HD4btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JudgeLoginOrOut(3,HD4btn,HD4status);
			}
		});
		HD5btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JudgeLoginOrOut(4,HD5btn,HD5status);
			}
		});
		HD6btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JudgeLoginOrOut(5,HD6btn,HD6status);
			}
		});
		HD7btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JudgeLoginOrOut(6,HD7btn,HD7status);
			}
		});
		HD8btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JudgeLoginOrOut(7,HD8btn,HD8status);
			}
		});
		HD9btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JudgeLoginOrOut(8,HD9btn,HD9status);
			}
		});
		HD10btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JudgeLoginOrOut(9,HD10btn,HD10status);
			}
		});
		HD11btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JudgeLoginOrOut(10,HD11btn,HD11status);
			}
		});
		HD12btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JudgeLoginOrOut(11,HD12btn,HD12status);
			}
		});
		HD13btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JudgeLoginOrOut(12,HD13btn,HD13status);
			}
		});
		HD14btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JudgeLoginOrOut(13,HD14btn,HD14status);
			}
		});
	}
	
	public void JudgeLoginOrOut(int hostcode,JButton enterbtn,JLabel labelstatus){
		/*for (int i=0;i<DDuserId.length;i++){
			System.out.println(i+":"+DDuserId[i]);
		}*/
		if (DDuserId[hostcode] == null){
			LoginForm window = new LoginForm(hostcode,enterbtn,labelstatus);
			window.Loginframe.setVisible(true);
		} else {
			int res=JOptionPane.showConfirmDialog(null, 
					"是否确认注销", "注销", JOptionPane.YES_NO_OPTION);
			if(res==JOptionPane.YES_OPTION){
				int logoffsig = DealDataHD.LogoffTransact(hostcode);
				if (logoffsig == 1){
					hoststatus[hostcode] = 0;
					enterbtn.setText(btnText[hoststatus[hostcode]]);
					labelstatus.setText(freestatustext);
					DDuserId[hostcode]= null;
					connectsystem = new ConnectCtrlSystem();
					int flag = connectsystem.GetConnectCtrl("hd", hostname[hostcode], "0");
					if (flag == 1){
						JOptionPane.showMessageDialog(frame,"注销成功");
					} else {
						JOptionPane.showMessageDialog(frame,"注销成功,但设备关闭失败，请联系管理员");
					}
				} else {
					JOptionPane.showMessageDialog(frame,"系统出错，无法注销");
				}
				//System.out.println("注销成功");
			} 
		}
	}
	
	public void MakeStatusLabelText(int hostindex,JLabel statuslabel){
		if (DeviceUser[hostindex]!= null){
			statuslabel.setText(DeviceUser[hostindex]);
		} else {
			statuslabel.setText(freestatustext);
		}
	}
	
	public void MakeBtnText(int hostindex,JButton btn){
		if (DeviceUser[hostindex]!= null){
			btn.setText(btnText[1]);
		} else {
			btn.setText(btnText[0]);
		}
	}
}
