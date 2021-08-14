package jkronyak;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    T get(Integer plu);

    //List<T> getAll();


}
