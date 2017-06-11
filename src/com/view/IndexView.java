package com.view;

import java.util.List;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.jcraft.jsch.SftpException;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JFrame;

public class IndexView {
	private JFrame x; 
	private TextField tf = null;
	private Label title = null;
	private Button endata = null;
	private Button enfile = null;
	
	public void display(){
		x = new JFrame();
		
		tf = new TextField();
		tf.setBounds(110, 20, 200, 20);
		
		title = new Label("请输入文件号：");
		title.setBounds(10, 20, 90, 25);
		
		endata = new Button("同步数据");
		Endata an = new Endata();
		endata.addActionListener(an);
		endata.setBounds(80, 100, 70, 25);
		
		enfile = new Button("同步附件");
		Enfile bn = new Enfile();
		enfile.addActionListener(bn);
		enfile.setBounds(180, 100, 70, 25);
		
		x.setBounds(300,300,350,200);
		x.setLayout(null);
		x.setBackground(Color.white);
		
		x.add(tf);
		x.add(title);
		x.add(endata);
		x.add(enfile);
		x.setVisible(true);
	}
	
	class Endata implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			tf.setText("");
			JOptionPane.showMessageDialog(x, "同步数据成功");
		}
	}
	
	class Enfile implements ActionListener{
		public void actionPerformed(ActionEvent e){
			tf.setText("");
			JOptionPane.showMessageDialog(x, "同步数据成功");
		}
	}

}
