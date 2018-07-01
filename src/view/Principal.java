/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.ClienteControl;
import controler.EmprestimoControl;
import controler.EmprestimoRevistaControl;
import controler.LivroControl;
import controler.RevistaControl;
import controler.ValidacaoException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vo.ClienteVO;
import vo.EmprestimoLivroVO;
import vo.EmprestimoRevistaVO;

import vo.LivrosVO;
import vo.RevistaVO;


/**
 *
 * @author leonardo
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.buscarClientes();
        this.buscarLivros();
        this.buscarRevistas();
        this.popuEmpresLiv();
        this.popuEmpresRev();
        //this.buscarEmprestimo();
        this.txtNomeLivroEmprestimo.setEnabled(false);
       this.txtNomeClienteEmprestimo.setEnabled(false);
       this.txtNomeRevistaEmprestimo.setEnabled(false);
       this.txtNomeClienteEmprestimo1.setEnabled(false);
    
       this.bGerarEmprestimoLivro.setEnabled(true);
       this.bGerarEmprestimoRevista.setEnabled(true);

    }
    
     public void buscarEmprestimoRevista(){
        try {
            
            EmprestimoRevistaControl emprestimoRevistaControl = new EmprestimoRevistaControl();
            ArrayList<EmprestimoRevistaVO> emprestimos = emprestimoRevistaControl.buscar();
            this.popularTabelaEmprestimoRevista(emprestimos);

        } catch (Exception ex) {

            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void popuEmpresRev(){
        try{
            EmprestimoRevistaControl emprestimoRevistaControl = new EmprestimoRevistaControl();
            ArrayList<EmprestimoRevistaVO> emprestimos =  emprestimoRevistaControl.buscar();
            DefaultTableModel dtmEmprestimoRevista =  (DefaultTableModel) tEmprestimoRevista.getModel();
            dtmEmprestimoRevista.fireTableDataChanged();
            dtmEmprestimoRevista.setRowCount(0);
            for (EmprestimoRevistaVO emprestimo : emprestimos) {
                dtmEmprestimoRevista.addRow(new Object[] {emprestimo.getCliente(),emprestimo.getNomeRevista()});
            }
            
           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "Erro de comunicação com o Banco de Dados.", "Bucsar Emprestimo", JOptionPane.ERROR_MESSAGE);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher a tabela.", "Bucsar Emprestimo", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void buscarEmprestimoLivro(){
        try {
            
            EmprestimoControl emprestimoControl = new EmprestimoControl();
            ArrayList<EmprestimoLivroVO> emprestimos = emprestimoControl.buscar();
            this.popularTabelaEmprestimoLivro(emprestimos);

        } catch (Exception ex) {

            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void popuEmpresLiv(){
        try{
            EmprestimoControl emprestimoControl = new EmprestimoControl();
            ArrayList<EmprestimoLivroVO> emprestimos =  emprestimoControl.buscar();
            DefaultTableModel dtmEmprestimoLivro =  (DefaultTableModel) tEmprestimoLivro.getModel();
            dtmEmprestimoLivro.fireTableDataChanged();
            dtmEmprestimoLivro.setRowCount(0);
            for (EmprestimoLivroVO emprestimo : emprestimos) {
                dtmEmprestimoLivro.addRow(new Object[] {emprestimo.getCliente(),emprestimo.getNomeLivro()});
            }
            
           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "Erro de comunicação com o Banco de Dados.", "Bucsar Emprestimo", JOptionPane.ERROR_MESSAGE);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher a tabela.", "Bucsar Emprestimo", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void buscarRevistas(){
        
        try {
            RevistaControl revistaControl = new RevistaControl();
            ArrayList<RevistaVO> revistas = revistaControl.buscar();
            this.popularTabelaRevistas(revistas);

        } catch (Exception ex) {

            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public void diminuirQtdLivros(String livro){
         try{
             LivroControl livroControl = new LivroControl();
             ArrayList<LivrosVO> livros = livroControl.buscar();
             DefaultTableModel dtmLivro = (DefaultTableModel) tLivros.getModel();
             dtmLivro.fireTableDataChanged();
            dtmLivro.setRowCount(0);
             for (LivrosVO livro1 : livros) {
                 if (livro1.getTitulo().equals(livro)){
                     int i = (livro1.getQuantidade() - 1);
                     dtmLivro.addRow(new Object[] {livro1.getTitulo(),livro1.getEditora(),i});
                 }else{
                     dtmLivro.addRow(new Object[] {livro1.getTitulo(),livro1.getEditora(),livro1.getQuantidade()});
                 }
             }
           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "Erro de comunicação com o Banco de Dados.", "Bucsar Livro", JOptionPane.ERROR_MESSAGE);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher a tabela.", "Bucsar Livro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void diminuirQtdRevistas(String revista){
         try{
             RevistaControl revistaControl = new RevistaControl();
             ArrayList<RevistaVO> revistas = revistaControl.buscar();
             DefaultTableModel dtmRevista = (DefaultTableModel) tRevista.getModel();
             dtmRevista.fireTableDataChanged();
            dtmRevista.setRowCount(0);
             for (RevistaVO revista1 : revistas) {
                 if (revista1.getTitulo().equals(revista)){
                     int i = (revista1.getQuantidade() - 1);
                     dtmRevista.addRow(new Object[] {revista1.getTitulo(),revista1.getData(),i});
                 }else{
                     dtmRevista.addRow(new Object[] {revista1.getTitulo(),revista1.getData(),revista1.getQuantidade()});
                 }
             }
           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "Erro de comunicação com o Banco de Dados.", "Bucsar Revista", JOptionPane.ERROR_MESSAGE);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher a tabela.", "Bucsar Revista", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void buscarLivros(){
        try {
            LivroControl livroControl = new LivroControl();
            ArrayList<LivrosVO> livros = livroControl.buscar();
            this.popularTabelaLivros(livros);

        } catch (Exception ex) {

            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void buscarClientes() {
         try {
            ClienteControl clienteControl = new ClienteControl();
             ArrayList<ClienteVO> clientes = clienteControl.buscar();
             this.popularTabelaAlunos(clientes);

        } catch (Exception ex) {

            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void popularTabelaEmprestimoLivro(ArrayList<EmprestimoLivroVO> emprestimos){
        try {
             DefaultTableModel dtmEmprestimo = (DefaultTableModel) tEmprestimoLivro.getModel();
             dtmEmprestimo.fireTableDataChanged();
             dtmEmprestimo.setRowCount(0);
             for (EmprestimoLivroVO emprestimoVO : emprestimos) {
                dtmEmprestimo.addRow(new Object[] {emprestimoVO.getCliente(),emprestimoVO.getNomeLivro()});
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher a tabela.", "Buscar Revistas", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void popularTabelaEmprestimoRevista(ArrayList<EmprestimoRevistaVO> emprestimos){
        try {
             DefaultTableModel dtmEmprestimo = (DefaultTableModel) tEmprestimoRevista.getModel();
             dtmEmprestimo.fireTableDataChanged();
             dtmEmprestimo.setRowCount(0);
             for (EmprestimoRevistaVO emprestimoVO : emprestimos) {
                dtmEmprestimo.addRow(new Object[] {emprestimoVO.getCliente(),emprestimoVO.getNomeRevista()});
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher a tabela.", "Buscar Revistas", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void popularTabelaRevistas(ArrayList<RevistaVO> revistas){
        try {
             DefaultTableModel dtmRevista = (DefaultTableModel) tRevista.getModel();
             dtmRevista.fireTableDataChanged();
             dtmRevista.setRowCount(0);
             for (RevistaVO revistaVO : revistas) {
                dtmRevista.addRow(new Object[] {revistaVO.getTitulo(),revistaVO.getData(),revistaVO.getQuantidade()});
            }


        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher a tabela.", "Buscar Revistas", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void popularTabelaLivros(ArrayList<LivrosVO> livros){
        try {
             DefaultTableModel dtmLivro = (DefaultTableModel) tLivros.getModel();
             dtmLivro.fireTableDataChanged();
             dtmLivro.setRowCount(0);
             for (LivrosVO livroVO : livros) {
                dtmLivro.addRow(new Object[] {livroVO.getTitulo(),livroVO.getEditora(),livroVO.getQuantidade()});
            }


        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher a tabela.", "Buscar Livros", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     
     private void popularTabelaAlunos(ArrayList<ClienteVO> clientes) {
         try {
             DefaultTableModel dtmCliente = (DefaultTableModel) tClientes.getModel();
             dtmCliente.fireTableDataChanged();
             dtmCliente.setRowCount(0);
             for (ClienteVO clienteVO : clientes) {
                 dtmCliente.addRow(new Object[] {clienteVO.getNome(),clienteVO.getEmail(),clienteVO.getTelefone(),
                 clienteVO.getCidade()});
             }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher a tabela.", "Bucsar Clientes", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        j = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tClientes = new javax.swing.JTable();
        bClientesCadastrar = new javax.swing.JButton();
        bClientesMostrarInformacoes = new javax.swing.JButton();
        bClientesExcluir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtFiltroClientes = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tLivros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtFiltroLivrosNomeAutor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFiltroLivrosNomeLivro = new javax.swing.JTextField();
        bLivrosCadastrar = new javax.swing.JButton();
        bLivrosMostrarInformacoes = new javax.swing.JToggleButton();
        bLivrosExcluir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtFiltroRevistas = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tRevista = new javax.swing.JTable();
        bRevistaMostrarInformacoes = new javax.swing.JToggleButton();
        bRevistaCadastrar = new javax.swing.JToggleButton();
        bRevistaExcluir = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        txtPesquisarPorNomeCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tEmprestimoLivro = new javax.swing.JTable();
        txtNomeClienteEmprestimo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNomeLivroEmprestimo = new javax.swing.JTextField();
        bGerarEmprestimoLivro = new javax.swing.JButton();
        bEmprestimoCancelar = new javax.swing.JButton();
        bEmprestimoConfirmarLivro = new javax.swing.JToggleButton();
        jPanel5 = new javax.swing.JPanel();
        txtNomeClienteEmprestimo1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNomeRevistaEmprestimo = new javax.swing.JTextField();
        bGerarEmprestimoRevista = new javax.swing.JButton();
        bEmprestimoCancelar1 = new javax.swing.JButton();
        bEmprestimoConfirmarRevista = new javax.swing.JToggleButton();
        txtPesquisarPorNomeCliente1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tEmprestimoRevista = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Email", "Telefone", "Cidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tClientes);

        bClientesCadastrar.setText("Cadastrar");
        bClientesCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClientesCadastrarActionPerformed(evt);
            }
        });

        bClientesMostrarInformacoes.setText("Mostrar informacoes do cliente");
        bClientesMostrarInformacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClientesMostrarInformacoesActionPerformed(evt);
            }
        });

        bClientesExcluir.setText("Excluir");
        bClientesExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClientesExcluirActionPerformed(evt);
            }
        });

        jLabel4.setText("Pesquisar cliente (nome):");

        txtFiltroClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroClientesKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bClientesMostrarInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bClientesCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(bClientesExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltroClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFiltroClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bClientesMostrarInformacoes)
                    .addComponent(bClientesCadastrar)
                    .addComponent(bClientesExcluir))
                .addGap(34, 34, 34))
        );

        j.addTab("Clientes", jPanel1);

        tLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Editora", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tLivros);

        jLabel1.setText("Pesquisar livro (autor):");

        txtFiltroLivrosNomeAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroLivrosNomeAutorKeyReleased(evt);
            }
        });

        jLabel2.setText("Pesquisar livro (titulo):");

        txtFiltroLivrosNomeLivro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroLivrosNomeLivroKeyReleased(evt);
            }
        });

        bLivrosCadastrar.setText("Cadastrar ");
        bLivrosCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLivrosCadastrarActionPerformed(evt);
            }
        });

        bLivrosMostrarInformacoes.setText("Mostrar informações do livro");
        bLivrosMostrarInformacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLivrosMostrarInformacoesActionPerformed(evt);
            }
        });

        bLivrosExcluir.setText("Excluir ");
        bLivrosExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLivrosExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bLivrosMostrarInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(264, 264, 264)
                        .addComponent(bLivrosCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(bLivrosExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltroLivrosNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtFiltroLivrosNomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFiltroLivrosNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtFiltroLivrosNomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bLivrosCadastrar)
                    .addComponent(bLivrosMostrarInformacoes)
                    .addComponent(bLivrosExcluir))
                .addGap(57, 57, 57))
        );

        j.addTab("Gaveta Livros", jPanel2);

        jLabel3.setText("Pesquisar revista (titulo):");

        txtFiltroRevistas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroRevistasKeyReleased(evt);
            }
        });

        tRevista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Data Edição", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tRevista);

        bRevistaMostrarInformacoes.setText("Mostrar informações da revista");
        bRevistaMostrarInformacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRevistaMostrarInformacoesActionPerformed(evt);
            }
        });

        bRevistaCadastrar.setText("Cadastrar");
        bRevistaCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRevistaCadastrarActionPerformed(evt);
            }
        });

        bRevistaExcluir.setText("Excluir");
        bRevistaExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRevistaExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltroRevistas, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bRevistaMostrarInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 315, Short.MAX_VALUE)
                        .addComponent(bRevistaCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bRevistaExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltroRevistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bRevistaMostrarInformacoes)
                    .addComponent(bRevistaCadastrar)
                    .addComponent(bRevistaExcluir))
                .addGap(24, 24, 24))
        );

        j.addTab("Gaveta Revistas", jPanel3);

        jLabel5.setText("Pesquisar(nome cliente):");

        tEmprestimoLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Nome Livro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tEmprestimoLivro);

        jLabel6.setText("Nome cliente:");

        jLabel8.setText("Nome Livro:");

        bGerarEmprestimoLivro.setText("Gerar emprestimo ");
        bGerarEmprestimoLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGerarEmprestimoLivroActionPerformed(evt);
            }
        });

        bEmprestimoCancelar.setText("Cancelar");
        bEmprestimoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEmprestimoCancelarActionPerformed(evt);
            }
        });

        bEmprestimoConfirmarLivro.setText("Confirmar ");
        bEmprestimoConfirmarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEmprestimoConfirmarLivroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5)
                        .addGap(44, 44, 44)
                        .addComponent(txtPesquisarPorNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNomeClienteEmprestimo)
                                    .addComponent(txtNomeLivroEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                                .addGap(376, 376, 376))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bEmprestimoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bGerarEmprestimoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addComponent(bEmprestimoConfirmarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisarPorNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeClienteEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNomeLivroEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bGerarEmprestimoLivro)
                    .addComponent(bEmprestimoCancelar)
                    .addComponent(bEmprestimoConfirmarLivro))
                .addGap(33, 33, 33))
        );

        j.addTab("Emprestimo Livro", jPanel4);

        jLabel7.setText("Nome cliente:");

        jLabel9.setText("Nome Revista:");

        bGerarEmprestimoRevista.setText("Gerar emprestimo ");
        bGerarEmprestimoRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGerarEmprestimoRevistaActionPerformed(evt);
            }
        });

        bEmprestimoCancelar1.setText("Cancelar");
        bEmprestimoCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEmprestimoCancelar1ActionPerformed(evt);
            }
        });

        bEmprestimoConfirmarRevista.setText("Confirmar ");
        bEmprestimoConfirmarRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEmprestimoConfirmarRevistaActionPerformed(evt);
            }
        });

        jLabel10.setText("Pesquisar(nome cliente):");

        tEmprestimoRevista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Nome Revista"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tEmprestimoRevista);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10)
                        .addGap(44, 44, 44)
                        .addComponent(txtPesquisarPorNomeCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNomeClienteEmprestimo1)
                                    .addComponent(txtNomeRevistaEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                                .addGap(376, 376, 376))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bEmprestimoCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bGerarEmprestimoRevista, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addComponent(bEmprestimoConfirmarRevista, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisarPorNomeCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeClienteEmprestimo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNomeRevistaEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bGerarEmprestimoRevista)
                    .addComponent(bEmprestimoCancelar1)
                    .addComponent(bEmprestimoConfirmarRevista))
                .addGap(33, 33, 33))
        );

        j.addTab("Emprestimo Revista", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bClientesCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClientesCadastrarActionPerformed
       Clientes formularioCliente =  new Clientes(this);
       formularioCliente.setVisible(true);
    }//GEN-LAST:event_bClientesCadastrarActionPerformed

    private void bClientesMostrarInformacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClientesMostrarInformacoesActionPerformed
         try {
             ArrayList<ClienteVO> clientes = new ArrayList<>();
             ClienteControl cli = new ClienteControl();
             clientes = cli.buscar();
             ClienteVO clienteVO = new ClienteVO();
             clienteVO.setNome((String) this.tClientes.getValueAt(this.tClientes.getSelectedRow(), 0));
             clienteVO.setEmail((String) this.tClientes.getValueAt(this.tClientes.getSelectedRow(), 1));
             clienteVO.setTelefone((String) this.tClientes.getValueAt(this.tClientes.getSelectedRow(), 2));
             clienteVO.setCidade((String) this.tClientes.getValueAt(this.tClientes.getSelectedRow(), 3));
             
             for (ClienteVO cliente : clientes) {
                 if (cliente.getNome().equals(clienteVO.getNome())){
                     clienteVO.setId(cliente.getId());
                     clienteVO.setCep(cliente.getCep());
                     clienteVO.setBairro(cliente.getBairro());
                     clienteVO.setNumero(cliente.getNumero());
                     clienteVO.setUf(cliente.getUf());
                     clienteVO.setRua(cliente.getRua());
                 }
             }
             Clientes formularioCliente = new Clientes(this,clienteVO);
             formularioCliente.setVisible(true);


        } catch (ArrayIndexOutOfBoundsException ex) {

            JOptionPane.showMessageDialog(rootPane, "Selecione um registro na tabela", "Edição de Registro", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bClientesMostrarInformacoesActionPerformed

    private void bClientesExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClientesExcluirActionPerformed
         try {

            int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir permanentemente o aluno " + this.tClientes.getValueAt(this.tClientes.getSelectedRow(), 0).toString() + "?", "Exclusão de Registro", JOptionPane.YES_NO_CANCEL_OPTION);

            if (confirmacao == 0) {
                ClienteControl clienteControl = new ClienteControl();
                clienteControl.excluir(this.tClientes.getValueAt(this.tClientes.getSelectedRow(), 0).toString());

                JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso!", "Exclusão de Registro", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (ArrayIndexOutOfBoundsException ex) {

            JOptionPane.showMessageDialog(rootPane, "Selecione um registro na tabela", "Exclusão de Registro", JOptionPane.WARNING_MESSAGE);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao excluir o registro!", "Exclusão de Registro", JOptionPane.ERROR_MESSAGE);

        } finally {

            this.buscarClientes();
        }
    }//GEN-LAST:event_bClientesExcluirActionPerformed

    private void txtFiltroClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroClientesKeyReleased
       try {
        
            String nome = this.txtFiltroClientes.getText();
            
            ClienteControl clienteControl = new ClienteControl();
            ArrayList<ClienteVO> clientes = clienteControl.buscarAluno(nome);
            this.popularTabelaAlunos(clientes);
       
        } catch (SQLException ex) {
        
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
       
        } catch (Exception ex) {
            
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtFiltroClientesKeyReleased

    private void bLivrosCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLivrosCadastrarActionPerformed
        Livros formularioLivros = new Livros(this);
        formularioLivros.setVisible(true);
    }//GEN-LAST:event_bLivrosCadastrarActionPerformed

    private void bLivrosMostrarInformacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLivrosMostrarInformacoesActionPerformed
         try {
             ArrayList<LivrosVO> livros =  new ArrayList<>();
             LivroControl liv =  new LivroControl();
             livros = liv.buscar();
             LivrosVO livroVO = new LivrosVO();
             //titulo editora quantidade
             livroVO.setTitulo((String) this.tLivros.getValueAt(this.tLivros.getSelectedRow(), 0));
             livroVO.setEditora((String) this.tLivros.getValueAt(this.tLivros.getSelectedRow(), 1));
             livroVO.setQuantidade(Integer.parseInt(this.tLivros.getValueAt(this.tLivros.getSelectedRow(), 2).toString()));
             
             for (LivrosVO livro : livros) {
                 if (livro.getTitulo().equals(livroVO.getTitulo())){
                     livroVO.setISBN(livro.getISBN());
                     livroVO.setAutor(livro.getAutor());
                     livroVO.setLocalEdicao(livro.getLocalEdicao());
                     
                 }
             }
             Livros formularioLivros = new Livros(this,livroVO);
             formularioLivros.setVisible(true);


        } catch (ArrayIndexOutOfBoundsException ex) {

            JOptionPane.showMessageDialog(rootPane, "Selecione um registro na tabela", "Edição de Registro", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bLivrosMostrarInformacoesActionPerformed

    private void bLivrosExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLivrosExcluirActionPerformed
        try {

            int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir permanentemente o livro " + this.tLivros.getValueAt(this.tLivros.getSelectedRow(), 0).toString() + "?", "Exclusão de Registro", JOptionPane.YES_NO_CANCEL_OPTION);

            if (confirmacao == 0) {
                LivroControl livroControl = new LivroControl();
                livroControl.excluir(this.tLivros.getValueAt(this.tLivros.getSelectedRow(), 0).toString());
                JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso!", "Exclusão de Registro", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (ArrayIndexOutOfBoundsException ex) {

            JOptionPane.showMessageDialog(rootPane, "Selecione um registro na tabela", "Exclusão de Registro", JOptionPane.WARNING_MESSAGE);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao excluir o registro!", "Exclusão de Registro", JOptionPane.ERROR_MESSAGE);

        } finally {

            this.buscarLivros();
        }
    }//GEN-LAST:event_bLivrosExcluirActionPerformed

    private void txtFiltroLivrosNomeLivroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroLivrosNomeLivroKeyReleased
         try {
             String titulo = this.txtFiltroLivrosNomeLivro.getText();
             LivroControl livroControl = new LivroControl();
             ArrayList<LivrosVO> livros = livroControl.buscarTitulo(titulo);
             this.popularTabelaLivros(livros);
            
        } catch (SQLException ex) {
        
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
       
        } catch (Exception ex) {
            
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtFiltroLivrosNomeLivroKeyReleased

    private void txtFiltroLivrosNomeAutorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroLivrosNomeAutorKeyReleased
         try {
        
            String autor = this.txtFiltroLivrosNomeAutor.getText();
            LivroControl livroControl = new LivroControl();
            ArrayList<LivrosVO> livros = livroControl.buscarAutor(autor);
            this.popularTabelaLivros(livros);
         
       
        } catch (SQLException ex) {
        
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
       
        } catch (Exception ex) {
            
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtFiltroLivrosNomeAutorKeyReleased

    private void bRevistaCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRevistaCadastrarActionPerformed
       Revistas formularioRevista = new Revistas(this);
       formularioRevista.setVisible(true);
    }//GEN-LAST:event_bRevistaCadastrarActionPerformed

    private void bRevistaMostrarInformacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRevistaMostrarInformacoesActionPerformed
         try {
             ArrayList<RevistaVO> revistas = new ArrayList<>();
             RevistaControl rev = new RevistaControl();
             revistas = rev.buscar();
             RevistaVO revistaVO = new RevistaVO();
             
             //titulo data quantidade
             revistaVO.setTitulo((String) this.tRevista.getValueAt(this.tRevista.getSelectedRow(), 0));
             revistaVO.setData((String) this.tRevista.getValueAt(this.tRevista.getSelectedRow(), 1));
             revistaVO.setQuantidade(Integer.parseInt(this.tRevista.getValueAt(this.tRevista.getSelectedRow(), 2).toString()));
             for (RevistaVO revista : revistas) {
                 if (revista.getTitulo().equals(revistaVO.getTitulo())){
                     revistaVO.setId(revista.getId());
                 }
             }
             
             Revistas formularioRevistas = new Revistas(this,revistaVO);
             formularioRevistas.setVisible(true);
            


        } catch (ArrayIndexOutOfBoundsException ex) {

            JOptionPane.showMessageDialog(rootPane, "Selecione um registro na tabela", "Edição de Registro", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bRevistaMostrarInformacoesActionPerformed

    private void bRevistaExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRevistaExcluirActionPerformed
        try {

            int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir permanentemente a revista " + this.tRevista.getValueAt(this.tRevista.getSelectedRow(), 0).toString() + "?", "Exclusão de Registro", JOptionPane.YES_NO_CANCEL_OPTION);

            if (confirmacao == 0) {
                RevistaControl revistaControl = new RevistaControl();
                revistaControl.excluir(this.tRevista.getValueAt(this.tRevista.getSelectedColumn(), 0).toString());
                JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso!", "Exclusão de Registro", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (ArrayIndexOutOfBoundsException ex) {

            JOptionPane.showMessageDialog(rootPane, "Selecione um registro na tabela", "Exclusão de Registro", JOptionPane.WARNING_MESSAGE);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Erro ao excluir o registro!", "Exclusão de Registro", JOptionPane.ERROR_MESSAGE);

        } finally {

            this.buscarRevistas();
        }
    }//GEN-LAST:event_bRevistaExcluirActionPerformed

    private void txtFiltroRevistasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroRevistasKeyReleased
         try {
            String titulo = this.txtFiltroRevistas.getText();
            RevistaControl revistaControl = new RevistaControl();
            ArrayList<RevistaVO> revistas = revistaControl.buscarTitulo(titulo);
            this.popularTabelaRevistas(revistas);
       
        } catch (SQLException ex) {
        
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
       
        } catch (Exception ex) {
            
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtFiltroRevistasKeyReleased

    private void bGerarEmprestimoLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGerarEmprestimoLivroActionPerformed
       this.txtNomeLivroEmprestimo.setEnabled(true);
       this.txtNomeClienteEmprestimo.setEnabled(true);
       this.txtNomeClienteEmprestimo.setText("");
       this.txtNomeLivroEmprestimo.setText("");
    }//GEN-LAST:event_bGerarEmprestimoLivroActionPerformed

    private void bEmprestimoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEmprestimoCancelarActionPerformed
        this.txtNomeLivroEmprestimo.setEnabled(false);
       this.txtNomeClienteEmprestimo.setEnabled(false);

       this.bGerarEmprestimoLivro.setEnabled(true);

    }//GEN-LAST:event_bEmprestimoCancelarActionPerformed

    private void bEmprestimoConfirmarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEmprestimoConfirmarLivroActionPerformed

         EmprestimoControl emprestimoControl = new EmprestimoControl();
         
        try {
            emprestimoControl.gerarEmprestimo(this.txtNomeClienteEmprestimo.getText(), this.txtNomeLivroEmprestimo.getText());
            
            JOptionPane.showMessageDialog(rootPane, "Emprestimo realizado com sucesso!","Emprestimo",JOptionPane.INFORMATION_MESSAGE);
           popuEmpresLiv();
           diminuirQtdLivros(this.txtNomeLivroEmprestimo.getText());
        }catch(ValidacaoException v){
            JOptionPane.showMessageDialog(rootPane, v.getMessage(),"Inscrição",JOptionPane.WARNING_MESSAGE);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao realizar inscrição","Exclusão de Inscrição",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bEmprestimoConfirmarLivroActionPerformed

    private void bGerarEmprestimoRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGerarEmprestimoRevistaActionPerformed
        // TODO add your handling code here:
       this.txtNomeRevistaEmprestimo.setEnabled(true);
       this.txtNomeClienteEmprestimo1.setEnabled(true);
       this.txtNomeClienteEmprestimo1.setText("");
       this.txtNomeRevistaEmprestimo.setText("");
    }//GEN-LAST:event_bGerarEmprestimoRevistaActionPerformed

    private void bEmprestimoCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEmprestimoCancelar1ActionPerformed
        // TODO add your handling code here:
       this.txtNomeRevistaEmprestimo.setEnabled(false);
       this.txtNomeClienteEmprestimo1.setEnabled(false);

       this.bGerarEmprestimoRevista.setEnabled(true);
    }//GEN-LAST:event_bEmprestimoCancelar1ActionPerformed

    private void bEmprestimoConfirmarRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEmprestimoConfirmarRevistaActionPerformed
        // TODO add your handling code here:
         EmprestimoRevistaControl emprestimoRevistaControl = new EmprestimoRevistaControl();
         
        try {
            emprestimoRevistaControl.gerarEmprestimo(this.txtNomeClienteEmprestimo1.getText(), this.txtNomeRevistaEmprestimo.getText());
            
            JOptionPane.showMessageDialog(rootPane, "Emprestimo realizado com sucesso!","Emprestimo",JOptionPane.INFORMATION_MESSAGE);
           popuEmpresRev();
           diminuirQtdRevistas(this.txtNomeRevistaEmprestimo.getText());
        }catch(ValidacaoException v){
            JOptionPane.showMessageDialog(rootPane, v.getMessage(),"Inscrição",JOptionPane.WARNING_MESSAGE);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao realizar inscrição","Exclusão de Inscrição",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bEmprestimoConfirmarRevistaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClientesCadastrar;
    private javax.swing.JButton bClientesExcluir;
    private javax.swing.JButton bClientesMostrarInformacoes;
    private javax.swing.JButton bEmprestimoCancelar;
    private javax.swing.JButton bEmprestimoCancelar1;
    private javax.swing.JToggleButton bEmprestimoConfirmarLivro;
    private javax.swing.JToggleButton bEmprestimoConfirmarRevista;
    private javax.swing.JButton bGerarEmprestimoLivro;
    private javax.swing.JButton bGerarEmprestimoRevista;
    private javax.swing.JButton bLivrosCadastrar;
    private javax.swing.JButton bLivrosExcluir;
    private javax.swing.JToggleButton bLivrosMostrarInformacoes;
    private javax.swing.JToggleButton bRevistaCadastrar;
    private javax.swing.JToggleButton bRevistaExcluir;
    private javax.swing.JToggleButton bRevistaMostrarInformacoes;
    private javax.swing.JTabbedPane j;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tClientes;
    private javax.swing.JTable tEmprestimoLivro;
    private javax.swing.JTable tEmprestimoRevista;
    private javax.swing.JTable tLivros;
    private javax.swing.JTable tRevista;
    private javax.swing.JTextField txtFiltroClientes;
    private javax.swing.JTextField txtFiltroLivrosNomeAutor;
    private javax.swing.JTextField txtFiltroLivrosNomeLivro;
    private javax.swing.JTextField txtFiltroRevistas;
    private javax.swing.JTextField txtNomeClienteEmprestimo;
    private javax.swing.JTextField txtNomeClienteEmprestimo1;
    private javax.swing.JTextField txtNomeLivroEmprestimo;
    private javax.swing.JTextField txtNomeRevistaEmprestimo;
    private javax.swing.JTextField txtPesquisarPorNomeCliente;
    private javax.swing.JTextField txtPesquisarPorNomeCliente1;
    // End of variables declaration//GEN-END:variables

   

   
}
