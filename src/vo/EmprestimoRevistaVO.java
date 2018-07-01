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
public class EmprestimoRevistaVO {
    private String cliente;
    private String nomeRevista;
    
    public EmprestimoRevistaVO(){
    }
    public EmprestimoRevistaVO(String cliente,String nomeRevista){
        this.cliente = cliente;
        this.nomeRevista = nomeRevista;
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
    public String getNomeRevista() {
        return nomeRevista;
    }

    /**
     * @param nomeRevista the nomeLivro to set
     */
    public void setNomeRevista(String nomeRevista) {
        this.nomeRevista = nomeRevista;
    }

    /**
     * @return the nomeRevista
     */
 
}
