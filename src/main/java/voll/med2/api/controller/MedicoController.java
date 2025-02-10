package voll.med2.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import voll.med2.api.medico.DadosCadastroMedico;
import voll.med2.api.medico.Medico;
import voll.med2.api.medico.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
            repository.save(new Medico(dados));
    }

}
