package si.tpo.fitin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import si.tpo.fitin.entities.Equipment;
import si.tpo.fitin.model.EquipmetReq;
import si.tpo.fitin.repositories.EquipmentRepository;

import java.util.List;

@RestController
public class EquipmentController {
    @Autowired
    EquipmentRepository equipmentRepository;

    @GetMapping("/equipments")
    public List<Equipment> getEquipments() {
        return equipmentRepository.findAll();
    }

    @PostMapping("/equipments/add")
    public void addEquipment(@RequestBody EquipmetReq req) throws Exception {
        Equipment eq = new Equipment();
        String name = req.getName();
        if (!equipmentRepository.findByName(name).isPresent()) {
            eq.setName(name);
            equipmentRepository.save(eq);
        } else {
            throw new Exception("Equipment already exists");
        }
    }
}
