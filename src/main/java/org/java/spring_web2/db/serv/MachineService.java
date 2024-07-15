package org.java.spring_web2.db.serv;

import java.util.List;
import java.util.Optional;

import org.java.spring_web2.db.pojo.Machine;
import org.java.spring_web2.db.repo.MachineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineService {

    @Autowired
    private MachineRepo machineRepo;

    public List<Machine> getAllMachines() {

        return machineRepo.findAll();
    }

    public Optional<Machine> getById(int id) {

        return machineRepo.findById(id);
    }

    public void save(Machine machine) {

        machineRepo.save(machine);
    }

    public void delete(Machine machine) {

        machineRepo.delete(machine);
    }
}
