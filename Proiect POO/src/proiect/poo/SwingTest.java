package proiect.poo;

import java.awt.*;
import java.awt.event.*;
import static java.lang.Integer.parseInt;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.*;

public class SwingTest {
    public static void main(String[] args) {
        Masa mese[] = new Masa[7];
        mese[0] = new Masa(2, "interior");
        mese[1] = new Masa(4, "interior");
        mese[2] = new Masa(8, "interior");
        mese[3] = new Masa(4, "interior");
        mese[4] = new Masa(6, "interior");
        mese[5] = new Masa(2, "interior");
        mese[6] = new Masa(2, "terasa");
        
        JFrame f = new JFrame();
        f.setSize(500, 500);
        f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.PAGE_AXIS));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel numeLabel = new JLabel("Nume:");
        JTextField numeField = new JTextField(20);
        JLabel prenumeLabel = new JLabel("Prenume:");
        JTextField prenumeField = new JTextField(20);
        JLabel nrTelLabel = new JLabel("Numar de telefon:");
        JTextField nrTelField = new JTextField(20);
        JLabel nrPersLabel = new JLabel("Numar persoane:");
        JTextField nrPersField = new JTextField(3);
        JLabel dataLabel = new JLabel("Data rezervarii:");
        JTextField dataField = new JTextField(20);
        JLabel oraLabel = new JLabel("Ora rezervarii:");
        JTextField oraField = new JTextField(20);
        JButton meseButton = new JButton("Verifica mese");
        f.getContentPane().add(numeLabel);
        f.getContentPane().add(numeField);
        f.getContentPane().add(prenumeLabel);
        f.getContentPane().add(prenumeField);
        f.getContentPane().add(nrTelLabel);
        f.getContentPane().add(nrTelField);
        f.getContentPane().add(nrPersLabel);
        f.getContentPane().add(nrPersField);
        f.getContentPane().add(dataLabel);
        f.getContentPane().add(dataField);
        f.getContentPane().add(oraLabel);
        f.getContentPane().add(oraField);
        f.getContentPane().add(meseButton);
        
        
        meseButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                Rezervare rez = new Rezervare(new Persoana(numeField.getText(), prenumeField.getText(), nrTelField.getText()), parseInt(nrPersField.getText()), LocalDate.parse(dataField.getText(), ProiectPOO.format), LocalTime.parse(oraField.getText()), null);
                Masa valabile[] = rez.verificaMese(mese);
                JComboBox meseBox = new JComboBox(valabile);
                SwingUtilities.updateComponentTreeUI(f);
                f.getContentPane().add(meseBox);
            }
        });
        
        f.setVisible(true);
    }
}
