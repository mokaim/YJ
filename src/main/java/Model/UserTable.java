package Model;

public class UserTable {
	private String ID;
	private String PW;
	private String NName; // 닉네임
	private String Phone;
	private String Email;
	
	public UserTable(String id, String pw, String nname, String phone, String email) {
		this.ID = id;
		this.PW = pw;
		this.NName = nname;
		this.Phone = phone;
		this.Email = email;
	}
	
	// Getter Setter
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public String getNName() {
		return NName;
	}

	public void setNName(String nName) {
		NName = nName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
}
