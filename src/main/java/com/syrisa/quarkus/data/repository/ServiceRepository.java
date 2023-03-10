package com.syrisa.quarkus.data.repository;

import com.syrisa.quarkus.data.entity.Service;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
@RequiredArgsConstructor
//@ActivateRequestContext
public class ServiceRepository implements PanacheRepository<Service> {

}
