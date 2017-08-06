/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Igrac;
import domen.Trening;
import java.awt.Component;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.ModelTabeleTrening;
import komunikacija.KomunikacijaSaServerom;
import pomoc.Operacija;
import pomoc.StatusOdgovora;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Milos
 */
public class FPrikazTreninga extends javax.swing.JDialog {

    private final Igrac igrac;

    /**
     * Creates new form FPrikazTreninga
     */
    public FPrikazTreninga(java.awt.Frame parent, boolean modal, Igrac igrac) {
        super(parent, modal);
        this.igrac = igrac;
        initComponents();
        srediFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTreninzi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableTreninzi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableTreninzi.setToolTipText("");
        jScrollPane1.setViewportView(jTableTreninzi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTreninzi;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        ModelTabeleTrening mtt = new ModelTabeleTrening();
        jTableTreninzi.setModel(mtt);
        srediKoloneTabele();
        try {
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setAkcija(Operacija.VRATI_SVE_TRENINGE_ZA_IGRACA);
            kz.setParametar(igrac);
            try {
                KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
                ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
                if (so.getStatus() == StatusOdgovora.OK) {
                    List<Trening> treninzi = (List<Trening>) so.getOdgovor();
                    mtt.dodajSve(treninzi);
                }

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(FIgrac.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (Exception ex) {
            Logger.getLogger(FPrikazTreninga.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void srediKoloneTabele() {
        jTableTreninzi.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableTreninzi.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTableTreninzi.getColumnModel().getColumn(2).setPreferredWidth(75);
        jTableTreninzi.getColumnModel().getColumn(3).setPreferredWidth(75);
        jTableTreninzi.getColumnModel().getColumn(4).setPreferredWidth(125);
        jTableTreninzi.getColumnModel().getColumn(5).setPreferredWidth(175);
        jTableTreninzi.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel c = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setToolTipText("<html><p width=\"150\">" + c.getText() + "</p></html>");
                return c;
            }
        });
        jTableTreninzi.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel c = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setToolTipText("<html><p width=\"150\">" + c.getText() + "</p></html>");
                return c;
            }
        });
        jTableTreninzi.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel c = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setToolTipText("<html><p width=\"150\">" + c.getText() + "</p></html>");
                return c;
            }
        });
    }

}