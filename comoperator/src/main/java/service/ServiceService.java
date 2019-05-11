package service;

import dao.ClientDao;
import dao.ServiceDao;
import entities.Client;
import entities.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceService {
    @Autowired
    ServiceDao dao;

    public int add(Service service) {
        return dao.add(service);
    }

    public void update(Service service) {
        dao.update(service);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public Service get(int id) {
        return dao.get(id);
    }

    public List<Service> list() {
        return dao.getAll();
    }

    public List<Service> getByNameAndDescription(String name, String description) {
        return dao.getByNameAndDescription(name, description);
    }
}
