package org.freeuse.spbt.test.respository;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.freeuse.spbt.jpa.dao.PersonRepository;
import org.freeuse.spbt.jpa.entity.Person;
import org.freeuse.spbt.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;

public class PersonDaoTest extends BaseTest {

	@Autowired
	private PersonRepository personRepository;
	
	
	@Autowired
	private TaskExecutor taskExecutor;
	
	@Test
	public void findByNameTest(){
		List<Person> people = personRepository.findAll();
		System.out.println(people);
	}
	
	
	
	/**
	 * 异步查询测试
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	@Test
	public void asyncFindByAddressTest() throws Exception{
		System.out.println("异步查询结束");
		taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				Future<List<Person>> future = personRepository.findByAddress("天津");
				System.out.println("future is done:"+future.isDone());
				try {
					List<Person> result = future.get();
					System.out.println("result"+result);
					System.out.println("future is done:"+future.isDone());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("查询结束");
		Thread.sleep(1000000000);
	}
	
}
