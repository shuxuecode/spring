import com.zsx.processor.TestItemProcessor;
import com.zsx.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/resources/applicationContext.xml",
        "file:src/main/resources/springMVC-servlet.xml"})
//		"file:src/main/resources/spring-hibernate.xml",
@WebAppConfiguration
public class UnitTest {

    @Autowired
    TestService testService;

    @Autowired
    PlatformTransactionManager transactionManager;
    @Autowired
    JobRepository jobRepository;
    @Autowired
    JobLauncher jobLauncher;


    @Test
    public void aaaa() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        ItemReader<Integer> itemReader = new ItemReader<Integer>() {
            public Integer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
                if (new Date().getMinutes() / 5 == 0){
                    return null;
                }

                System.out.println("读取");
                return 99;
            }
        };

        ItemWriter<Integer> itemWriter = new ItemWriter<Integer>() {
            public void write(List<? extends Integer> list) throws Exception {
                System.out.println("写操作，结果为：" + list);
            }
        };


        TestItemProcessor testItemProcessor = new TestItemProcessor();

        // 创建Step
        StepBuilderFactory stepBuilderFactory = new StepBuilderFactory(jobRepository, transactionManager);
        TaskletStep step = stepBuilderFactory.get("step")
                .<Integer, Integer>chunk(1)
                .reader(itemReader)
                .processor(testItemProcessor)
                .writer(itemWriter)
                .build();


        // 创建Job
        JobBuilderFactory jobBuilderFactory = new JobBuilderFactory(jobRepository);
        Job job = jobBuilderFactory.get("job")
                .start(step)
                .build();

        // 启动任务
        jobLauncher.run(job, new JobParameters());

    }

    @Test
    public void name() {

        String nihao = testService.getName("a1");
        System.out.println(nihao);


    }

}
