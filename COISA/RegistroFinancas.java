/**
 * Registro de finanças, permite adicionar ganhos, pagar despesas, exibir seus ganhos e mostra o total de seus ganhos,
 * o total de despesas e seu total disponível, tudo em centavos.
 *
 * @author Gabriel Victor de Vasconcelos Cesario
 */
public class RegistroFinancas {
    /**
     * Ganhos iniciais do usuário em centavos.
     */
    private int ganhosIniciais = 0;
    /**
     * Despesas totais do usuário em centavos.
     */
    private int despesasTotais = 0;
    /**
     * Total de dinheiro disponível do usuário em centavos.
     */
    private int totalDisponivel = 0;
    /**
     * Guarda as quantidades de todos os ganhos, pode ser sobrescrito.
     */
    private int[] ganhos;

    /**
     * Recebe os ganhos iniciais do aluno e quantos ganhos ele obteve.
     *
     * @param ganhosIniciais valor, em centavos, inicial do aluno.
     * @param totalDeGanhos quantos ganhos o usuário teve.
     */
    public RegistroFinancas(int ganhosIniciais, int totalDeGanhos) {
        this.ganhosIniciais = ganhosIniciais;
        this.ganhos = new int[totalDeGanhos];
    }

    /**
     * Adiciona o um ganho, em centavos, em uma posição.
     *
     * @param valorCentavos quantia de dinheiro em centavos.
     * @param posicaoGanho posição do ganho.
     */
    public void adicionaGanhos(int valorCentavos, int posicaoGanho) {
        ganhos[posicaoGanho - 1] = valorCentavos;
    }

    /**
     * Atribui o valor, em centavos, em despesas.
     *
     * @param valorCentavos quantia de dinheiro em centavos.
     */
    public void pagaDespesa(int valorCentavos) {
        this.despesasTotais += valorCentavos;
    }

    /**
     * Retorna, em String, uma lista exibindo os ganhos, no formato
     * "POSIÇÃO - XXXXXX
     *  POSIÇÃO - XXXXXX
     * ..."
     * Sendo 'XXXXXX' o número do ganho, em centavos.
     *
     * @return em String uma lista exibindo os ganhos e suas posições.
     */
    public String exibeGanhos( ) {
        String[] saida = new String[ganhos.length];

        for (int i = 0; i < ganhos.length ; i++) {
            saida[i] = i+1 + " - " + ganhos[i];
        }
        return String.join("\n", saida);
    }

    /**
     *  Retorna em String, o total recebido, as despesas totais e o total disponível, no formato
     *  "Total recebidos: XXX, Despesas totais: YYY, Total disponível: ZZZ"
     *  Onde 'XXX', 'YYY', 'ZZZ' são respectivamente, total recebidos, despesas totais e total
     *  de dinheiro disponível, todos em centavos.
     *
     * @return em String, os totais de ganhos recebidos, despesas e dinheiro disponível.
     */
    public String toString( ) {
        int totalRecebidos = 0;
        for (int i = 0; i < ganhos.length; i ++) totalRecebidos += ganhos[i];
        totalRecebidos += ganhosIniciais;
        totalDisponivel = totalRecebidos - despesasTotais;
        return "Total recebidos: " + totalRecebidos + ", Despesas totais: " + despesasTotais + ", Total disponível: " + totalDisponivel;
    }
}

