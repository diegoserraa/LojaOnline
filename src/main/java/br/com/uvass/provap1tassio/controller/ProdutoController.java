package br.com.uvass.provap1tassio.controller;
import br.com.uvass.provap1tassio.model.entity.Produto;
import br.com.uvass.provap1tassio.model.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.HashMap;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(JdbcTemplate jdbcTemplate){
        produtoRepository = new ProdutoRepository(jdbcTemplate);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Produto inserir(@RequestBody Produto produto) throws Exception {
        return produtoRepository.inserir(produto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public HashMap buscarPorId(@PathVariable int id){
        return produtoRepository.buscarPorId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Produto> buscarProdutoNomeValor(@RequestParam(required = false) String nome, String valorMinimo, String valorMaximo) {
        return produtoRepository.buscarProdutoNomeValor(nome, valorMinimo, valorMaximo);
    }
}