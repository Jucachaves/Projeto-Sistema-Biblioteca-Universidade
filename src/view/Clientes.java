/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.ClienteControl;
import controler.ValidacaoException;
import javax.swing.JOptionPane;
import vo.ClienteVO;


/**
 *
 * @author leonardo
 */
public class Clientes extends javax.swing.JFrame {
    private Principal buscaClientePrincipal; //tabela
    
    public Clientes(Principal buscaClientePrincipal) {
        initComponents();
        this.setTitle("Cadastro Cliente");
        this.bConfirmarEdicao.setEnabled(false);
        this.setLocationRelativeTo(null);
        this.buscaClientePrincipal = buscaClientePrincipal;
        this.bEditar.setEnabled(false);
    }
    
    public Clientes(Principal buscaClienteView, ClienteVO clienteVO){
        initComponents();
        this.setTitle("Edição de Registro de Aluno");
        this.bCadastrar.setEnabled(false);
        this.txtClientesId.setEnabled(false);
        this.setLocationRelativeTo(null);
        this.buscaClientePrincipal = buscaClienteView;
        
        this.txtClientesNome.setEnabled(false);
        this.txtClientesEmail.setEnabled(false);
        this.txtClientesTelefone.setEnabled(false);
        this.txtClientesCep.setEnabled(false);
        this.cbClientesUF.setEnabled(false);
        this.cbClienteCidade.setEnabled(false);
        this.txtClientesRua.setEnabled(false);
        this.txtClienteNumero.setEnabled(false);
        this.txtClientesBairro.setEnabled(false);
        this.bConfirmarEdicao.setEnabled(false);
        popularCampos(clienteVO);
    }
    
    public void popularCampos(ClienteVO clienteVO){
        this.getTID().setText(String.valueOf(clienteVO.getId()));
        this.getTNome().setText(clienteVO.getNome());
        this.getTEmail().setText(clienteVO.getEmail());
        this.getTTelefone().setText(clienteVO.getTelefone());
        this.getCbUf().setSelectedItem(clienteVO.getUf());
        this.getTBairro().setText(clienteVO.getBairro());
        this.getTNumero().setText(String.valueOf(clienteVO.getNumero()));
        this.getCbCidade().setSelectedItem(clienteVO.getCidade());
        this.getTRua().setText(clienteVO.getRua());
        this.getTCep().setText(clienteVO.getCep());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtClientesId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtClientesNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtClientesEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtClientesTelefone = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        cbClientesUF = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtClientesCep = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtClientesRua = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtClientesBairro = new javax.swing.JTextField();
        bCadastrar = new javax.swing.JButton();
        bConfirmarEdicao = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        cbClienteCidade = new javax.swing.JComboBox<>();
        txtClienteNumero = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        bEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID:");

        jLabel2.setText("Nome :");

        txtClientesNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClientesNomeActionPerformed(evt);
            }
        });

        jLabel3.setText("Email:");

        jLabel4.setText("Telefone:");

        try {
            txtClientesTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("UF:");

        cbClientesUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jLabel6.setText("CEP:");

        try {
            txtClientesCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("Cidade:");

        jLabel8.setText("Rua:");

        txtClientesRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClientesRuaActionPerformed(evt);
            }
        });

        jLabel9.setText("Nº:");

        jLabel10.setText("Bairro:");

        bCadastrar.setText("Cadastrar");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });

        bConfirmarEdicao.setText("Confirmar Edicao");
        bConfirmarEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConfirmarEdicaoActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        cbClienteCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Adamantina", "Apucarana", "Bauru", "Campinas", "Cascavel", "Curitiba", "Maringa", "Ponta Grossa", "Ribeirao Preto", "São Paulo" }));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel11.setText("Todos os campos são obrigatórios.");

        bEditar.setText("Editar");
        bEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtClientesBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtClientesId, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtClientesEmail)
                        .addComponent(txtClientesNome)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtClientesTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbClientesUF, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)))
                                .addComponent(txtClientesRua, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtClientesCep, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                .addComponent(cbClienteCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtClienteNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(178, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(bEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(bConfirmarEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtClientesId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtClientesNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtClientesEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtClientesTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtClientesCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbClientesUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbClienteCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtClienteNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtClientesRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtClientesBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bConfirmarEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClientesNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClientesNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClientesNomeActionPerformed

    private void txtClientesRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClientesRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClientesRuaActionPerformed

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        try {
            
            ClienteControl clienteControl = new ClienteControl();
            clienteControl.cadastrar(this.txtClientesId.getText(), 
                    this.txtClientesNome.getText(),this.txtClientesEmail.getText(),
                    this.txtClientesTelefone.getText(),this.cbClientesUF.getSelectedItem().toString() , 
                    this.txtClientesCep.getText(),this.txtClientesBairro.getText() , 
                    this.txtClienteNumero.getText(), 
                    this.cbClienteCidade.getSelectedItem().toString(),this.txtClientesRua.getText());
            this.buscaClientePrincipal.buscarClientes();
            
            JOptionPane.showMessageDialog(rootPane, "Cadastro realizado com sucesso!", "Cadastro Cliente", JOptionPane.INFORMATION_MESSAGE);
            
            this.dispose();
            
        } catch (ValidacaoException validacaoException) {
            
            JOptionPane.showMessageDialog(rootPane, validacaoException.getMessage(), "Cadastro Cliente", JOptionPane.WARNING_MESSAGE);
        
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro ao efetuar o cadastro!", "Cadastro Cliente", JOptionPane.ERROR_MESSAGE);
        
        }
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bConfirmarEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConfirmarEdicaoActionPerformed
        try {
            ClienteControl clienteCrontrol = new ClienteControl();
            clienteCrontrol.editar(this.txtClientesId.getText(), 
                   this.txtClientesNome.getText(), 
                   this.txtClientesEmail.getText(), 
                   this.txtClientesTelefone.getText(),
                   this.cbClientesUF.getSelectedItem().toString(),
                   this.txtClientesCep.getText(),
                   this.txtClientesBairro.getText(), 
                   this.txtClienteNumero.getText(), 
                   this.cbClienteCidade.getSelectedItem().toString(),
                   this.txtClientesRua.getText());
            
            this.buscaClientePrincipal.buscarClientes();
            
            JOptionPane.showMessageDialog(rootPane, "Edição realizada com sucesso!", "Editar Cliente", JOptionPane.INFORMATION_MESSAGE);
            
            this.dispose();
            
        } catch (ValidacaoException validacaoException) {
            
            JOptionPane.showMessageDialog(rootPane, validacaoException.getMessage(), "Editar Cliente", JOptionPane.WARNING_MESSAGE);
        
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(rootPane, "Erro ao efetuar a edição!", "Editar Cliente", JOptionPane.ERROR_MESSAGE);
        
        }
    }//GEN-LAST:event_bConfirmarEdicaoActionPerformed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed
        this.txtClientesNome.setEnabled(true);
        this.txtClientesEmail.setEnabled(true);
        this.txtClientesTelefone.setEnabled(true);
        this.txtClientesCep.setEnabled(true);
        this.cbClientesUF.setEnabled(true);
        this.cbClienteCidade.setEnabled(true);
        this.txtClientesRua.setEnabled(true);
        this.txtClienteNumero.setEnabled(true);
        this.txtClientesBairro.setEnabled(true);
        this.bConfirmarEdicao.setEnabled(true);
        this.bEditar.setEnabled(false);
    }//GEN-LAST:event_bEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    
     
    
    public javax.swing.JTextField getTID(){
        return txtClientesId;
    }
    public javax.swing.JTextField getTNome(){
        return txtClientesNome;
    }
    public javax.swing.JTextField getTEmail(){
        return txtClientesEmail;
    }
    public javax.swing.JFormattedTextField getTTelefone(){
        return txtClientesTelefone;
    }
    public javax.swing.JComboBox<String> getCbUf(){
        return cbClientesUF;
    }
    public javax.swing.JFormattedTextField getTCep(){
        return txtClientesCep;
    }
    public javax.swing.JTextField getTBairro(){
        return txtClientesBairro;
    }
    public javax.swing.JTextField getTNumero(){
        return txtClienteNumero;
    }
    public javax.swing.JComboBox<String> getCbCidade(){
        return cbClienteCidade;
    }
    public javax.swing.JTextField getTRua(){
        return txtClientesRua;
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bConfirmarEdicao;
    private javax.swing.JButton bEditar;
    private javax.swing.JComboBox<String> cbClienteCidade;
    private javax.swing.JComboBox<String> cbClientesUF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtClienteNumero;
    private javax.swing.JTextField txtClientesBairro;
    private javax.swing.JFormattedTextField txtClientesCep;
    private javax.swing.JTextField txtClientesEmail;
    private javax.swing.JTextField txtClientesId;
    private javax.swing.JTextField txtClientesNome;
    private javax.swing.JTextField txtClientesRua;
    private javax.swing.JFormattedTextField txtClientesTelefone;
    // End of variables declaration//GEN-END:variables
}
