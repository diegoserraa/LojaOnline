package br.com.uvass.provap1tassio.model.entity;

public class PromocaoItem {
    private int id;
    private float valorPromocao;
    private String dataCadastro;
    private String dataUltimaAtualizacao;
    private int produtoId;
    private int promocaoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValorPromocao() {
        return valorPromocao;
    }

    public void setValorPromocao(float valorPromocao) {
        this.valorPromocao = valorPromocao;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(String dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getPromocaoId() {
        return promocaoId;
    }

    public void setPromocaoId(int promocaoId) {
        this.promocaoId = promocaoId;
    }
}
