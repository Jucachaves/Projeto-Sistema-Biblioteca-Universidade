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
public class LivrosVO {
    private int ISBN;
    private String titulo;
    private String editora;
     private int quantidade;
    private String autor;
    private String localEdicao;
   
  
    
    public LivrosVO(){
    }
    public LivrosVO(int ISBN,String titulo,int quantidade,String autor,String localEdicao,String editora){
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.quantidade = quantidade;
        this.autor = autor;
        this.localEdicao = localEdicao;
        this.editora = editora;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLocalEdicao() {
        return localEdicao;
    }

    public void setLocalEdicao(String localEdicao) {
        this.localEdicao = localEdicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

}
