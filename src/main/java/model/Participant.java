package model;

public class Participant {
	private String p_id;
    private String pname;
    private String phone;
    private String email;
    private String b_id;
    
    
	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	Participant(String p_id, String pname, String phone, String email, String b_id) {
		super();
		this.p_id = p_id;
		this.pname = pname;
		this.phone = phone;
		this.email = email;
		this.b_id = b_id;
	}
	
	
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
    
    

}
