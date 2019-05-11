package service;

import dao.DepositDao;
import entities.Deposit;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepositService {
    @Autowired
    DepositDao dao;

    public int add(Deposit deposit) {
        return dao.add(deposit);
    }

    public void update(Deposit deposit) {
        dao.update(deposit);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public Deposit get(int id) {
        return dao.get(id);
    }

    public List<Deposit> list() {
        return dao.getAll();
    }
}
