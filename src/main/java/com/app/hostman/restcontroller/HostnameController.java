package com.app.hostman.restcontroller;

import com.app.hostman.model.HostnameInfo;
import com.app.hostman.util.RestEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HostnameController {

    @GetMapping(value = "/hostname", produces = "application/json")
    public Map<RestEnum, Object> hostname(@RequestBody @Valid HostnameInfo hostnameInfo ){
        Map<RestEnum,Object> map = new LinkedHashMap<>();
        map.put(RestEnum.status, true);
        map.put(RestEnum.result, hostnameInfo.generateHostname());
        return map;
    }
}
