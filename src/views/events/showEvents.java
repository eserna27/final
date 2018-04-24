/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.events;

import controller.QuotationController;
import controller.EventsController;
import model.Event;

/**
 *
 * @author BenitoH
 */
public class showEvents extends javax.swing.JFrame {

    /**
     * Creates new form showEvents
     */
    public showEvents() {
        initComponents();
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
        lblClient = new javax.swing.JLabel();
        displayClient = new javax.swing.JLabel();
        btnReturn = new javax.swing.JButton();
        lblPlace = new javax.swing.JLabel();
        displayPlace = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        displayDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        displayTime = new javax.swing.JLabel();
        btnQuotation = new javax.swing.JButton();
        btnShowQuotation = new javax.swing.JButton();
        displayEventId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Evento");

        lblClient.setText("Cliente");

        btnReturn.setText("Regresar");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        lblPlace.setText("Lugar");

        lblDate.setText("Dia");

        lblTime.setText("Hora");

        btnQuotation.setText("Cotización");
        btnQuotation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuotationActionPerformed(evt);
            }
        });

        btnShowQuotation.setText("Ver Cotización");
        btnShowQuotation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowQuotationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblClient)
                                .addGap(18, 18, 18)
                                .addComponent(displayClient))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPlace)
                                .addGap(18, 18, 18)
                                .addComponent(displayPlace))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDate)
                                .addGap(18, 18, 18)
                                .addComponent(displayDate))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTime)
                                .addGap(18, 18, 18)
                                .addComponent(displayTime)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 228, Short.MAX_VALUE)
                        .addComponent(btnShowQuotation))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(displayEventId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuotation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReturn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnShowQuotation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClient)
                    .addComponent(displayClient))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlace)
                    .addComponent(displayPlace))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(displayDate))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTime)
                    .addComponent(displayTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReturn)
                    .addComponent(btnQuotation)
                    .addComponent(displayEventId))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        dispose();
        EventsController.index();
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnQuotationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuotationActionPerformed
        dispose();
        QuotationController.store();
    }//GEN-LAST:event_btnQuotationActionPerformed

    private void btnShowQuotationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowQuotationActionPerformed
        dispose();
        QuotationController.show();
    }//GEN-LAST:event_btnShowQuotationActionPerformed

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
            java.util.logging.Logger.getLogger(showEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(showEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(showEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(showEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new showEvents().setVisible(true);
            }
        });
    }

    public void setValues(Event event) {
        displayClient.setText(event.clientName());
        displayPlace.setText(event.place());
        displayDate.setText(event.date());
        displayTime.setText(event.time());
        btnShowQuotation.setVisible(event.quotation());
        btnQuotation.setVisible(!event.quotation());
        displayEventId.setText(String.valueOf(event.id()));
        displayEventId.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuotation;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnShowQuotation;
    private javax.swing.JLabel displayClient;
    private javax.swing.JLabel displayDate;
    private javax.swing.JLabel displayEventId;
    private javax.swing.JLabel displayPlace;
    private javax.swing.JLabel displayTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblClient;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblPlace;
    private javax.swing.JLabel lblTime;
    // End of variables declaration//GEN-END:variables
}
