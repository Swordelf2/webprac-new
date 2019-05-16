package service;

import dao.ServiceDao;
import entities.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {
    @Autowired
    ServiceDao dao;

    @Transactional
    public int add(Service service) {
        return dao.add(service);
    }

    @Transactional
    public void update(Service service) {
        dao.update(service);
    }

    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Transactional
    public Service get(int id) {
        return dao.get(id);
    }

    @Transactional
    public List<Service> list() {
        return dao.getAll();
    }

    @Transactional
    public List<Service> getByNameAndDescription(String name, String description) {
        return dao.getByNameAndDescription(name, description);
    }
}
