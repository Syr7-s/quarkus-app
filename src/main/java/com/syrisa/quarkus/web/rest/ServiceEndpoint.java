package com.syrisa.quarkus.web.rest;

import com.syrisa.quarkus.data.entity.Service;
import com.syrisa.quarkus.data.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestPath;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@Path("/rest/services")
@Produces("application/json")
@Consumes("application/json")
@RequiredArgsConstructor
public class ServiceEndpoint {
    private final ServiceRepository serviceRepository;

    @GET
    @Path("/{id}")
    public Service getService(@RestPath("id") long id){
        Service service = this.serviceRepository.findById(id);
        if (service == null) throw new NotFoundException();
        return service;
    }

    @POST
    @ResponseStatus(201)
    @Transactional
    public Service addService(Service service){
        this.serviceRepository.persist(service);
        return service;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @ResponseStatus(204)
    public void updateService(@RestPath("id") long id, Service service){
        if (id != service.getId()) throw new BadRequestException();
        Service entity = this.serviceRepository.findById(id);
        if (entity == null) throw new NotFoundException();
        entity.setName(service.getName());
        entity.setPrice(service.getPrice());
        this.serviceRepository.persist(entity);
    }
    @GET
    @Path("/all")
    public List<Service> getServices(){
        return this.serviceRepository.listAll();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @ResponseStatus(205)
    public void deleteCustomer(@RestPath("id") long id){
        this.serviceRepository.deleteById(id);
    }
}
