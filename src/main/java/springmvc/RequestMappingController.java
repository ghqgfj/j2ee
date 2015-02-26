package springmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/springmvc")
public class RequestMappingController {
	User user = new User("John Doe", "Some random message");
	@RequestMapping(value = "/xml", method = RequestMethod.POST, consumes = "application/xml")
	public ResponseEntity<String> processXml(@RequestBody String requestBody) {
		System.out.println(requestBody);
		return new ResponseEntity<String>(
				"Handled application/xml request. Request body was: "
						+ requestBody, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/json", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> processJson(@RequestBody String requestBody) {
		System.out.println(requestBody);
		return new ResponseEntity<String>(
				"Handled application/json request. Request body was: "
						+ requestBody, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/modelandview")
	public ModelAndView hello() {		
		return new ModelAndView("hello", "user", user);
	}

	@RequestMapping(value = "/simple")
	public String simplePattern(ModelMap model) {		
		model.addAttribute(user);
        model.addAttribute("function", "simplePatter");
		System.out.println("simplePattern method was called");
		return "hello";

	}

	@RequestMapping(value = "/departments")
	public String findDepatment(
			@RequestParam("departmentId") String departmentId,ModelMap model) {
		System.out.println("Find department with ID: " + departmentId);
		model.addAttribute(user);
        model.addAttribute("departmentId", departmentId);
		return "hello";

	}

	@RequestMapping(value = "/departments/{departmentId}/employees/{employeeId}")
	public String findEmployee(@PathVariable String departmentId,
			@PathVariable String employeeId,ModelMap model) {
		System.out.println("Find employee with ID: " + employeeId
				+ " from department: " + departmentId);
		model.addAttribute(user);
        model.addAttribute("departmentId", departmentId);
        model.addAttribute("employeeId", employeeId);
		return "hello";

	}
}
