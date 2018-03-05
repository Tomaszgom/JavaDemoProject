package com.designPatterns_Strategy;

public class HardDrive {
	
	private String nameLetter;
	private double capacity;
	private double accessTime;
	private int weight;
	private float price;
	
/*Strategy Pattern may be used in case there is a need to define super class and a series of sub-class that will have one characteristic or behavior
/*	that is similar in a sense that it can be defined as the same type of behavior or character but in detail it differs.
	Instead of implementing an interface in typical way and overriding methods in each sub-class
	we use an instance variable that is interface subclass with appropriate method.
	We use here Composition, instead of typical inheriting, we compose super class including object with desired characteristic.
	This also allows to change the characteristic at run time*/
		
	public FileSystem fileSystem;
	
		// fileSystem takes responsibility for choice of system that is used	
	public String useFileSystem(){		
		return fileSystem.fileSystem();		
	}
	
		// possibility to change file system dynamically	
	public void setFileSystem(FileSystem newFileSys){
		fileSystem = newFileSys;
	}
		
	public void setNameLetter(String nmLet){ nameLetter = nmLet; }
	public String getNameLetter(){ return nameLetter; }

	public void setCapacity(double cap){ capacity = cap; }
	public double getCapacity(){ return capacity; }
	
	public double getAccessTime(){ return accessTime; }
	public int getWeight(){ return weight; }

	
	public void setPrice(int newPrice){ 
		if (newPrice > 20){
			price = newPrice; 
		} else {
			System.out.println("Price must be higer than 20");
		}
	}
	public double getPrice(){ return price; }
		
}
