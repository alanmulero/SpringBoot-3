package voll.med2.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import voll.med2.api.medico.*;

import java.beans.Transient;
import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    // Metodo Get
    @GetMapping
    public Page<DTOListagemMedicos> listar(Pageable paginacao) { // Paginação
        return repository.findAllByAtivoTrue(paginacao).map(DTOListagemMedicos::new);
    }

    // Metodo Put
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosPutMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizaDados(dados);
    }

    // Metodo Delete exclusão total
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void excluir(@PathVariable Long id){
//        repository.deleteById(id);


    // Exclusão lógica
    @DeleteMapping("/{id}")
    @Transactional
    public void exclusaoLogica(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}