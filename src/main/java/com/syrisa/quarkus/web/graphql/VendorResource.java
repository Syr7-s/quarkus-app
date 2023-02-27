package com.syrisa.quarkus.web.graphql;

import com.syrisa.quarkus.data.entity.Vendor;
import com.syrisa.quarkus.service.VendorService;
import com.syrisa.quarkus.web.graphql.input.VendorInput;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.*;

import java.util.List;

@GraphQLApi
@RequiredArgsConstructor
public class VendorResource {
    private final VendorService vendorService;

    @Query("allVendors")
    @Description("Get all Vendors available in the system")
    public List<Vendor> getVendors(){
        return vendorService.getAllVendors();
    }

    @Mutation("addVendor")
    @Description("Adds a Vendor to the system")
    public Vendor addVendor(VendorInput vendorInput){
        return vendorService.addVendor(vendorInput.getEntity());
    }

    @Query("getVendor")
    @Description("Gets an individual Vendor by ID")
    public Vendor getVendor(@Name("id") long id){
        return this.vendorService.getVendor(id);
    }

    @Query("getVendorsByName")
    @Description("Gets an individual Vendor by Name")
    public List<Vendor> getVendorsByName(@Name("name") String name){
        return vendorService.getVendorsByName(name);
    }

    @Query("getVendorsByEmail")
    @Description("Gets an individual Vendor by Email")
    public List<Vendor> getVendorsByEmail(@Name("email") String email){
        return vendorService.getVendorsByEmail(email);
    }

    @Query("getVendorsByEmailAndName")
    @Description("Gets an individual Vendor by Email and Name")
    public List<Vendor> getVendorsByEmailAndName(@Name("email") String email,@Name("name") String name){
        return vendorService.getVendorsByEmailAndName(email, name);
    }

    @Mutation("updateVendor")
    @Description("Update and individual Vendor")
    public Vendor updateVendor(Vendor vendor){
        return vendorService.updateVendor(vendor);
    }

    @Mutation("deleteVendor")
    @Description("Delete an individual Vendor by ID")
    public Vendor deleteVendor(@Name("id") long id){
        Vendor vendor = this.vendorService.getVendor(id);
        this.vendorService.deleteVendor(id);
        return vendor;
    }

}
