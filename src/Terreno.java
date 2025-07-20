public class Terreno extends Imovel {
    private boolean limpo;

    public Terreno() {
        System.out.println("Terreno adicionado");
    }

    @Override
    public void calculo_comissao(double valor_venda) {
        setValor_venda(valor_venda * 0.1);
    }

}
