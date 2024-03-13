package model.DAO;


import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public interface SellerDAO {
    public void insert(Seller obj);
    public void update(Seller obj);
    public void deleteById(Integer id);
    public Seller findById(Integer id);
    public List<Seller> findAll();
    List<Seller> findByDepartment(Department department);
}
