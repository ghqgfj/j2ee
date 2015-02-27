package springws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

@Endpoint
public class PersonEndpoint implements MarshallingPersonService {

	@PayloadRoot(localPart = GET_PERSONS_REQUEST, namespace = NAMESPACE)
	public PersonResponse getPersons(GetPersonsRequest request) {
		List<Person> persons = new ArrayList<Person>();
		Person person1 = new Person(1, "jin", "qian");
		Person person2 = new Person(1, "world", "hello");
		persons.add(person1);
		persons.add(person2);
		PersonResponse response = new PersonResponse();
		response.setPerson(persons);
		return response;
	}

}
