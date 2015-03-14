package dk.jpconsulting.config;

import dk.jpconsulting.batch.SiteBatchProcessor;
import dk.jpconsulting.domain.Site;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@EnableBatchProcessing
@Configuration
public class BatchConfiguration {

    @Bean
    public ItemProcessor<Site, Site> processor() {
        return new SiteBatchProcessor();
    }

    @Bean
    public ItemReader<Site> reader(EntityManager entityManager) throws Exception {
        JpaPagingItemReader<Site> siteJpaPagingItemReader = new JpaPagingItemReader<>();
        siteJpaPagingItemReader.setEntityManagerFactory(entityManager.getEntityManagerFactory());
        siteJpaPagingItemReader.setQueryString("from Site");
        siteJpaPagingItemReader.setPageSize(1);
        siteJpaPagingItemReader.afterPropertiesSet();
        siteJpaPagingItemReader.setSaveState(true);

        return siteJpaPagingItemReader;
    }

    @Bean
    public ItemWriter<Site> writer(EntityManager entityManager) {
        JpaItemWriter<Site> jpaItemWriter = new JpaItemWriter<>();
        jpaItemWriter.setEntityManagerFactory(entityManager.getEntityManagerFactory());

        return jpaItemWriter;
    }

    @Bean
    public Job importUserJob(JobBuilderFactory jobs, Step s1) {
        return jobs.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .flow(s1)
                .end()
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<Site> reader,
                      ItemWriter<Site> writer, ItemProcessor<Site, Site> processor) {
        return stepBuilderFactory.get("step1")
                .<Site, Site>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
