package model.DAO.impl;

import db.DB;
import db.DbException;
import model.DAO.DepartmentDAO;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDaoJDBC implements DepartmentDAO {
    private Connection conn;
    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }
    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "INSERT INTO department "
                            +"(Name) "
                            +"VALUES "
                            +"(?)", Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, obj.getName());
            int rowsAffected = st.executeUpdate();
            if(rowsAffected > 0 ){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            }else{
                throw new DbException("Unexpected Error!, No rows affected!");
            }
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Department obj) {

        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
              "UPDATE department "
                    +"SET Name = ?"
                      +"WHERE Id = ?"
            );
            st.setString(1,obj.getName());
            st.executeUpdate();
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }


    }

    @Override
    public void deleteById(Integer id) {

        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "DELETE FROM department "+
                            "WHERE Id = ?"
            );
            st.setInt(1,id);
            int rowsAffected = st.executeUpdate();
            if(rowsAffected == 0){
                throw new DbException("Nenhum dado foi encontrado");
            }

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT Name  "
                            +"FROM department "
                            +"WHERE id = ?"
            );
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                Department dep;
                return  dep = instantiateDepartment(rs);
            }
            return null;


        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }

    @Override
    public List<Department> findAll() {

        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT department.* "
                            +"FROM department "
                            +"ORDER BY Name"
            );
            rs = st.executeQuery();
            List<Department> list = new ArrayList<>();
            while(rs.next()){
                Department obj = instantiateDepartment(rs);
                list.add(obj);
                return list;
            }
            return null;
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }


    private Department instantiateDepartment(ResultSet rs) throws SQLException{
        Department dep = new  Department();
        dep.setId(rs.getInt("Id"));
        dep.setName(rs.getString("Name"));
        return dep;
    }

}

