package voll.med2.api.medico;

import jakarta.validation.constraints.NotNull;
import voll.med2.api.endereco.Endereco;

public record DadosPutMedico(@NotNull Long id, String nome, String telefone, Endereco endereco) {
}
