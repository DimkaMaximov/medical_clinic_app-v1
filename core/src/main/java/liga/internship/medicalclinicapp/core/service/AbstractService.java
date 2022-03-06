package liga.internship.medicalclinicapp.core.service;

import java.util.List;

public interface AbstractService<T> {

    T findById(Long id);

    List<T> findAll();

    void deleteById(Long id);

    void update(T entity);

    T create(T entity);
}
