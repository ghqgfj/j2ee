package springmvc;

public class User {
	private String name;
	private String message;

	public User(String name, String message) {
		this.name = name;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getName() {
		return name;
	}
}
