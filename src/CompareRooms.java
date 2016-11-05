/*
 *  Program CompareRooms
 *  Pozwala sprawdzić różnice w przechowywaniu obiektów klasy Room w kolekcjach.
 *  Obejmuje: Vector, ArrayList, LinkedList, HashSet, TreeSet
 *
 *  @author Tobiasz Rumian
 *  @version 1.0
 *   Data: 05 Listopad 2016 r.
 *   Indeks: 226131
 *   Grupa: śr 13:15 TN
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class CompareRooms extends JFrame implements ActionListener {
    private JMenuBar menuBar;

    private Vector<Room> vector = new Vector<>();
    private ArrayList<Room> arrayList = new ArrayList<>();
    private LinkedList<Room> linkedList = new LinkedList<>();
    private HashSet<Room> hashSet = new HashSet<>();
    private TreeSet<Room> treeSet = new TreeSet<>();

    private RoomView vectorView;
    private RoomView arrayView;
    private RoomView linkedView;
    private RoomView hashView;
    private RoomView treeView;

    private JLabel buildingNumberLabel = new JLabel("Numer budynku:");
    private JTextField buildingNumberField = new JTextField(4);
    private JLabel roomNumberLabel = new JLabel("Numer pokoju:");
    private JTextField roomNumberField = new JTextField(4);
    private JLabel descriptionLabel = new JLabel("Opis:");
    private JTextField descriptionField = new JTextField(20);
    private JButton buttonAdd = new JButton("Dodaj");
    private JButton buttonDelete = new JButton("Usuń");
    private JButton buttonClear = new JButton("Wyczyść");
    private JButton buttonAbout = new JButton("Autor");

    public CompareRooms() {
        super("Porownanie działania kolekcji");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 300);

        JPanel panel = new JPanel();
        buttonAdd.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonAbout.addActionListener(this);

        menuBar = new JMenuBar();
        menuBar.add(buildingNumberLabel);
        menuBar.add(buildingNumberField);
        menuBar.add(roomNumberLabel);
        menuBar.add(roomNumberField);
        menuBar.add(descriptionLabel);
        menuBar.add(descriptionField);
        menuBar.add(buttonAdd);
        menuBar.add(buttonDelete);
        menuBar.add(buttonClear);
        menuBar.add(buttonAbout);
        setJMenuBar(menuBar);
        vectorView = new RoomView(vector, 150, 200, "vector:");
        panel.add(vectorView);

        arrayView = new RoomView(arrayList, 150, 200, "arrayView:");
        panel.add(arrayView);

        linkedView = new RoomView(linkedList, 150, 200, "linkedView:");
        panel.add(linkedView);

        hashView = new RoomView(hashSet, 150, 200, "hashView:");
        panel.add(hashView);
        treeView = new RoomView(treeSet, 150, 200, "treeView:");
        panel.add(treeView);


        setContentPane(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String buildingNumber = buildingNumberField.getText();
        int roomNumber = Integer.parseInt(roomNumberField.getText());
        String description = descriptionField.getText();
        if (source == buttonAdd) {
            Room room = new Room(buildingNumber, roomNumber, description);
            arrayList.add(room);
            vector.add(room);
            linkedList.add(room);
            hashSet.add(room);
            treeSet.add(room);

        } else if (source == buttonClear) {
            arrayList.clear();
            vector.clear();
            linkedList.clear();
            hashSet.clear();
            treeSet.clear();
        } else if (source == buttonDelete) {
            Room room = new Room(buildingNumber, roomNumber, description);

            arrayList.remove(room);
            vector.remove(room);
            linkedList.remove(room);
            hashSet.remove(room);
            treeSet.remove(room);
        } else if (source == buttonAbout) {
            About about;
            try {
                about = new About(this);
                about.setVisible(true);
            } catch (Exception event) {
                System.err.println(event.getMessage());
            }
        }

        arrayView.refresh();
        vectorView.refresh();
        linkedView.refresh();
        hashView.refresh();
        treeView.refresh();
    }

    public static void main(String[] args) {
        new CompareRooms();
    }

    private class About extends JDialog {
        About(JFrame owner) throws MalformedURLException {
            super(owner, "O Autorze", true);
            URL url = null;
            try {
                url = new URL("https://media.giphy.com/media/l0HlIKdi4DIEDk92g/giphy.gif");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            Icon icon = new ImageIcon(url);
            JLabel label = new JLabel(icon);
            add(new JLabel("Autor:\t Tobiasz Rumian\t Indeks: 226131"), BorderLayout.NORTH);
            add(label, BorderLayout.CENTER);
            JButton ok = new JButton("ok");
            ok.addActionListener(e -> setVisible(false));
            add(ok, BorderLayout.SOUTH);
            setSize(400, 400);
        }
    }
}

