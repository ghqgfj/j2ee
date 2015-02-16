package springws;

public interface MarshallingPersonService {
    
    public final static String NAMESPACE = "http://springws/person/schema/beans";
    public final static String GET_PERSONS_REQUEST = "get-persons-request";

    /**
     * Gets person list.
     */
    public PersonResponse getPersons(GetPersonsRequest request);

}
