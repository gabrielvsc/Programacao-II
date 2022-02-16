/**
 * Representa uma agenda de contatos, cadastra e guarda todos os contatos, favoritos e tags.
 *
 * @author Gabriel Victor de Vasconcelos Cesário - 120210143
 */
public class Agenda {

	/**
	 * Tamanho estático da agenda.
	 */
	private static final int TAMANHO_AGENDA = 100;

	/**
	 * Tamanho estático dos favoritos.
	 */
	private static final int TAMANHO_FAVORITOS = 10;

	/**
	 * Tamanho estático das tags.
	 */
	private static final int TAMANHO_TAGS = 5;

	/**
	 * Array do objeto Contato que guarda os contatos.
	 */
	private Contato[] contatos;

	/**
	 * Array do objeto Contato que guarda os contatos favoritos.
	 */
	private Contato[] favoritos;

	/**
	 *  Array que guarda tags dos contatos, os contatos podem ter mais de uma tag.
	 */
	private String[][] tags;

	/**
	 *  Constrói uma agenda, contendo 3 arrays, um de contatos, onde ficam armazenados todos os contatos, outro de
	 *  favoritos, que guarda os contatos favoritos, outro de tags que guarda tags.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];
		this.tags = new String[TAMANHO_AGENDA][TAMANHO_TAGS];
	}

	/**
	 *  Verifica as condições necessárias para a criação de um contato, cadastra um contato em um array de Contato[]
	 * chamado 'contatos' e exibe se o contato foi cadastrado, ou se o cadastro não pode ser concluído por algum tipo
	 * de informação passada de maneira errrada ou já existente.
	 *
	 * @param posicao posição do contato no array
	 * @param nome nome do contato
	 * @param sobrenome sobrenome do contato
	 * @param telefone telefone do contato
	 * @return um aviso, em String, sobre a situação do cadastro
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		boolean chave = true;
		for (int i = 0; i < contatos.length; i++) {
			if(contatos[i] != null) {
				if(nome.equals(contatos[i].getNomeDoContato()) && sobrenome.equals(contatos[i].getSobrenomeDoContato())) {
					chave = false;
					break;
				}
			}
		}
		if(chave == false) {
			return "CONTATO JÁ CADASTRADO";
		} else if (nome.equals("") || telefone.equals("")) {
			return "CONTATO INVÁLIDO";
		} else if (posicao > 100 || posicao < 1) {
			return "POSIÇÃO INVÁLIDA";
		} else {
			Contato novoContato = new Contato(nome, sobrenome, telefone);
			this.contatos[posicao-1] = novoContato;
			return "CADASTRO REALIZADO!";
		}
	}

	/**
	 * Retorna uma String com os dados do contato no formato:
	 * "Nome Sobrenome
	 *  Telefone"
	 * A String pode possuir um "❤ " antes dessas informações, isso identifica um contato favoritado.
	 *
	 * @param posicao posição do contato no array contatos
	 * @return retorna o nome, sobrenome e telefone de um contato em uma String
	 */
	public String getContato(int posicao) {
		String tagsString = "";
		if (contatos[posicao - 1] != null) {
			for (int i = 0; i < 5; i++) {
				if (tags[posicao - 1][i] != null) {
					tagsString += tags[posicao - 1][i] + " ";
				}
			}
			for (int i = 0; i < favoritos.length; i++) {
				if (favoritos[i] != null) {
					if (favoritos[i] == contatos[posicao - 1]) {
						return "❤ " + contatos[posicao - 1].toStringExbirContato() + tagsString.trim();
					}
				}
			}
			return contatos[posicao - 1].toStringExbirContato() + tagsString.trim();
		} else {
			return "POSIÇÃO INVÁLIDA!";
		}
	}

	/**
	 * Retorna, em String, uma lista de todos os contatos, com posição, nome e sobrenome no formato:
	 * "1 - Nome Sobrenome
	 *  2 - Nome Sobrenome
	 *  ...".
	 *
	 * @return retorna uma String com uma lista de todos os contatos em ordem de posição
	 */
	public String listarContatos() {
		String lista = "";
		for(int i = 0 ; i < contatos.length; i++) {
			if (contatos[i] != null) {
				lista += contatos[i].toStringListaContatos(i);
			}
		}
		return lista.trim();
	}

	/**
	 * Adiciona um contato existente ao array de favoritos e retorna em que posição esse contato foi favoritado ou null.
	 *
	 * @param contato posição do contato no array contatos
	 * @param posicao posição do contato no array favoritos
	 * @return em String, a posição em que o contato foi favoritado, ou null caso o contato não possa ser favoritado
	 */
	public String adicionaFavoritos(int contato, int posicao) {
		if(contatos[contato-1] != null) {
			this.favoritos[posicao-1] = contatos[contato-1];
			return "CONTATO FAVORITADO NA POSIÇÃO " + posicao + "!";
		}
		return null;
	}

	/**
	 *  Retorna, em String, uma lista de todos os favoritos, com posição, nome e sobrenome no formato:
	 * "1 - Nome Sobrenome
	 *  2 - Nome Sobrenome
	 *  ...".
	 *
	 * @return retorna uma String com uma lista de todos os favoritos em ordem de posição
	 */
	public String listarFavoritos() {
		String lista = "";
		for(int i = 0 ; i < favoritos.length; i++) {
			if (favoritos[i] != null) {
				lista += favoritos[i].toStringListaContatos(i);
			}
		}
		return lista.trim();
	}

	/**
	 * Adiciona tags a um array de tags, numa posição equivalente a posição do contato no array contatos.
	 *
	 * @param contatosTag contatos em que o usuário quer adicionar a tag
	 * @param tag String que representa a tag
	 * @param posicao posição da tag no array de tags
	 */
	public void adicionaTags(String[] contatosTag, String tag, String posicao) {
		for (int i = 0; i < contatosTag.length; i++) {
			this.tags[Integer.parseInt(contatosTag[i])-1][Integer.parseInt(posicao)-1] = tag;
		}

	}
}


