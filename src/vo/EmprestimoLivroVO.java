/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author leonardo
 */
public class EmprestimoLivroVO {
    private String cliente;
    private String nomeLivro;
    
    public EmprestimoLivroVO(){
    }
    public EmprestimoLivroVO(String cliente,String nomeLivro){
        this.cliente = cliente;
        this.nomeLivro = nomeLivro;
    }
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the nomeLivro
     */
    public String getNomeLivro() {
        return nomeLivro;
    }

    /**
     * @param nomeLivro the nomeLivro to set
     */
    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    /**
     * @return the nomeRevista
     */
 
}
