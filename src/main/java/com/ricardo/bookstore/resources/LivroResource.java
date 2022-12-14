package com.ricardo.bookstore.resources;

import com.ricardo.bookstore.domain.Livro;
import com.ricardo.bookstore.dtos.LivroDTO;
import com.ricardo.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
@CrossOrigin(origins = "http://localhost:4200")
public class LivroResource {

    @Autowired
    private LivroService livroService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id) {
        Livro obj = livroService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat) {
        List<Livro> list = livroService.findAll(id_cat);
        List<LivroDTO> listDto = list.stream().map(LivroDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id, @Valid @RequestBody Livro obj) {
        Livro newObj = livroService.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @Valid @RequestBody Livro obj) {
        Livro newObj = livroService.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat, @Valid @RequestBody Livro obj) {
        Livro newObj = livroService.create(id_cat, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Integer id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
