package com.example.enlatadosmg.controller;

import com.example.enlatadosmg.models.Almacen;
import com.example.enlatadosmg.service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/almacen")
public class AlmacenController {
    @Autowired
    private AlmacenService almacenService;

    @PostMapping("/push")
    public Almacen pushBox() {
        return almacenService.push();
    }

    @PostMapping("/pop")
    public Almacen popBox() {
        return almacenService.pop();
    }
}
