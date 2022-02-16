import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *  Testes da classe Agenda.
 *
 * @author Gabriel Victor de Vasconcelos Cesário - 120210143
 */
class AgendaTest {

    Agenda agenda = new Agenda();

    // ================================================ TESTES CADASTRAR ============================================ //

    /**
     * Testa o cadastro em uma posição existente onde não há algum contato.
     */
    @Test
    public void testCadastraContatoPosicaoVazia() {
        assertEquals(agenda.cadastraContato(1,"Matheus", "Gaudencio", "(83) 99999-0000"), "CADASTRO REALIZADO!");
    }

    /**
     * Testa o cadastro em uma posição existente onde há um contato, sobrescrevendo.
     */
    @Test
    public void testCadastraContatoPosicaoExistente() {
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals(agenda.cadastraContato(1, "Gabriel", "Victor", "(83) 99999-1234"), "CADASTRO REALIZADO!");
        assertEquals(agenda.getContato(1), "Gabriel Victor\n(83) 99999-1234\n");
    }

    /**
     * Testa o cadastro de um contato que já foi cadastrado, com nome e sobrenome iguais.
     */
    @Test
    public void testCadastraContatoJaExistente() {
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals(agenda.cadastraContato(3, "Matheus", "Gaudencio", "(83) 99999-1234"), "CONTATO JÁ CADASTRADO");
    }

    /**
     * Testa o cadastro na posição superior limite, 100.
     */
    @Test
    public void testCadastraContatoPosicaoLimite() {
        assertEquals(agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000"), "CADASTRO REALIZADO!");
    }

    /**
     * Testa o cadastro na posição acima do limite, 101.
     */
    @Test
    public void testCadastraContatoAcimaDoLimite() {
        assertEquals(agenda.cadastraContato(101, "Gabriel", "Vasconcelos", "(83) 99999-1234"), "POSIÇÃO INVÁLIDA");
    }

    /**
     * Testa o cadastro na posição abaixo do limite, 0.
     */
    @Test
    public void testCadastraContatoAbaixoDoLimite() {
        assertEquals(agenda.cadastraContato(0, "Gabriel", "Vasconcelos", "(83) 99999-1234"), "POSIÇÃO INVÁLIDA");
    }

    /**
     * Testa o cadastro de um contato sem telefone.
     */
    @Test
    public void testCadastraContatoSemTelefone() {
        assertEquals(agenda.cadastraContato(1, "Matheus", "Gaudencio", ""), "CONTATO INVÁLIDO");
    }

    /**
     * Testa o cadastro de um contato sem nome.
     */
    @Test
    public void testCadastraContatoSemNome() {
        assertEquals(agenda.cadastraContato(1, "", "Kami", "(83) 99999-9865"), "CONTATO INVÁLIDO");
    }

    // ================================================ TESTES EXIBIR =============================================== //


    /**
     * Testa a exibição normal de um contato.
     */
    @Test
    public void testExibirContatoCadastrado() {
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals(agenda.getContato(1), "Matheus Gaudencio\n(83) 99999-0000\n");
    }

    /**
     * Testa a exibição de um contato inexistente.
     */
    @Test
    public void testExibirContatoSemContato() {
        assertEquals(agenda.getContato(1),  "POSIÇÃO INVÁLIDA!");
    }

    /**
     * Testa a exibição de um contato acima do limite.
     */
    @Test
    public void testExibirContatoAcimaDoLimiteSuperior() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> agenda.getContato(101));
    }

    /**
     * Testa a exibição de um contato abaixo do limite.
     */
    @Test
    public void testExibirContatoLimiteInferior() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> agenda.getContato(0));
    }

    /**
     * Testa a exibição de um contato favritado.
     */
    @Test
    public void testExibirContatoFavoritado() {
        agenda.cadastraContato(1, "Aurelion", "Sol", "(83) 99999-3924");
        assertEquals(agenda.adicionaFavoritos(1,1), "CONTATO FAVORITADO NA POSIÇÃO 1!");
        assertEquals(agenda.getContato(1), "❤ Aurelion Sol\n(83) 99999-3924\n");
    }

    /**
     * Testa a exibição de um contato com uma tag.
     */
    @Test
    public void testExibirContatoComTags() {
        String[] array = new String[1];
        array[0] = "1";

        agenda.cadastraContato(1, "Gabriel", "Victor", "(83) 99999-2193");
        agenda.adicionaTags(array, "CCC", "1");
        assertEquals(agenda.getContato(1), "Gabriel Victor\n(83) 99999-2193\nCCC");

    }

    // =========================================== TESTES LISTAR CONTATOS =========================================== //

    /**
     * Testa a exibição da lista de contatos.
     */
    @Test
    public void testListarContatos() {
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-1392");
        agenda.cadastraContato(2, "Kami", "", "(83) 99999-1290");
        agenda.cadastraContato(3,"Gabriel", "Victor", "(83) 99999-4921");

        assertEquals(agenda.listarContatos(), "1 - Matheus Gaudencio\n2 - Kami \n3 - Gabriel Victor");
    }

    /**
     * Testa o listar vazio.
     */
    @Test
    public void testListarContatosVazio() {
        assertEquals(agenda.listarContatos(), "");
    }

    // ======================================== TESTES ADICIONAR FAVORITOS ========================================== //

    /**
     * Testa os dois limites de favoritos, posição 1 e posição 10.
     */
    @Test
    public void testAdicionarFavoritoNoLimite() {
        agenda.cadastraContato(1,"Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals(agenda.adicionaFavoritos(1,1), "CONTATO FAVORITADO NA POSIÇÃO 1!");

        agenda.cadastraContato(100, "Gabriel", "Victor", "(83) 99999-0934");
        assertEquals(agenda.adicionaFavoritos(100,10), "CONTATO FAVORITADO NA POSIÇÃO 10!");
    }

    /**
     * Testa acima do limite superior do array de favoritos.
     */
    @Test
    public void testAdicionarFavoritoAcimaDoLimiteSuperior() {
        agenda.cadastraContato(1,"Matheus","Gaudencio", "(83) 99999-0000");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> agenda.adicionaFavoritos(1,11));
    }

    /**
     * Teste abaixo do limite inferior do array de favoritos.
     */
    @Test
    public void testAdicionarFavoritoAbaixoDoLimiteInferior(){
        agenda.cadastraContato(1,"Gabriel","Victor", "(83) 99999-1234");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> agenda.adicionaFavoritos(1,0));
    }

    /**
     * Teste de tentar adicionar aos favoritos, um contato inexistente, retorna null.
     */
    @Test
    public void testAdicionarFavoritoContatoInexistente(){
        assertEquals(agenda.adicionaFavoritos(1,1), null);
    }


    /**
     * Testa a exibição de um contato que já foi favorito, mas foi sobrescrito
     */
    @Test
    public void testSobrescreveFavorito(){
        agenda.cadastraContato(1, "Renato", "Russo", "(83) 99999-1453");
        agenda.cadastraContato(2, "Dinho", "Ouro Preto", "(83) 99999-1263");
        agenda.adicionaFavoritos(1,1);
        assertEquals(agenda.getContato(1), "❤ Renato Russo\n(83) 99999-1453\n");
        agenda.adicionaFavoritos(2,1);
        assertEquals(agenda.getContato(2), "❤ Dinho Ouro Preto\n(83) 99999-1263\n");
        assertEquals(agenda.getContato(1), "Renato Russo\n(83) 99999-1453\n");
    }

    // ========================================== TESTAR LISTAR FAVORITOS =========================================== //

    /**
     * Teste da listagem de favoritos.
     */
    @Test
    public void testListarFavoritos() {
        agenda.cadastraContato(1, "Gabriel", "Victor", "(83) 99999-3042");
        agenda.cadastraContato(2, "Kami", "", "(83) 99999-1494");
        agenda.cadastraContato(3,"Matheus", "Gaudencio", "(83) 99999-2130");
        agenda.adicionaFavoritos(3, 1);
        agenda.adicionaFavoritos(2,2);

        assertEquals(agenda.listarFavoritos(), "1 - Matheus Gaudencio\n2 - Kami");
    }

    // =============================================== ADICIONAR TAGS =============================================== //

    /**
     * Teste da adição de tags e exibição da tag.
     */
    @Test
    public void testAdicionarTags() {
        String[] array = new String[1];
        array[0] = "1";

        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        agenda.adicionaTags(array, "PROGRAMAÇÃO 2", "1");
        assertEquals(agenda.getContato(1), "Matheus Gaudencio\n(83) 99999-0000\nPROGRAMAÇÃO 2");
    }

    /**
     * Teste da adição de uma tag a mais de 1 contato, e sua exibição.
     */
    @Test
    public void testAdicionarTagsEmMaisContatos() {
        String[] array = new String[2];
        array[0] = "1";
        array[1] = "100";

        agenda.cadastraContato(1, "Gabriel", "Victor", "(83) 99999-1534");
        agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0430");
        agenda.adicionaTags(array, "CCC", "1");

        assertEquals(agenda.getContato(1), "Gabriel Victor\n(83) 99999-1534\nCCC");
        assertEquals(agenda.getContato(100), "Matheus Gaudencio\n(83) 99999-0430\nCCC");

    }

    /**
     * Teste da adição de tags no limite inferior, 1.
     */
    @Test
    public void testAdicionarTagsNoLimite() {
        String[] array = new String[1];
        array[0] = "1";

        agenda.cadastraContato(1, "Gabriel", "Vasconcelos", "(83) 99999-2130");
        agenda.adicionaTags(array, "CCC", "1");
        agenda.adicionaTags(array, "2020.2", "5");
        assertEquals(agenda.getContato(1), "Gabriel Vasconcelos\n(83) 99999-2130\nCCC 2020.2" );
    }

    /**
     * Teste da adição de tags abaixo do limite inferior, 0.
     */
    @Test
    public void testAdicionarTagsAbaixoDoLimiteInferior() {
        String[] array = new String[1];
        array[0] = "1";

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> agenda.adicionaTags(array, "CCC", "0"));
    }

    /**
     * Teste da adição de tags acima do limite superior, 6.
     */
    @Test
    public void testAdicionarTagsAcimaDoLimiteSuperior() {
        String[] array = new String[1];
        array[0] = "1";

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> agenda.adicionaTags(array, "UFCG", "6"));
    }

    /**
     * Teste da adição de 5 tags e sua exibição.
     */
    @Test
    public void testAdicionarCincoTags() {
        String[] array = new String[1];
        array[0] = "1";

        agenda.cadastraContato(1,"Gabriel", "Vasconcelos", "(83) 99999-2727");
        agenda.adicionaTags(array, "UFCG", "1");
        agenda.adicionaTags(array, "CCC", "2");
        agenda.adicionaTags(array, "LOLZERO", "3");
        agenda.adicionaTags(array, "EX-BBB", "4");
        agenda.adicionaTags(array, "ARTISTA", "5");
        assertEquals(agenda.getContato(1), "Gabriel Vasconcelos\n(83) 99999-2727\nUFCG CCC LOLZERO EX-BBB ARTISTA");
    }

    /**
     * Teste de sobreescrever uma tag.
     */
    @Test
    public void testTagSobrescrita() {
        String[] array = new String[1];
        array[0] = "1";

        agenda.cadastraContato(1, "Freddie", "Mercury", "(83) 99999-1533");
        agenda.adicionaTags(array, "Queen", "1");
        assertEquals(agenda.getContato(1), "Freddie Mercury\n(83) 99999-1533\nQueen");
        agenda.adicionaTags(array, "King", "1");
        assertEquals(agenda.getContato(1),"Freddie Mercury\n(83) 99999-1533\nKing");
    }
}