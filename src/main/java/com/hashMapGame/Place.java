package com.hashMapGame;

import java.io.Serializable;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Comparator;

public class Place implements Serializable{
	
	private static final long serialVersionUID = 10L;
	private int placeID;
	private String placeDesc;
	private final Map<String, Integer> ways;

	public Place(int PlaceID, String PlaceDesc, Map<String,  Integer> ways) {
		this.placeID = PlaceID;
		this.placeDesc = PlaceDesc;
	
		if(ways != null) {
									
			/** Tree Map Alternative Constructor without Comparator **/
			//private Map<String, Integer> wMap = new TreeMap<String, Integer>(ways);
			
			/** TreeMap Constructor with Comparator **/
			Map<String, Integer> wMap = new TreeMap<String, Integer>(new Comparator<String>() {
                	@Override
                	public int compare(String s1, String s2) {
                    return s2.compareTo(s1);
                    }
            });	
			wMap.putAll(ways);
			this.ways = wMap;
			
		} else {	
			System.out.println("Could not create ways in Constructor: ways = null");
			System.exit(0);
			this.ways = new TreeMap<String, Integer>();
		}
		this.ways.put("EX", 0);
	}
	

    protected void addWay(String dir, int PlaceID) {
        ways.put(dir, PlaceID);
    }
	public int getPlaceID() {
		return placeID;
	}
	public String getPlaceDesc() {
		return placeDesc;
	}

    public Map<String, Integer> getWays() {
    	
    	Map<String, Integer> wMap = new TreeMap<String, Integer>(new Comparator<String>() {
        	@Override
        	public int compare(String s1, String s2) {
            return s1.compareTo(s2);          
            }
    	});	
		wMap.putAll(ways);		   	
        return wMap;
    }
}
