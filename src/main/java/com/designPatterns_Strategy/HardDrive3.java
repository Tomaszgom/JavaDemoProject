package com.designPatterns_Strategy;

public class HardDrive3 extends HardDrive{
	
	public String saveData(){		
		return "Drive "+getNameLetter()+" 'SaveData method has been called.";		
	}
 
	public HardDrive3(){		
		super();		
		setNameLetter("F");
		setCapacity(100);
		setPrice(100);
		
			// FilesSystem interface is set polymorphically which defines behavior/characteristic of hard drive file system	
		fileSystem = new ext2();		
	}	
}
