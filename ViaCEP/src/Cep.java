public class Cep {
    private int cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String siglaEstado;

    public Cep(int cep){
            this.cep = cep;
    }

    public int getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }
}
