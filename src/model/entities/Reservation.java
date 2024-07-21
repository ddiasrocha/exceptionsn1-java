package model.entities;

import model.exceptions.DomainException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        if(!checkOut.after(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return this.checkIn;
    }

    public Date getCheckOut() {
        return this.checkOut;
    }

    public long duration() {
        long diff = this.checkOut.getTime() - this.checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) /*throws DomainException*/{ //quando se usa o RuntimeException, posso retirar a chamada de tratamento de exceção no codigo fonte do tipo Exception, que obriga a fazer tratamentos

        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("Reservation dates for update must be future dates");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }

    public String toString() {
        Integer var10000 = this.roomNumber;
        return "Room " + var10000 + ", check-in: " + sdf.format(this.checkIn) + ", check-ou: " + sdf.format(this.checkOut) + ", " + this.duration() + " nights";
    }
}
