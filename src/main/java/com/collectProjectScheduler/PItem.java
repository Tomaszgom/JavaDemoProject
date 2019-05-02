package com.collectProjectScheduler;

/**
 * 
 * @author Tomasz Gomoradzki
 * 'Item' Object class which is part of Project Scheduler Module
 *  More information about the module in Controllers package, Project Scheduler Controller Class
 * 
 */

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
