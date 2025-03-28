package br.com.desafio_picpay.desafio_pickpay.domain.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.desafio_picpay.desafio_pickpay.domain.exception.RegraDeNegocioException;
import br.com.desafio_picpay.desafio_pickpay.domain.usuario.Usuario;
import br.com.desafio_picpay.desafio_pickpay.domain.usuario.UsuarioComum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "Transacao")
@Table(name = "transacao")
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transacao {

    public Transacao(UsuarioComum pagador,
            Usuario beneficiario,
            BigDecimal valor,
            TransacaoStatus status) {
        setPagador(pagador);
        setBeneficiario(beneficiario);
        setValor(valor);
        setStatus(status);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @JoinColumn(name = "pagador_id", nullable = false)
    private UsuarioComum pagador;

    @JoinColumn(name = "beneficiario_id", nullable = false)
    private Usuario beneficiario;

    @Column(nullable = false)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransacaoStatus status;

    @PrePersist
    private void prePersist() {
        this.dataHora = LocalDateTime.now();
    }

    private void setPagador(UsuarioComum pagador) {
        if (pagador == null) {
            throw new RegraDeNegocioException("Pagador não pode ser nulo");
        }

        this.pagador = pagador;
    }

    private void setBeneficiario(Usuario beneficiario) {
        if (beneficiario == null) {
            throw new RegraDeNegocioException("Beneficiário não pode ser nulo");
        }

        this.beneficiario = beneficiario;
    }

    private void setValor(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RegraDeNegocioException("Valor deve ser maior que zero");
        }

        this.valor = valor;
    }

    private void setStatus(TransacaoStatus status) {
        if (status == null) {
            throw new RegraDeNegocioException("Status não pode ser nulo");
        }

        this.status = status;
    }
}
