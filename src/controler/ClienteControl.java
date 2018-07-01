/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.ClientesDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import vo.ClienteVO;

/**
 *
 * @author leonardo
 */
public class ClienteControl {
     public ClienteControl() {

    }
    public void cadastrar(String id,String nome,String email,String telefone,String uf,String cep,String bairro,String numero,String cidade,String rua) throws ValidacaoException, IOException, SQLException, Exception {
        this.validarCamposObrigatorios(id, nome, email, telefone, uf, cep, bairro, numero, cidade, rua);
        ClienteVO clienteVO = new ClienteVO();
        clienteVO.setId(Integer.parseInt(id));
        clienteVO.setNome(nome);
        clienteVO.setEmail(email);
        clienteVO.setTelefone(telefone);
        clienteVO.setUf(uf);
        clienteVO.setCep(cep);
        clienteVO.setBairro(bairro);
        clienteVO.setNumero(Integer.parseInt(numero));
        clienteVO.setCidade(cidade);
        clienteVO.setRua(rua);
        
        ClientesDAO clienteDao = new ClientesDAO(clienteVO);
        clienteDao.cadastrar();
    }

   
    public ArrayList<ClienteVO> buscar() throws IOException, SQLException, Exception {
        ClientesDAO clienteDao = new ClientesDAO();
        return clienteDao.buscar();
    }


    public void editar(String id,String nome,String email,String telefone,String uf,String cep,String bairro,String numero,String cidade,String rua) throws ValidacaoException, IOException, SQLException, Exception {

        this.validarCamposObrigatorios(id, nome, email, telefone, uf, cep, bairro, numero, cidade, rua);
        ClienteVO clienteVO = new ClienteVO();
        clienteVO.setId(Integer.parseInt(id));
        clienteVO.setNome(nome);
        clienteVO.setEmail(email);
        clienteVO.setTelefone(telefone);
        clienteVO.setUf(uf);
        clienteVO.setCep(cep);
        clienteVO.setBairro(bairro);
        clienteVO.setNumero(Integer.parseInt(numero));
        clienteVO.setCidade(cidade);
        clienteVO.setRua(rua);
        
        ArrayList<ClienteVO> clientes = this.buscar();
        for (int i = 0; i < clientes.size(); i++) {
            ClienteVO cliente = clientes.get(i);
            if (cliente.getId() == clienteVO.getId()){
                clientes.remove(i);
                clientes.add(clienteVO);
            }
                   
        }
        
        ClientesDAO clientePers = new ClientesDAO(clientes);
        clientePers.editar();
    }

    public void excluir(String nome) throws IOException, SQLException, Exception {
        ArrayList<ClienteVO> clientes = this.buscar();
        for (int i = 0; i < clientes.size(); i++) {
            ClienteVO clienteVO = clientes.get(i);
            
            if (nome.equals(clienteVO.getNome())){
                clientes.remove(i);
            }
        }
        
        ClientesDAO  clientePers = new ClientesDAO(clientes);
        clientePers.excluir();
    }

    public boolean verificarExistencia(String nomeArquivo) throws IOException, SQLException, Exception {
        ClientesDAO clienteDAO = new ClientesDAO();
        return clienteDAO.verificarExistencia(nomeArquivo);
    }

    public void gerarRelatorio(String nomeArquivo) throws IOException, SQLException, Exception {
        ArrayList<ClienteVO> clientes = this.buscar();
        ClientesDAO clienteDAO = new ClientesDAO();
        clienteDAO.gerarRelatorio(nomeArquivo);
    }

   
    private void validarCamposObrigatorios(String id,String nome,String email,String telefone,String uf,String cep,String bairro,String numero,String cidade,String rua) throws ValidacaoException {

        if (id.equals("") || nome.equals("") || email.equals("") || telefone.equals("") || uf.equals("") || cep.equals("") || bairro.equals("") || numero.equals("") || cidade.equals("") || rua.equals("")) {

            throw new ValidacaoException("Todos os campos são obrigatórios.");

        } else if (Integer.parseInt(id) < 0 ) {

            throw new ValidacaoException(("O campo id não pode ser negativo."));

        } else if (Integer.parseInt(numero) < 1) {

            throw new ValidacaoException("O numero deve ser maior que zero.");
        }
    }
     public ArrayList<ClienteVO> buscarAluno(String nome) throws IOException, SQLException, Exception {
        ClientesDAO clienteDAO = new ClientesDAO();
        ArrayList<ClienteVO> clientes = clienteDAO.buscar();
        
        ArrayList<ClienteVO> clientesFiltrados = new ArrayList<>();
        
        
         for (ClienteVO clienteVO : clientes) {
             if (clienteVO.getNome().contains(nome)){
                 clientesFiltrados.add(clienteVO);
             }
         }
        
        return clientesFiltrados;
    }
}
