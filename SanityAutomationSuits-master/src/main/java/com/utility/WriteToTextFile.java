package com.utility;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToTextFile {
	@SneakyThrows
	public static void writeData(String data, String filepath, Boolean doAppend) throws IOException {
		try (FileWriter fWriter = new FileWriter(filepath, doAppend)) {

			fWriter.write(data);

		} catch (IOException e) {
			File file = new File(filepath);
			file.createNewFile();
		}

	}
}
