package br.com.desafio_picpay.desafio_pickpay.domain.usuario;

import br.com.desafio_picpay.desafio_pickpay.domain.exception.RegraDeNegocioException;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
public abstract class Usuario {

    @Id
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "nome_completo", nullable = false, length = 100)
    private String nomeCompleto;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    public void setNomeCompleto(String nomeCompleto) {
        if (nomeCompleto == null || nomeCompleto.isBlank()) {
            throw new RegraDeNegocioException("Nome não pode ser nulo ou estar em branco");
        }

        this.nomeCompleto = nomeCompleto;
    }

    public void setEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new RegraDeNegocioException("Email não pode ser nulo ou estar em branco");
        }
    }

    public void setSenha(String senha) {
        if (senha == null || senha.isBlank()) {
            throw new RegraDeNegocioException("Senha não pode ser nula ou estar em branco");
        }

        this.senha = senha;
    }
}
