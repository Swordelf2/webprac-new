package service;

import dao.DepositDao;
import entities.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepositService {
    @Autowired
    DepositDao dao;

    @Transactional
    public int add(Deposit deposit) {
        return dao.add(deposit);
    }

    @Transactional
    public void update(Deposit deposit) {
        dao.update(deposit);
    }

    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Transactional
    public Deposit get(int id) {
        return dao.get(id);
    }

    @Transactional
    public List<Deposit> list() {
        return dao.getAll();
    }
}
