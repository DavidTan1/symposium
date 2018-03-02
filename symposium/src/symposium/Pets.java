package symposium;

public class Pets {

	private String name; 
	private int str;
	private int agl;
	
	public Pets(String name, int str, int agl) {
		this.setName(name);
		this.setStr(str);
		this.setAgl(agl);
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getAgl() {
		return agl;
	}

	public void setAgl(int agl) {
		this.agl = agl;
	}

}
