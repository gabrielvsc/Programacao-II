import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *  Testes da classe Contato.
 *
 * @author Gabriel Victor de Vasconcelos Cesário - 120210143
 */
class ContatoTest {

    Contato contatoComSobrenome = new Contato("Matheus", "Gaudencio", "(83) 99999-0000");
    Contato contatoSemSobrenome = new Contato("Matheus", "", "(83) 99999-2032");

    /**
     * Teste do getNomeDoContato.
     */
    @Test
    public void testGetNomeDoContato() {
        assertEquals(contatoComSobrenome.getNomeDoContato(), "Matheus");

    }

    /**
     * Teste do getSobrenomeDoContato para um contato COM sobrenome.
     */
    @Test
    public void testGetSobrenomeDoContatoComSobrenome() {
        assertEquals(contatoComSobrenome.getSobrenomeDoContato(), "Gaudencio");
    }

    /**
     * Teste do toStringListaContatos para um contato COM sobrenome.
     */
    @Test
    public void testToStringListaContatosComSobrenome() {
        assertEquals(contatoComSobrenome.toStringListaContatos(0), "1 - Matheus Gaudencio\n");
    }

    /**
     * Teste do toString exibirContato para um contato COM sobrenome.
     */
    @Test
    public void testToStringExibirContatoComSobrenome() {
        assertEquals(contatoComSobrenome.toStringExbirContato(), "Matheus Gaudencio\n(83) 99999-0000\n");
    }

    // CONTATO SEM SOBRENOME

    /**
     * Teste do getSobrenomeDoContato SEM sobrenome.
     */
    @Test
    public void testGetSobrenomeDoContatoSemSobrenome() {
        assertEquals(contatoSemSobrenome.getSobrenomeDoContato(), "");
    }

    /**
     * Teste do toStringListaContatos SEM sobrenome.
     */
    @Test
    public void testToStringListaContatosSemSobrenome() {
        assertEquals(contatoSemSobrenome.toStringListaContatos(0), "1 - Matheus \n");
    }

    /**
     * Teste do toString exibirContato SEM sobrenome.
     */
    @Test
    public void testToStringExiberContatoSemSobrenome() {
        assertEquals(contatoSemSobrenome.toStringExbirContato(), "Matheus \n(83) 99999-2032\n");
    }



}