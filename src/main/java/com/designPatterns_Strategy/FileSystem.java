package com.designPatterns_Strategy;

/*Created Interface, we will be used in HardDrive sub-classes with instance variable
which is set as appropriate file system class implementing FileSystem interface. This
allows not to affect HardDrive classes which do not typically implement interfaces but
still allows them to use interface. This is also known as decoupling, that is encapsulating
characteristic or behavior that varies. Classes that implement file System allow other
classes to use exact same code without its duplication.*/


	//Decoupling : characteristic that varies
public interface FileSystem {
String fileSystem();
}

class FAT32 implements FileSystem{
	public String fileSystem() {
		return " Uses FAT32 File System";		
	}
}
class NTFS implements FileSystem{
	public String fileSystem() {
		return " Uses NTFS File System";
	}
}
class ext2 implements FileSystem{
	public String fileSystem() {
		return " Uses ext2 File System";
	}
	
}
