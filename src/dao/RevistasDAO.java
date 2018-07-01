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
import vo.RevistaVO;

/**
 *
 * @author leonardo
 */
public class RevistasDAO {
    private File arquivo;
    private RevistaVO revistaVO;
    private ArrayList<RevistaVO> revistas;
    
    public RevistasDAO(){
        arquivo = new File("");
    }
    public RevistasDAO(RevistaVO revistaVO){
        arquivo = new File("");
        this.revistaVO = revistaVO;
    }
    public RevistasDAO(ArrayList<RevistaVO> revistas){
        arquivo = new File("");
        this.revistas = revistas;
    }
   

   
    public void cadastrar() throws IOException, SQLException, Exception {

        String linha;
  
        BufferedWriter documento = new BufferedWriter(new FileWriter(arquivo.getAbsolutePath() + "/data/Revistas.xls", true));
    
        String texto =  revistaVO.getId() + "\t" + revistaVO.getTitulo() + "\t" + revistaVO.getData() + "\t" + revistaVO.getQuantidade() ;
        StringTokenizer st = new StringTokenizer(texto, "\n");

        while (st.hasMoreTokens()) {

            linha = st.nextToken();

            documento.write(linha);
            documento.newLine();
        }

        documento.close();
    }

  
    public ArrayList<RevistaVO> buscar() throws IOException, SQLException, Exception {
        ArrayList<RevistaVO> revistas = new ArrayList<>();
        BufferedReader documento = new BufferedReader(new FileReader(arquivo.getAbsolutePath() + "/data/Revistas.xls"));

        String linha = documento.readLine();

        while (linha != null) {
     
            String[] revista = linha.split("\t");
            RevistaVO revistaVO = new RevistaVO(Integer.parseInt(revista[0]),revista[1], revista[2],Integer.parseInt(revista[3]));
            revistas.add(revistaVO);
            linha = documento.readLine();
        }

        documento.close();

        return revistas;
    }

   
    public void editar() throws IOException, SQLException, Exception {

        String linha;
        String texto;
        
        BufferedWriter documento = new BufferedWriter(new FileWriter(arquivo.getAbsolutePath() + "/data/Revistas.xls"));
        
        for (int i = 0; i < this.revistas.size(); i++) {
            
            RevistaVO revistaVO = revistas.get(i);
            
            texto = revistaVO.getId() + "\t" + revistaVO.getTitulo() + "\t" + revistaVO.getData() + "\t" + revistaVO.getQuantidade() ;
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

        BufferedWriter documento = new BufferedWriter(new FileWriter(arquivo.getAbsolutePath() + "/data/Revistas.xls"));

        for (int i = 0; i < this.revistas.size(); i++) {

             RevistaVO revistaVO  = revistas.get(i);
            texto =  revistaVO.getId() + "\t" + revistaVO.getTitulo() + "\t" + revistaVO.getData() + "\t" + revistaVO.getQuantidade() ;
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

        for (int i = 0; i < this.revistas.size(); i++) {

            RevistaVO revistaVO  = revistas.get(i);
            texto = revistaVO.getId() + "\t" + revistaVO.getTitulo() + "\t" + revistaVO.getData() + "\t" + revistaVO.getQuantidade() ;
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
