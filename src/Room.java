/*
 * @version 1.0
 * @author Tobiasz Rumian
 * Data: 05 Listopad 2016 r.
 * Indeks: 226131
 * Grupa: śr 13:15 TN
 */
class Room implements Comparable<Room> {
    private String buildingNumber;
    private int roomNumber;
    private String description;

    Room(String buildingNumber, int roomNumber, String description) {
        this.buildingNumber = buildingNumber;
        this.roomNumber = roomNumber;
        this.description = description;
    }

    @Override
    public int compareTo(Room o) {
        int i = buildingNumber.compareTo(o.buildingNumber);
        if (i != 0) return i;
        return Integer.compare(roomNumber, o.roomNumber);
    }

    @Override
    public String toString() {

        return null;
    }

    @Override
    public int hashCode() {

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Room && this.compareTo((Room) o) == 0;
    }

    String getBuildingNumber() {
        return buildingNumber;
    }

    String getDescription() {
        return description;
    }

    int getRoomNumber() {
        return roomNumber;
    }
}
