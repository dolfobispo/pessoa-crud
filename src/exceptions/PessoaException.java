package exceptions;

import java.util.List;

public class PessoaException  extends Exception{

    private List<String> erros;

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public boolean hasErros(){
        return erros.size() > 0 ? true : false;
    }
    public String getErros(){
        return erros.toString();
    }
}
