package model;

public class Utilizador extends AbstractEntity {
	private String email;
	private String password;
	private String status;//ACTIVO/INACTIVO
	private String perfil;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	@Override
	public String toString() {
		return "Utilizador [email=" + email + ", password=" + password + ", status=" + status + ", perfil=" + perfil
				+ "]";
	}
	
	

}
