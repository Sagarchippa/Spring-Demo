package org.app.dao;

import org.app.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    @Autowired
    SessionFactory sessionFactory;

    public void save(Employee employee){
        Session session=sessionFactory.getCurrentSession();
        session.save(employee);
    }

    public Employee getEmployee(Integer id){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("FROM Employee where id=:id");
        query.setParameter("id",id);
        return (Employee)query.uniqueResult();
    }

    public List<Employee> getAllEmployees(){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("FROM Employee");
        return query.getResultList();
    }
}
