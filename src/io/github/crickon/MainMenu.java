package io.github.crickon;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMenu extends JFrame {
	private HUD hud;

	private JPanel root;

	private JPanel header;
	private JLabel sellout;
	private final int header_width = HUD.WIDTH;
	private final int header_height = 40;
	private final String header_label = "Tome's Planetside Overlay";

	private JPanel scrims;
	private JLabel scrimsheader;
	private final int scrims_width = HUD.WIDTH;
	private final int scrims_height = (HUD.HEIGHT - header_height) / 2;
	private final String scrim_label = "Scrims";
	private JPanel scrimslength;
	private JLabel scrimslengthheader;
	private JTextField scrimslengthinput;

	private JPanel live;
	private final int live_width = HUD.WIDTH;
	private final int live_height = (HUD.HEIGHT - header_height) / 2;

	public MainMenu(HUD hud) {
		super(HUD.TITLE);
		this.hud = hud;
		initFrame();

		initHeader();
		initScrimsPanel();

		root.grabFocus();
	}

	private void initFrame() {
		// terminate program on window close
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// frame contains a panel spanning the full window
		root = new JPanel();
		root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
		root.setPreferredSize(new Dimension(HUD.WIDTH, HUD.HEIGHT));
		this.setContentPane(root);
		this.pack();

		// hot key support
		root.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_G:
					updateChroma();
					break;
				default:
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

		});

		// frame to center of screen
		this.setLocationRelativeTo(null);

		// enable the frame
		this.setVisible(true);
	}

	protected void updateChroma() {
		hud.setChroma(!hud.getChroma());
		if (hud.getChroma()) {
			root.setBackground(HUD.CHROMA_COLOR);

			header.setBackground(HUD.CHROMA_COLOR);
			sellout.setForeground(HUD.TEXT_CHROMA);

			scrims.setBackground(HUD.CHROMA_COLOR);
			scrimsheader.setForeground(HUD.TEXT_CHROMA);
			scrimslength.setBackground(HUD.CHROMA_COLOR);
			scrimslengthheader.setForeground(HUD.TEXT_CHROMA);
			scrimslengthinput.setForeground(HUD.TEXT_CHROMA);
			scrimslengthinput.setBackground(HUD.CHROMA_COLOR);

		} else {
			root.setBackground(HUD.DEFAULT_COLOR);

			header.setBackground(HUD.DEFAULT_COLOR);
			sellout.setForeground(HUD.TEXT_DEFAULT);

			scrims.setBackground(HUD.DEFAULT_COLOR);
			scrimsheader.setForeground(HUD.TEXT_DEFAULT);
			scrimslength.setBackground(HUD.DEFAULT_COLOR);
			scrimslengthheader.setForeground(HUD.TEXT_DEFAULT);
			scrimslengthinput.setForeground(HUD.TEXT_DEFAULT);
			scrimslengthinput.setBackground(HUD.DEFAULT_COLOR);
		}
	}

	private void initHeader() {
		header = new JPanel();
		header.setMaximumSize(new Dimension(header_width, header_height));

		sellout = new JLabel();
		sellout.setFont(HUD.DEFAULT_FONT);
		sellout.setText(header_label);
		header.add(sellout);

		root.add(header);
		root.setVisible(false);
		root.setVisible(true);
	}

	private void initScrimsPanel() {
		scrims = new JPanel();
		scrims.setLayout(new BoxLayout(scrims, BoxLayout.Y_AXIS));
		scrims.setMaximumSize(new Dimension(scrims_width, scrims_height));

		scrimsheader = new JLabel();
		scrimsheader.setFont(HUD.DEFAULT_FONT);
		scrimsheader.setText(scrim_label);
		scrims.add(scrimsheader);

		scrimslength = new JPanel();
		scrimslengthheader = new JLabel();
		scrimslengthheader.setFont(HUD.DEFAULT_FONT);
		scrimslengthheader.setText("Match length (minutes) = ");
		scrimslengthinput = new JTextField(4);
		scrimslengthinput.setFont(HUD.DEFAULT_FONT);
		scrimslengthinput.setText("10");
		scrimslengthinput.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					root.grabFocus();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

		scrimslength.add(scrimslengthheader);
		scrimslength.add(scrimslengthinput);
		scrims.add(scrimslength);

		root.add(scrims);
		root.setVisible(false);
		root.setVisible(true);
	}
}