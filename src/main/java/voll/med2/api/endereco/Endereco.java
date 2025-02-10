package voll.med2.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record Endereco
        (

                String id,
                @NotBlank
                String logradouro,
                @NotBlank
                String bairro,
                @NotBlank
                @Pattern(regexp = "\\d{8}")
                String cep,
                @NotBlank
                String cidade,

                String uf,
                String complemento,
                String numero) {
}
