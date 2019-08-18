package br.info.sistemas.carros.dao;

import br.info.sistemas.carros.entidade.Carro;
import br.info.sistemas.carros.util.FabricaConexao;
import br.info.sistemas.carros.util.exception.ErroSistema;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO implements CrudDAO<Carro>{
    
    @Override
    public void salvar(Carro carro) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(carro.getId() == null){
                ps = conexao.prepareStatement("INSERT INTO `carro` (`placa`,`chassi`,`renavam`,`modelo`,`marca`,`ano`) VALUES (?,?,?,?,?,?)");
            } else {
                ps = conexao.prepareStatement("update carro set placa=?, chassi=?, renavam=?, modelo=?, marca=?, ano=? where id=?");
                ps.setInt(7, carro.getId());
            }
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getChassi());
            ps.setString(3, carro.getRenavam());
            ps.setString(4, carro.getModelo());
            ps.setString(5, carro.getMarca());
            ps.setDate(6, new Date(carro.getAno().getTime()));
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }
    
    @Override
    public void deletar(Carro carro) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps  = conexao.prepareStatement("delete from carro where id = ?");
            ps.setInt(1, carro.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o carro!", ex);
        }
    }
    
    @Override
    public List<Carro> buscar() throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from carro");
            ResultSet resultSet = ps.executeQuery();
            List<Carro> carros = new ArrayList<>();
            while(resultSet.next()){
                Carro carro = new Carro();
                carro.setId(resultSet.getInt("id"));
                carro.setPlaca(resultSet.getString("placa"));
                carro.setChassi(resultSet.getString("chassi"));
                carro.setRenavam(resultSet.getString("renavam"));
                carro.setModelo(resultSet.getString("modelo"));
                carro.setMarca(resultSet.getString("marca"));
                carro.setAno(resultSet.getDate("ano"));
                carros.add(carro);
            }
            FabricaConexao.fecharConexao();
            return carros;
            
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar os carros!",ex);
        }
    }
}
