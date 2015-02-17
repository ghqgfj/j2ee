package springmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/springmvc")
public class RequestMappingController {
	@RequestMapping(value = "/xml", method = RequestMethod.POST, consumes = "application/xml")
	public ResponseEntity<String> processXml(@RequestBody String requestBody) {
		return new ResponseEntity<String>(
				"Handled application/xml request. Request body was: "
						+ requestBody, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/json", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> processJson(@RequestBody String requestBody) {
		return new ResponseEntity<String>(
				"Handled application/json request. Request body was: "
						+ requestBody, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/modelandview")
	public ModelAndView hello() {
		User user = new User("John Doe", "Some random message");
		return new ModelAndView("hello", "user", user);
	}

	@RequestMapping(value = "/departments")
	public String simplePattern() {

		System.out.println("simplePattern method was called");
		return "someResult";

	}

	@RequestMapping(value = "/departments")
	public String findDepatment(
			@RequestParam("departmentId") String departmentId) {
		System.out.println("Find department with ID: " + departmentId);
		return "someResult";

	}

	@RequestMapping(value = "/departments/{departmentId}/employees/{employeeId}")
	public String findEmployee(@PathVariable String departmentId,
			@PathVariable String employeeId) {
		System.out.println("Find employee with ID: " + employeeId
				+ " from department: " + departmentId);
		return "someResult";

	}
}
