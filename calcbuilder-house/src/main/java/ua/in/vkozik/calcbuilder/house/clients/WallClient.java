package ua.in.vkozik.calcbuilder.house.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("calc-builder-walls")
public interface WallClient {

    @GetMapping("/calculate")
    Double calculate(@RequestParam(value = "length") Double length,
                                    @RequestParam(value = "width") Double width,
                                    @RequestParam(value = "numberOfLevels") Integer numberOfLevels,
                                    @RequestParam(value = "roomHeight") Double roomHeight);

}
