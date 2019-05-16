package service;

import dao.ClientDao;
import entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientDao dao;

    @Transactional
    public int add(Client client) {
        return dao.add(client);
    }

    @Transactional
    public void update(Client client) {
        dao.update(client);
    }

    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Transactional
    public Client get(int id) {
        return dao.get(id);
    }

    @Transactional
    public List<Client> list() {
        return dao.getAll();
    }

    @Transactional
    public List<Client> getByName(String name) { return dao.getByName(name); }
}
