package org.freeuse.spbt.batch;


import javax.sql.DataSource;

import org.freeuse.spbt.model.PersonBatch;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * batch config
 * @author geliang
 *
 */

@Configuration
@EnableBatchProcessing
public class CsvBatchConfig {

	/**
	 * itemReader
	 */
	@Bean
	public ItemReader<PersonBatch> reader() throws Exception{
		FlatFileItemReader<PersonBatch> reader = new FlatFileItemReader<PersonBatch>();
		reader.setResource(new ClassPathResource("people.csv"));
		reader.setLineMapper(new DefaultLineMapper<PersonBatch>(){
			{
				setLineTokenizer(new DelimitedLineTokenizer(){
					{
						setNames(new String[]{"name","age","nation","address"});
					}
				});
				
				setFieldSetMapper(new BeanWrapperFieldSetMapper<PersonBatch>(){
					{
						setTargetType(PersonBatch.class);
					}
				});
			}
		});
		return reader;
	}
	
	
	/**
	 * process
	 */
	@Bean
	public ItemProcessor<PersonBatch, PersonBatch> processor(){
		CsvItemProessor csvItemProessor = new CsvItemProessor();
		return csvItemProessor;
	}
	
	/**
	 * writer
	 */
	@Bean
	public ItemWriter<PersonBatch> writer(DataSource dataSource){
		JdbcBatchItemWriter<PersonBatch> batchItemWriter = new JdbcBatchItemWriter<PersonBatch>();
		batchItemWriter.setDataSource(dataSource);
		batchItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<PersonBatch>());
		String sql = "insert into PERSONBATCH"+"(id,name,age,nation,address)"+"values(PERSONBATCH_SEQ.nextval,:name,:age,:nation,:address)";
		batchItemWriter.setSql(sql);
		return batchItemWriter;
	}
	
	
	/**
	 * job 容器
	 * @param dataSource
	 * @param transactionManager
	 * @return
	 * @throws Exception
	 */
	@Bean
	public JobRepository jobRepository(DataSource dataSource,PlatformTransactionManager transactionManager) throws Exception{
		JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
		jobRepositoryFactoryBean.setDataSource(dataSource);
		jobRepositoryFactoryBean.setTransactionManager(transactionManager);
		jobRepositoryFactoryBean.setDatabaseType("oracle");
		return jobRepositoryFactoryBean.getObject();
	}
	
	@Bean
	public SimpleJobLauncher jobLauncher(DataSource dataSource,PlatformTransactionManager transactionManager) throws Exception{
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(jobRepository(dataSource,transactionManager));
		return jobLauncher;
	}
	
	
	@Bean
	public Job importJob(JobBuilderFactory jobs,Step s1){
		return jobs.get("importJob").incrementer(new RunIdIncrementer()).flow(s1).end().listener(new CsvJobListener()).build();
	}
	
	@Bean
	public Step step1(StepBuilderFactory stepBuilderFactory,ItemReader<PersonBatch> reader,ItemWriter<PersonBatch> writer,ItemProcessor<PersonBatch, PersonBatch> processor){
		return stepBuilderFactory.get("step1").<PersonBatch,PersonBatch>chunk(65000).reader(reader).processor(processor).writer(writer).build();
	}
	
}
