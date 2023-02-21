package br.pucpr.musicserver.rest.albums;

import br.pucpr.musicserver.lib.exception.NotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumsService {
    private AlbumsRepository repository;

    public AlbumsService(AlbumsRepository repository) {
        this.repository = repository;
    }


    public Album add(Album album) {
        return repository.save(album);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(id);
        }
        repository.deleteById(id);
    }

    public Album update( Album album) {
        if (album.getId()>0)
            repository.save(album);

        return album;
    }


    public List<Album> search(String album_name) {
        return  album_name == null ?
                repository.findAll(Sort.by(Sort.Order.asc("album_name"))) :
                repository.findAll();
    }

    public List<Album>listar(){
        return repository == null ?
                repository.findAll(Sort.by(Sort.Order.asc("id"))):
                repository.findAll();
    }

    public List<Album>listar_ano(){
        return repository.findAll(Sort.by(Sort.Order.asc("ano")));
    }


}


