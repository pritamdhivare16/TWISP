package com.customException;


public class ResourceNotFoundException extends RuntimeException{
public ResourceNotFoundException(String name) {
	super(name);
}
}
