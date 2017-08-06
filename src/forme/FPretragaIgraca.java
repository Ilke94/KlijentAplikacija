/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Igrac;
import domen.Uzrast;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.ModelTabeleIgrac;
import komunikacija.KomunikacijaSaServerom;
import kontroler.Kontroler;
import observer.ObserverIgrac;
import pomoc.Operacija;
import pomoc.StatusOdgovora;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Milos
 */
public class FPretragaIgraca extends javax.swing.JDialog implements ObserverIgrac {

    private List<String> stiklirani = new ArrayList<>();

    /**
     * Creates new form FPretragaIgraca
     */
    public FPretragaIgraca(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        Kontroler.attach(this);
        initComponents();
        popuniTabeluIgrac();
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
        jtblIgrac = new javax.swing.JTable();
        jbtnDetalji = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFilterIgraca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonDodajTrening = new javax.swing.JButton();
        jButtonPrikaziTreninge = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pretraga igrača");

        jtblIgrac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ime", "Prezime", "JMBG", "Adresa", "Mesto", "Uzrast", "Trener", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtblIgrac);

        jbtnDetalji.setText(" Detalji o igraču");
        jbtnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDetaljiActionPerformed(evt);
            }
        });

        jLabel1.setText("Unesi kriterijum pretrage (ime,prezime, jmbg)");

        jTextFieldFilterIgraca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldFilterIgracaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldFilterIgracaKeyReleased(evt);
            }
        });

        jButton1.setText("Pretraži");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Poništi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButtonDodajTrening.setText("Dodaj treninge");
        jButtonDodajTrening.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDodajTreningActionPerformed(evt);
            }
        });

        jButtonPrikaziTreninge.setText("Prikaži treninge");
        jButtonPrikaziTreninge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrikaziTreningeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldFilterIgraca, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnDetalji)
                                .addGap(31, 31, 31)
                                .addComponent(jButtonDodajTrening)
                                .addGap(31, 31, 31)
                                .addComponent(jButtonPrikaziTreninge)
                                .addGap(0, 337, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldFilterIgraca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnDetalji)
                    .addComponent(jButtonDodajTrening)
                    .addComponent(jButtonPrikaziTreninge))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDetaljiActionPerformed
        if (jtblIgrac.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Morate selektovati igrača u tabeli", "Upozorenje", JOptionPane.WARNING_MESSAGE);
        } else {
            //JOptionPane.showMessageDialog(this, "Sistem je prikazao podatke o igraču", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
            FIgrac forma = new FIgrac(null, true, true);
            int index = jtblIgrac.getSelectedRow();
            ModelTabeleIgrac mti = (ModelTabeleIgrac) jtblIgrac.getModel();
            Igrac igrac = mti.vratiIgraca(index);
            forma.postaviVrednostPoljima(igrac);
            forma.setTitle("Detalji o igraču");
            forma.setLocationRelativeTo(null);
            forma.setVisible(true);
        }
    }//GEN-LAST:event_jbtnDetaljiActionPerformed

    private void jTextFieldFilterIgracaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFilterIgracaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            filtriraj();
            ModelTabeleIgrac mti = (ModelTabeleIgrac) jtblIgrac.getModel();
            int brojIgraca = mti.vratiListu().size();
            if (brojIgraca > 0) {
                JOptionPane.showMessageDialog(this, "Sistem je našao igrače po zadatoj vrednosti", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Sistem ne može da nađe igrače po zadatoj vrednosti", "Greška", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTextFieldFilterIgracaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setAkcija(Operacija.VRATI_SVE_ZA_ODO);
        kz.setParametar(new Uzrast());
        try {
            KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
            ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();

            if (so.getStatus() == StatusOdgovora.OK) {
                List<Uzrast> uzrasti = (List<Uzrast>) so.getOdgovor();
                List<String> lista = new ArrayList<>();
                for (Uzrast uzrast : uzrasti) {
                    lista.add(uzrast.getNaziv());
                }
                FNaprednaPretraga fNaprednaPretraga = new FNaprednaPretraga(null, true, this, lista, stiklirani);
                fNaprednaPretraga.setTitle("Pretraga po uzrastu");
                fNaprednaPretraga.setLocationRelativeTo(null);
                fNaprednaPretraga.setVisible(true);
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(FPretragaIgraca.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextFieldFilterIgraca.setText("");
        stiklirani.clear();
        resetujFilter();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonDodajTreningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajTreningActionPerformed
        if (jtblIgrac.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Morate selektovati igrača u tabeli", "Upozorenje", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Sistem je kreirao formu za unos novih treninga", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
            FTrening fTrening = new FTrening(null, true);
            int index = jtblIgrac.getSelectedRow();
            ModelTabeleIgrac mti = (ModelTabeleIgrac) jtblIgrac.getModel();
            Igrac igrac = mti.vratiIgraca(index);
            fTrening.postaviParametre(igrac);
            fTrening.setLocationRelativeTo(null);
            fTrening.setVisible(true);
        }
    }//GEN-LAST:event_jButtonDodajTreningActionPerformed

    private void jButtonPrikaziTreningeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrikaziTreningeActionPerformed
        if (jtblIgrac.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Morate selektovati igrača u tabeli", "Upozorenje", JOptionPane.WARNING_MESSAGE);
        } else {
            //JOptionPane.showMessageDialog(this, "Sistem je našao sve treninge igrača", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
            int index = jtblIgrac.getSelectedRow();
            ModelTabeleIgrac mti = (ModelTabeleIgrac) jtblIgrac.getModel();
            Igrac igrac = mti.vratiIgraca(index);
            FPrikazTreninga fPrikazTreninga = new FPrikazTreninga(null, true, igrac);
            fPrikazTreninga.setTitle("Prikaz svih treninga za igrača " + igrac.getIme() + " " + igrac.getPrezime());
            fPrikazTreninga.pack();
            fPrikazTreninga.setLocationRelativeTo(null);
            fPrikazTreninga.setVisible(true);
        }
    }//GEN-LAST:event_jButtonPrikaziTreningeActionPerformed

    private void jTextFieldFilterIgracaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFilterIgracaKeyReleased
        filtriraj();
    }//GEN-LAST:event_jTextFieldFilterIgracaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonDodajTrening;
    private javax.swing.JButton jButtonPrikaziTreninge;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldFilterIgraca;
    private javax.swing.JButton jbtnDetalji;
    private javax.swing.JTable jtblIgrac;
    // End of variables declaration//GEN-END:variables

    private void popuniTabeluIgrac() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setAkcija(Operacija.VRATI_SVE_ZA_ODO);
        kz.setParametar(new Igrac());
        try {
            KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
            ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();

            if (so.getStatus() == StatusOdgovora.OK) {
                List<Igrac> igraci = (List<Igrac>) so.getOdgovor();
                TableModel model = new ModelTabeleIgrac(igraci);
                jtblIgrac.setModel(model);
                jtblIgrac.getColumnModel().getColumn(0).setPreferredWidth(50);
                jtblIgrac.getColumnModel().getColumn(1).setPreferredWidth(75);
                jtblIgrac.getColumnModel().getColumn(2).setPreferredWidth(50);
                jtblIgrac.getColumnModel().getColumn(3).setPreferredWidth(100);
                jtblIgrac.getColumnModel().getColumn(4).setPreferredWidth(50);
                jtblIgrac.getColumnModel().getColumn(5).setPreferredWidth(120);
                jtblIgrac.getColumnModel().getColumn(6).setPreferredWidth(75);
                jtblIgrac.getColumnModel().getColumn(7).setPreferredWidth(50);
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(FPretragaIgraca.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update() {
        popuniTabeluIgrac();
    }

    public void resetujFilter() {
        ModelTabeleIgrac mti = (ModelTabeleIgrac) jtblIgrac.getModel();
        mti.resetujFilter();
    }

    private void filtriraj() {
        ModelTabeleIgrac mti = (ModelTabeleIgrac) jtblIgrac.getModel();
        mti.filtriraj(jTextFieldFilterIgraca.getText().trim(), stiklirani);
    }

    void setStikliraj(List<String> stiklirani) {
        this.stiklirani = stiklirani;
        filtriraj();
    }

}
