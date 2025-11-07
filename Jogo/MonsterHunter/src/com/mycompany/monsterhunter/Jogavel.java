package com.mycompany.monsterhunter;

public class Jogavel extends Personagem implements Controle {
    private int nivel;
    
    public Jogavel(String nome,int vital,Jogo jogo,int nivel){
        super(nome,vital,jogo);
        this.nivel=Math.min(Math.max(nivel, 1), 5);
    }
    
    

    @Override
    public void aplicarGolpeEspecial(Personagem p){
    switch(nivel){
            case 1 -> p.setVital(p.getVital()-nivel*10);
            case 2 -> p.setVital(p.getVital()-nivel*10);
            case 3 -> p.setVital(p.getVital()-nivel*10);
            case 4 -> p.setVital(p.getVital()-nivel*10);
            case 5 -> p.setVital(p.getVital()-nivel*10);
        }
    }
    
    @Override
    public void BotaoA(NaoJogavel p) {
        aplicarGolpeNormal(p);
    }

    @Override
    public void BotaoB(NaoJogavel p) {
        aplicarGolpeEspecial(p);
    }
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel=Math.min(Math.max(nivel, 1), 5);
    }
}
