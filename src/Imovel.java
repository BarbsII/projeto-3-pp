
/** Superclasse abstrata Imovel que contem valores e métodos básicos para todos os tipos de imóveis */

public abstract class Imovel implements Comissao{
    /** Variáveis necessarias*/
    private String endereco;
    private int id_imovel;
    private String proprietario;
    private String corretor;
    private double comissao_total;
    private double metragem;

    /** Métodos Get e Set dos valores*/
    public double getMetragem() {
        return metragem;
    }

    public void setMetragem(double metragem) {
        this.metragem = metragem;
    }

    public void setComissao_total(double comissao_total) {
        this.comissao_total = comissao_total;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId_imovel() {
        return id_imovel;
    }

    public void setId_imovel(int id_imovel) {
        this.id_imovel = id_imovel;
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
