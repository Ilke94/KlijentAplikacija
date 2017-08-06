/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent;

import forme.FLogin;
import java.awt.Dimension;
import java.io.IOException;
import java.net.Socket;
import komunikacija.KomunikacijaSaServerom;

/**
 *
 * @author Milos
 */
public class Klijent {

    public void poveziSeSaServerom() throws IOException {
        Socket socket = new Socket("127.0.0.1", 9000);
        System.out.println("Klijent se povezao sa serverom");

        KomunikacijaSaServerom.getInstanca().setSocket(socket);

        FLogin fLogin = new FLogin(null, true);
        fLogin.setLocationRelativeTo(null);
        fLogin.setMinimumSize(new Dimension(400, 200));
        fLogin.setVisible(true);
    }
}
