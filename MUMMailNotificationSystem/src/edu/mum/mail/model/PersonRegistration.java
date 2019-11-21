package edu.mum.mail.model;

public class PersonRegistration {
    
	private int personId;
	private String fname;
    private String lname;
    private String ptype;
    private String email;
    private String phone;
    private String boxnumber;//string
   

    public int getPersonId() {
    	return personId;
    }
    
    public void setPersonId(int personId) {
    	this.personId = personId;
    }
    
    
    public PersonRegistration() {
    }

    public PersonRegistration(String fname, String lname, String ptype, String email, String phone, String boxnumber) {
        this.fname = fname;
        this.lname = lname;
        this.ptype = ptype;
        this.email = email;
        this.phone = phone;
        this.boxnumber = boxnumber;
    }


	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBoxnumber() {
		return boxnumber;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public void setBoxnumber(String boxnumber) {
		this.boxnumber = boxnumber;
	}

	@Override
    public String toString() {
        return "PersonRegistration{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", ptype='" + ptype + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", boxnumber='" + boxnumber + '\'' +
                '}';
    }
}
