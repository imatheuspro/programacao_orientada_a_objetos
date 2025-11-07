package com.mycompany.monsterhunter;

public class MonsterHunter {

    public static void main(String[] args) {
    
        Jogo jogo= new Jogo(2);
        
        Jogavel p1 = new Jogavel("Paulo", 100, jogo, 3);
        NaoJogavel p2 = new NaoJogavel(false,"Luisa", 100, jogo );
        
        p1.BotaoA(p2);
        p1.BotaoA(p2);
        p1.BotaoB(p2);
        
        System.out.println(p2.getVital());
        
        p2.aplicarGolpeNormal(p1);
        p2.aplicarGolpeEspecial(p1);
        System.out.println(p1.getVital());
    }

    
}

