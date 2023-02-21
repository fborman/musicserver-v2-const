package br.pucpr.musicserver.rest.albums;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data @NoArgsConstructor


public class Album {
    @Id
    @GeneratedValue
    private Long id;
    private String album_name;
    private int ano;
    private String artist;

}
