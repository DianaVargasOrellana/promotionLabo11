package com.example.promotiondiana.dto;

import com.example.promotiondiana.model.ModelBase;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class BaseDTO<E extends ModelBase> {
    protected Logger logger = LoggerFactory.getLogger(BaseDTO.class);
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date updatedAt;
    private long version;

    protected void beforeConversion(E element, ModelMapper mapper) {
        // Do nothing
    }

    protected void afterConversion(E element, ModelMapper mapper) {
        // Do nothing
    }

    @SuppressWarnings("unchecked")
    public <D extends BaseDTO> D toDto(E element, ModelMapper mapper) {
        if (element == null) {
            return (D) this;
        }
        return convert(element, mapper);
    }

    @SuppressWarnings("unchecked")
    protected <D extends BaseDTO> D convert(E element, ModelMapper mapper) {
        beforeConversion(element, mapper);
        try {
            mapper.map(element, this);
        } catch (Exception ex) {
            setId(element.getId());
            logger.error("Error mapping", ex);
            return (D) this;
        }
        afterConversion(element, mapper);
        return (D) this;
    }

    public <D extends BaseDTO> List<D> toListDto(Collection<E> elements, ModelMapper mapper) {
        if (elements == null || elements.isEmpty()) {
            return Collections.emptyList();
        }
        return convert(elements, mapper);
    }

    @SuppressWarnings("unchecked")
    protected <D extends BaseDTO> List<D> convert(Collection<E> elements, ModelMapper mapper) {
        return (List<D>) elements.stream().map(element -> {
            try {
                return this.getClass().newInstance().toDto(element, mapper);
            } catch (InstantiationException | IllegalAccessException e) {
                return new BaseDTO<>();
            }
        }).sorted(Comparator.comparing(BaseDTO::getId)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
