package com.syrisa.quarkus.web.graphql;

import com.syrisa.quarkus.data.entity.Service;
import com.syrisa.quarkus.service.ServiceService;
import com.syrisa.quarkus.web.graphql.input.ServiceInput;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.*;

import java.util.List;

@GraphQLApi
@RequiredArgsConstructor
public class ServiceResource {

    private final ServiceService serviceService;

    @Query("allServices")
    @Description("Gets all services available in the system")
    public List<Service> getAllServices(){
        return this.serviceService.getAllServices();
    }

    @Mutation("addService")
    @Description("Adds a service to the system")
    public Service addService(ServiceInput serviceInput){
        return serviceService.addService(serviceInput.getEntity());
    }

    @Query("getService")
    @Description("Gets and individual service by ID")
    public Service getService(@Name("id") long id){
        return this.serviceService.getService(id);
    }

    @Mutation("updateService")
    @Description("Update an individual Service")
    public Service updateService(Service service){
        return this.serviceService.updateService(service);
    }

    @Mutation("deleteService")
    @Description("Deletes an individual Service")
    public Service deleteService(@Name("id")long id){
        Service service = this.serviceService.getService(id);
        this.serviceService.deleteService(id);
        return service;
    }
}
