/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.resources;

import com.rest.RESTStartup;
import com.rest.dto.Car;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author pjs
 */
@Path ("car")
public class CarResource {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addCar(@FormParam("licenceplate")String licencePlate,
                            @FormParam("color")String color){
        
        Map<Integer, Car> db = RESTStartup.getCarDB();
        
        Double id = Math.random()*10000+1;
        Car car =new Car(licencePlate,color);
        db.put(id.intValue(), car);
        return Response.ok(db.get(id.intValue())).build();
        
        
              
        
       
    }
}
