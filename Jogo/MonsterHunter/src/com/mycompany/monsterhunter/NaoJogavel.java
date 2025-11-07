package com.mycompany.monsterhunter;

public class NaoJogavel extends Personagem {
    private boolean aliado;
    
    public NaoJogavel(boolean aliado,String nome, int vital,Jogo jogo){
        super(nome,vital,jogo);
        this.aliado=aliado;
    }

    public boolean isAliado() {
        return aliado;
    }

    public void setAliado(boolean aliado) {
        this.aliado = aliado;
    }
    
    @Override
    public void aplicarGolpeEspecial(Personagem p){
        switch (p.getJogo().getDificult()){
            case 1 -> p.setVital(p.getVital()-20);
            case 2 -> p.setVital(p.getVital()-30);
            case 3 -> p.setVital(p.getVital()-40);
        }
    }
}

