package com.example.enlatadosmg.service;

import com.example.enlatadosmg.models.Almacen;
import com.example.enlatadosmg.repositories.AlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class AlmacenService {
    @Autowired
    private AlmacenRepository almacenRepository;

    public Almacen push() {
        Almacen top = almacenRepository.findTopByOrderByCorrelativoDesc();
        Almacen newBox = new Almacen();
        newBox.setFechaIngreso(new Date());

        if (top != null) {
            newBox.setNext(top);
        }

        return almacenRepository.save(newBox);
    }

    public Almacen pop() {
        Almacen top = almacenRepository.findTopByOrderByCorrelativoDesc();
        if (top != null) {
            almacenRepository.delete(top);
            return top;
        }
        return null;
    }
}