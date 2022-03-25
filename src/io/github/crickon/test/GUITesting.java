package io.github.crickon.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUITesting extends JFrame {
	public JPanel root;
	private int test;

	public GUITesting() {
		super("Tome's Planetside Utils v0.01");
		setUp();
		root = new JPanel();
		this.add(root);
		refreshFrame();
	}

	public void setUp() {
		this.setSize(1280, 720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void refreshFrame() {
		this.setVisible(false);
		this.setVisible(true);
	}
	
	public void refreshRoot() {
		if (root != null) {
			root.setVisible(false);
			root.setVisible(true);
		}
	}

	public void addButton() {
		JButton button = new JButton("Click here");
		button.setFocusable(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		root.add(button);
		refreshFrame();
	}

	public static void main(String[] args) {
		GUITesting testing = new GUITesting();
		testing.addButton();
	}
}