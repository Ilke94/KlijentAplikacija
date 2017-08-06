/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;


import domen.Igrac;
import domen.Trener;
import java.util.ArrayList;
import java.util.List;
import observer.ObserverIgrac;

/**
 *
 * @author Milos
 */
public class Kontroler {

    private static Trener loggedUser;
    private static List<Igrac> listaIgraca = new ArrayList<>();
    private static List<ObserverIgrac> observers = new ArrayList<>();

    public static void attach(ObserverIgrac observer) {
        observers.add(observer);
    }

    public static void notifyAllObservers(Igrac igrac) {
        observers.forEach(ObserverIgrac::update);
//        for (ObserverIgrac observer : observers) {
//            observer.update();
//        }
    }

    public static void setLoggedUser(Trener trener) {
        loggedUser = trener;
    }

    public static Trener getLoggedUser() {
        return loggedUser;
    }

}
