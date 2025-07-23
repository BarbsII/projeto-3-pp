import javax.swing.*;
import java.awt.*;

public class frameAltEx extends JDialog {
    frameAltEx() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(600,600);
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

        JPanel painelEsqBaixo = new JPanel();
        painelEsqBaixo.setBackground(Color.yellow);
        painelEsq.add(painelEsqBaixo);

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

        // -- botoes
        JButton btnAlterar = new JButton("Alterar");
        JButton btnExcluir = new JButton("Excluir");

        painelDirCima.add(btnAlterar);
        painelDirCima.add(btnExcluir);

        // -- Painel de Baixo Direita --

        // Adições ao Frame:
        this.add(painelEsq);
        this.add(painelDir);
        this.setVisible(true);
    }
}
