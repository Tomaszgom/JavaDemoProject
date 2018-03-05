package com.videoGame2D;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void main(String[] args) {
		System.out.println("TEST TEST TEST");
		
/*		for(int i = 0; i<30; i++) {
			double rand = Math.random();
		System.out.print(rand+"---");
		System.out.print(rand*(960)+"---");
		System.out.println(rand*(960)+1);		
		}*/
		
		
	// ------	Generate random in range
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		for(int i = 0; i<30; i++) {
		double randomNum = ThreadLocalRandom.current().nextInt(-10, 1);
		//float randomNum = ThreadLocalRandom.current().nextFloat();
		System.out.println(randomNum);
		}

	}

}
