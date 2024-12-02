package com.mingi.aspectj.declaringadvice.model;

public interface UsageTracked {

	void incrementUseCount();
	
	int getUseCount();
}
