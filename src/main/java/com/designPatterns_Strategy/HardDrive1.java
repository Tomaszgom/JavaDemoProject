package com.designPatterns_Strategy;

public class HardDrive1 extends HardDrive{
		
	public HardDrive1(){
		
		super();
		setNameLetter("D");
		setCapacity(1000);
		setPrice(380);
		
			// FilesSystem interface is set polymorphically which defines behavior/characteristic of hard drive file system	
		fileSystem = new NTFS();
		
	}
	
}