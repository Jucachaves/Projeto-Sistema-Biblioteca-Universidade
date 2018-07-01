/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;


import dao.EmprestimoLivroDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import vo.ClienteVO;
import vo.EmprestimoLivroVO;
import vo.LivrosVO;


/**
 *
 * @author leonardo
 */
public class EmprestimoControl {
    public EmprestimoControl(){
    }
    public ArrayList<EmprestimoLivroVO> buscar() throws IOException, SQLException, Exception {
        EmprestimoLivroDAO emprestimoDao = new EmprestimoLivroDAO();
        return emprestimoDao.buscar();
    }
    
    public void gerarEmprestimo(String cliente , String livro)throws ValidacaoException, IOException, SQLException, Exception {
        ArrayList<ClienteVO> clientes = new ArrayList<>();
        ArrayList<LivrosVO> livros = new ArrayList<>();
        ClienteControl clienteControl = new ClienteControl();
        LivroControl livroControl = new LivroControl();
        
        clientes = clienteControl.buscar();
        livros = livroControl.buscar();
        String c="",l="";
        for (ClienteVO cliente1 : clientes) {
            if(cliente1.getNome().equals(cliente)){
                c = cliente1.getNome();
            }
        }
        for (LivrosVO livro1 : livros) {
            if (livro1.getTitulo().equals(livro)){
                l  = livro1.getTitulo();
            }
        }
        
        if (!c.equals("") && !l.equals("")){
            cadastrarLivro(c, l);
        }else{
            throw new ValidacaoException("Cliente ou livro não cadastrado!.");
        }
        
    }
    public void cadastrarLivro(String cliente,String nomeLivro) throws ValidacaoException, IOException, SQLException, Exception {
        //this.validarCamposObrigatorios(id, nome, email, telefone, uf, cep, bairro, numero, cidade, rua);
        EmprestimoLivroVO emprestimoVO = new EmprestimoLivroVO(cliente, nomeLivro);
        EmprestimoLivroDAO emprestimoDao = new EmprestimoLivroDAO(emprestimoVO);
        emprestimoDao.cadastrar();
    }
}
