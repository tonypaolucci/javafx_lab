package com.container;

import java.awt.*;
import java.awt.event.*;


public class AwtContainer {

	private Frame mainFrame; //The main frame or container to display
	
	private Label headerLabel;
	private Label statusLabel;
	private Label msgLabel;
	private Panel controlPanel;
	private TextField firstName;
	private TextField lastName;
	private TextField age;
	
	public AwtContainer()
	{
		prepareGUI();
	}
	
	public void prepareGUI()
	{
		//new frame
		mainFrame = new Frame("Claim Java AWT Frame");
		
		mainFrame.setSize(400,400);
		mainFrame.setLayout(new GridLayout(3,1));
		mainFrame.addWindowListener(new WindowAdapter()	{
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
		});
		
		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);
		
		//headerLabel.setSize(350, 100);
		
		statusLabel = new Label();
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(350, 100);
		
		msgLabel = new Label();
		msgLabel.setAlignment(Label.CENTER);
		msgLabel.setText("Mt First Java Frame Yea!!!!");
		
		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());
		
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
		
		firstName = new TextField();
		firstName.setPreferredSize(new Dimension(175,25));
		lastName = new TextField();
		lastName.setPreferredSize(new Dimension(175,25));
		age = new TextField();
		age.setPreferredSize(new Dimension(175,25));
	}
	
	public void showFrame()
	{
		headerLabel.setText("Container in action:Frame");
		headerLabel.setForeground(Color.RED);
		final Frame frame = new Frame();
		final Frame babyFrame = new Frame();
		frame.setResizable(false);
		
		frame.setSize(275, 275);
		//frame.setMinimumSize(new Dimension(300,300));
		//frame.setMaximumSize(new Dimension(300,300));
		//
		frame.setLayout(new FlowLayout());
		frame.add(msgLabel);
		firstName.setSize(30, 10);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent windowEvent){
				frame.dispose();
			}
		});
		babyFrame.setSize(150, 150);
		babyFrame.setLayout(new FlowLayout());
		babyFrame.add(msgLabel);
		babyFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent windowEvent){
				babyFrame.dispose();
			}
		});
		
//		Button opnButton = new Button("Open sub-sub Frame");
//		opnButton.addActionListener(new ActionListener() {			
//			public void actionPerformed(ActionEvent e) {
//				babyFrame.setVisible(true);
//			}
//		});
		
		Button okButton = new Button("Open sub Frame");
		okButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				statusLabel.setText("Look at this second Frame.");
				frame.setVisible(true);
			}
		});
		
		Button clsButton = new Button("CLOSE ME!!!");
		clsButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
			}
		});
		
		controlPanel.add(okButton);
		controlPanel.add(clsButton);
		
		mainFrame.setVisible(true);
		
		Button closeButton = new Button("Close the frame");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		frame.add(closeButton);
		
		Button formButton = new Button("Open sesame");
		formButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				babyFrame.setVisible(true);
			}
		});
		firstName.setSize(350,150);
		frame.add(formButton);
		frame.add(new Label("First Name"));
		frame.add(firstName);
		frame.add(new Label("Last Name"));
		frame.add(lastName);
		frame.add(new Label("Age\t\t\t\t"));
		frame.add(age);
		
		Button submitButton = new Button("Close the frame");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("First Name: " + firstName.getText());
				System.out.println("Last Name: " + lastName.getText());
				System.out.println("Age: " + age.getText());
			}
		});
		frame.add(submitButton);
	}
	
	public static void main(String[] args)
	{
		AwtContainer container = new AwtContainer();
		container.showFrame();
	}
}
