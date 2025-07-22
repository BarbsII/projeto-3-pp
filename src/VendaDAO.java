import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {
    private static final String ARQUIVO_CSV = "vendas.csv";
    private static int proximoId = 1;

    public static void salvarVenda(Venda venda) {
        try (FileWriter fw = new FileWriter(ARQUIVO_CSV, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            out.println(vendaToCSV(venda));
            CorretorDAO.registrarVenda(venda.getId_venda(), venda.getId_corretor());
        } catch (IOException e) {
            System.err.println("Erro ao salvar venda: " + e.getMessage());
        }
    }

    private static String vendaToCSV(Venda venda) {
        return String.join(",",
                String.valueOf(venda.getId_venda()),
                String.valueOf(venda.getId_corretor()),
                String.valueOf(venda.getId_imovel()),
                String.valueOf(venda.getValor_venda())
        );
    }

    public static List<Venda> listarVendas() {
        List<Venda> vendas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_CSV))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                Venda venda = new Venda();
                venda.setId_venda(Integer.parseInt(dados[0]));
                venda.setId_corretor(Integer.parseInt(dados[1]));
                venda.setId_imovel(Integer.parseInt(dados[2]));
                venda.setValor_venda(Double.parseDouble(dados[3]));
                vendas.add(venda);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler vendas: " + e.getMessage());
        }
        return vendas;
    }

    public static int getProximoId() {
        return proximoId++;
    }
}