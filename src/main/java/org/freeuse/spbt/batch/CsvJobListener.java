package org.freeuse.spbt.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * job listener
 * @author geliang
 *
 */
public class CsvJobListener implements JobExecutionListener {

	long startTime;
	
	long endTime;
	
	@Override
	public void afterJob(JobExecution arg0) {
		
		startTime = System.currentTimeMillis();
		System.out.println("start deal job");
		
	}

	@Override
	public void beforeJob(JobExecution arg0) {

		endTime = System.currentTimeMillis();
		System.out.println("end job");
		System.out.println("use the time:"+(endTime-startTime));
		
	}

}
