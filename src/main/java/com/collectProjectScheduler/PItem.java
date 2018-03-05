package com.collectProjectScheduler;


public class PItem {
	  private String shortDescription;
	  
	  
	  public PItem(String shortDescription) {
	        this.shortDescription = shortDescription;
	    }
	  

	    @Override
	    public String toString() {
	        return shortDescription;
	    } 
	  
}
