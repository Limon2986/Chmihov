package DAO;

import entity.MarkaCoffi;

import java.util.List;

/**
 * Created by Администратор on 12.07.2017.
 */
public interface MarkaDAO {
    
    List<MarkaCoffi> getAll();
    MarkaCoffi get(Integer id);
    Boolean delete(Integer id);
    Boolean update(MarkaCoffi markaCoffi);
    Boolean create(MarkaCoffi markaCoffi);
    
}
