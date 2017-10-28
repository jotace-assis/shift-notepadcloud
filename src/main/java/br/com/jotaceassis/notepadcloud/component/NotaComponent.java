package br.com.jotaceassis.notepadcloud.component;

import br.com.jotaceassis.notepadcloud.model.Nota;
import br.com.jotaceassis.notepadcloud.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotaComponent {

    @Autowired
    NotaRepository notaRepository;

    public Nota salvar(Nota nota) {
        List<Nota> notas = notaRepository.findByTitulo(nota.getTitulo());
        if(notas.size() > 0) {
            nota.setId(notas.get(0).getId());
        }
        return notaRepository.save(nota);
    }

    public List<Nota> findAll() {
        return notaRepository.findAll();
    }

    public List<Nota> findByTitulo(String titulo) {
        return notaRepository.findByTitulo(titulo);
    }

    public void deleteAll() {
        notaRepository.deleteAll();
    }

}
