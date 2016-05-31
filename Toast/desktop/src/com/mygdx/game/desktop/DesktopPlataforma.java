package com.mygdx.game.desktop;

import com.mygdx.game.Plataforma;

import javax.swing.JOptionPane;

/**
 * Created by Zan on 31/05/2016.
 */
public class DesktopPlataforma implements Plataforma {

    @Override
    public void mostrarDialogo(String titulo, String mensaje) {
       JOptionPane.showMessageDialog(null,mensaje,titulo,JOptionPane.INFORMATION_MESSAGE);


    }
}
