package org.example.dao;
import java.util.List;

public interface SeatDao {
    List<SeatDao> getAll();
    SeatDao getById(long id);
    long save(SeatDao data);
    boolean update(SeatDao data,long id);
    boolean delete(long id);
}
