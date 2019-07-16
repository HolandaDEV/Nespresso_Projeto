package br.com.nespresso.services;

import br.com.nespresso.entities.Categoria;
import br.com.nespresso.repositories.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public List<Categoria> buscaTodasCategorias() {
        return this.categoriaRepositorio.findAll();
    }

    public Categoria buscaCategoria(int codigoCategoria) {
        Categoria categoria = this.categoriaRepositorio.findOne(codigoCategoria);
        return categoria;
    }

    public boolean existe(Categoria categoria) {
        return this.categoriaRepositorio
                .exists(categoria.getCodigo());
    }

}
