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
import vo.EmprestimoLivroVO;


/**
 *
 * @author leonardo
 */
public class EmprestimoLivroDAO {
    private File arquivo;
    private EmprestimoLivroVO emprestimoVO;
    private ArrayList<EmprestimoLivroVO> emprestimos;
    
    public EmprestimoLivroDAO(){
        arquivo = new File("");
    }
    public EmprestimoLivroDAO(EmprestimoLivroVO emprestimoVO){
        arquivo = new File("");
        this.emprestimoVO = emprestimoVO;
    }
    public EmprestimoLivroDAO(ArrayList<EmprestimoLivroVO> emprestimos){
        arquivo = new File("");
        this.emprestimos = emprestimos;
    }
    
     public void cadastrar() throws IOException, SQLException, Exception {

        String linha;
  
        BufferedWriter documento = new BufferedWriter(new FileWriter(arquivo.getAbsolutePath() + "/data/EmprestimoLivro.xls", true));
        
        String texto = emprestimoVO.getCliente() + "\t" + emprestimoVO.getNomeLivro();
        StringTokenizer st = new StringTokenizer(texto, "\n");

        while (st.hasMoreTokens()) {

            linha = st.nextToken();

            documento.write(linha);
            documento.newLine();
        }

        documento.close();
    }
     
    public ArrayList<EmprestimoLivroVO> buscar() throws IOException, SQLException, Exception {
        ArrayList<EmprestimoLivroVO> emprestimos = new ArrayList<>();
        BufferedReader documento = new BufferedReader(new FileReader(arquivo.getAbsolutePath() + "/data/EmprestimoLivro.xls"));

        String linha = documento.readLine();
        
        while (linha != null) {
     
            String[] emprestimo = linha.split("\t");
            EmprestimoLivroVO emprestimoVO = new EmprestimoLivroVO();
            emprestimoVO.setCliente(emprestimo[0]);
            emprestimoVO.setNomeLivro(emprestimo[1]);
            emprestimos.add(emprestimoVO);
            linha = documento.readLine();
        }

        documento.close();

        return emprestimos;
    }
    

}
