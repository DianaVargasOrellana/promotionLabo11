package com.example.promotiondiana.service;

import com.example.promotiondiana.dto.BaseDTO;
import com.example.promotiondiana.model.ModelBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
@SuppressWarnings("rawtypes")
public interface GenericService <T extends ModelBase>{
    List<T> findAll();

    T findById(Long id);

    T save(T model);

    T saveAndFlush(T model);

    T patch(BaseDTO dto, T model);

    List<T> saveAll(Iterable<T> models);

    void deleteById(Long id);

    Byte[] getBytes(MultipartFile file);

    Page<T> findAll(Pageable pageable);

    List<T> findAll(String filter);


}
