package br.pucpr.musicserver.rest.albums;


import br.pucpr.musicserver.rest.artists.Artist;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jdk.jfr.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/albums")

public class AlbumsResource {

    private AlbumsService service;
    public AlbumsResource(AlbumsService service) {
        this.service = service;
    }




    @GetMapping("/busca por nome")
    public List<Album> search(
            @RequestParam(value = "album_name", required = false) String album_name
    ) {
        return service.search(album_name);
    }

    @GetMapping("/busca por ano")
    public List<Album> lista_ano(
            @RequestParam(value = "ano", required = false) String ano
    ) {
        return service.listar_ano();
    }

    @GetMapping("/todos")
    public List<Album> listar(
            @RequestParam(value = "album_name", required = false) String album_name
    ) {
        return service.listar();
    }

    @PostMapping
    @Transactional
    public Album add(@Valid @RequestBody Album album) {
        return service.add(album);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
    @PutMapping
    @Transactional
    public Album update(@Valid @RequestBody Album album){
        return service.update(album);
    }



}
