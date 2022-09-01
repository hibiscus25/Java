package A_GROM_lesson.lesson36.B_model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Room implements Comparable<Room> {
    private long id;
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    public Room(long id, int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.id = id;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    public Room(int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id && numberOfGuests == room.numberOfGuests && Double.compare(room.price, price) == 0 && breakfastIncluded == room.breakfastIncluded && petsAllowed == room.petsAllowed && dateAvailableFrom.equals(room.dateAvailableFrom) && hotel.equals(room.hotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfGuests, price, breakfastIncluded, petsAllowed, dateAvailableFrom, hotel);
    }


    public long getId() {
        return id;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public String getDateFormat() {
        return new SimpleDateFormat("dd-MM-yyyy").format(dateAvailableFrom);
    }

    @Override
    public String toString() {
        return id + "," + numberOfGuests + "," + price + "," + breakfastIncluded + "," + petsAllowed + "," + getDateFormat() + "," + hotel.getId();
    }

    @Override
    public int compareTo(Room o) {
        return (int) (this.id-o.getId());
    }
}
