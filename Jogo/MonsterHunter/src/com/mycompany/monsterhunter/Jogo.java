package com.mycompany.monsterhunter;
import java.util.ArrayList;
import java.util.List;
    

public class Jogo {
    
    private int dificult;
    private List<Personagem> listaPersonagens;

    public Jogo(int dificult) {
        this.dificult = dificult;
        this.listaPersonagens = new ArrayList<>();
    }
    
    public void adicionarPersonagem(Personagem p){
        listaPersonagens.add(p);
    }
    
    public void RemoverPersonagem(Personagem p){
        listaPersonagens.remove(p);
    }
    
    
    public List<Personagem>getListaPersonagens(){
        return listaPersonagens;
    }
    
   
    public int getDificult() {
        return dificult;
    }

    public void setDificult(int dificult) {
        this.dificult = Math.min(Math.max(dificult, 1), 3);
    }
}

