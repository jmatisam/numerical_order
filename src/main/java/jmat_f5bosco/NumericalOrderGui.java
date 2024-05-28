package jmat_f5bosco;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class NumericalOrderGui extends JFrame {
    private final JTextField numberInput;
    private final JTextArea numberListArea;
    private final DefaultListModel<Integer> numberListModel;

    public NumericalOrderGui() {
        setTitle("數字順序顯示---Numerical Order Show");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel numberLabel = new JLabel("插入一個數字 / Insert a number:");
        numberInput = new JTextField(10);
        JButton addButton = new JButton("添加 / Add");
        JButton sortButton = new JButton("命令 / Order");

        inputPanel.add(numberLabel);
        inputPanel.add(numberInput);
        inputPanel.add(addButton);
        inputPanel.add(sortButton);

        numberListModel = new DefaultListModel<>();
        JList<Integer> numberList = new JList<>(numberListModel);
        numberListArea = new JTextArea();
        numberListArea.setEditable(false);

        add(new JScrollPane(numberList), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);

        addButton.addActionListener((ActionEvent e) -> {
            addNumber();
        });

        sortButton.addActionListener((ActionEvent e) -> {
            sortNumbers();
        });
    }

    private void addNumber() {
        try {
            int number = Integer.parseInt(numberInput.getText());
            if (number == 4) {
                JOptionPane.showMessageDialog(this, "數字4在中國文化中被認為是不吉利的，不能進入該列表 / The number 4 is considered unlucky in Chinese culture and cannot be entered into the list.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            numberListModel.addElement(number);
            numberInput.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void sortNumbers() {
        int size = numberListModel.getSize();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = numberListModel.getElementAt(i);
        }

        NumericalOrder.bubbleSort(array);

        numberListModel.clear();
        for (int num : array) {
            numberListModel.addElement(num);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new NumericalOrderGui().setVisible(true);
        });
    }
}
