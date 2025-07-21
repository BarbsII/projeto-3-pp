import java.util.HashSet;
import java.util.Set;

/** Classe Corretor para guardar seus valores e métodos*/

public class Corretor {
    /** Variáveis necessárias*/
    private String nome;
    private int id_corretor;
    private Set<Integer> vendas_realizadas = new HashSet<Integer>(); // lista de vendas feitas pelo corretor

    public Set<Integer> getVendas_realizadas() {
        return vendas_realizadas;
    }

    public void setVendas_realizadas(Set<Integer> vendas_realizadas) {
        this.vendas_realizadas = vendas_realizadas;
    }

    public void insertVendas_realizadas(Integer id_venda) {
        this.vendas_realizadas.add(id_venda);
    }
}
