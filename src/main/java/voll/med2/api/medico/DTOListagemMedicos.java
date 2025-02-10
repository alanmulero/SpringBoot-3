package voll.med2.api.medico;

public record DTOListagemMedicos(String nome, String email, String crm, Especialidade especialidade) {

    // Criando um construtor dentro de um Record vindo de DTOListagemMedicos, de MedicoController.
    public DTOListagemMedicos(Medico medico ){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
