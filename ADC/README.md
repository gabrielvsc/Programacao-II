<h1> 🖥️ Agenda De Contatos - (ADC) </h1>

> Idealizada pela Disciplina de Programação II

<h2> 🔍 Sobre</h2>
  
<p>
  Nesse projeto, tivemos que desenvolver um sistema de agenda, capaz de cadastrar contatos e gerenciá-los através de uma interface básica.
</p>

<h2>📌 Funcionalidaes</h2>

<h3> (C) Cadastrar Contato </h3>

<p>Onde o usuário consegue cadastrar um contato, informando a sua posição numa lista de 1 a 100, seu nome, sobrenome e telefone.
</p>

<h3> ⚠️ Exceções </h3>
<p>
  <i>-> Caso o usuário tente cadastrar um contato que esteja numa posição inválida, <b>fora do espectro [1-100]</b>, o sistema mostrará "POSIÇÃO INVÁLIDA" e o cadastro não será realizado.</i> <br>
  <i>-> Caso o usuário tente cadastrar um contato com nome e sobrenomes já existentes no sistema o cadastro não será realizado e será exibido na tela a mensagem "CONTATO JÁ CADASTRADO".</i> <br>
  <i>-> Caso o usuário tente cadastrar um contato com nome ou telefone vazio, o cadastro não será realizado e a mensagem "CONTATO INVÁLIDO" será exibida.</i>
</p>  

<h3> (L) Listar Contatos</h3>

<p>
  Lista os contatos já cadastrados.
</p>  

<h3> (E) Exibir Contato</h3>
  
<p>
  Exibe o contato escolhido pelo usuário de acordo com a sua posição na memória e todas as informações inseridas no seu cadastro.
</p>  

<h3> ⚠️ Exceções </h3>

<p>
  <i>-> Caso o usuário tente exibir um contato  inexistente ou que esteja numa posição inválida, <b>fora do espectro [1-100]</b>, o sistema mostrará "POSIÇÃO INVÁLIDA".</i> <br>
</p>
  
  
<h3> (F) Favoritos</h3>

<p>
  Lista os contatos favoritados.
</p>  

<h3> (A) Adicionar Favorito</h3>
  
<p>
  Adiciona um contato aos favoritos, dentro do espaço de [1-10].
</p>

<h3> (T) Tags </h3>

<p>
  Adicina tags a um contato, podendo adicionar até 5 tags por contato.
</p>  

<h3> (S) Sair </h3>

<p> 
  Encerra a aplicação. 
</p>

<h2> 📂 Classes</h2>

<h4>Agenda</h4>

<p>
  Representa uma agenda de contatos, cadastra e guarda todos os contatos, favoritos e tags.
</p>

<h4>Contato</h4>

<p>
  Representação do contato. Todo contato possuí obrigatoriamente nome e telefone, sobrenome é opcional. Também possui dois toString's relacionados a exibição dos dados do contato nas funções "Listar Contato" e "Exibir Contato".
</p>  

<h4>Main Agenda</h4>

<p>
  Interface da agenda, mostra um menu e permite ao usuário, optar por qual função ele quer que seja realizada ao escrever a letra que identifica aquela função (C, L, E, F, A, T ou S).
</p>  
