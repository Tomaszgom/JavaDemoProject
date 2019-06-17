package com.inOutput;

import java.io.*;
import java.util.*;

/**
 * 
 * Class handles writing to files
 *
 */

public class Output {

	public static void main(String[] args) throws IOException {

		// Buffered Writer Option

		try (BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
				BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))) {
		}
	}

	static {

		try (Scanner scanner = new Scanner(new FileReader("locations_big.txt"))) {
			scanner.useDelimiter(",");
			while (scanner.hasNextLine()) {
				int loc = scanner.nextInt();
				scanner.skip(scanner.delimiter());
				String description = scanner.nextLine();
				System.out.println("Imported loc: " + loc + ": " + description);
				Map<String, Integer> tempExit = new HashMap<>();
				// locations.put(loc, new Location(loc, description, tempExit));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Read txt
		try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))) {
			String input;
			while ((input = dirFile.readLine()) != null) {
				String[] data = input.split(",");
				int loc = Integer.parseInt(data[0]);
				String direction = data[1];
				int destination = Integer.parseInt(data[2]);

				System.out.println(loc + ": " + direction + ": " + destination);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
