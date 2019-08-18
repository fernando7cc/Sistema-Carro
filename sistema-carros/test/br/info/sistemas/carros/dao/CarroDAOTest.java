/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.info.sistemas.carros.dao;

import br.info.sistemas.carros.entidade.Carro;
import br.info.sistemas.carros.util.exception.ErroSistema;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author ferna
 */
public class CarroDAOTest {
    
    public CarroDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of salvar method, of class CarroDAO.
     */
    @Test
    @Ignore
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        Carro carro = null;
        CarroDAO instance = new CarroDAO();
        instance.salvar(carro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class CarroDAO.
     */
    @Test
    @Ignore
    public void testDeletar() throws Exception {
        System.out.println("deletar");
        Carro carro = null;
        CarroDAO instance = new CarroDAO();
        instance.deletar(carro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class CarroDAO.
     */
    @Test
    public void testBuscar() throws ErroSistema{
        CarroDAO dao = new CarroDAO();
        
        for(Carro c: dao.buscar()){
            System.out.println("Placa"+c.getPlaca()+"Chassi"+c.getChassi()+"Renavam"+c.getRenavam()+"Modelo"+c.getModelo()+"Marca"+c.getMarca()+"Ano"+c.getAno());
        }  
    } 
}
