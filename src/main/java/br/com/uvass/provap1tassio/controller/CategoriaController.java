package br.com.uvass.provap1tassio.controller;
import br.com.uvass.provap1tassio.model.entity.Produto;
import br.com.uvass.provap1tassio.model.repository.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private CategoriaRepository categoriaRepository;

    public CategoriaController(JdbcTemplate jdbcTemplate) {
        categoriaRepository = new CategoriaRepository(jdbcTemplate);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/produto")
    public List<Produto> buscarProdutoNomeValor(@PathVariable int id, @RequestParam(required = false)String nome, String valorMinimo, String valorMaximo) {
        return categoriaRepository.buscarProdutoNomeValor(id, nome, valorMinimo, valorMaximo);
    }
}