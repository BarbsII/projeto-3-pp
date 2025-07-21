/** Classe Venda para registro de informações da mesma*/

public class Venda {
    private int id_corretor;
    private int id_venda;
    private int id_imovel;
    private double valor_venda;

    public int getId_corretor() {
        return id_corretor;
    }

    public void setId_corretor(int id_corretor) {
        this.id_corretor = id_corretor;
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public int getId_imovel() {
        return id_imovel;
    }

    public void setId_imovel(int id_imovel) {
        this.id_imovel = id_imovel;
    }

    public double getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(double valor_venda) {
        this.valor_venda = valor_venda;
    }
}
