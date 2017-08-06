/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Igrac;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import komunikacija.KomunikacijaSaServerom;
import pomoc.Operacija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Milos
 */
public class ModelTabeleIgrac extends AbstractTableModel {

    List<Igrac> igraci;
    List<Igrac> igraciFiltrirano;
    String[] kolone = {"Ime", "Prezime", "JMBG", "Adresa", "Mesto", "Uzrast", "Trener", "Status"};

    public ModelTabeleIgrac(List<Igrac> igraci) {
        this.igraci = igraci;
        this.igraciFiltrirano = igraci;
    }

    @Override
    public int getRowCount() {
        if (igraciFiltrirano == null) {
            return 0;
        }
        return igraciFiltrirano.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Igrac igrac = igraciFiltrirano.get(row);
        switch (column) {
            case 0:
                return igrac.getIme();
            case 1:
                return igrac.getPrezime();
            case 2:
                return igrac.getJmbg();
            case 3:
                return igrac.getUlica() + " " + igrac.getBroj();
            case 4:
                return igrac.getMesto();
            case 5:
                return igrac.getUzrast();
            case 6:
                return igrac.getTrener();
            case 7:
                return igrac.isStatus();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (column == 7) {
            return true;
        }
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Igrac igrac = igraciFiltrirano.get(rowIndex);
        switch (columnIndex) {
            case 7: {
                boolean status = (boolean) aValue;
                igrac.setStatus(status);
                try {
                    KlijentskiZahtev kz = new KlijentskiZahtev();
                    kz.setAkcija(Operacija.IZMENI_ODO);
                    kz.setParametar(igrac);
                    KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
                    ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
                } catch (Exception ex) {
                    igrac.setStatus(!status);
                    System.out.println(ex.getMessage());
                }

                break;
            }
        }
    }

    @Override
    public Class<?> getColumnClass(int i) {
        Class clazz = String.class;
        switch (i) {
            case 7:
                clazz = Boolean.class;
        }
        return clazz;
    }

    public void azurirajPodatkeOIgracu(Igrac igrac) {
        for (Igrac igr : igraciFiltrirano) {
            if (igr.getId() == igrac.getId()) {
                igr.setIme(igrac.getIme());
                igr.setPrezime(igrac.getPrezime());
                igr.setUlica(igrac.getUlica());
                igr.setBroj(igrac.getBroj());
                igr.setMesto(igrac.getMesto());
                igr.setUzrast(igrac.getUzrast());
                igr.setStatus(igrac.isStatus());
                break;
            }
        }
        fireTableDataChanged();
    }

    public Igrac vratiIgraca(int index) {
        return igraciFiltrirano.get(index);
    }

    public void resetujFilter() {
        igraciFiltrirano = igraci;
        fireTableDataChanged();
    }

    public void filtriraj(String trim, List<String> stiklirani) {
        igraciFiltrirano = new ArrayList<>();

        for (int i = 0; i < igraci.size(); i++) {
            Igrac igrac = igraci.get(i);

            if (zadovoljenUslov1(igrac, trim) && zadovoljenUslov2(igrac, stiklirani)) {
                igraciFiltrirano.add(igrac);
            }

        }

        fireTableDataChanged();
    }

    private boolean zadovoljenUslov1(Igrac igrac, String upit) {
        if (upit.isEmpty()) {
            return true;
        }
        if (igrac.getIme().toLowerCase().startsWith(upit.toLowerCase())
                || igrac.getPrezime().toLowerCase().startsWith(upit
                        .toLowerCase()) || igrac.getJmbg().startsWith(upit)) {
            return true;
        }

        return false;
    }

    private boolean zadovoljenUslov2(Igrac igrac, List<String> stiklirani) {
        if (stiklirani.isEmpty()) {
            return true;
        }
        for (String string : stiklirani) {
            if (igrac.getUzrast().getNaziv().equals(string)) {
                return true;
            }
        }
        return false;
    }

    public List<Igrac> vratiListu() {
        return igraciFiltrirano;
    }

}
