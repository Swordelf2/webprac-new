package service;

import dao.ClientDao;
import entities.Client;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientService {
    @Autowired
    ClientDao dao;

    public int add(Client client) {
        return dao.add(client);
    }

    public void update(Client client) {
        dao.update(client);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public Client get(int id) {
        return dao.get(id);
    }

    public List<Client> list() {
        return dao.getAll();
    }

    public List<Client> getByName(String name) { return dao.getByName(name); }
}
