package services;

import dao.OperationsServiceImpl;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractService<Model, Entity> {
    private final OperationsServiceImpl<Entity> currentDAO;
    public AbstractService(OperationsServiceImpl<Entity> osi){
        currentDAO=osi;
    }
    abstract Entity ModelToEntity(Model model);
    abstract Model EntityToModel(Entity entity);
    abstract long getId(Model model);
    public void create(Model model){
        currentDAO.create(ModelToEntity(model));
    }
    public void update(Model model){
        currentDAO.update(ModelToEntity(model));
    }
    public void delete(Model model){
        currentDAO.delete(getId(model));
    }
    public List<Model> getAll(){
        List<Entity> entityList = currentDAO.getAll();
        List<Model> modelList=new LinkedList<Model>();
        for (Entity entity:
             entityList) {
            modelList.add(EntityToModel(entity));
        }
        return modelList;
    }
    public Model getById(Model model){
         return EntityToModel(currentDAO.getByID(getId(model)));
    }



}
