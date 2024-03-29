/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DialogoPontos.java
 *
 * Created on Aug 29, 2011, 1:04:55 PM
 */
package projetofisicamovimento.ig;

import java.awt.geom.Point2D;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */
public class DialogoPontos extends javax.swing.JDialog {

    private PainelGrafico painelGrafico;
    private int linhaSelecionada = -1;
    
    /** Creates new form DialogoPontos */
    public DialogoPontos( java.awt.Frame parent, boolean modal, PainelGrafico painelGrafico ) {
        super( parent, modal );
        initComponents();
        this.painelGrafico = painelGrafico;
        
        DefaultTableModel modelo = ( DefaultTableModel ) tabelaPontos.getModel();
        for ( Point2D p : painelGrafico.getPontos() ) {
            modelo.addRow( new Object[]{ p.getY(), p.getX() } );
        }
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOk = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        painelPontos = new javax.swing.JPanel();
        scrollPontos = new javax.swing.JScrollPane();
        tabelaPontos = new javax.swing.JTable();
        tabelaPontos.setModel( new DefaultTableModel() );
        labelDs = new javax.swing.JLabel();
        labelDt = new javax.swing.JLabel();
        fieldDs = new javax.swing.JTextField();
        fieldDt = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pontos do Gráfico");

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        painelPontos.setBorder(javax.swing.BorderFactory.createTitledBorder("Pontos"));

        tabelaPontos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Δs", "Δt"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaPontos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPontosMouseClicked(evt);
            }
        });
        scrollPontos.setViewportView(tabelaPontos);

        labelDs.setText("Δs:");

        labelDt.setText("Δt:");

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPontosLayout = new javax.swing.GroupLayout(painelPontos);
        painelPontos.setLayout(painelPontosLayout);
        painelPontosLayout.setHorizontalGroup(
            painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPontosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPontosLayout.createSequentialGroup()
                        .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDs, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelDt, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(fieldDs, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fieldDt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelPontosLayout.createSequentialGroup()
                                .addComponent(btnNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir))))
                    .addComponent(scrollPontos, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelPontosLayout.setVerticalGroup(
            painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPontosLayout.createSequentialGroup()
                .addComponent(scrollPontos, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDs)
                    .addComponent(fieldDs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDt)
                    .addComponent(fieldDt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(painelPontos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(painelPontos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnOk))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-330)/2, (screenSize.height-318)/2, 330, 318);
    }// </editor-fold>//GEN-END:initComponents

private void tabelaPontosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPontosMouseClicked
    
    linhaSelecionada = tabelaPontos.getSelectedRow();
    
    fieldDs.setText( tabelaPontos.getValueAt( linhaSelecionada, 0 ).toString() );
    fieldDt.setText( tabelaPontos.getValueAt( linhaSelecionada, 1 ).toString() );
    
}//GEN-LAST:event_tabelaPontosMouseClicked

private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
    
    fieldDs.setText( "" );
    fieldDt.setText( "" );
    linhaSelecionada = -1;
    
}//GEN-LAST:event_btnNovoActionPerformed

private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

    try {
        
        double ds = Double.parseDouble( fieldDs.getText() );
        double dt = Double.parseDouble( fieldDt.getText() );
        
        DefaultTableModel modelo = ( DefaultTableModel ) tabelaPontos.getModel();
        
        if ( linhaSelecionada != -1 ) {
            modelo.setValueAt( ds, linhaSelecionada, 0 );
            modelo.setValueAt( dt, linhaSelecionada, 1 );
        } else {
            modelo.addRow( new Object[]{ ds, dt } );
        }
        
        fieldDs.setText( "" );
        fieldDt.setText( "" );
        
    } catch ( NumberFormatException exc ) {
        JOptionPane.showMessageDialog( 
                this, "Valor inválido!", "ERRO", JOptionPane.ERROR_MESSAGE );
    }
    
    
}//GEN-LAST:event_btnSalvarActionPerformed

private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
    
    DefaultTableModel modelo = ( DefaultTableModel ) tabelaPontos.getModel();
    painelGrafico.limparPontos();
    
    for ( int i = 0; i < modelo.getRowCount(); i++ ) {
        painelGrafico.adicionarPonto( 
                ( Double ) modelo.getValueAt( i, 1 ), 
                ( Double ) modelo.getValueAt( i, 0 ) );
    }
    
    dispose();
    
}//GEN-LAST:event_btnOkActionPerformed

private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
    if ( linhaSelecionada != -1 ) {

        if ( JOptionPane.showConfirmDialog( 
                this, "Deseja mesmo excluir o ponto selecionado?", 
                "Confirmação", JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION ) {

            DefaultTableModel modelo = ( DefaultTableModel ) tabelaPontos.getModel();
            modelo.removeRow( linhaSelecionada );
            fieldDs.setText( "" );
            fieldDt.setText( "" );
            linhaSelecionada = -1;

        } else {
            
            linhaSelecionada = -1;
            fieldDs.setText( "" );
            fieldDt.setText( "" );
            
        }

    } else {
        JOptionPane.showMessageDialog( 
                this, "Selecione um ponto para excluir!", 
                "ERRO", JOptionPane.ERROR_MESSAGE );
    }
    
}//GEN-LAST:event_btnExcluirActionPerformed

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    dispose();
}//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField fieldDs;
    private javax.swing.JTextField fieldDt;
    private javax.swing.JLabel labelDs;
    private javax.swing.JLabel labelDt;
    private javax.swing.JPanel painelPontos;
    private javax.swing.JScrollPane scrollPontos;
    private javax.swing.JTable tabelaPontos;
    // End of variables declaration//GEN-END:variables
}
