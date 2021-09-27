package br.com.uvass.provap1tassio.model.repository;
import br.com.uvass.provap1tassio.model.entity.Categoria;
import br.com.uvass.provap1tassio.model.entity.Produto;
import br.com.uvass.provap1tassio.model.entity.Promocao;
import br.com.uvass.provap1tassio.model.entity.PromocaoItem;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class ProdutoRepository {

    private JdbcTemplate jdbcTemplate;

    public ProdutoRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public Produto inserir(Produto produto) throws Exception {
        String sql = "INSERT INTO produto(id, nome, descricao, fotoUrl, dataCadastro, dataUltimaAtualizacao, valorUnitario) VALUES (?,?,?,?,?,?,?)";
        int insert = jdbcTemplate.update(sql,
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getFotoUrl(),
                produto.getDataCadastro(),
                produto.getDataUltimaAtualizacao(),
                produto.getValorUnitario()
        );

        if (insert == 1){
            return produto;
        } throw new Exception("Produto nao cadastrado");
    }

    public HashMap buscarPorId(int id)  {
        HashMap hashMap = new HashMap();
        Produto produto =  jdbcTemplate.queryForObject("SELECT * FROM produto WHERE id=?", new Object[]{id}, new ProdutoMapper());
        hashMap.put("Produto", produto);
        List<Categoria> categoria = jdbcTemplate.query("SELECT c.* FROM categoria c JOIN categoriaProduto e ON e.categoriaId = c.id JOIN produto p ON p.id = e.produtoId WHERE p.id = ?", new Object[]{id}, new CategoriaMapper());
        hashMap.put("Categoria", categoria);
        List<PromocaoItem> promocaoItem = jdbcTemplate.query("SELECT i.* FROM promocaoItem i JOIN produto p ON p.id = i.produtoId WHERE p.id = ?", new Object[]{id}, new PromocaoItemMapper());
        hashMap.put("PromocaoItem", promocaoItem);
        List<Promocao> promocao = jdbcTemplate.query("SELECT r.* FROM promocao r JOIN promocaoItem i ON i.promocaoId = r.id JOIN produto p ON p.id = i.produtoId WHERE p.id = ?", new Object[]{id}, new PromocaoMapper());
        hashMap.put("Promocao", promocao);
        return hashMap;
    }

    public List<Produto> buscarProdutoNomeValor(String nome, String valorMinimo, String valorMaximo) {
        String sql = "SELECT * FROM produto WHERE";
        List<Object> listObject = new ArrayList<Object>();

        if (nome != null && nome != " "){
            sql += " nome = ?";
            listObject.add(nome);
        }
        if (valorMaximo != null && valorMinimo != null && valorMaximo != " " && valorMinimo != " " && nome != null && nome != " "){
            sql += " AND valorUnitario BETWEEN ? AND ?";
            listObject.add(Integer.parseInt(valorMinimo));
            listObject.add(Integer.parseInt(valorMaximo));
        }
        if (valorMaximo != null && valorMinimo != null && valorMaximo != " " && valorMinimo != " " && nome == null) {
            sql += " valorUnitario BETWEEN ? AND ?";
            listObject.add(Integer.parseInt(valorMinimo));
            listObject.add(Integer.parseInt(valorMaximo));
        }
        Object[] objeto = listObject.toArray(new Object[]{});
        return jdbcTemplate.query(sql, objeto, new ProdutoMapper());
    }
}
