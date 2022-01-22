/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameter.apirest.ws;

import com.jofrantoba.model.jpa.shared.UnknownException;
import com.parameter.entity.Empleado;
import com.parameter.service.inter.InterServiceEmpleado;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jona
 */
@RestController
@RequestMapping("parameta")
public class RestEmpleado {
    
    @Autowired    
    private InterServiceEmpleado serviceEmpleado;

    @PostMapping(
            value = "/saveEmpleado",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Empleado saveEmpleado(@RequestBody Empleado entidad) throws UnknownException {
        entidad.setIsPersistente(Boolean.TRUE);
        entidad.setVersion((new Date()).getTime());
        return serviceEmpleado.saveEmpleado(entidad);

    }
}
