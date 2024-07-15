package org.java.spring_web2.web.controller;

import java.util.List;

import org.java.spring_web2.db.pojo.Machine;
import org.java.spring_web2.db.serv.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private MachineService machineService;

    @GetMapping("/machines/test/add")
    public ResponseEntity<Void> addTestMachines() {

        Machine m1 = new Machine("Machine 1", "Description 1", 100);
        Machine m2 = new Machine("Machine 2", "Description 2", 200);
        Machine m3 = new Machine("Machine 3", "Description 3", 300);

        machineService.save(m1);
        machineService.save(m2);
        machineService.save(m3);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/machines")
    public ResponseEntity<List<Machine>> getAllMachines() {

        List<Machine> machines = machineService.getAllMachines();

        return ResponseEntity.ok(machines);
    }
}
