package com.ggl.wordle.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Statistics {
	
	private int currentStreak, longestStreak, totalGamesPlayed;
	
	private List<Integer> wordsGuessed;
	
	private String path, log;
	
	public Statistics() {
		this.wordsGuessed = new ArrayList<>();
		String fileSeparator = System.getProperty("file.separator");
		this.path = System.getProperty("user.home") + fileSeparator + "Wordle";
		this.log = fileSeparator + "statistics.log";
		readStatistics();
	}
	
	private void readStatistics() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path + log));
			this.currentStreak = Integer.valueOf(br.readLine().trim());
			this.longestStreak = Integer.valueOf(br.readLine().trim());
			this.totalGamesPlayed = Integer.valueOf(br.readLine().trim());
			int totalWordsGuessed = Integer.valueOf(br.readLine().trim());
			
			for (int index = 0; index < totalWordsGuessed; index++) {
				wordsGuessed.add(Integer.valueOf(br.readLine().trim()));
			}
			br.close();
		} catch (FileNotFoundException e) {
			this.currentStreak = 0;
			this.longestStreak = 0;
			this.totalGamesPlayed = 0;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeStatistics() {
		try {
			File file = new File(path);
			file.mkdir();
			file = new File(path + log);
			file.createNewFile();

			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(Integer.toString(currentStreak));
			bw.write(System.lineSeparator());
			bw.write(Integer.toString(longestStreak));
			bw.write(System.lineSeparator());
			bw.write(Integer.toString(totalGamesPlayed));
			bw.write(System.lineSeparator());
			bw.write(Integer.toString(wordsGuessed.size()));
			bw.write(System.lineSeparator());
			
			for (Integer value : wordsGuessed) {
				bw.write(Integer.toString(value));
				bw.write(System.lineSeparator());
			}
			
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getCurrentStreak() {
		return currentStreak;
	}

	public void setCurrentStreak(int currentStreak) {
		this.currentStreak = currentStreak;
		if (currentStreak > longestStreak) {
			this.longestStreak = currentStreak;
		}
	}

	public int getLongestStreak() {
		return longestStreak;
	}

	public int getTotalGamesPlayed() {
		return totalGamesPlayed;
	}

	public void incrementTotalGamesPlayed() {
		this.totalGamesPlayed++;
	}

	public List<Integer> getWordsGuessed() {
		return wordsGuessed;
	}

	public void addWordsGuessed(int wordCount) {
		this.wordsGuessed.add(wordCount);
	}

}
