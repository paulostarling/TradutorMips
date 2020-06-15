# TradutorMips
## Trbalho de Arquitetura de Computadores: Simulador de Instruções MIPS.
- MIPS (microprocessador sem estágios intertravados de pipeline) é uma arquitetura baseada em registrador, ou seja, a CPU usa apenas 
registradores para realizar suas operações aritiméticas e lógicas.
O programa desenvolvido simula o funcionamento de uma máquina MIPS, possuindo uma Unidade Lógica e Aritmética, 
Banco de Registradores e Memória Principal. 

# Descrição do funcionamento do programa:

 1. Leitura de um arquivo de entrada.
 2. Decodificar o comando em linguagem de montagem para instrução de máquina do MIPS;
 3. Atualizar o valor dos registradores envolvidos;
 4. Atualizar o conteúdo da memória principal;
 5. Escrever o conteúdo dos registradores no arquivo de saída *register.out*
 6. Escrever o conteúdo da memória no arquivo de saída *memory.out*

# Descrição de classes e métodos: 

  - **Memory:** Entidade responsável por receber as características relacionados a memória,
como por exemplo o endereço e o valor.
  - **MemoryManager:** Entidade responsável por conter os métodos relacionados a administração da memória;
      - void createMemoryFile(): Método responsável por criar o arquivo referente a memória;
      - void writeToFile(): Método responsável por escrever no arquivo referente a memória;
 - **Register:**  Entidade responsável por receber as características relacionadas ao registrador,
como por exemplo o nome e o valor.
 - **RegisterManager:** Entidade responsável por conter métodos relacionados a administração do registrador;
      - void createRegisterFile(): Método responsável por criar o arquivo referente ao registrador;
      - void writeToFile(): Método responsável por escrever no arquivo referentes ao registrador;
 - **DoTranslation:** Entidade responsável por conter os métodos relacionados a tradução da linguagem de máquina para binário.
     - transformaEmBinario(): Método responsável por realizar a transformação de uma string (linguagem de máquina) em inteiro (binário);
     - traduzRegistradores(): Método responsável por traduzir os registradores para binário.
 - **Process:** Entidade responsável processar os métodos de tradução, leitura, criação e escrita dos arquivos.
     - processaTraduçãoArquivo(): Método responsável por processar a tradução do arquivo da memória e do registrador.
     - readFile(): Método responsável por processar a leitura do arquivo.
     - createFile(): Método responsável por processar a criação do arquivo.
     - writeInFile(): Método responsável por processar a escrita no arquivo.
       

