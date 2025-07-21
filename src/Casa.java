/** Classe Casa com seus valores e métodos [Subclasse de Imovel]
 * @see Imovel*/

public class Casa extends Imovel{
    /** Variável Específica da Classe*/
    private int qtd_andares;

    public Casa() {
        System.out.println("Casa adicionado");
    }

    /**
     * Reescrita do metodo calculo_comissao para definir a comissao
     * da venda como 20% do valor total
     *
     * @return Comissao a ser recebida
     */
    @Override
    public double calculo_comissao(double valor_venda) {
        return valor_venda * 0.2;
    }
}
