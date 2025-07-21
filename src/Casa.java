/** Classe Casa com seus valores e métodos [Subclasse de Imovel]
 * @see Imovel*/

public class Casa extends Imovel{
    private int qtd_andares;

    public Casa() {
        System.out.println("Casa adicionado");
    }

    @Override
    public void calculo_comissao(double valor_venda) {
        setValor_venda(valor_venda * 0.2);
    }
}
