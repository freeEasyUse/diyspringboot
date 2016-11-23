package org.freeuse.spbt.batch;

import org.freeuse.spbt.model.PersonBatch;
import org.springframework.batch.item.ItemProcessor;

/**
 * 数据处理
 * @author geliang
 *
 */
public class CsvItemProessor implements ItemProcessor<PersonBatch, PersonBatch> {

	@Override
	public PersonBatch process(PersonBatch person) throws Exception {
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
