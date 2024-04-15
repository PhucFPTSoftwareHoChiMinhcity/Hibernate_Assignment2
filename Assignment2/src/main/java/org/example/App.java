package org.example;
import org.example.dao.SeatDao;
import org.example.dao.impl.SeatDaoImpl;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        tao doi tuong cho seatdao
        SeatDao seatDao = new SeatDaoImpl();
        SeatDao seat = null;

        seat = seatDao.getById(1);
        System.out.println(seat);

        seat = seatDao.getById(1);
        System.out.println(seat);

        seat = seatDao.getById(1);
        System.out.println(seat);
    }
}
