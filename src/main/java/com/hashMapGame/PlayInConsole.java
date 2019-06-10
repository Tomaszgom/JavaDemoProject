package com.hashMapGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//import Input_Output_Basic_src_try_block.Location;
//import Input_Output_Basic_src_try_block.Locations;

/**
 * 
 * Temporary Class handling playing the Game Console
 *
 */

public class PlayInConsole {

	static MapAndLoadPlaces places = new MapAndLoadPlaces();
	
 public static void main(String[] args) {

// static MapAndLoadPlaces places = new MapAndLoadPlaces();
	
	    Scanner scanner = new Scanner(System.in);

        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("EXIT", "EX");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");


        int PlaceID = 1;
        while(true) {
            System.out.println(places.get(PlaceID).getPlaceID() + ". " + places.get(PlaceID).getPlaceDesc());

            if(PlaceID == 0) {
                break;
            }

            Map<String, Integer> ways = places.get(PlaceID).getWays();
            System.out.print("Available ways are: ");
            for(String dir: ways.keySet()) {
                System.out.print(dir + ", ");
            }
            System.out.println();

            String dir = scanner.nextLine().toUpperCase();
            if(dir.length() > 1) {
                String[] words = dir.split(" ");
                for(String word: words) {
                    if(vocabulary.containsKey(word)) {
                        dir = vocabulary.get(word);
                        break;
                    }
                }
            }

            if(ways.containsKey(dir)) {
                PlaceID = ways.get(dir);

            } else {
                System.out.println("You cannot go in that direction");
            }
        }		
				
	System.out.println("Bye!");
	System.exit(0);
	
	}
	
}
