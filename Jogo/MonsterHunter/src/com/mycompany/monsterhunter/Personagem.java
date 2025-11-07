package com.mycompany.monsterhunter;


public abstract class Personagem{
    private String nome;
    private int vital;
    private Jogo jogo;
    
    public Personagem(String nome, int vital, Jogo jogo){
        this.nome=nome;
        this.vital=Math.min(Math.max(vital, 0), 100);
        this.jogo=jogo;
    }
    
    public void aplicarGolpeNormal(Personagem P){
        P.setVital(P.getVital() -10);
    }
    
    public abstract void aplicarGolpeEspecial(Personagem P);
    
    
    
    
    
//Getters
    public String getNome() {
        return nome;
    }

    public int getVital() {
        return vital;
    }

    public Jogo getJogo() {
        return jogo;
    }
//Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVital(int vital) {
        this.vital = vital;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    } 
}

