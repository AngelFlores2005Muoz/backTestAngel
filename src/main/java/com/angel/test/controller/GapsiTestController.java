package com.angel.test.controller;

import com.angel.test.dao.SupplierRepository;
import com.angel.test.entity.Supplier;
import com.angel.test.payload.request.SupplierRequest;
import com.angel.test.payload.response.ResponseMessage;
import com.angel.test.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gapsi")
public class GapsiTestController {
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierService supplierService;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/welcome")
    public String welcome() {
        return "Bienvenido Candidato 01";
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/version")
    public String version() {
        return "Version 1.0.0";
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/saveSupplier")
    public ResponseEntity<?> saveSupplier(@RequestBody SupplierRequest supplier) {

        Optional<String> supplierOptional = Optional.ofNullable(supplierRepository.findByNombre(supplier.getName()));

        if (supplierOptional.isPresent()) {
            return new ResponseEntity<>(new ResponseMessage(HttpStatus.SEE_OTHER.value(), "Supplier already" +
					" exists, please chose another"), HttpStatus.SEE_OTHER);
        }

        Supplier supplierIn = new Supplier(supplier.getName(), supplier.getRazonSocial(), supplier.getDireccion());

        supplierRepository.save(supplierIn);

        return new ResponseEntity<>(new ResponseMessage(HttpStatus.CREATED.value(), "Supplier saved"),
				HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("/deleteSupplier/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable(name = "id") String id) {

        Optional<Supplier> supplierOptional = supplierRepository.findById(Integer.parseInt(id));

        if (supplierOptional.isEmpty()) {
            return new ResponseEntity<>(new ResponseMessage(HttpStatus.SEE_OTHER.value(), "Supplier does not exists" +
                    " please verify your id"), HttpStatus.SEE_OTHER);
        }

        supplierRepository.deleteById(Integer.valueOf(id));

        return new ResponseEntity<>(new ResponseMessage(HttpStatus.OK.value(), "Supplier deleted"),
                HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/suppliers/{pageNumber}/{pageSize}")
    public List<Supplier> getSupplier(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
        Page<Supplier> data = supplierService.getSupplierePagination(pageNumber, pageSize);
        return data.getContent();
    }
}
