package com.bankingapp.fundtransferservice.model.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

abstract class Mapper<E, D> {
    public abstract E mapToEntity(D dto);

    public abstract D mapToDto(E entity);

    public Collection<E> mapToEntity(Collection<D> dtoList) {
        return dtoList.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    public Collection<D> mapToDto(Collection<E> dtoList) {
        return dtoList.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public List<E> mapToEntityList(Collection<D> dtoList) {
        return dtoList.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    public List<D> mapToDtoList(Collection<E> dtoList) {
        return dtoList.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public Set<E> mapToEntitySet(Collection<D> dtoList) {
        return dtoList.stream().map(this::mapToEntity).collect(Collectors.toSet());
    }

    public Set<D> mapToDtoSet(Collection<E> dtoList) {
        return dtoList.stream().map(this::mapToDto).collect(Collectors.toSet());
    }
}
