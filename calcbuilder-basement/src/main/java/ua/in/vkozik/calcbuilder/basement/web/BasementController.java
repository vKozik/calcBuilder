package ua.in.vkozik.calcbuilder.basement.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.in.vkozik.calcbuilder.basement.service.BasementCalc;

@RestController
public class BasementController {
    @Autowired
    BasementCalc basementCalc;

    @GetMapping("/test")
    public ResponseEntity apiTest() {
        return new ResponseEntity("Ok", HttpStatus.OK);
    }

    @GetMapping("/calculate")
    public ResponseEntity calculate(@RequestParam(value = "square") Double square,
             @RequestParam(value = "height") Double height, @RequestParam(value = "depth") Double depth) {
        return new ResponseEntity(basementCalc.calculate(square, height, depth  ), HttpStatus.OK);
    }
}
