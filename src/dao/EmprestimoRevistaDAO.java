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
import vo.EmprestimoRevistaVO;


/**
 *
 * @author leonardo
 */
public class EmprestimoRevistaDAO {
    private File arquivo;
    private EmprestimoRevistaVO emprestimoVO;
    private ArrayList<EmprestimoRevistaVO> emprestimos;
    
    public EmprestimoRevistaDAO(){
        arquivo = new File("");
    }
    public EmprestimoRevistaDAO(EmprestimoRevistaVO emprestimoVO){
        arquivo = new File("");
        this.emprestimoVO = emprestimoVO;
    }
    public EmprestimoRevistaDAO(ArrayList<EmprestimoRevistaVO> emprestimos){
        arquivo = new File("");
        this.emprestimos = emprestimos;
    }
    
     public void cadastrar() throws IOException, SQLException, Exception {

        String linha;
  
        BufferedWriter documento = new BufferedWriter(new FileWriter(arquivo.getAbsolutePath() + "/data/EmprestimoRevista.xls", true));
        
        String texto = emprestimoVO.getCliente() + "\t" + emprestimoVO.getNomeRevista();
        StringTokenizer st = new StringTokenizer(texto, "\n");

        while (st.hasMoreTokens()) {

            linha = st.nextToken();

            documento.write(linha);
            documento.newLine();
        }

        documento.close();
    }
     
    public ArrayList<EmprestimoRevistaVO> buscar() throws IOException, SQLException, Exception {
        ArrayList<EmprestimoRevistaVO> emprestimos = new ArrayList<>();
        BufferedReader documento = new BufferedReader(new FileReader(arquivo.getAbsolutePath() + "/data/EmprestimoRevista.xls"));

        String linha = documento.readLine();
        
        while (linha != null) {
     
            String[] emprestimo = linha.split("\t");
            EmprestimoRevistaVO emprestimoVO = new EmprestimoRevistaVO();
            emprestimoVO.setCliente(emprestimo[0]);
            emprestimoVO.setNomeRevista(emprestimo[1]);
            emprestimos.add(emprestimoVO);
            linha = documento.readLine();
        }

        documento.close();

        return emprestimos;
    }
    

}
