import controller.PessoaController;
import exceptions.PessoaException;
import model.Pessoa;


import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        final PessoaController pessoaController = new PessoaController();
        boolean continuar = true;
        Scanner scan = new Scanner(System.in);
        /*
        System.out.println("Digite o CPF \n");

        Pessoa pessoa = pessoaController.buscar(scan.nextLine());
        System.out.println(pessoa.toString());
        */


        while (continuar){

            Pessoa pessoa = new Pessoa();
            System.out.println("Digite o CPF \n");
            pessoa.setCpf(scan.nextLine());
            System.out.println("Digite o Nome \n");
            pessoa.setNome(scan.nextLine());
            System.out.println("Digite a Idade\n");
            pessoa.setIdade(Integer.parseInt(scan.nextLine()));
            try{
                Pessoa pessoaRetorno = pessoaController.cadastrar(pessoa);
                System.out.println(pessoaRetorno.toString());

            }catch (PessoaException e) {
                System.out.println(e.getErros());
            }finally {
                System.out.println("Deseja continuar cadastrando ? S/N \n");
                if(scan.nextLine().toUpperCase().equals("N")){
                    continuar = false;
                    System.out.println("fim da operação");
                };
            }
        }


    }
}
