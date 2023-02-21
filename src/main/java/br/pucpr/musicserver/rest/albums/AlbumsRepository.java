package br.pucpr.musicserver.rest.albums;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlbumsRepository extends JpaRepository<Album, Long> {

    List<Album>findAll();

    }
