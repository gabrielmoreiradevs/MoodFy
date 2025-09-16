package com.moodify.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_contents")
public class Contents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    private double rating;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateData;

    @ManyToMany
    @JoinTable(name = "contents_moods",
        joinColumns = @JoinColumn(name = "contents_id"),
        inverseJoinColumns = @JoinColumn(name = "moods_id")
    )
    private List<Moods> moods;

    @ManyToMany
    @JoinTable(name = "contents_plataforms",
        joinColumns = @JoinColumn(name = "contents_id"),
        inverseJoinColumns = @JoinColumn(name = "plataforms_id")
    )
    private List<Plataform> plataforms;

}
