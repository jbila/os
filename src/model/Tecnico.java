package model;

public class Tecnico extends AbstractEntity {

    private String contacto;
    private String email;
    private Funcao funcao;

    public Tecnico() {
    }

    public Tecnico(String contacto, String email) {
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

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return getNome();
    }

}
