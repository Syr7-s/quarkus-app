package com.syrisa.quarkus.web.graphql.input;

import com.syrisa.quarkus.data.entity.Service;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@ApplicationScoped
@ToString
public class ServiceInput {
    private String name;
    private BigDecimal price;

    public Service getEntity(){
        Service service = new Service();
        service.setName(this.name);
        service.setPrice(this.price);
        return service;
    }
}
