package com.hashMapGame;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * Class Represents collection of Places objects loads used in the Game Project,
 * handles loading objects from .txt file and saving to .dat file as objects
 * Implements Map interface, class behaves like a map
 * Interface abstract methods implemented
 *
 */


public class MapAndLoadPlaces implements Map<Integer, Place> {
	
	private static Map<Integer, Place> places = new LinkedHashMap<Integer, Place>();


	/* Static initialization block, executed one while class is loaded 
	 * one copy of static data shared among all classes	*/
	static {

		/*	Read txt file - Load Places	 */

    	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    	try (InputStream inputStreamPlaces = classLoader.getResourceAsStream("com/txt/hashMapGame_RomePlaces.txt")) {
			// String result = IOUtils.toString(inputStreamProperties, StandardCharsets.UTF_8);
			InputStreamReader streamReader = new InputStreamReader(inputStreamPlaces, StandardCharsets.UTF_8);			
			BufferedReader dirFile = new BufferedReader(streamReader);
						
//		try (BufferedReader dirFile = new BufferedReader(
//				new FileReader("./src/main/resources/com/txt/hashMapGame_RomePlaces.txt"))) {
			String input;
			while ((input = dirFile.readLine()) != null) {
				Map<String, Integer> ways = new LinkedHashMap<>();

				String[] data = input.split(";;");
				int PlaceID = Integer.parseInt(data[0]);
				String desc = data[1];

				places.put(PlaceID, new Place(PlaceID, desc, ways));
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

    	
    	/*	Read txt file - Load Ways (alternative way to ready txt file)	*/
    					
		try (Scanner scanner = new Scanner(
									new BufferedReader(
										new InputStreamReader(
												classLoader.getResourceAsStream("com/txt/hashMapGame_RomeWays.txt"), StandardCharsets.UTF_8)))) {
			
			scanner.useDelimiter(";");
			while (scanner.hasNextLine()) {
				String input = scanner.nextLine();

				String[] data = input.split(";");
				int PlaceID = Integer.parseInt(data[0]);
				String way = data[1];
				int DestinPlaceID = Integer.parseInt(data[2]);
				Place place = places.get(PlaceID);
				place.addWay(way, DestinPlaceID);
			}

		}

	} //	Static End

	
	/*	Save into .dat - Save entire objects into dat file	*/
	
	public void SaveLocationsAsObjects() {
		System.out.println("Start Saving Rome Places...");

		try (ObjectOutputStream locFile = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("./src/main/resources/com/dat/hashMapGame_Places.dat")))) {
			for(Place place : places.values()) { 
				locFile.writeObject(place);
				System.out.println("PlaceID: "+place.getPlaceID()+" : "+place.getPlaceDesc());
			}

		}catch(IOException ex){
			ex.printStackTrace();
		}   
	}

	
	/* Override interface methods */

	@Override
	public int size() {
		return places.size();
	}

	@Override
	public boolean isEmpty() {
		return places.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return places.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return places.containsValue(value);
	}

	@Override
	public Place get(Object key) {
		return places.get(key);
	}

	@Override
	public Place put(Integer key, Place value) {
		return places.put(key, value);
	}

	@Override
	public Place remove(Object key) {
		return places.remove(key);
	}

	@Override
	public void putAll(Map<? extends Integer, ? extends Place> m) {

	}

	@Override
	public void clear() {
		places.clear();

	}

	@Override
	public Set<Integer> keySet() {
		return places.keySet();
	}

	@Override
	public Collection<Place> values() {
		return places.values();
	}

	@Override
	public Set<Entry<Integer, Place>> entrySet() {
		return places.entrySet();
	}

}
