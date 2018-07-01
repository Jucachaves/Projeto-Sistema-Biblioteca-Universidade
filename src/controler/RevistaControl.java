/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.RevistasDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import vo.RevistaVO;

/**
 *
 * @author leonardo
 */
public class RevistaControl {
    
    public RevistaControl() {

    }
    /*    private int id;
    private String titulo;
    private String data;
    private int quantidade;
*/
    public void cadastrar(String id,String titulo,String data,String quantidade) throws ValidacaoException, IOException, SQLException, Exception {
        //this.validarCamposObrigatorios(id, nome, email, telefone, uf, cep, bairro, numero, cidade, rua);
        this.validarCamposObrigatorios(id, titulo, data, quantidade);
        RevistaVO revistaVO = new RevistaVO(Integer.parseInt(id), titulo, data, Integer.parseInt(quantidade));
        RevistasDAO revistaDao = new RevistasDAO(revistaVO);
        revistaDao.cadastrar();
    }

   
    public ArrayList<RevistaVO> buscar() throws IOException, SQLException, Exception {
        RevistasDAO revistaDao = new RevistasDAO();
        return revistaDao.buscar();
    }


    public void editar(String id,String titulo,String data,String quantidade) throws ValidacaoException, IOException, SQLException, Exception {

        //this.validarCamposObrigatorios(id, nome, email, telefone, uf, cep, bairro, numero, cidade, rua);
        this.validarCamposObrigatorios(id, titulo, data, quantidade);
        RevistaVO revistaVO = new RevistaVO(Integer.parseInt(id), titulo, data, Integer.parseInt(quantidade));
       
        
        ArrayList<RevistaVO> revistas = this.buscar();
        for (int i = 0; i < revistas.size(); i++) {
            RevistaVO revista = revistas.get(i);
            if (revista.getId() == revistaVO.getId()){
                revistas.remove(i);
                revistas.add(revistaVO);
            }
                   
        }
        RevistasDAO revistaPers = new RevistasDAO(revistas);
        revistaPers.editar();
    }

    public void excluir(String titulo) throws IOException, SQLException, Exception {
        ArrayList<RevistaVO> revistas = this.buscar();
        for (int i = 0; i < revistas.size(); i++) {
            RevistaVO revistaVO = revistas.get(i);
            
            if (titulo.equals(revistaVO.getTitulo())){
                revistas.remove(i);
            }
        }
         RevistasDAO revistaPers = new RevistasDAO(revistas);
         revistaPers.excluir();
    }

    public boolean verificarExistencia(String nomeArquivo) throws IOException, SQLException, Exception {
        RevistasDAO revistaDAO = new RevistasDAO();
        return revistaDAO.verificarExistencia(nomeArquivo);
    }

    public void gerarRelatorio(String nomeArquivo) throws IOException, SQLException, Exception {
        ArrayList<RevistaVO> revistas = this.buscar();
        RevistasDAO revistaDAO = new RevistasDAO();
        revistaDAO.gerarRelatorio(nomeArquivo);
    }

   
    private void validarCamposObrigatorios(String id,String titulo,String data,String quantidade) throws ValidacaoException {

        if (id.equals("") || titulo.equals("") || data.equals("") || quantidade.equals("") ) {

            throw new ValidacaoException("Todos os campos são obrigatórios.");

        } else if (Integer.parseInt(id) < 0 ) {

            throw new ValidacaoException(("O campo id não pode ser negativo."));

        } else if (Integer.parseInt(quantidade) < 0) {

            throw new ValidacaoException("Quantidade tem q ser maior que zero.");
        }
    }
     public ArrayList<RevistaVO> buscarTitulo(String titulo) throws IOException, SQLException, Exception {
        RevistasDAO clienteDAO = new RevistasDAO();
        ArrayList<RevistaVO> revistas = clienteDAO.buscar();
        
        ArrayList<RevistaVO> revistasFiltrados = new ArrayList<>();
        
        
         for (RevistaVO revistaVO : revistas) {
             if (revistaVO.getTitulo().contains(titulo)){
                 revistasFiltrados.add(revistaVO);
             }
         }
        
        return revistasFiltrados;
    }
}
