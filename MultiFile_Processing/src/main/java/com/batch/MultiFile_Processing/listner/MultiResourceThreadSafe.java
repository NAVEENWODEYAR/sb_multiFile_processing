package com.batch.MultiFile_Processing.listner;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.core.io.Resource;

/**
 * @author NaveenWodeyar
 * @date 10-Sept-2024
 * @time 12:45:39 am
 */
public class MultiResourceThreadSafe<T> implements ItemReader<T>{

	private final MultiResourceItemReader<T> delegate;
	
	public MultiResourceThreadSafe(MultiResourceItemReader<T> delegate) {
		super();
		this.delegate = delegate;
	}

	private final Object lock = new Object();
	
	@Override
	public T read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		synchronized (lock) {
			return delegate.read();
		}
	}
	
	public void setResource(Resource[] resources) {
		synchronized (lock) {
			delegate.setResources(resources);
		}
	}

	public void open(ExecutionContext context) {
		synchronized (lock) {
			delegate.open(context);
		}
	}
	
	public void close() {
		synchronized (lock) {
			delegate.close();
		}
	}
}
