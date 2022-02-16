import java.util.Scanner;

/**
 *  Interface da agenda, mostra um menu e permite ao usuário, optar por qual função ele quer que seja realizada ao
 * escrever a letra que identifica aquela função (C, L, E, F, A, T ou S).
 *
 * @author Gabriel Victor de Vasconcelos Cesário - 120210143
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}
	}

	/**
	 *  Menu, interface que mostra as opções que o usuário possui para executar, aceita apenas as letras referentes as
	 * funções nele descritas (C, L, E, F, A, T e S).
	 *
	 * @param scanner scanner que receberá uma String
	 * @return retorna a String digitada no Scanner em caixa alta
	 */
	private static String menu(Scanner scanner) {
		System.out.print(
						"\n" +
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" +
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(T)ags\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 *  Switch da interface. Receberá a String (em caixa alta) que o usuário digitou, verificar se existe uma função com
	 * essa String, caso exista, chamará um novo método referente a esta função, caso não, irá mostrar uma String
	 * "OPÇÃO INVÁLIDA!".
	 *
	 * @param opcao String digitada pelo usuário capturada pelo scanner no menu
	 * @param agenda objeto agenda que será invocado no método
	 * @param scanner objeto scanner que será invocado no método
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			listaFavoritos(agenda);
			break;
		case "A":
			adicionarFavorito(agenda, scanner);
			break;
		case "T":
			adicionarTags(agenda, scanner);
			break;
		case "S":
			sair();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}

	/**
	 *  Recebe os dados de um contato, nome, sobrenome e telefone e invoca o cadastraContato da classe Agenda que irá
	 * cadastrar o contato no sistema.
	 *
	 * @param agenda objeto agenda, invocado para chamar o método cadastraContato
	 * @param scanner objeto scanner, invocado para receber a posição, nome, sobrenome e telefone
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		scanner.nextLine();
		System.out.print("\nNome> ");
		String nome = scanner.nextLine();
		System.out.print("\nSobrenome> ");
		String sobrenome = scanner.nextLine();
		System.out.print("\nTelefone> ");
		String telefone = scanner.nextLine();
		System.out.println(agenda.cadastraContato(posicao, nome, sobrenome, telefone));
	}

	/**
	 * Exibe uma listagem dos contatos no formato:
	 * "1 - Nome Sobrenome
	 *  2 - Nome Sobrenome
	 *  ..."
	 * invoca o "listarContatos" da classe agenda.
	 *
	 * @param agenda objeto agenda.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println(agenda.listarContatos());
	}

	/**
	 *  Pede o número identificador do contato e exibe o contato específico relacionado a esse número no formato:
	 * "Nome Sobrenome
	 *  Telefone".
	 *
	 * @param agenda objeto agenda, invocado para poder chamar o método getContato
	 * @param scanner objeto scanner, invocado para receber um número inteiro
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		System.out.println(agenda.getContato(posicao));
	}

	/**
	 * Mostra uma lista todos os contatos favoritos existentes no formato:
	 * "1 - Nome Sobrenome
	 *  2 - Nome Sobrenome
	 *  ...".
	 *
	 * @param agenda objeto agenda, invocado para chamar o método listarFavoritos
	 */
	private static void listaFavoritos(Agenda agenda) {
		System.out.println(agenda.listarFavoritos());
	}

	/**
	 *  Recebe um contato e irá enviar para o adicionaFavoritos para que ele seja adicionado a uma posição específica
	 * num array de favoritos.
	 *
	 * @param agenda objeto agenda, invocado para chamar o método adicionaFavoritos
	 * @param scanner objeto scanner, invocado para receber o contato e a posição
	 */
	private static void adicionarFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int contato = scanner.nextInt();

		System.out.print("Posicao> ");
		int posicao = scanner.nextInt();

		agenda.adicionaFavoritos(contato, posicao);
	}

	/**
	 * Recebe tags a um ou mais contatos específicos.
	 *
	 * @param agenda objeto agenda, invocado para chamar o método adicionaTags
	 * @param scanner objeto scanner, invocado para receber os contatos, a tag e a posição
	 */
	private static void adicionarTags(Agenda agenda, Scanner scanner) {
		scanner.nextLine();
		System.out.print("Contato(s)> ");
		String entrada = scanner.nextLine();
		System.out.print("Tag> ");
		String tag = scanner.nextLine();
		System.out.print("Posicao tag> ");
		String posicao = scanner.nextLine();

		String[] contatos = entrada.split(" ");
		agenda.adicionaTags(contatos, tag, posicao);
	}

	/**
	 * Finaliza a execução do programa.
	 */
	private static void sair() {
		System.exit(0);
	}

}
