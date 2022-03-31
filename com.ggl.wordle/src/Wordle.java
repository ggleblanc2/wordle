package com.ggl.wordle;

import javax.swing.SwingUtilities;

import com.ggl.wordle.model.WordleModel;
import com.ggl.wordle.view.WordleFrame;

public class Wordle implements Runnable {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Wordle());
	}

	@Override
	public void run() {
		new WordleFrame(new WordleModel());
	}

}
