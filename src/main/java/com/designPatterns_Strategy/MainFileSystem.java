package com.designPatterns_Strategy;

public class MainFileSystem{
	
	private static String outp;
	
	public static void main(String[] args){
		
		HardDrive drive1 = new HardDrive1();
		HardDrive drive2 = new HardDrive2();
		HardDrive3 drive3 = new HardDrive3();
		
		outp = "Drive "+drive1.getNameLetter()+ drive1.useFileSystem();
		outp = outp +" # Capacity "+drive1.getCapacity();		
		
		outp = outp+"\n" + "Drive "+drive2.getNameLetter() + drive2.useFileSystem();
		outp = outp + " # Capacity "+drive2.getCapacity();		
		outp = outp +"\n" + "Drive "+drive3.getNameLetter()+ drive3.useFileSystem();
		outp = outp + " # Capacity "+drive3.getCapacity();
		outp = outp +"\n" +"Drive "+drive3.getNameLetter()+drive3.saveData();								
		drive2.setFileSystem(new NTFS());// This allows dynamic changes for flyingType	
		outp = outp +"\n" + "Drive "+drive2.getNameLetter()+" file system dynamically changed and now " + drive2.useFileSystem();
		outp = outp +" # Capacity "+drive2.getCapacity();
		
		System.out.print(outp);	
	}
	public static String GetOutput() {
		return outp;
	}
}