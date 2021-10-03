package test1;

import com.AppConfig;
import com.zsx.service.TestTransactionService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * todo 没有测试成功
 */
public class TestUnitTest {

	static AnnotationConfigApplicationContext ac;

	@BeforeAll
	static void before() {
		ac = new AnnotationConfigApplicationContext();
		ac.register(AppConfig.class);
		ac.refresh();
	}


	@Test
	void t1() {
		TestTransactionService testTransactionService = ac.getBean(TestTransactionService.class);
		String res = testTransactionService.testTransaction(2);

		System.out.println(res);
	}

}
