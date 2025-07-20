public abstract class Imovel implements Comissao{
    private double valor_venda;
    private String endereco;
    private int id_venda;
    private String proprietario;
    private String corretor;
    private double comissao_total;
    private double metragem;

    @Override
    public void calculo_comissao(double valor_venda){
        setComissao_total(valor_venda * 0.5);
    };

    public double getMetragem() {
        return metragem;
    }

    public void setMetragem(double metragem) {
        this.metragem = metragem;
    }

    public void setComissao_total(double comissao_total) {
        this.comissao_total = comissao_total;
    }

    public double getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(double valor_venda) {
        this.valor_venda = valor_venda;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getCorretor() {
        return corretor;
    }

    public void setCorretor(String corretor) {
        this.corretor = corretor;
    }
}
