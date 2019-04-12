import com.zsx.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/resources/applicationContext.xml", 
		"file:src/main/resources/springMVC-servlet.xml" })
//		"file:src/main/resources/spring-hibernate.xml",
public class UnitTest {

	@Autowired
	TestService testService;
	
	@Test
	public void name() {

		String nihao = testService.getName("a1");
		System.out.println(nihao);


	}

}
