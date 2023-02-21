package br.pucpr.musicserver.rest.artists;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistsResource {
    private ArtistsService service;

    public ArtistsResource(ArtistsService service) {
        this.service = service;
    }

    @GetMapping
    @Transactional
    public List<Artist> search(
        @RequestParam(value = "genre", required = false) String genre
    ) {
        return service.search(genre);
    }

    @PostMapping
    @Transactional
    public Artist add(@Valid @RequestBody Artist artist) {
        return service.add(artist);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @PutMapping
    @Transactional
    public Artist update(@Valid @RequestBody Artist artist){
        return service.update(artist);
    }
}
