package assignment1;

import assignment1.gui.View;

import javax.swing.*;
import java.text.ParseException;

public class Main
{
    public static void main( String[] args ) throws ParseException {
        JFrame frame = new View("Polynomial calculator by Salomeea Muresan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }
}
