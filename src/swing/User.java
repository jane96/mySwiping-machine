package swing;

public class User {
	
	private String id;
	private String name;
	private Class1 class1;
	public User(){
		
	}
	public User(String id, String name, Class1 class1) {
		super();
		
		this.id = id;
		this.name = name;
		this.class1 = class1;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Class1 getClass1() {
		return class1;
	}
	public void setClass1(Class1 class1) {
		this.class1 = class1;
	}
	
}
