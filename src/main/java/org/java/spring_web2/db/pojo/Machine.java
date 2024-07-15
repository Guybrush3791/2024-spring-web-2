package org.java.spring_web2.db.pojo;

import org.java.spring_web2.web.dto.MachineDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 32)
    private String name;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private int price;

    public Machine() {

    }

    public Machine(String name, String description, int price) {

        setName(name);
        setDescription(description);
        setPrice(price);
    }

    public Machine(MachineDto machineDto) {

        this(machineDto.getName(), machineDto.getDescription(), machineDto.getPrice());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void update(MachineDto machineDto) {

        setName(machineDto.getName());
        if (machineDto.getDescription() != null)
            setDescription(machineDto.getDescription());
        setPrice(machineDto.getPrice());
    }

    @Override
    public String toString() {

        return "Machine{\n" +
                "id=" + id + ",\n" +
                "name='" + name + "',\n" +
                "description='" + description + "',\n" +
                "price=" + price + "\n" +
                "}";
    }
}
