import javax.swing.*;
import java.awt.*;

public class frameAltEx extends JDialog {
    // -- botoes
    JButton btnAlterar = new JButton("Alterar");
    JButton btnExcluir = new JButton("Excluir");

    frameAltEx() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(800,600);
        this.setLayout(new GridLayout(1,2,10,0));
        this.setTitle("Alterar ou Excluir Vendas");

        // Painéis Direita e Esquerda:
        JPanel painelEsq = new JPanel();
        JPanel painelDir = new JPanel();

        painelEsq.setBackground(Color.gray); // cor do painel esquerdo
        painelDir.setBackground(Color.BLUE); // cor do painel direito

        // Componentes do Painel Esquerdo
        painelEsq.setLayout(new BorderLayout());

        JLabel textoEsq = new JLabel("Vendas Realizadas");
        textoEsq.setFont(new Font(Font.SERIF, Font.PLAIN, 20)); // altera tamanho da fonte
        textoEsq.setHorizontalAlignment(JLabel.CENTER);
        textoEsq.setPreferredSize(new Dimension(100,100));
        painelEsq.add(textoEsq, BorderLayout.NORTH);

        // -- Painel de Baixo Esquerda
        JPanel painelEsqBaixo = new JPanel();
        painelEsqBaixo.setBackground(Color.yellow);
        painelEsq.add(painelEsqBaixo);

        // -- vendas cadastradas
       String textoVenda = "";
        for (Venda venda : VendaDAO.listarVendas()) {
            Corretor corretor = CorretorDAO.getCorretor(venda.getId_corretor());
            textoVenda = (String.format("ID: %d | Corretor: %s (ID: %d) | Valor: R$%.2f\n",
                    venda.getId_venda(),
                    corretor != null ? corretor.getNome() : "Desconhecido",
                    venda.getId_corretor(),
                    venda.getValor_venda()));
            JButton botaoVenda = new JButton(textoVenda);
            botaoVenda.addActionListener(e -> {habilitarbotoes();});
            painelEsqBaixo.add(botaoVenda);

        }






        // Componentes do Painel Direito
        painelDir.setLayout(new BorderLayout());

        // -- Painel de Cima Direita --
        JPanel painelDirCima = new JPanel(new GridLayout(2,1));
        painelDirCima.setBackground(Color.BLACK);
        painelDirCima.setPreferredSize(new Dimension(100,100));
        painelDir.add(painelDirCima, BorderLayout.NORTH);

        // -- texto
        JLabel nomeVenda = new JLabel("Venda ID:");
        nomeVenda.setHorizontalAlignment(JLabel.CENTER);
        painelDirCima.add(nomeVenda);

        JLabel idVenda= new JLabel("Id da Venda Aqui");
        idVenda.setHorizontalAlignment(JLabel.CENTER);
        painelDirCima.add(idVenda);



        btnAlterar.setEnabled(false); // inicia desabilitado
        btnExcluir.setEnabled(false); // inicia desabilitado


        painelDirCima.add(btnAlterar);
        painelDirCima.add(btnExcluir);

        // -- Painel de Baixo Direita --
        JPanel painelDirBaixo = new JPanel(new GridLayout(4,3));
        painelDirBaixo.setBackground(Color.lightGray);
        painelDir.add(painelDirBaixo);
        painelDirBaixo.setVisible(false);

        // -- textos e caixas
        JLabel text1 = new JLabel("Id Corretor");
        JLabel idCorAntigo = new JLabel("Valor antigo");
        JTextField idCorNovo = new JTextField();

        JLabel text2 = new JLabel("Tipo Imóvel");
        JLabel tipoImovAntigo = new JLabel("Valor antigo");
        JTextField tipoImovNovo = new JTextField();

        JLabel text3 = new JLabel("Id Imóvel");
        JLabel idImovAntigo = new JLabel("Valor antigo");
        JTextField idImovNovo = new JTextField();

        JLabel text4 = new JLabel("Valor Total da Compra");
        JLabel valorTotalAntigo = new JLabel("Valor antigo");
        JTextField valorTotalNovo = new JTextField();

        painelDirBaixo.add(text1);
        painelDirBaixo.add(idCorAntigo);
        painelDirBaixo.add(idCorNovo);

        painelDirBaixo.add(text2);
        painelDirBaixo.add(tipoImovAntigo);
        painelDirBaixo.add(tipoImovNovo);

        painelDirBaixo.add(text3);
        painelDirBaixo.add(idImovAntigo);
        painelDirBaixo.add(idImovNovo);


        painelDirBaixo.add(text4);
        painelDirBaixo.add(valorTotalAntigo);
        painelDirBaixo.add(valorTotalNovo);

        // Ações Botões Painel Direito
        btnAlterar.addActionListener(e -> {painelDirBaixo.setVisible(true);});
        btnExcluir.addActionListener(e -> painelDirBaixo.setVisible(false));

        // Adições ao Frame:
        this.add(painelEsq);
        this.add(painelDir);
        this.setVisible(true);
    }

    public void habilitarbotoes(){
        this.btnAlterar.setEnabled(true);
        this.btnExcluir.setEnabled(true);
    }
}
