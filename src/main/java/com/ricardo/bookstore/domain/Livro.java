package com.ricardo.bookstore.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Livro {

    private Integer id;
    private String titulo;
    private String nome_autor;
    private String texto;

    private Categoria categoria;

}
