package br.com.uvass.provap1tassio.model.entity;

public class Categoria {
    private int id;
    private String imagemSimboloUlr;
    private String nome;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagemSimboloUlr() {
        return imagemSimboloUlr;
    }

    public void setImagemSimboloUlr(String imagemSimboloUlr) {
        this.imagemSimboloUlr = imagemSimboloUlr;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
