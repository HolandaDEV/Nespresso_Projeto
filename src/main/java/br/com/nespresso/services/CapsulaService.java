package br.com.nespresso.services;

import br.com.nespresso.entities.Capsula;
import br.com.nespresso.entities.Categoria;
import br.com.nespresso.repositories.CapsulaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CapsulaService {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CapsulaRepositorio capsulaRepositorio;

    public List<Capsula> buscaPorCategoria(int codigoCategoria) {
        Categoria categoria =
                this.categoriaService.buscaCategoria(codigoCategoria);

        if (categoria == null)
            throw new NullPointerException("Categoria não localizada");
        else {
            List<Capsula> capsulas =
                    this.capsulaRepositorio.findByCategoria(categoria);

            return capsulas;
        }
    }

    @Transactional
    public Capsula nova(Capsula capsula) {
        if (this.categoriaService.existe(capsula.getCategoria())) {
            if (this.capsulaValida(capsula)) {
                return this.capsulaRepositorio.save(capsula);
            } else {
                throw new IllegalArgumentException("Capsula com dados inválidos.");
            }
        } else {
            throw new NullPointerException("Categoria não localizada.");
        }
    }

    private boolean capsulaValida(Capsula capsula) {

        if (capsula.getNome() == null)
            return false;
        else if (capsula.getPreco() == null || capsula.getPreco() <= 0)
            return false;
        else if (capsula.getCategoria() == null)
            return false;
        else if (capsula.getQuantidadeUnitaria() <= 0)
            return false;
        

        return true;
    }

    public List<Capsula> buscaTodas() {
        return this.capsulaRepositorio.findAll();
    }

    public Capsula buscaCapsula(int pCodigo) {
        Capsula capsula = this.capsulaRepositorio.findOne(pCodigo);
        return capsula;
    }

    public void remover(int pCodigo) {
        boolean existe = this.capsulaRepositorio.exists(pCodigo);
        if (existe)
            this.capsulaRepositorio.delete(pCodigo);
//        Capsula capsula = this.capsulaRepositorio.findOne(pCodigo);
//        if (capsula != null)
//            this.capsulaRepositorio.delete(capsula);
    }

    public Capsula atualizarCapsula(Capsula capsula) {
        if (this.capsulaValida(capsula))
            return this.capsulaRepositorio.save(capsula);
        return null;
    }
}
