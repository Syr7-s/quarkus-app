package com.syrisa.quarkus.web.rest;

import com.syrisa.quarkus.data.entity.Service;
import com.syrisa.quarkus.data.entity.Vendor;
import com.syrisa.quarkus.data.repository.VendorRepository;
import io.netty.util.internal.StringUtil;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestQuery;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@Path("/rest/vendors")
@Produces("application/json")
@Consumes("application/json")
@RequiredArgsConstructor
public class VendorEndpoint {
    private final VendorRepository vendorRepository;

    @GET
    public Vendor getByEmail(@RestQuery("email") String email){
        if (StringUtil.isNullOrEmpty(email)){
            throw new BadRequestException();
        }
        Vendor vendor = this.vendorRepository.findByEmail(email);
        if (vendor == null){
            throw new NotFoundException();
        }
        return vendor;
    }

    @GET
    public Vendor getByName(@RestQuery("name") String name){
        if (StringUtil.isNullOrEmpty(name)){
            throw new BadRequestException();
        }
        Vendor vendor = this.vendorRepository.findByName(name);
        if (vendor == null){
            throw new NotFoundException();
        }
        return vendor;
    }

    @GET
    @Path("/all")
    public List<Vendor> getServices(){
        return this.vendorRepository.listAll();
    }

    @POST
    @ResponseStatus(201)
    @Transactional
    public Vendor addVendor(Vendor vendor){
        this.vendorRepository.persist(vendor);
        return vendor;
    }

    @GET
    @Path("/{id}")
    public Vendor getVendor(@RestPath("id") long id){
        Vendor vendor = this.vendorRepository.findById(id);
        if(vendor == null){
            throw new NotFoundException();
        }
        return vendor;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @ResponseStatus(204)
    public void updateVendor(@RestPath("id") long id, Vendor vendor){
        if (id != vendor.getId()) throw new BadRequestException();
        Vendor entity = this.vendorRepository.findById(id);
        if (entity == null) throw new NotFoundException();
        entity.setPhone(vendor.getPhone());
        entity.setEmail(vendor.getEmail());
        entity.setAddress(vendor.getAddress());
        entity.setContact(vendor.getContact());
        entity.setName(vendor.getName());
        this.vendorRepository.persist(entity);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @ResponseStatus(205)
    public void deleteVendor(@RestPath("id") long id){
        this.vendorRepository.deleteById(id);
    }
}

