/*
 * @version 1.0
 * @author Tobiasz Rumian
 * Data: 05 Listopad 2016 r.
 * Indeks: 226131
 * Grupa: śr 13:15 TN
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Collection;


class RoomView extends JScrollPane {
    private static final long serialVersionUID = 1L;

    private JTable table;
    private DefaultTableModel tableModel;
    private Collection<Room> rooms;

    RoomView(Collection<Room> collection, int width, int height, String description) {
        String[] column = {"Budynek:", "Pokój", "Opis"};
        tableModel = new DefaultTableModel(column, 0);
        table = new JTable(tableModel);
        table.setRowSelectionAllowed(false);
        this.rooms = collection;
        setViewportView(table);
        setPreferredSize(new Dimension(width, height));
        setBorder(BorderFactory.createTitledBorder(description));
    }

    void refresh() {
        tableModel.setRowCount(0);
        for (Room r : rooms) {
            String[] row = {r.getBuildingNumber(), Integer.toString(r.getRoomNumber()), r.getDescription()};
            tableModel.addRow(row);
        }
    }

}

