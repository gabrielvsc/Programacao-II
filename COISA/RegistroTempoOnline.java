/**
 * Registra o tempo em que o aluno se dedica a uma discplina em relação ao tempo necessário que ele deveria
 * passar. O tempo necessário é o dobro do tempo da disciplina, por padrão, são 120h.
 *
 * @author Gabriel Victor de Vasconcelos Cesario
 */
public class RegistroTempoOnline {
    /**
     * Nome da disciplina.
     */
    private String nomeDaDisciplina;
    /**
     * Horas de dedicação necessárias.
     */
    private int horasNecessarias;
    /**
     * Horas de dedicação que o aluno já cumpriu.
     */
    private int horasPagas;

    /**
     * Constrói um registro de tempo com base no nome da discplina. Toda disciplina começa com 120 horas necessárias.
     *
     * @param nomeDisciplina o nome da disciplina.
     */
    public RegistroTempoOnline (String nomeDisciplina) {
        this.nomeDaDisciplina = nomeDisciplina;
        this.horasNecessarias = 120;
    }

    /**
     * Constrói um registro de tempo com base no nome da disciplina e no tempo esperado.
     *
     * @param nomeDisciplina o nome da disciplina.
     * @param tempoOnlineEsperado o tempo online necessário para dedicação a disciplina.
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDaDisciplina = nomeDisciplina;
        this.horasNecessarias = tempoOnlineEsperado;
    }

    /**
     * Atribui o tempo que o aluno permaneceu online a variável horasPagas.
     *
     * @param tempo tempo, em horas, de horas pagas.
     */
    public void adicionaTempoOnline(int tempo) {
        this.horasPagas += tempo;
    }

    /**
     * Retorna em boolean 'true' se as horas pagas forem suficientes e 'false' se não forem.
     *
     * @return em boolean 'true' ou 'false'
     */
    public boolean atingiuMetaTempoOnline() {
        return this.horasPagas >= horasNecessarias;
    }

    /**
     * Retorna em String as horas e o nome da disciplina no formato
     * "Nome da disciplina horas pagas/horas necessárias"
     *
     * @return em String, o nome da disciplina, as horas pagas e as horas necessárias.
     */
    public String toString() {
        return nomeDaDisciplina + " " + horasPagas + "/" + horasNecessarias;
    }
}