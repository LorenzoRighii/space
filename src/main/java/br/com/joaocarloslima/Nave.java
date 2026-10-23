package br.com.joaocarloslima;

import javafx.scene.image.ImageView;

public class Nave extends Asset {

    public static final int LARGURA_TELA = 640;
    public static final int TAMANHO = 50;

    public Nave(int x, int y, int velocidade, Direcao direcao) {
        super(x, y, velocidade, direcao);

        ImageView imagem = new ImageView(
                App.class.getResource("images/ships/playerShip1_blue.png").toString());
        imagem.setFitWidth(TAMANHO);
        imagem.setFitHeight(TAMANHO);
        imagem.setPreserveRatio(true);
        setImagem(imagem);
    }

    public Tiro atirar(int poder) {
        return new Tiro(getX(), getY(), 10, Direcao.CIMA, poder);
    }

    @Override
    public void mover() {
        super.mover();

        int xMin = 0;
        int xMax = LARGURA_TELA - TAMANHO;

        if (getX() < xMin) {
            setX(xMin);
        } else if (getX() > xMax) {
            setX(xMax);
        }
    }
}
