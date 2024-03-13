package model.DAO;

import model.entities.Department;

import java.util.List;

public interface DepartmentDAO {
    public void insert(Department obj);
    public void update(Department obj);
    public void deleteById(Integer id);
    public Department findById(Integer id);
    public List<Department> findAll();
}
