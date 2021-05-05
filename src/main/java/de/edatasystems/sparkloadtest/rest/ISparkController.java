package de.edatasystems.sparkloadtest.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;

@RestController
@Produces("application/json")
@RequestMapping("/api/spark")
@Api(tags = "Spark Controller", description = "Controller for testing spark")
public interface ISparkController {

    @PostMapping
    @RequestMapping("/provokeException")
    @ApiOperation(value = "Penetrate spark")
    void provokeException(@RequestParam("listSize") long listSize,
                          @RequestParam("amountOfLists") long amountOfLists);

}
