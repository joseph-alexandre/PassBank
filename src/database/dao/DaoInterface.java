package database.dao;

import java.util.List;

public interface DaoInterface<T>  {

    public boolean add(T thing);
    
    public boolean removeById(Integer id);

    public boolean update(T thing);

    public List<T> getAll();

}