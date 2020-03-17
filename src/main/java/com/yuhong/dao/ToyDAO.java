package com.yuhong.dao;
 
import java.util.List;
import com.yuhong.model.Toy;
 
public interface ToyDAO {
 
    public void addToy(Toy movi);
 
    public List<Toy> getAllToys();
 
    public void deleteToy(Integer ToyId);
 
    public Toy updateToy(Toy movi);
 
    public Toy getToy(int ToyId);
}