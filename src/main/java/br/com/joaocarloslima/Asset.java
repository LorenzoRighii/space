package br.com.joaocarloslima;

import javafx.scene.image.ImageView;

public abstract class Asset {

    private int x;
    private int y;
    private ImageView imagem;
    private int velocidade;
    private Direcao direcao;

    public Asset(int x, int y, int velocidade, Direcao direcao) {
        this.x = x;
        this.y = y;
        this.velocidade = velocidade;
        this.direcao = direcao;
    }

    public void mover() {
        switch (direcao) {
            case CIMA:
                setY(y - velocidade);
                break;
            case BAIXO:
                setY(y + velocidade);
                break;
            case ESQUERDA:
                setX(x - velocidade);
                break;
            case DIREITA:
                setX(x + velocidade);
                break;
        }
    }

    public boolean colidiuCom(Asset asset) {
        return x < asset.getX() + 50 &&
                x + 50 > asset.getX() &&
                y < asset.getY() + 50 &&
                y + 50 > asset.getY();
    }

    private void atualizarImagem() {
        if (imagem != null) {
            imagem.setLayoutX(x);
            imagem.setLayoutY(y);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        atualizarImagem();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        atualizarImagem();
    }

    public ImageView getImagem() {
        return imagem;
    }

    public void setImagem(ImageView imagem) {
        this.imagem = imagem;
        atualizarImagem();
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public Direcao getDirecao() {
        return direcao;
    }

    public void setDirecao(Direcao direcao) {
        this.direcao = direcao;
    }
}
