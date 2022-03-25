package io.github.crickon.test;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import io.github.crickon.struct.Census;

public class HUD {
	public final String title = "tdev";
	
	private JFrame frame;
	private JPanel root;
	private ArrayList<Component> active;
	
	public HUD() {
		frame = new JFrame(title);
		root = new JPanel();
		root.setLayout(new GridBagLayout());
		frame.setSize(1280, 720);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(root);
		frame.setVisible(true);
		
		active = new ArrayList<Component>();
		loadDefault();
	}
	
	public void loadDefault() {
		JTextField textField = new JTextField(20);
		textField.setEditable(true);
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String entered = textField.getText();
				textField.setText("");
				textField.grabFocus();
				Census pl = Planetside.getPlayerCensusFromName(entered);
				if (pl == null) {
					System.out.println("not found");
				} else {
					System.out.println(pl.character_id());
				}
			}
		});
		textField.setPreferredSize(new Dimension(100, 20));
		root.add(textField);
		active.add(textField);
		refresh();
	}
	
	public void refresh() {
		root.setVisible(false);
		root.setVisible(true);
	}

	public static void main(String[] args) {
		new HUD();
	}
}
