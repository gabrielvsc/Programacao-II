/**
 * Cadastro de notas, o usuário pode cadastrar a nota, sobrescrever uma nota já cadastrada e uma média será gerada,
 * também é possível cadastrar as horas de estudo referentes a uma disciplina. Imprime uma String informando o nome
 * da discplina, o número de horas de estudo, a média e as notas de cada prova.
 *
 * @author Gabriel Victor de Vasconcelos Cesario
 */
public class Disciplina {
    /**
     * Nome da disciplina.
     */
    private String nomeDisciplina;
    /**
     * Horas de estudo dedicadas a disciplina.
     */
    private int horasDeEstudo = 0;
    /**
     * Recebe uma nota.
     */
    private double nota1, nota2, nota3, nota4;
    /**
     * Média do aluno.
     */
    private double media;

    /**
     * Recebe o nome da disciplina.
     *
     * @param nomeDisciplina o nome da disciplina.
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    /**
     * Adiciona as horas de estudo.
     *
     * @param horas horas de estudo.
     */
    public void cadastraHoras(int horas) {
        this.horasDeEstudo += horas;
    }

    /**
     * Cadastra as notas, podendo sobrescrever notas.
     *
     * @param nota pode ser a nota1, nota2, nota3 ou nota4.
     * @param valorNota valor da nota de 0.0 a 10.0.
     */
    public void cadastraNota(int nota, double valorNota) {
        if (nota == 1) {
            this.nota1 = valorNota;
        } else if (nota == 2) {
            this.nota2 = valorNota;
        } else if (nota == 3) {
            this.nota3 = valorNota;
        } else if (nota == 4) {
            this.nota4 = valorNota;
        }
    }

    /**
     * Retorna 'true' se for aprovado ou 'false' se for reprovado.
     *
     * @return boolean 'true' ou 'false'.
     */
    public boolean aprovado( ){
        media = (nota1 + nota2 + nota3 + nota4)/4;
        return media >= 7.0;
    }

    /**
     * Retorna em String, o nome da disciplina, as horas de estudo, a média e as 4 notas no formato
     * "Nome da disciplina horas de estudo média [nota 1, nota 2, nota 3, nota 4]"
     *
     * @return em String o nome da disciplina, as horas de estudo, a média e as 4 notas.
     */
    public String toString( ) {
        return nomeDisciplina + " " + horasDeEstudo + " " + media + " " + "[" + nota1 + ", " + nota2 + ", " + nota3 + ", " + nota4 + "]";
    }
}
