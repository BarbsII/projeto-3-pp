import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CorretorDAO {
    private static Map<Integer, Corretor> corretores = new HashMap<>();
    private static Map<Integer, Integer> vendaCorretorMap = new HashMap<>();

    public static void cadastrarCorretor(Corretor corretor) {
        corretores.put(corretor.getId_corretor(), corretor);
    }

    public static Corretor getCorretor(int id) {
        return corretores.get(id);
    }

    public static void registrarVenda(int idVenda, int idCorretor) {
        vendaCorretorMap.put(idVenda, idCorretor);
        Corretor corretor = corretores.get(idCorretor);
        if (corretor != null) {
            corretor.insertVendas_realizadas(idVenda);
        }
    }

    public static List<Corretor> listarCorretores() {
        return new ArrayList<>(corretores.values());
    }
}