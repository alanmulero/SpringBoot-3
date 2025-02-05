package voll.med2.api.medico;

import voll.med2.api.endereco.Endereco;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, Endereco endereco) {
}
