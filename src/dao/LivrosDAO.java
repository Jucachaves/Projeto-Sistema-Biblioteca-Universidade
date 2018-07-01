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
import vo.LivrosVO;

/**
 *
 * @author leonardo
 */
public class LivrosDAO {
    private File arquivo;
    private LivrosVO livroVO;
    private ArrayList<LivrosVO> livros; 
    
    
    public LivrosDAO(){
        arquivo = new File("");
    }
    public LivrosDAO(LivrosVO livroVO){
        arquivo = new File("");
        this.livroVO = livroVO;
    }
    public LivrosDAO(ArrayList<LivrosVO> livros){
        arquivo = new File("");
        this.livros = livros;
    }
   

public void cadastrar() throws IOException, SQLException, Exception {

        String linha;
  
        BufferedWriter documento = new BufferedWriter(new FileWriter(arquivo.getAbsolutePath() + "/data/Livros.xls", true));

        String texto = livroVO.getISBN() + "\t" + livroVO.getTitulo() + "\t" + livroVO.getEditora() + "\t" + livroVO.getQuantidade() + "\t" + livroVO.getAutor() + "\t" + livroVO.getLocalEdicao();
        
        StringTokenizer st = new StringTokenizer(texto, "\n");

        while (st.hasMoreTokens()) {

            linha = st.nextToken();

            documento.write(linha);
            documento.newLine();
        }

        documento.close();
    }

  
    public ArrayList<LivrosVO> buscar() throws IOException, SQLException, Exception {
        ArrayList<LivrosVO> livros = new ArrayList<>();
        BufferedReader documento = new BufferedReader(new FileReader(arquivo.getAbsolutePath() + "/data/Livros.xls"));

        String linha = documento.readLine();

        while (linha != null) {

            String[] livro = linha.split("\t");
            LivrosVO livroVO = new LivrosVO();
            livroVO.setISBN(Integer.parseInt(livro[0]));
            livroVO.setTitulo(livro[1]);
            livroVO.setEditora(livro[2]);
            livroVO.setQuantidade(Integer.parseInt(livro[3]));
            livroVO.setAutor(livro[4]);
            livroVO.setLocalEdicao(livro[5]);
            livros.add(livroVO);
            linha = documento.readLine();
        }

        documento.close();

        return livros;
    }

   
    public void editar() throws IOException, SQLException, Exception {

        String linha;
        String texto;
        
        BufferedWriter documento = new BufferedWriter(new FileWriter(arquivo.getAbsolutePath() + "/data/Livros.xls"));
        
        for (int i = 0; i < this.livros.size(); i++) {
            
            LivrosVO livroVO = livros.get(i);
            
            texto = livroVO.getISBN() + "\t" + livroVO.getTitulo() + "\t" + livroVO.getEditora() + "\t" + livroVO.getQuantidade() + "\t" + livroVO.getAutor() + "\t" + livroVO.getLocalEdicao();
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

        BufferedWriter documento = new BufferedWriter(new FileWriter(arquivo.getAbsolutePath() + "/data/Livros.xls"));

        for (int i = 0; i < this.livros.size(); i++) {

            LivrosVO livroVO = livros.get(i);
            texto = livroVO.getISBN() + "\t" + livroVO.getTitulo() + "\t" + livroVO.getEditora() + "\t" + livroVO.getQuantidade() + "\t" + livroVO.getAutor() + "\t" + livroVO.getLocalEdicao();
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

        for (int i = 0; i < this.livros.size(); i++) {

            LivrosVO cliente = livros.get(i);
            texto = livroVO.getISBN() + "\t" + livroVO.getTitulo() + "\t" + livroVO.getEditora() + "\t" + livroVO.getQuantidade() + "\t" + livroVO.getAutor() + "\t" + livroVO.getLocalEdicao();
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
