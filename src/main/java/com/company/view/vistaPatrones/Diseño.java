/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.view.vistaPatrones;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author FABIAN-VC
 */
public interface Diseño {

    public static final Dimension DIMENSIONPANTALLA = Toolkit.getDefaultToolkit().getScreenSize();

    public static final int ANCHOVENTANA = (int) (DIMENSIONPANTALLA.getWidth() / 1.2);
    public static final int ALTOVENTANA = (int) (DIMENSIONPANTALLA.getWidth() / 2);
    public static final int WIDTH_LEFT_PANE = 250;

    //Colors finals for the project
    public static final Color COLOR_VIOLET_PRIMARY = new Color(118, 99, 235);
    public static final Color COLOR_DEFAULT_BACKGROUND = new Color(248, 248, 248);
    public static final Color COLOR_DEFAULT_BORDERS = new Color(233, 233, 233);
    public static final Color COLOR_RED_PRIMARY = new Color(245,77,69);
    public static final Color COLOR_DEFAULT_WHITE = new Color(255, 255, 255);
    public static final Color COLOR_DEFAULT_BLACK = new Color(0,0,0);




    public static final Color COLOR_VIOLET = new Color(99, 105, 255);
    public static final Color COLOR_BLUE_LEFT = new Color(47, 46, 65);

    public static final Color COLOR_BACKGROUND2 = new Color(255, 255, 255);
    public static final Color COLOR_BACKGROUND3 = new Color(220, 220, 220);

    public static final Color COLORTP1 = new Color(70, 253, 236, 60);
    public static final Color COLORTP2 = new Color(193, 193, 181, 60);
    public static final Color COLORTP3 = new Color(248, 137, 119, 90);

    public static final Color COLORPRINCIPAL = new Color(255, 255, 255);
    public static final Color COLORBORDEBOTON = new Color(206, 206, 206);
    public static final Color COLORBOTON0 = new Color(70, 253, 236, 60);
    public static final Color COLORBOTON1 = new Color(38, 205, 59);
    public static final Color COLORBOTON2 = new Color(193, 193, 181);
    public static final Color COLORBOTON3 = new Color(248, 137, 119);

    public static final Color COLOR_GRAY_TEXT_FIELD = new Color(160, 168, 167);
    public static final Color COLOR_TEXT = new Color(255, 255, 255);
    public static final Color COLOR_BORDER_TEXT_FIELD = new Color(38, 128, 235);
    public static final Color COLOR_BORDER_TF = new Color(45, 146, 215);
    public static final Color COLOR_GRAY_CLARO = new Color(238, 238, 238);


    public static final Color COLOR_PANE_GRAPH = new Color(185, 214, 220);
    public static final Color COLOR_PANE_SET = new Color(187, 236, 210);

    public static final Color COLOR_VALIDATE = new Color(69, 253, 190);
    public static final Color COLOR_DELETE = new Color(248, 137, 119);
    public static final Color COLOR_BLUE_VALIDATE = new Color(138, 173, 223);
    public static final Color COLOR_TEXT_FIELD = new Color(255, 255, 255);

    public static Font INTER_MEDIUM_18 = cambiarFuente("Inter-Medium-slnt=0", 18);
    public static Font INTER_MEDIUM_16 = cambiarFuente("Inter-Medium-slnt=0", 16);
    public static Font INTER_MEDIUM_12 = cambiarFuente("Inter-Medium-slnt=0", 12);
    public static Font INTER_MEDIUM_14 = cambiarFuente("Inter-Medium-slnt=0", 12);

    public static final Font INTER_LIGTH_18 = cambiarFuente("Inter-Light-slnt=0", 18);
    public static final Font INTER_LIGTH_16 = cambiarFuente("Inter-Light-slnt=0", 16);
    public static final Font INTER_LIGTH_12 = cambiarFuente("Inter-Light-slnt=0", 12);
    public static final Font INTER_LIGTH_14 = cambiarFuente("Inter-Light-slnt=0", 14);

    public static final Font INTER_TITULO = cambiarFuente("Inter-ExtraBold-slnt=0", 14);
    public static final Font INTER_SUBTITULO = cambiarFuente("Inter-ExtraBold-slnt=0", 12);

    public static final Font INTER_PRINCIPAL = definirTamanho(0);
    public static final Font INTER_SECUNDARIA = definirTamanho(1);

    public static final int RADIO = 10;


    public static void makeMargins(JComponent component) {
        JPanel a = new JPanel();
        a.setOpaque(false);
        component.add(a, BorderLayout.WEST);
        a = new JPanel();
        a.setOpaque(false);
        component.add(a, BorderLayout.EAST);
        a = new JPanel();
        a.setOpaque(false);
    }

    public static void makeMargins2(JComponent component) {
        JPanel a = new JPanel();
        a.setOpaque(false);
        component.add(a, BorderLayout.WEST);
        a = new JPanel();
        a.setOpaque(false);
        component.add(a, BorderLayout.EAST);
        a = new JPanel();
        a.setOpaque(false);
        a.setPreferredSize(new Dimension(0, 0));
        component.add(a, BorderLayout.NORTH);
        a = new JPanel();
        a.setOpaque(false);
        a.setPreferredSize(new Dimension(0, 0));
        component.add(a, BorderLayout.SOUTH);
    }

    public static void makeMarginsNorth(JComponent component, int w, int h) {
        JPanel a = new JPanel();
        a.setOpaque(false);
        a.setPreferredSize(new Dimension(w, h));
        component.add(a, BorderLayout.NORTH);
    }

    public static void makeMarginsSouth(JComponent component, int w, int h) {
        JPanel a = new JPanel();
        a.setOpaque(false);
        a.setPreferredSize(new Dimension(w, h));
        component.add(a, BorderLayout.SOUTH);
    }

    public static void makeMarginsEast(JComponent component, int w, int h) {
        JPanel a = new JPanel();
        a.setOpaque(false);
        a.setPreferredSize(new Dimension(w, h));
        component.add(a, BorderLayout.EAST);
    }

    public static void makeMarginsWest(JComponent component, int w, int h) {
        JPanel a = new JPanel();
        a.setOpaque(false);
        a.setPreferredSize(new Dimension(w, h));
        component.add(a, BorderLayout.WEST);
    }

    public static Font cambiarFuente(String font, int px) {
        Font fuente = null;
        InputStream myStream;
        try {
            myStream = new BufferedInputStream(new FileInputStream("src/fonts/" + font + ".ttf"));
            fuente = Font.createFont(Font.TRUETYPE_FONT, myStream);
            fuente = fuente.deriveFont(Font.PLAIN, px);
        } catch (FontFormatException | IOException ex) {
        }
        return fuente;
    }

    public static Font definirTamanho(int i) {
        if (ANCHOVENTANA >= 1440) {
            if (i == 0) {
                return INTER_MEDIUM_16;
            } else {
                return INTER_LIGTH_16;
            }
        } else {
            if (i == 0) {
                return INTER_MEDIUM_12;
            } else {
                return INTER_LIGTH_12;
            }
        }
    }
}
