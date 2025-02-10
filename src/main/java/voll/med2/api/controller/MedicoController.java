package voll.med2.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import voll.med2.api.medico.DTOListagemMedicos;
import voll.med2.api.medico.DadosCadastroMedico;
import voll.med2.api.medico.Medico;
import voll.med2.api.medico.MedicoRepository;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
            repository.save(new Medico(dados));
    }

    // Metodo Get
    @GetMapping
    public Page<DTOListagemMedicos> listar(Pageable paginacao) { // Paginação
        return repository.findAll(paginacao).map(DTOListagemMedicos::new);
    }

}
