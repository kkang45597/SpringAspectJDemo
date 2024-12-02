package com.mingi.aspectj.declaringadvice.model;

public class DefaultUsageTracked implements UsageTracked {

	private int useCount = 0;
	
	@Override
	public void incrementUseCount() {
		useCount++;
		
	}

	@Override
	public int getUseCount() {
		return this.useCount;
	}

}
