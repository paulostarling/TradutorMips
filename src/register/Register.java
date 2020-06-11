package register;

public class Register {
	private String registerName;
	private String value;
	
	public Register(String registerName, String value) {
		this.registerName = registerName;
		this.value = value;
	}

	public String getRegisterName() {
		return registerName;
	}

	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
