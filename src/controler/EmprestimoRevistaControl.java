/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;


import dao.EmprestimoRevistaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import vo.ClienteVO;
import vo.EmprestimoRevistaVO;
import vo.RevistaVO;


/**
 *
 * @author leonardo
 */
public class EmprestimoRevistaControl {
    public EmprestimoRevistaControl(){
    }
    public ArrayList<EmprestimoRevistaVO> buscar() throws IOException, SQLException, Exception {
        EmprestimoRevistaDAO emprestimoDao = new EmprestimoRevistaDAO();
        return emprestimoDao.buscar();
    }
    
    public void gerarEmprestimo(String cliente , String revista)throws ValidacaoException, IOException, SQLException, Exception {
        ArrayList<ClienteVO> clientes = new ArrayList<>();
        ArrayList<RevistaVO> revistas = new ArrayList<>();
        ClienteControl clienteControl = new ClienteControl();
        RevistaControl revistaControl = new RevistaControl();
        
        clientes = clienteControl.buscar();
        revistas = revistaControl.buscar();
        String c="",l="";
        for (ClienteVO cliente1 : clientes) {
            if(cliente1.getNome().equals(cliente)){
                c = cliente1.getNome();
            }
        }
        for (RevistaVO revista1 : revistas) {
            if (revista1.getTitulo().equals(revista)){
                l  = revista1.getTitulo();
            }
        }
        
        if (!c.equals("") && !l.equals("")){
            cadastrarRevista(c, l);
        }else{
            throw new ValidacaoException("Cliente ou revista não cadastrado!.");
        }
        
    }
    public void cadastrarRevista(String cliente,String nomeRevista) throws ValidacaoException, IOException, SQLException, Exception {
        //this.validarCamposObrigatorios(id, nome, email, telefone, uf, cep, bairro, numero, cidade, rua);
        EmprestimoRevistaVO emprestimoVO = new EmprestimoRevistaVO(cliente, nomeRevista);
        EmprestimoRevistaDAO emprestimoDao = new EmprestimoRevistaDAO(emprestimoVO);
        emprestimoDao.cadastrar();
    }
}
