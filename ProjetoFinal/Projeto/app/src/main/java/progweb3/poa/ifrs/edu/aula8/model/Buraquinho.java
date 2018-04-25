package progweb3.poa.ifrs.edu.aula8.model;

import java.io.Serializable;

/**
 * Created by 0724122 on 24/04/2018.
 */

public class Buraquinho implements Serializable {
    private Long id;
    private String endereco;
    private int numero;
    private String lat;
    private String lon;
    private String descricao;
    private String imagem;

    public Buraquinho() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return endereco + ", " + numero;
    }
}
