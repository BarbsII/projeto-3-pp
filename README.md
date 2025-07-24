# Avaliação 3 de Paradigamas de Programação
## Registrador de transações imobiliárias

### Estudantes:
- Bárbara Ellen Torres Cunha
- Debora Leticia Silva dos Santos
- Ian Bruno de Oliveira Pacheco

### Conceito do Projeto:
Um registrador de transações imobiliárias que irá receber as informações de venda por meio de uma interface gráfica, calcular a comissão baseada no tipo de imóvel e salvar os dados em um arquivo .csv, também é podendo registrar corretores e consultar/editar/excluir vendas realizadas.

### Estrutura de Classes
Existem 9 classes e 1 interface.
- A classe **Imovel** é superclasse das três outras classes: **Apartamento**, **Casa** e **Terreno**.
- As classes **Corretor** e **Venda** modelam esses objetos que representam corretores e vendas, enquanto classes **CorretorDAO** e **VendaDAO** são utilizdas para a listagem dos mesmos.
- A classe **SistemaImobiliarioGUI** contém as estruturas da interface gráfica, a qual é inicializada no **Main**.
- A interface **Comissao** apresenta o cálculo das comissões e é implementada em Imovél, seu método "cálculo_comissão" é reescrito para cada tipo de subclasse de Imóvel.

### Cálculo de Comissão
Cada tipo de imóvel tem uma porcentagem arbitrária de comissão diferente que é calculada pela reescrita do método **calculo_comissao** (pertencente à interface Comissão) em cada subclasse de **Imovel**:
- Apartamento: 30%
- Casa: 20%
- Terreno: 10%

### Interface Gráfica
A Interface Gráfica possui um JFrame de título "**Empresa Y - Sistema Imobiliário**" com 4 diferentes abas:
1. **Cadastrar Vendas**: Onde são cadastradas as vendas por meio de informações fornecidas pelo usuário (Id do Corretor, Nome do Corretor,Tipo de Imóvel, Valor da venda), salva a venda no arquivo .csv ao apertar o botão de salvamento
2. **Editar/Consultar Vendas**: Onde o arquivo vendas.csv é lido e mostra as vendas realizadas. Também é possível editar as vendas por meio do botão "Editar";
4. **Corretores**: Onde são exibidos os corretores cadastrados, a qual lista todos os corretores anteriormente cadastrados

### Salvamento de Dados, Edição e Exclusão de Dados
As informações de cada venda são salvas em um arquivo chamado _vendas.csv_ .
