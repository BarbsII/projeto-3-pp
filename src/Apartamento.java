/** Classe Apartamento com seus valores e métodos [Subclasse de Imovel]
 * @see Imovel*/

public class Apartamento extends Imovel{
    private String condominio;
    private int andar;

    public Apartamento() {
        System.out.println("Apartamento adicionado");
    }

    @Override
    public void calculo_comissao(double valor_venda) {
        setValor_venda(valor_venda * 0.3);
    }
}
