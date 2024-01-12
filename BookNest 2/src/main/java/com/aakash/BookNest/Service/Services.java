package com.aakash.BookNest.Service;

import com.aakash.BookNest.DTO.BookDTOWithOutId;
import com.aakash.BookNest.DTO.BookDTOWithId;
import com.aakash.BookNest.Exception.ServiceException;

import java.util.List;

public abstract class Services {

    public abstract List<?> getAll() throws ServiceException;

    public abstract Object add(BookDTOWithOutId bookDTO) throws ServiceException;

    public abstract Object get(int id) throws ServiceException;

    public abstract Object update(BookDTOWithId newFieldDTO) throws ServiceException;

    public abstract boolean delete(int id) throws ServiceException;
}
