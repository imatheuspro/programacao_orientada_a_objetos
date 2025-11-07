public class Robo {
    private int linha;
    private int coluna;
    private int passo;

    public Robo(int linhaInicial, int colunaInicial) {
        this.linha = linhaInicial;
        this.coluna = colunaInicial;
        this.passo = 1;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int getPasso() {
        return passo;
    }

    public void setPasso(int passo) {
        this.passo = passo;
    }

    public void mostrarPosicaoAtual() {
        System.out.println("Posicao atual do robo: (" + linha + ", " + coluna + ")");
    }

    public void andarFrente() {
        if (linha - passo < 0) {
            linha = 0; 
        } else {
            linha -= passo;
        }
    }

    public void andarTras(int limiteLinhas) {
        if (linha + passo >= limiteLinhas) {
            linha = limiteLinhas - 1;
        } else {
            linha += passo;
        }
    }

    public void andarDireita(int limiteColunas) {
        if (coluna + passo >= limiteColunas) {
            coluna = limiteColunas - 1;
        } else {
            coluna += passo;
        }
    }

    public void andarEsquerda() {
        if (coluna - passo < 0) {
            coluna = 0;
        } else {
            coluna -= passo;
        }
    }
}
