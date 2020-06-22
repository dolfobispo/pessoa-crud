package validation.pessoaBO;

import exceptions.PessoaException;
import model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaBO {

    Pessoa pessoa;
    PessoaException pessoaException ;
    List<String> erros;
    public PessoaBO ( Pessoa pessoa){
        this.pessoa= pessoa;
        pessoaException = new PessoaException();

    }
    public void validaPessoaBO() throws PessoaException {
        erros = new ArrayList<>();

        if(pessoa.getNome().length() > 20){
            erros.add("Nome não pode conter mais que 20 caracteres");
        }
        if(pessoa.getCpf().length() > 11){
            erros.add("O cpf não pode ter mais que 11 caracteres");
        }
        pessoaException.setErros(erros);
        if(pessoaException.hasErros()){
            throw pessoaException;
        }
    }
}
