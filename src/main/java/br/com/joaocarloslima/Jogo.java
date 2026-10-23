package br.com.joaocarloslima;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogo {

    public static final int LARGURA_TELA = 640;
    public static final int ALTURA_TELA = 480;
    public static final int NIVEL_MAXIMO = 4;
    public static final int PONTOS_POR_NIVEL = 10;

    private static final Random RANDOM = new Random();

    protected List<Asset> assets = new ArrayList<>();
    protected Nave nave = new Nave(280, 400, 10, Direcao.DIREITA);
    private int pontos;
    private int nivel = 1;

    public Tiro atirar() {
        Tiro tiro = nave.atirar(nivel); // poder do tiro = nível atual (1 a 4)
        assets.add(tiro);
        return tiro;
    }

    public Meteoro criarMeteoro() {
        int x = RANDOM.nextInt(LARGURA_TELA - 50);
        int velocidade = 2 + RANDOM.nextInt(3) + (nivel - 1);
        Meteoro meteoro = new Meteoro(x, 0, velocidade, Direcao.BAIXO);
        assets.add(meteoro);
        return meteoro;
    }

    public int pontuar() {
        pontos++;
        nivel = Math.min(NIVEL_MAXIMO, pontos / PONTOS_POR_NIVEL + 1);
        return pontos;
    }

    public int getPontos() {
        return pontos;
    }

    public int getNivel() {
        return nivel;
    }

    public Nave getNave() {
        return nave;
    }

    public List<Asset> getAssets() {
        return assets;
    }
}
