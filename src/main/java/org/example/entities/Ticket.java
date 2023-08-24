package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "from_planet_id")
    private Planet fromPlanet;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "to_planet_id")
    private Planet toPlanet;

    public Ticket(LocalDateTime createdAt, @NonNull Client client, @NonNull Planet fromPlanet, @NonNull Planet toPlanet) {
        this.createdAt = createdAt;
        this.client = client;
        this.fromPlanet = fromPlanet;
        this.toPlanet = toPlanet;
    }
}
