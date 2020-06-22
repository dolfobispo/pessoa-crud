package controller;

import exceptions.PessoaException;
import model.Pessoa;
import service.PessoaService;
import validation.pessoaBO.PessoaBO;

public class PessoaController {
    private final PessoaService service;
    public PessoaController(){
        service = new PessoaService();
    }
    public Pessoa cadastrar(Pessoa pessoa) throws PessoaException {
        PessoaBO pessoaBO = new PessoaBO(pessoa);
        pessoaBO.validaPessoaBO();
        return service.cadastrar(pessoa);
    }
    public Pessoa buscar(String cpf){
         return service.buscar(cpf);
    }
}
