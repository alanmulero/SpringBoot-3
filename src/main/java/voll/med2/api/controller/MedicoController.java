package voll.med2.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import voll.med2.api.medico.DadosCadastroMedico;
import voll.med2.api.medico.Medico;
import voll.med2.api.medico.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @GetMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {
            repository.save(new Medico(dados));
    }

}
