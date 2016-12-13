package com.courses.spalah.mvc;

import com.courses.spalah.domain.Plane;
import com.courses.spalah.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Roman on 24.11.2016.
 */

@RestController
@RequestMapping(value = "/plane",  produces = MediaType.APPLICATION_JSON_VALUE)
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Plane> getPlane(@RequestParam long id) {
        Plane plane = planeService.getById(id);
        return new ResponseEntity<Plane>(plane,HttpStatus.OK);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST/*, produces = MediaType.APPLICATION_JSON_VALUE*/)
    //@ResponseBody
    public ResponseEntity<Plane> savePlane(@RequestParam String model, Long business, Long casual) {
        Plane newPlane = planeService.save(model, business, casual);
        return new ResponseEntity<>(newPlane, HttpStatus.OK);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<List<Plane>> getAllPlanes() {
            List<Plane> planes = planeService.getAll();
            return new ResponseEntity<List<Plane>>(planes, HttpStatus.OK);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResponseEntity<Plane> deletePlane(@RequestParam long id) {
        Plane deletedPlane = planeService.delete(id);
        return new ResponseEntity<Plane>(deletedPlane,HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Plane> updatePlane(@RequestParam long id, @RequestBody Plane plane) {
        Plane updatedPlane = planeService.getById(id);
        updatedPlane.setPlaneName(plane.getPlaneName());
        planeService.update(updatedPlane);
        return new ResponseEntity<Plane>(updatedPlane, HttpStatus.OK);
    }
}
