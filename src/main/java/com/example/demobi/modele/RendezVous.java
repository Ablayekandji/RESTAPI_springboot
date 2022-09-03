package com.example.demobi.modele;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RendezVous implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(nullable = false,updatable = false)
    private String codeRV;
    private String description;
    private String lieu;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;


}
