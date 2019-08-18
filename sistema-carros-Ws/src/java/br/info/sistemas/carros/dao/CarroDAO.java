package br.info.sistemas.carros.dao;

import br.info.sistemas.carros.entidade.Carro;
import br.info.sistemas.carros.util.FabricaConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO{
    
    public List<Carro> buscar() throws Exception{
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
            throw new Exception("Erro ao buscar os carros!",ex);
        }
    }
}