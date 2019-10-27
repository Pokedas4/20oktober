package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static JFrame gui = new JFrame();
    public static JTextArea text = new JTextArea(6, 50);
    public static JTextField file = new JTextField(20);
    public static JButton save = new JButton("SAVE TEXT");
    public static JButton calculate = new JButton("CALCULATE");
    public static JButton load = new JButton("LOAD");
    public static JLabel result = new JLabel();
    public static String txt = "";
    public static String filename = "";
    final static JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    public static void main(String[] args)
    {
       // save_text(square(1000), "1000squares.txt");
        //read_write();
        save.addActionListener(e ->
        {
            save_text(text.getText(), file.getText());
        });
        calculate.addActionListener(e ->
        {
            calc();
        });
        load.addActionListener(e ->
        {
            int returnValue = fc.showOpenDialog(null);
            filename = fc.getSelectedFile().getAbsolutePath();
            try
            {

            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        });
        gui.setSize(new Dimension(600, 400));
        gui.setLayout(new FlowLayout());
        gui.add(text);
        gui.add(file);
        gui.add(save);
        gui.adddd
            d(calculate);
        gui.add(result);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void save_text(String text, String filename)
    {
        try(FileWriter writer = new FileWriter(filename, false))
        {
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static String square(int n)
    {
        String result = "";
        for(int i = 0; i <= n; i++)
        {
            result = result + "Square of " + i + " is " + i*i + "\n";
        }
        return result;
    }

    public static void read_write()
    {
        String text = "";
        String file = "";
        Scanner input = new Scanner(System.in);
        System.out.println("ENTER TEXT:");
        text = input.nextLine();
        input = new Scanner(System.in);
        System.out.println("\nENTER FILE NAME:");
        file = input.next();
        save_text(text, file);

    }

    public static void calc()
    {
        int sum = 0;
        int average = 0;
        String temp = text.getText();
        String[] temp2 = temp.split(" ");
        for(String word : temp2)
        {
           sum = sum + Integer.parseInt(word);
        }
        average = sum/temp2.length;
        result.setText("SUM: " + sum + " AVERAGE: " + average);
    }
}
