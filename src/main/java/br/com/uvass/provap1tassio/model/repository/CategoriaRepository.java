package br.com.uvass.provap1tassio.model.repository;
import br.com.uvass.provap1tassio.model.entity.Produto;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.ArrayList;


public class CategoriaRepository {
    private JdbcTemplate jdbcTemplate;

    public CategoriaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Produto> listarProdutos(int id) {
        String sql = "SELECT p.* FROM produto p JOIN categoriaProduto e ON e.produtoId = p.id JOIN categoria c ON e.categoriaId = c.id WHERE c.id = ?";

        return jdbcTemplate.query(sql, new Object[]{id}, new ProdutoMapper());
    }

    public List<Produto> buscarProdutoNomeValor(int id, String nome, String valorMinimo, String valorMaximo) {
        String sql = "SELECT p.* FROM produto p JOIN categoriaProduto e ON e.produtoId = p.id JOIN categoria c ON e.categoriaId = c.id WHERE c.id = ?";
        List<Object> listObject = new ArrayList<Object>();
        listObject.add(id);

        if (nome != null && nome != " "){
            sql += " AND p.nome = ?";
            listObject.add(nome);
        }

        if (valorMaximo != null && valorMinimo != null && valorMaximo != " " && valorMinimo != " " && nome != null && nome != " "){
            sql += " AND p.valorUnitario BETWEEN ? AND ?";
            listObject.add(Integer.parseInt(valorMinimo));
            listObject.add(Integer.parseInt(valorMaximo));
        }

        if (valorMaximo != null && valorMinimo != null && valorMaximo != " " && valorMinimo != " " && nome == null) {
            sql += " AND p.valorUnitario BETWEEN ? AND ?";
            listObject.add(Integer.parseInt(valorMinimo));
            listObject.add(Integer.parseInt(valorMaximo));
        }

        Object[] objeto = listObject.toArray(new Object[]{});

        return jdbcTemplate.query(sql, objeto, new ProdutoMapper());
    }
}

