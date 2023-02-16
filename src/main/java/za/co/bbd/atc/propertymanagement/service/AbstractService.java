package za.co.bbd.atc.propertymanagement.service;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.atc.propertymanagement.model.db.DbModel;

public abstract class AbstractService<D extends DbModel, J extends JpaRepository<D, ?>> {
    final protected J repository;

    protected AbstractService(J repository) {
        this.repository = repository;
    }
}
