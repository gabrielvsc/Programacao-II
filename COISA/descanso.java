/**
 * Acompanha a rotina semanal de descanso do aluno, relacionando, suas horas de estudo com a quantidade de semanas
 * passadas, fornecendo o status do aluno, podendo ser "cansado" ou "descansado".
 *
 * @author Gabriel Victor de Vasconcelos Cesario
 */
public class descanso {
    /**
     * Horas de descanso do aluno.
     */
    private double tempoHoras;
    /**
     * Tempo decorrido em semanas.
     */
    private int tempoSemanas;

    /**
     * Atribui as horas de descanso do aluno.
     *
     * @param valor horas de descanso
     */
    public void defineHorasDescanso(int valor){
        this.tempoHoras = valor;
    }

    /**
     * Define o número de semanas que se passaram.
     *
     * @param valor tempo decorrido em semanas.
     */
    public void defineNumeroSemanas(int valor) {
        this.tempoSemanas = valor;
    }

    /**
     * Calcula se as horas necessárias foram atingidas e retorna a String que representa o status do aluno, em relação
     * a essas horas, podendo ser "cansado" ou "descansado"
     *
     * @return o status em String de um aluno, "cansado" ou "descansado".
     */
    public String getStatusGeral() {
        double horasNecessarias;
        horasNecessarias = tempoHoras / tempoSemanas;
        if (horasNecessarias >= 26) {
            return "descansado";
        } else {
            return "cansado";
        }
    }
}
