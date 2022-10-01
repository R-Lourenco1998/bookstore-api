package com.ricardo.bookstore.dtos;

import com.ricardo.bookstore.domain.Livro;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LivroDTO {

        private static final long serialVersionUID = 1L;

        private Integer id;
        private String titulo;

        public LivroDTO(Livro obj) {
            super();
            this.id = obj.getId();
            this.titulo = obj.getTitulo();
        }

}
