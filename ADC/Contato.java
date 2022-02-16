/**
 *  Representação do contato. Todo contato possuí obrigatoriamente nome e telefone, sobrenome é opcional. Também possui
 * dois toString's relacionados a exibição dos dados do contato nas funções "Listar Contato" e "Exibir Contato".
 *
 * @author Gabriel Victor de Vasconcelos Cesário - 120210143
 */
public class Contato {
    /**
     * Recebe o nome do contato.
     */
    private String nomeDoContato;
    /**
     * Recebe o sobrenome do contato, podendo ser uma String vazia.
     */
    private String sobrenomeDoContato;
    /**
     * Recebe o telefone do contato, o formato é de escolha do usuário.
     */
    private String telefoneDoContato;

    /**
     *  Constrói o contato, a partir do seu nome, sobrenome e telefone, todo contato possui, obrigatoriamente, nome e
     *  telefone.
     *
     * @param nome primeiro nome do contato.
     * @param sobrenome segundo nome do contato, sobrenome.
     * @param telefone telefone do contato.
     */
    public Contato(String nome, String sobrenome, String telefone) {
        this.nomeDoContato = nome;
        this.sobrenomeDoContato = sobrenome;
        this.telefoneDoContato = telefone;
    }

    /**
     * Retorna o nome de um contato.
     * @return nome de um contato
     */
    public String getNomeDoContato() {
        return nomeDoContato;
    }

    /**
     * Retorna o sobrenome de um contato.
     * @return sobrenome de um contato
     */
    public String getSobrenomeDoContato() {
        return sobrenomeDoContato;
    }

    /**
     *  toString referente a listagem de contatos, soma-se 1 à posição pois o contato na posição 0 do array se refere
     * ao contato 1 e assim por diante. Retorna uma String no formato: "númeroDoContato - Nome e sobrenome do contato".
     *
     * @param posicao posição do contato no array.
     * @return a representação em String de um contato relacionado a sua posiçõo de 1 a 100.
     */
    public String toStringListaContatos(int posicao) {
        return (posicao + 1) + " - " + this.nomeDoContato + " " + this.sobrenomeDoContato + "\n";
    }

    /**
     *  toString referente a exibição de um contato no formato:
     * "Nome Sobrenome
     *  Telefone".
     *
     * @return a representação em String de um contato, seu nome, sobrenome(caso possua) e telefone.
     */
    public String toStringExbirContato() {
        return this.nomeDoContato + " " + this.sobrenomeDoContato +  "\n" + this.telefoneDoContato + "\n";
    }

}