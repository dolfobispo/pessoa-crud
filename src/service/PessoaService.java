package service;

import model.Pessoa;
import repository.PessoaRepository;
import validation.pessoaBO.PessoaBO;

public class PessoaService {

    private final PessoaRepository pessoaRepository;
    public PessoaService(){
        pessoaRepository = new PessoaRepository();
    }
    public Pessoa cadastrar (Pessoa pessoa){
        return pessoaRepository.cadastrar(pessoa);
    }

    public Pessoa buscar(String cpf) {
        return pessoaRepository.buscar(cpf);
    }
}
