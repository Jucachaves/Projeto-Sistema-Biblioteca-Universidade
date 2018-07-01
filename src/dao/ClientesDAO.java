/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import vo.ClienteVO;

/**
 *
 * @author leonardo
 */
public class ClientesDAO {
    private File arquivo;
    private ClienteVO clienteVO;
    private ArrayList<ClienteVO> clientes;
    
    public ClientesDAO(){
        arquivo = new File("");
    }
    public ClientesDAO(ClienteVO clienteVO){
        arquivo = new File("");
        this.clienteVO = clienteVO;
    }
    public ClientesDAO(ArrayList<ClienteVO> clientes){
        arquivo = new File("");
        this.clientes = clientes;
    }
   

   
    public void cadastrar() throws IOException, SQLException, Exception {

        String linha;
  
        BufferedWriter documento = new BufferedWriter(new FileWriter(arquivo.getAbsolutePath() + "/data/Clientes.xls", true));

        String texto = clienteVO.getId() + "\t" + clienteVO.getNome() + "\t" + clienteVO.getEmail() + "\t" + clienteVO.getTelefone() + "\t" + clienteVO.getUf() + "\t" + clienteVO.getCep() + "\t" + clienteVO.getBairro() + "\t" + clienteVO.getNumero() + "\t" + clienteVO.getCidade() + "\t" + clienteVO.getRua();
        StringTokenizer st = new StringTokenizer(texto, "\n");

        while (st.hasMoreTokens()) {

            linha = st.nextToken();

            documento.write(linha);
            documento.newLine();
        }

        documento.close();
    }

  
    public ArrayList<ClienteVO> buscar() throws IOException, SQLException, Exception {
        ArrayList<ClienteVO> clientes = new ArrayList<>();
        BufferedReader documento = new BufferedReader(new FileReader(arquivo.getAbsolutePath() + "/data/Clientes.xls"));

        String linha = documento.readLine();

        while (linha != null) {
     
            String[] cliente = linha.split("\t");
            ClienteVO clienteVO = new ClienteVO();
            clienteVO.setId(Integer.parseInt(cliente[0]));
            clienteVO.setNome(cliente[1]);
            clienteVO.setEmail(cliente[2]);
            clienteVO.setTelefone(cliente[3]);
            clienteVO.setUf(cliente[4]);
            clienteVO.setCep(cliente[5]);
            clienteVO.setBairro(cliente[6]);
            clienteVO.setNumero(Integer.parseInt(cliente[7]));
            clienteVO.setCidade(cliente[8]);
            clienteVO.setRua(cliente[9]);
            clientes.add(clienteVO);
            linha = documento.readLine();
        }

        documento.close();

        return clientes;
    }

   
    public void editar() throws IOException, SQLException, Exception {

        String linha;
        String texto;
        
        BufferedWriter documento = new BufferedWriter(new FileWriter(arquivo.getAbsolutePath() + "/data/Clientes.xls"));
        
        for (int i = 0; i < this.clientes.size(); i++) {
            
            ClienteVO cliente = clientes.get(i);
            
            texto = cliente.getId() + "\t" + cliente.getNome() + "\t" + cliente.getEmail() + "\t" + cliente.getTelefone() + "\t" + cliente.getUf() + "\t" + cliente.getCep() + "\t" + cliente.getBairro() + "\t" + cliente.getNumero() + "\t" + cliente.getCidade() + "\t" + cliente.getRua();
            StringTokenizer st = new StringTokenizer(texto, "\n");
            
            while (st.hasMoreTokens()) {

                linha = st.nextToken();

                documento.write(linha);
                documento.newLine();
            }
        }

        documento.close();
    }

    public void excluir() throws IOException, SQLException, Exception {

        String linha;
        String texto;

        BufferedWriter documento = new BufferedWriter(new FileWriter(arquivo.getAbsolutePath() + "/data/Clientes.xls"));

        for (int i = 0; i < this.clientes.size(); i++) {

            ClienteVO cliente = clientes.get(i);
            texto = cliente.getId() + "\t" + cliente.getNome() + "\t" + cliente.getEmail() + "\t" + cliente.getTelefone() + "\t" + cliente.getUf() + "\t" + cliente.getCep() + "\t" + cliente.getBairro() + "\t" + cliente.getNumero() + "\t" + cliente.getCidade() + "\t" + cliente.getRua();
            StringTokenizer st = new StringTokenizer(texto, "\n");

            while (st.hasMoreTokens()) {

                linha = st.nextToken();

                documento.write(linha);
                documento.newLine();
            }
        }

        documento.close();
    }

    public boolean verificarExistencia(String nomeArquivo) throws IOException, SQLException, Exception {
        
        File arquivo = new File(nomeArquivo);

        return arquivo.exists();        
    }
    
    public void gerarRelatorio(String nomeArquivo) throws IOException, SQLException, Exception {
        
        String linha;
        String texto;

        BufferedWriter documento = new BufferedWriter(new FileWriter(nomeArquivo));

        for (int i = 0; i < this.clientes.size(); i++) {

            ClienteVO cliente = clientes.get(i);
            texto = cliente.getId() + "\t" + cliente.getNome() + "\t" + cliente.getEmail() + "\t" + cliente.getTelefone() + "\t" + cliente.getUf() + "\t" + cliente.getCep() + "\t" + cliente.getBairro() + "\t" + cliente.getNumero() + "\t" + cliente.getCidade() + "\t" + cliente.getRua();
            StringTokenizer st = new StringTokenizer(texto, "\n");

            while (st.hasMoreTokens()) {

                linha = st.nextToken();

                documento.write(linha);
                documento.newLine();
            }
        }

        documento.close();
    }
}
