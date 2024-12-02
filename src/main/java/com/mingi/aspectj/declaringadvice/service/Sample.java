package com.mingi.aspectj.declaringadvice.service;

import java.util.Collection;

public interface Sample<T> {

	void sampleGenericMethod(T sampleGenericParam);
	
	void sampleGenericCollection(Collection<T> param);
}
