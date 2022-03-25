package io.github.crickon;

import java.awt.Color;
import java.awt.Font;

public class HUD {
	public static final String TITLE = "Tomes Planetside Overlay";
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 576;
	public static final Color DEFAULT_COLOR = Color.white;
	public static final Color CHROMA_COLOR = Color.green;
	public static final Color TEXT_DEFAULT = Color.black;
	public static final Color TEXT_CHROMA = Color.white;
	
	public static final Font DEFAULT_FONT = new Font("Dialog", 1, 25);
	
	private boolean chroma;
	
	public HUD() {
		new MainMenu(this);
	}
	
	public boolean getChroma() {
		return this.chroma;
	}
	
	public void setChroma(boolean chroma) {
		this.chroma = chroma;
	}
	
	public static void main(String[] args) {
		new HUD();
	}
}