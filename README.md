# Avaliação 3 de Paradigamas de Programação
## Registrador de transações imobiliárias

### Conceito
O registrador irá receber as informações de venda por meio de uma interface gráfica, calcular a comissão baseada no tipo de imóvel e salvar os dados como uma planilha. Também é possível registrar corretores e consultar vendas realizadas.

### Estrutura de Classes
Existem 6 classes e 1 interface.
A interface **Comissao** apresenta o cálculo das comissões e é implementada pela classe **Imovel**, a qual é superclasse das três outras classes: **Apartamento**, **Casa** e **Imóvel**.
As classes **Corretor** e **Venda** modelam esses objetos que representam corretores e vendas, enquanto classes **CorretorDAO** e **VendaDAO** são utilizdas para a listagem dos mesmos.
Por fim, a classe **SistemaImobiliarioGUI** contém as estruturas da interface gráfica, a qual é inicializada no **Main**.

### Cálculo de Comissão
Cada tipo de imóvel tem uma porcentagem arbitrária de comissão diferente que é calculada pela reescrita do método **calculo_comissao** (pertencente à interface Comissão) em cada subclasse de **Imovel**:
- _SUBCLASSE DE IMOVEL: PORCENTAGEM DA COMISSÃO_
- Apartamento: 30%
- Casa: 20%
- Terreno: 10%

### Interface Gráfica
A Interface Gráfica possui como tela inicial o JFrame de título "**Empresa Y - Sistema Imobiliário**" com botões que guiam para as outras 4 telas:
1. **Cadastrar Vendas**: Envia para a tela onde são cadastradas as vendas por meio de informações fornecidas pelo usuário (id corretor, tipo imovel, id imovel, valor da venda), salva a venda e retorna o valor da comissão ao apertar o botão "Salvar venda";
2. **Consultar Vendas**: Envia para a tela que lê o arquivo .csv e mostra as vendas realizadas;
3. **Cadastrar Corretor**: Envia para tela de cadastro do corretor também via input do usuário
4. **Consultar Corretores**: Envia para a tela de exibição de corretores, a qual lista todos os corretores anteriormente cadastrados

### Salvamento de Dados
As informações de cada venda são salvas em um arquivo chamado vendas.csv, o qual é criado a partir do primeiro cadastro de vendas.
