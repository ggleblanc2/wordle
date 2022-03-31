package com.ggl.wordle.model;

import java.awt.Color;

public class ColorResponse {
	
	private final Color backgroundColor, foregroundColor;

	public ColorResponse(Color backgroundColor, Color foregroundColor) {
		this.backgroundColor = backgroundColor;
		this.foregroundColor = foregroundColor;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public Color getForegroundColor() {
		return foregroundColor;
	}

}
