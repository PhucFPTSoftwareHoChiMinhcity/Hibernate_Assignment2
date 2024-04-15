package org.example.dao;

import java.util.List;

public interface RoomDao {
    List<RoomDao> getAll();
    RoomDao getById(long id);
    long save(RoomDao data);
    boolean update(RoomDao data,long id);
    boolean delete(long id);
}
