package com.example.promotiondiana.repository;

import com.example.promotiondiana.model.ModelBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GenericRepository <T extends ModelBase> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}
