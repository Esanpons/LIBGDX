package com.mygdx.game.desktop;

import com.mygdx.game.DialogListener;
import com.mygdx.game.Plataforma;

import javax.swing.JOptionPane;


/**
 * Created by Zan on 31/05/2016.
 */
public class DesktopPlataforma implements Plataforma {

    @Override
    public void toast(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);


    }

    @Override
    public void mostrarPregunta(DialogListener listener) {

        int resultado = JOptionPane.showConfirmDialog(null, "estas seguro?", "Atencion pregunta", JOptionPane.YES_NO_OPTION);
        if (resultado == JOptionPane.YES_OPTION) {
            listener.onPressYes();
        } else if (resultado == JOptionPane.NO_OPTION) {
            listener.onPressNo();

        }

    }


}
