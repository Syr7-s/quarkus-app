package com.syrisa.quarkus.service;

import com.syrisa.quarkus.data.entity.Service;
import com.syrisa.quarkus.data.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public List<Service> getAllServices(){
        return this.serviceRepository.listAll();
    }

    @Transactional
    public Service addService(Service service){
        this.serviceRepository.persist(service);
        return service;
    }

    public Service getService(long id){
        Service service =  this.serviceRepository.findById(id);
        if(service ==null){
            throw new NotFoundException();
        }
        return service;
    }

    @Transactional
    public Service updateService(Service service){

        Service entity = this.serviceRepository.findById(service.getId());
        if(entity == null){
            throw new NotFoundException();
        }
        entity.setPrice(service.getPrice());
        entity.setName(service.getName());
        this.serviceRepository.persist(entity);
        return entity;
    }

    @Transactional
    public void deleteService(long id){
        this.serviceRepository.deleteById(id);
    }
}