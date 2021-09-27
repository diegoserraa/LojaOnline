package br.com.uvass.provap1tassio.model.repository;
import br.com.uvass.provap1tassio.model.entity.PromocaoItem;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PromocaoItemMapper implements RowMapper<PromocaoItem> {
    @Override
    public PromocaoItem mapRow(ResultSet result, int i) throws SQLException {
        PromocaoItem promocaoItem = new PromocaoItem();
        promocaoItem.setId(result.getInt("id"));
        promocaoItem.setValorPromocao(result.getFloat("ValorPromocao"));
        promocaoItem.setDataCadastro(result.getString("dataCadastro"));
        promocaoItem.setDataUltimaAtualizacao(result.getString("dataUltimaAtualizacao"));
        promocaoItem.setProdutoId(result.getInt("produtoId"));
        promocaoItem.setPromocaoId(result.getInt("promocaoId"));
        return promocaoItem;
    }
}
