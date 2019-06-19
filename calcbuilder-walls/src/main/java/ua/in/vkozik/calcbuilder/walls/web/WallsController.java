package ua.in.vkozik.calcbuilder.walls.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.in.vkozik.calcbuilder.walls.service.WallsCalc;

@RestController
public class WallsController {
    @Autowired
    WallsCalc wallsCalc;

    @GetMapping("/test")
    public ResponseEntity apiTest() {
        return new ResponseEntity("Ok", HttpStatus.OK);
    }

    @GetMapping("/calculate")
    public ResponseEntity calculate(@RequestParam(value = "length") Double length,
             @RequestParam(value = "width") Double width, @RequestParam(value = "numberOfLevels") Integer numberOfLevels,
             @RequestParam(value = "roomHeight") Double roomHeight) {

        return new ResponseEntity(wallsCalc.calculate(length, width, numberOfLevels, roomHeight), HttpStatus.OK);
    }
}
