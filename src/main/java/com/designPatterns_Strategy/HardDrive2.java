package com.designPatterns_Strategy;

public class HardDrive2 extends HardDrive{
	
	public String saveData(){		
		return "Data saved";		
	}
	 
	public HardDrive2(){		
		super();		
		setNameLetter("E");
		setCapacity(500);
		setPrice(200);
		
			// FilesSystem interface is set polymorphically which defines behavior/characteristic of hard drive file system	
		fileSystem = new FAT32();		
	
	}	
}
