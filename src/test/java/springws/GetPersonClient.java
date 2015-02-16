package springws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
@Service
public class GetPersonClient implements MarshallingPersonService{
	@Autowired
	private WebServiceTemplate wsTemplate;
	   
   
    public PersonResponse getPersons(GetPersonsRequest request) {
        PersonResponse response = 
            (PersonResponse) wsTemplate.marshalSendAndReceive(request);
        return response;
        
    }
}
