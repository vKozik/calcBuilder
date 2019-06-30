package ua.in.vkozik.calcbuilder.house.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("calc-builder-basement")
public interface BasementClient {

    @GetMapping("/calculate")
    Double calculate(@RequestParam(value = "square") Double square,
                                    @RequestParam(value = "height") Double height,
                                    @RequestParam(value = "depth") Double depth);
}
