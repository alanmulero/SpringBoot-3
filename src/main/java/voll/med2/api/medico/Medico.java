package voll.med2.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import voll.med2.api.endereco.EnderecoJpa;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private EnderecoJpa enderecoJpa;


    public Medico(DadosCadastroMedico dados) {

        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.enderecoJpa = new EnderecoJpa(dados.endereco());
    }
}
