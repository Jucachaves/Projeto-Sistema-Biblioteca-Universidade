/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.LivrosDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import vo.LivrosVO;

/**
 *
 * @author leonardo
 */
public class LivroControl {
    
    public LivroControl(){
    }
    /* private int ISBN;
    private String titulo;
    private String editora;
    private int quantidade;
    private String autor;
    private String localEdicao;*/
    
    public void cadastrar(String ISBN,String titulo,String editora,String quantidade,String autor,String localEdicao) throws ValidacaoException, IOException, SQLException, Exception {
        //this.validarCamposObrigatorios(id, nome, email, telefone, uf, cep, bairro, numero, cidade, rua);
        this.validarCamposObrigatorios(ISBN, titulo, editora, quantidade, autor, localEdicao);
        LivrosVO livroVO = new LivrosVO(Integer.parseInt(ISBN), titulo, Integer.parseInt(quantidade), autor, localEdicao, editora);
        LivrosDAO livroDao = new LivrosDAO(livroVO);
        livroDao.cadastrar();

    }

   
    public ArrayList<LivrosVO> buscar() throws IOException, SQLException, Exception {
        LivrosDAO livroDao = new LivrosDAO();
        return livroDao.buscar();
    }


    public void editar(String ISBN,String titulo,String editora,String quantidade,String autor,String localEdicao) throws ValidacaoException, IOException, SQLException, Exception {

       // this.validarCamposObrigatorios(id, nome, email, telefone, uf, cep, bairro, numero, cidade, rua);
       this.validarCamposObrigatorios(ISBN, titulo, editora, quantidade, autor, localEdicao);
       LivrosVO livroVO = new LivrosVO(Integer.parseInt(ISBN), titulo,Integer.parseInt(quantidade), autor, localEdicao, editora);
        
        ArrayList<LivrosVO> livros = this.buscar();
        for (int i = 0; i < livros.size(); i++) {
            LivrosVO livro = livros.get(i);
            if(livro.getISBN() == livroVO.getISBN()){
                livros.remove(i);
                livros.add(livroVO);
            }
        }
        
        LivrosDAO livroPers = new LivrosDAO(livros);
        livroPers.editar();
       
    }

    public void excluir(String titulo) throws IOException, SQLException, Exception {
        ArrayList<LivrosVO> livros = this.buscar();
        for (int i = 0; i < livros.size(); i++) {
            LivrosVO livroVO = livros.get(i);
            
            if (titulo.equals(livroVO.getTitulo())){
                livros.remove(i);
            }
        }
        
        LivrosDAO livroPers = new LivrosDAO(livros);
        livroPers.excluir();
    }

    public boolean verificarExistencia(String nomeArquivo) throws IOException, SQLException, Exception {
        LivrosDAO livroDAO = new LivrosDAO();
        return livroDAO.verificarExistencia(nomeArquivo);
    }

    public void gerarRelatorio(String nomeArquivo) throws IOException, SQLException, Exception {
        ArrayList<LivrosVO> livros = this.buscar();
        LivrosDAO livroDAO = new LivrosDAO();
        livroDAO.gerarRelatorio(nomeArquivo);
    }

   
    private void validarCamposObrigatorios(String ISBN,String titulo,String editora,String quantidade,String autor,String localEdicao) throws ValidacaoException {

        if (ISBN.equals("") || titulo.equals("") || editora.equals("") || quantidade.equals("") || autor.equals("") || localEdicao.equals("") ) {

            throw new ValidacaoException("Todos os campos são obrigatórios.");

        } else if (Integer.parseInt(ISBN) < 0 ) {

            throw new ValidacaoException(("O campo isbn não pode ser negativo."));

        } else if (Integer.parseInt(quantidade) < 0) {

            throw new ValidacaoException("Quantidade deve ser maior que zero.");
        }
    }
     public ArrayList<LivrosVO> buscarTitulo(String titulo) throws IOException, SQLException, Exception {
         LivrosDAO livrosDAO =  new LivrosDAO();
         ArrayList<LivrosVO> livros = livrosDAO.buscar();
         ArrayList<LivrosVO> livrosFiltrados = new ArrayList<>();
         for (LivrosVO livroVO : livros) {
             if (livroVO.getTitulo().contains(titulo)){
                 livrosFiltrados.add(livroVO);
             }
         }
        
        
        return livrosFiltrados;
    }
     
     public ArrayList<LivrosVO> buscarAutor(String autor) throws IOException, SQLException, Exception {
         LivrosDAO livrosDAO =  new LivrosDAO();
         ArrayList<LivrosVO> livros = livrosDAO.buscar();
         ArrayList<LivrosVO> livrosFiltrados = new ArrayList<>();
         for (LivrosVO livroVO : livros) {
             if (livroVO.getAutor().contains(autor)){
                 livrosFiltrados.add(livroVO);
             }
         }
        
        
        return livrosFiltrados;
    }
}
