package springws;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class GetPersonTest{
	@Autowired
	private GetPersonClient client;
	@Test
	public void testGetPerson() {		
		PersonResponse response = client.getPersons(new GetPersonsRequest());
		System.out.println(response.getPerson().size());
	}
}
