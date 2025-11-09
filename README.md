--- Sudoku em Java
Este é um projeto de Sudoku com interface gráfica feito em Java usando Swing. O jogo gera tabuleiros aleatórios, permite interações com o usuário e possui validação de jogadas.

--- Funcionalidades detalhadas
- Geração de tabuleiro válido e aleatório
O jogo utiliza um algoritmo de backtracking para preencher um tabuleiro 9x9 com números de 1 a 9 de forma que todas as regras do Sudoku sejam respeitadas.
Após gerar o tabuleiro completo, ele remove aleatoriamente uma quantidade de números (ex: 40) para criar o desafio.
Isso garante que o tabuleiro inicial seja válido e jogável.

- Interface gráfica com campos editáveis
A interface é construída com Java Swing, exibindo uma janela com uma grade 9x9 de campos de texto (JTextField).
Cada célula representa uma posição do tabuleiro e pode ser preenchida pelo jogador.
A interface é responsiva e atualiza o tabuleiro conforme o usuário interage.

- Números fixos e jogáveis com cores diferentes
Os números fixos (pré-definidos no início do jogo) são exibidos com fundo cinza claro e são não editáveis.
Os campos jogáveis (vazios no início) têm fundo branco e podem ser preenchidos pelo jogador.
Isso ajuda o jogador a distinguir claramente entre os números dados e os que ele pode alterar.

--- Botões de controle
- Iniciar novo jogo
Gera um novo tabuleiro aleatório e exibe na interface.
Reinicia o estado do jogo e limpa qualquer jogada anterior.

- Limpar jogadas
Remove todos os números inseridos pelo jogador.
Mantém os números fixos intactos.
Útil para recomeçar sem gerar um novo tabuleiro.

- Verificar status
Analisa o tabuleiro atual e exibe um dos seguintes estados:
Não iniciado: antes de clicar em “Iniciar”
Incompleto: há células vazias
Completo: todas as células estão preenchidas

- Finalizar jogo
Verifica se o tabuleiro está completo e válido:
Todas as células estão preenchidas
Nenhuma violação das regras do Sudoku (linhas, colunas, blocos 3x3)
Se estiver correto, exibe uma mensagem de vitória.

- Validação de jogadas e verificação de vitória
Cada jogada é validada com base nas regras do Sudoku:
O número não pode se repetir na mesma linha, coluna ou bloco 3x3.
A função de finalização verifica se o tabuleiro está corretamente resolvido antes de declarar vitória.

--- Requisitos
Java JDK 8 ou superior
Editor de código (VS Code, IntelliJ, Eclipse, etc.)
