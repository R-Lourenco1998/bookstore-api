package com.ricardo.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Livro {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo TÍTULO é requerido")
    @Length(min = 3, max = 100, message = "O campo TÍTULO deve ter entre 3 e 100 caracteres")
    private String titulo;

    @NotEmpty(message = "Campo NOME DO AUTOR é requerido")
    @Length(min = 3, max = 100, message = "O campo NOME DO AUTOR deve ter entre 3 e 100 caracteres")
    private String nome_autor;

    @NotEmpty(message = "Campo TEXTO é requerido")
    @Length(min = 10, max = 2000000, message = "O campo TEXTO deve ter entre 10 e 2.000.000 caracteres")
    private String texto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
