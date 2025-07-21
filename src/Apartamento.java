/** Classe Apartamento com seus valores e métodos [Subclasse de Imovel]
 * @see Imovel*/

public class Apartamento extends Imovel{
    /** Variáveis específicas da Classe*/
    private String condominio;
    private int andar;

    public Apartamento() {
        System.out.println("Apartamento adicionado");
    }

    /**
     * Reescrita do metodo calculo_comissao para definir a comissao
     * da venda como 30% do valor total
     *
     * @return Comissao a ser recebida
     */
    @Override
    public double calculo_comissao(double valor_venda) {
        return valor_venda * 0.3;
    }
}
