/** Classe Terreno com seus valores e métodos [Subclasse de Imovel]
 * @see Imovel*/

public class Terreno extends Imovel {
    /** Variável Específica da Classe*/
    private boolean limpo;

    public Terreno() {
        System.out.println("Terreno adicionado");
    }

    /**
     * Reescrita do metodo calculo_comissao para definir a comissao
     * da venda como 10% do valor total
     *
     * @return Comissao a ser recebida
     */
    @Override
    public double calculo_comissao(double valor_venda) {
        return valor_venda * 0.1;

    }

}
