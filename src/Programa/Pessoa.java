package Programa;

public class Pessoa {

    private static int counter = 1;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    public Pessoa(String nome, String cpf, String email, String telefone) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setEmail(email);
        this.setTelefone(telefone);
        counter++;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



    // toString retorna uma String de represantação do objeto
    @Override
    public String toString() {
        return "Pessoa{" +
                "\nConta=" + counter +
                "\nnome= " + nome + '\'' +
                "\ncpf=" + cpf + '\'' +
                "\nemail=" + email + '\'' +
                "\ntelefone=" + telefone + '\'' +
                '}';
    }


}
