package database.dao;

import java.util.List;

public interface DaoInterface<T>  {

    public boolean add(T thing);
    
    public boolean removeById(Integer id);

    public boolean update(T thing);
    
    public T getById(Integer id);

    public List<T> getAll();

}