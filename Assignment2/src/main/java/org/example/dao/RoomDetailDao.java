package org.example.dao;

import java.util.List;

public interface RoomDetailDao {
    List<RoomDetailDao> getAll();
    RoomDetailDao getById(long id);
    long save(RoomDetailDao data);
    boolean update(RoomDetailDao data,long id);
    boolean delete(long id);
}
