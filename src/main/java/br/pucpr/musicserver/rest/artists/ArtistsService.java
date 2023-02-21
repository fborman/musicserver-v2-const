package br.pucpr.musicserver.rest.artists;

import br.pucpr.musicserver.lib.exception.NotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistsService {
    private ArtistsRepository repository;

    public ArtistsService(ArtistsRepository repository) {
        this.repository = repository;
    }

    public List<Artist> search(String genre) {
        return genre == null ?
            repository.findAll(Sort.by(Sort.Order.asc("name"))) :
            repository.findByGenre(genre);
    }

    public Artist add(Artist artist) {
        return repository.save(artist);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(id);
        }
        repository.deleteById(id);
    }
    public Artist update( Artist artist) {
        if (artist.getId()>0)
            repository.save(artist);

        return artist;
    }
}
