package com.inOutput;

import java.io.*;
import javax.swing.JOptionPane;

/**
 * 
 * Class handles Writing into and reading from binary .dat file
 *
 */

public class Binary {

	// Try with-resources ensures that data stream is automatically closed
	public static void main(String[] args) throws IOException {
		ReadFromBinary();
		// WriteIntoBinary();
	}

	public static void WriteIntoBinary() throws IOException {

		try (DataOutputStream locFile = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("./src/main/resources/com/dat/inOutput_binary.dat")))) {
			locFile.writeInt(5);
			locFile.writeUTF("\t Hello! This is content saved in binary .dat file");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "IOException: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		JOptionPane.showMessageDialog(null, "Binary file succesfully saved.", "Completed", JOptionPane.PLAIN_MESSAGE);
	}

	public static void ReadFromBinary() throws IOException {

		try (DataInputStream locFile = new DataInputStream(
				new BufferedInputStream(new FileInputStream("./src/main/resources/com/dat/inOutput_binary.dat")))) {
			boolean eof = false;
			while (!eof) {
				try {

					int locID = locFile.readInt();
					String desc = locFile.readUTF();
					System.out.println("Read from binary ID " + locID + desc);

				} catch (EOFException e) {
					eof = true;
				}

			}
		} catch (IOException io) {
			System.out.println("IO Exception");
		}

	}

}
