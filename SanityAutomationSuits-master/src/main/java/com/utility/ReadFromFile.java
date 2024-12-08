package com.utility;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ReadFromFile {
	public static String readData(String filepath) {
		String data = "";
		try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			data = sb.toString();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		return data;
	}

	public static String readOneLineData(String filepath) {
		String data = "";
		try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			if (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			data = sb.toString();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		return data;
	}

	public static ArrayList<ArrayList<String>> readDataIntoArrayList(String filepath) {
		ArrayList<ArrayList<String>> biD = new ArrayList<>();
		int rows = 0;
		Scanner file = null;
		try {
			file = new Scanner(new File(filepath));
			while (file.hasNextLine()) {

				ArrayList<String> line = new ArrayList<>();
				final String nextLine = file.nextLine();
				final String[] items = nextLine.split(":");

				Collections.addAll(line, items);

				biD.add(line);
				rows++;
				Arrays.fill(items, null); // to clear out the 'items' array
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		return biD;

	}

}
