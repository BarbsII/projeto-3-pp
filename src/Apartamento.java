/** Classe Apartamento com seus valores e métodos [Subclasse de Imovel]
 * @see Imovel*/

public class Apartamento extends Imovel{
    /** Variáveis específicas da Classe*/
    private String condominio;
    private int andar;

    public Apartamento() {
        System.out.println("Apartamento adicionado");
    }

    /** Reescrita do metodo calculo_comissao para definir a comissao
     * da venda como 30% do valor total*/
    @Override
    public void calculo_comissao(double valor_venda) {
        setValor_venda(valor_venda * 0.3);
    }
}
