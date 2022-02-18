package com.app.hostman.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class HostnameInfo {

    @NotNull(message = "Alias is not empty")
    private String alias;

    @NotNull(message = "Domain is not empty")
    private Character domain;

    @NotNull(message = "Role is not empty")
    private Character role;

    @NotNull(message = "SystemCode is not empty")
    private Byte systemCode;

    @Min(value = 1, message = "count min 1")
    @Max(value = 99, message = "count max 99")
    private Byte count;


    public String generateHostname(){
        List<String> hostnameList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String hostname = new StringBuilder()
                    .append(alias)
                    .append(i <10 ? "0" + i: i)
                    .append(domain)
                    .append(role)
                    .append(systemCode).toString();
            hostnameList.add(hostname);
        }
        return hostnameList.toString();
    }
}
