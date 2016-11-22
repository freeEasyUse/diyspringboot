package org.freeuse.spbt.batch;

import org.freeuse.spbt.model.PersonBatch;
import org.springframework.batch.item.validator.ValidatingItemProcessor;

/**
 * 数据处理
 * @author geliang
 *
 */
public class CsvItemProessor extends ValidatingItemProcessor<PersonBatch> {

	public PersonBatch process(PersonBatch person){
		super.process(person);
		if(person.getNation().equals("汉族")){
			person.setNation("01");
		}
		else
		{
			person.setNation("02");
		}
		return person;
	}
	
}
