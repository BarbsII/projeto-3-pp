import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SistemaImobiliarioGUI {
    public static void init() {
        JFrame frame = new JFrame("Empresa Y - Sistema Imobiliário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));

        JButton btnCadastrarVenda = new JButton("Cadastrar Venda");
        JButton btnConsultarVendas = new JButton("Consultar Vendas");
        JButton btnCadastrarCorretor = new JButton("Cadastrar Corretor");
        JButton btnConsultarCorretores = new JButton("Consultar Corretores");
        JButton btnAltExVendas = new JButton("Alterar ou Excluir Vendas");

        btnCadastrarVenda.addActionListener(e -> mostrarTelaCadastroVenda());
        btnConsultarVendas.addActionListener(e -> mostrarConsultarVendas());
        btnCadastrarCorretor.addActionListener(e -> mostrarCadastroCorretor());
        btnConsultarCorretores.addActionListener(e -> mostrarConsultarCorretores());
        btnAltExVendas.addActionListener(e -> mostrarAltExVendas());

        panel.add(btnCadastrarVenda);
        panel.add(btnConsultarVendas);
        panel.add(btnCadastrarCorretor);
        panel.add(btnConsultarCorretores);
        panel.add(btnAltExVendas);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void mostrarTelaCadastroVenda() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Cadastrar Venda");
        dialog.setSize(500, 400);
        dialog.setLayout(new GridLayout(8, 2, 5, 5));

        dialog.add(new JLabel("ID Corretor:"));
        JTextField txtIdCorretor = new JTextField();
        dialog.add(txtIdCorretor);

        dialog.add(new JLabel("Tipo Imóvel:"));
        JComboBox<String> cbTipoImovel = new JComboBox<>(new String[]{"Apartamento", "Casa", "Terreno"});
        dialog.add(cbTipoImovel);

        dialog.add(new JLabel("ID Imóvel:"));
        JTextField txtIdImovel = new JTextField();
        dialog.add(txtIdImovel);

        dialog.add(new JLabel("Valor da Venda:"));
        JTextField txtValorVenda = new JTextField();
        dialog.add(txtValorVenda);

        JButton btnSalvar = new JButton("Salvar Venda");
        dialog.add(btnSalvar);

        JLabel lblMensagem = new JLabel("");
        dialog.add(lblMensagem);

        btnSalvar.addActionListener(e -> {
            try {
                Venda venda = new Venda();
                venda.setId_venda(VendaDAO.getProximoId());
                venda.setId_corretor(Integer.parseInt(txtIdCorretor.getText()));
                venda.setId_imovel(Integer.parseInt(txtIdImovel.getText()));
                venda.setValor_venda(Double.parseDouble(txtValorVenda.getText()));

                VendaDAO.salvarVenda(venda);

                // Calcula a comissão conforme o tipo de imóvel
                Imovel imovel = criarImovel(cbTipoImovel.getSelectedIndex());
                double comissao = imovel.calculo_comissao(venda.getValor_venda());

                lblMensagem.setText(String.format("Venda cadastrada! ID: %d | Comissão: R$%.2f",
                        venda.getId_venda(), comissao));
            } catch (Exception ex) {
                lblMensagem.setText("Erro: " + ex.getMessage());
            }
        });

        dialog.setVisible(true);
    }

    private static Imovel criarImovel(int tipo) {
        switch(tipo) {
            case 0: return new Apartamento();
            case 1: return new Casa();
            default: return new Terreno();
        }
    }

    private static void mostrarConsultarVendas() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Vendas Registradas");
        dialog.setSize(600, 400);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        StringBuilder sb = new StringBuilder("=== VENDAS REGISTRADAS ===\n\n");
        for (Venda venda : VendaDAO.listarVendas()) {
            Corretor corretor = CorretorDAO.getCorretor(venda.getId_corretor());
            sb.append(String.format("ID: %d | Corretor: %s (ID: %d) | Valor: R$%.2f\n",
                    venda.getId_venda(),
                    corretor != null ? corretor.getNome() : "Desconhecido",
                    venda.getId_corretor(),
                    venda.getValor_venda()));
        }

        textArea.setText(sb.toString());
        dialog.add(new JScrollPane(textArea));
        dialog.setVisible(true);
    }

    private static void mostrarCadastroCorretor() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Cadastrar Corretor");
        dialog.setSize(400, 200);
        dialog.setLayout(new GridLayout(4, 2, 5, 5));

        dialog.add(new JLabel("ID Corretor:"));
        JTextField txtId = new JTextField();
        dialog.add(txtId);

        dialog.add(new JLabel("Nome:"));
        JTextField txtNome = new JTextField();
        dialog.add(txtNome);

        JButton btnSalvar = new JButton("Salvar Corretor");
        dialog.add(btnSalvar);

        JLabel lblMensagem = new JLabel("");
        dialog.add(lblMensagem);

        btnSalvar.addActionListener(e -> {
            try {
                Corretor corretor = new Corretor();
                corretor.setNome(txtNome.getText());
                corretor.setId_corretor(Integer.parseInt(txtId.getText()));

                CorretorDAO.cadastrarCorretor(corretor);
                lblMensagem.setText("Corretor cadastrado com sucesso!");
            } catch (Exception ex) {
                lblMensagem.setText("Erro: " + ex.getMessage());
            }
        });

        dialog.setVisible(true);
    }

    private static void mostrarConsultarCorretores() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Corretores Cadastrados");
        dialog.setSize(500, 400);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        StringBuilder sb = new StringBuilder("=== CORRETORES CADASTRADOS ===\n\n");
        for (Corretor corretor : CorretorDAO.listarCorretores()) {
            sb.append(String.format("ID: %d | Nome: %s | Vendas Realizadas: %d\n",
                    corretor.getId_corretor(),
                    corretor.getNome(),
                    corretor.getVendas_realizadas().size()));
        }

        textArea.setText(sb.toString());
        dialog.add(new JScrollPane(textArea));
        dialog.setVisible(true);
    }

    private static void mostrarAltExVendas() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Alteração ou Exclusão de Vendas");
        dialog.setSize(500, 400);
        dialog.setLayout(new BorderLayout());

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton btnExcluir = new JButton("Excluir Venda");
        JButton btnAlterar = new JButton("Alterar Venda");
        
        panel1.add(btnExcluir);
        panel1.add(btnAlterar);

        JPanel panel2 = new JPanel();
        ArrayList listaBtVendas = new ArrayList();
        for (Venda venda : VendaDAO.listarVendas()) {
            Corretor corretor = CorretorDAO.getCorretor(venda.getId_corretor());
            JButton vendaAnterior = new JButton(String.format("ID: %d | Corretor: %s (ID: %d) | Valor: R$%.2f\n",
                    venda.getId_venda(),
                    corretor != null ? corretor.getNome() : "Desconhecido",
                    venda.getId_corretor(),
                    venda.getValor_venda()));
            listaBtVendas.add(vendaAnterior);
            vendaAnterior.addActionListener(e ->{

            });

            panel2.add(vendaAnterior);
        }

        dialog.add(panel1, BorderLayout.NORTH);
        dialog.add(panel2, BorderLayout.CENTER);
        panel1.setVisible(true);
        panel2.setVisible(true);
        dialog.setVisible(true);
    }
}