package com.yuhong.service;
 
import java.util.List;
 
import com.yuhong.model.Toy;
 
public interface ToyService {
     
    public void addToy(Toy movi);
 
    public List<Toy> getAllToys();
 
    public void deleteToy(Integer ToyId);
 
    public Toy getToy(int Toyid);
 
    public Toy updateToy(Toy movi);
}
