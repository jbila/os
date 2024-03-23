package model;


public class Cliente extends AbstractEntity{
	private String contacto;
	private String email;
	
	public Cliente() {
	}

    public Cliente(String contacto, String email) {
        this.contacto = contacto;
        this.email = email;
    }
        

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getEmail() {
		return email.toLowerCase();
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

    @Override
    public String toString() {
        return getNome();
    }

	
                

}
