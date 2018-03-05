package com.hashMapGame;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class MapAndLoadPlaces implements Map<Integer, Place> {
	private static Map<Integer, Place> places = new LinkedHashMap<Integer, Place>();
	//Class that behaves like a map
	//Interface abstract methods implemented
	
	//------------static initialization block, executed one while class is loaded
	//------------one copy of static data shared among all classes	
	static {
	
	//------Read txt - Load Places------------
		
    try (BufferedReader dirFile = new BufferedReader(
    								new FileReader("./src/main/resources/com/txt/hashMapGame_RomePlaces.txt"))) {
        String input;
        while((input = dirFile.readLine()) != null) {
        	Map<String, Integer> ways = new LinkedHashMap<>();
        	
            String[] data = input.split(";;");
            int PlaceID = Integer.parseInt(data[0]);
            String desc = data[1];
            
           // Map<String, Integer> tempExit = new HashMap<>();
           // locations.put(loc, new Location(loc, desc, tempExit)); 
            places.put(PlaceID, new Place(PlaceID, desc, ways)); 
            //System.out.println("Imported PlaceID: " + PlaceID + ": Desc: " + desc);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }	
	
  //------Read txt - Load Ways-----------
     
    try (Scanner scanner = new Scanner(
    						new BufferedReader(
    						new FileReader("./src/main/resources/com/txt/hashMapGame_RomeWays.txt")))){
        scanner.useDelimiter(";");
        while(scanner.hasNextLine()) {
            String input = scanner.nextLine();
            
            String[] data = input.split(";");
            int PlaceID = Integer.parseInt(data[0]);
            String way = data[1];
            int DestinPlaceID = Integer.parseInt(data[2]);
           // System.out.println("PlaceID: "+PlaceID + " : Way: " + way + " :Destination Place: " + DestinPlaceID);
            Place place = places.get(PlaceID);
            place.addWay(way, DestinPlaceID);
        }
    
    } catch (IOException ex) {
        ex.printStackTrace();
    }
		
	}//------------static END
	
	//-----Save into .dat - Save entire objects into dat file-----------//
	public void SaveLocationsAsObjects() {
    	System.out.println("Start Saving Rome Places...");
        
        try (ObjectOutputStream locFile = new ObjectOutputStream(
        									new BufferedOutputStream(
        									new FileOutputStream("./src/main/resources/com/dat/hashMapGame_Places.dat")))) {
            for(Place place : places.values()) { 
            	locFile.writeObject(place);
            	System.out.println("PlaceID: "+place.getPlaceID()+" : "+place.getPlaceDesc());
            }
            //System.out.println("Object written to .dat file");
        }catch(IOException ex){
        	ex.printStackTrace();
        }   
	}
	
	//------Override interface methods----------------
	
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
