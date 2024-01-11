package com.aakash.BookNest.Service;

import com.aakash.BookNest.DTO.BookRequestDTO;
import com.aakash.BookNest.DTO.BookResponseDTO;
import com.aakash.BookNest.Exception.ServiceException;
import com.aakash.BookNest.Model.Book;

import java.util.List;

public abstract class Services {

    public abstract List<BookResponseDTO> getAll() throws ServiceException;

    public abstract BookResponseDTO add(BookRequestDTO bookDTO) throws ServiceException;

    public abstract BookResponseDTO get(int id) throws ServiceException;

    public abstract BookResponseDTO update(BookResponseDTO newFieldDTO) throws ServiceException;

    public abstract boolean delete(int id) throws ServiceException;
}
