package repository;

import connection.Connect;
import model.Pessoa;

import java.sql.*;

public class PessoaRepository {
    private Connection connection;
    public PessoaRepository(){
        this.connection = Connect.getConnection();
    }
    public Pessoa cadastrar(Pessoa pessoa){

        String sql = String.format("INSERT INTO pessoa(nome,cpf,idade) VALUES ('%s','%s','%s')",
                pessoa.getNome(),
                pessoa.getCpf(),
                pessoa.getIdade());
        try {
            Statement stmt = connection.prepareStatement(sql);
            stmt.execute(sql,Statement.RETURN_GENERATED_KEYS);
            final ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                rs.getInt(1);
                pessoa.setId((long)rs.getInt(1));
                stmt.close();
            }

        }
        catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return pessoa;
    }
    public Pessoa buscar (String cpf){
        String sql = "select * from pessoa where cpf = "+cpf;
        Pessoa pessoa = new Pessoa();
        try {
            ResultSet rs = connection.prepareStatement(sql).executeQuery();
            while(rs.next()){
                pessoa.setId((long)rs.getInt(1));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setIdade(rs.getInt("idade"));

            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return pessoa;
    }
}
