package ua.in.vkozik.calcbuilder.roof.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ua.in.vkozik.calcbuilder.roof.service.RoofCalc;

@RestController
public class RoofController {
    @Autowired
    RoofCalc roofCalc;

    @GetMapping("/test")
    public ResponseEntity apiTest() {
        return new ResponseEntity("Ok", HttpStatus.OK);
    }

    @GetMapping("/calculate")
    public ResponseEntity calculate(@RequestParam(value = "length") Double length,
             @RequestParam(value = "width") Double width) {

        return new ResponseEntity(roofCalc.calculate(length, width), HttpStatus.OK);
    }
}
