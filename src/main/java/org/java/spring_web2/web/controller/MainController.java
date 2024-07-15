package org.java.spring_web2.web.controller;

import java.util.List;
import java.util.Optional;

import org.java.spring_web2.db.pojo.Machine;
import org.java.spring_web2.db.serv.MachineService;
import org.java.spring_web2.web.dto.MachineDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("machines")
public class MainController {

    @Autowired
    private MachineService machineService;

    @GetMapping("test/add")
    public ResponseEntity<Void> addTestMachines() {

        Machine m1 = new Machine("Machine 1", "Description 1", 100);
        Machine m2 = new Machine("Machine 2", "Description 2", 200);
        Machine m3 = new Machine("Machine 3", "Description 3", 300);

        machineService.save(m1);
        machineService.save(m2);
        machineService.save(m3);

        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Machine>> getAllMachines() {

        List<Machine> machines = machineService.getAllMachines();

        return ResponseEntity.ok(machines);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable int id) {

        Optional<Machine> optMachine = machineService.getById(id);

        if (optMachine.isEmpty())
            return ResponseEntity.notFound().build();

        Machine machine = optMachine.get();
        machineService.delete(machine);

        return ResponseEntity.ok("Deleted machine (id: " + id + ")");
    }

    @PostMapping("")
    public ResponseEntity<Machine> addMachine(
            @RequestBody MachineDto machineDto) {

        Machine machine = new Machine(machineDto);
        machineService.save(machine);

        return ResponseEntity.ok(machine);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Machine> updateMachine(
            @PathVariable int id,
            @RequestBody MachineDto machineDto) {

        Optional<Machine> optMachine = machineService.getById(id);

        if (optMachine.isEmpty())
            return ResponseEntity.notFound().build();

        Machine machine = optMachine.get();
        machine.update(machineDto);

        machineService.save(machine);

        return ResponseEntity.ok(machine);
    }
}
