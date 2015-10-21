package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import controller.ErrorHandler;
import gui.*;

public class Settings {

	ErrorHandler err = new ErrorHandler();
	GUI gui = new GUI();
	private String fileLoc;
	private String writeLocX, writeLocY;
	private String defaultLoc;
	private String path = "/PinGen/Dorma RS8";

	public void readSettings(String line) {
		String[] lineSplit = line.split(";");
		switch (lineSplit[0]) {
		case "fileLoc":
			fileLoc = lineSplit[1];
			break;
		case "writeLoc":
			String[] lineSplit2 = lineSplit[1].split(",");
			writeLocX = lineSplit2[0];
			writeLocY = lineSplit2[1];
			break;
		case "defaultLoc":
			defaultLoc = lineSplit[1];
			break;
		}
	}

	public void updateSettings(String newDefaultLoc, String newFileLoc,
			String newWriteLoc, String ownLoc) {
		defaultLoc = newDefaultLoc;
		fileLoc = newFileLoc;
		String[] lineSplit2 = newWriteLoc.split(",");
		writeLocX = lineSplit2[0];
		writeLocY = lineSplit2[1];
		writeSettings(ownLoc);
	}

	public void writeSettings(String ownLoc) {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter(ownLoc + path + "/DormaRS8Settings.txt")));
			out.write("defaultLoc" + ";" + defaultLoc + "\n");
			out.write("fileLoc" + ";" + fileLoc + "\n");
			out.write("writeLoc" + ";" + writeLocX + "," + writeLocY + ""
					+ "\n");
			out.close();
		} catch (FileNotFoundException e) {
			File dir = new File(ownLoc + "/PinGen");
			dir.mkdir();
			File dir2 = new File(ownLoc + "/PinGen/Dorma RS8");
			dir2.mkdir();
		} catch (IOException e) {
			String prePath = ownLoc + "/PinGen/Dorma RS8";
			Path path2 = Paths.get(prePath);
			if (Files.exists(path2)) {

			} else {
				File dir = new File(ownLoc + "/PinGen");
				dir.mkdir();
				File dir2 = new File(ownLoc + "/PinGen/Dorma RS8");
				dir2.mkdir();
			}
			err.printError(ownLoc, e);
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			err.printError(ownLoc, e);
		}
	}

	public String getFileLoc() {
		return fileLoc;
	}

	public void setFileLoc(String fileLoc) {
		this.fileLoc = fileLoc;
	}

	public String getWriteLocX() {
		return writeLocX;
	}

	public void setWriteLocX(String writeLocX) {
		this.writeLocX = writeLocX;
	}

	public String getDefaultLoc() {
		return defaultLoc;
	}

	public void setDefaultLoc(String defaultLoc) {
		this.defaultLoc = defaultLoc;
	}

	public String getWriteLocY() {
		return writeLocY;
	}

	public void setWriteLocY(String writeLocY) {
		this.writeLocY = writeLocY;
	}

}
