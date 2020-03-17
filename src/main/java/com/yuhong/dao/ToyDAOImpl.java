package com.yuhong.dao;
 
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.yuhong.model.Toy;
 
@Repository
public class ToyDAOImpl implements ToyDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addToy(Toy movi) {
        sessionFactory.getCurrentSession().saveOrUpdate(movi);
 
    }
 
    @SuppressWarnings("unchecked")
    public List<Toy> getAllToys() {
 
        return sessionFactory.getCurrentSession().createQuery("from Toy")
                .list();
    }
 
    @Override
    public void deleteToy(Integer ToyId) {
        Toy movi = (Toy) sessionFactory.getCurrentSession().load(
                Toy.class, ToyId);
        if (null != movi) {
            this.sessionFactory.getCurrentSession().delete(movi);
        }
 
    }
 
    public Toy getToy(int ToyId) {
        return (Toy) sessionFactory.getCurrentSession().get(
                Toy.class, ToyId);
    }
 
    @Override
    public Toy updateToy(Toy movi) {
        sessionFactory.getCurrentSession().update(movi);
        return movi;
    }
 
}