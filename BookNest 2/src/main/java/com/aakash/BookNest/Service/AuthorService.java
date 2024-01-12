package com.aakash.BookNest.Service;

import com.aakash.BookNest.Converter.AuthorConvert;
import com.aakash.BookNest.DAO.AuthorDao;
import com.aakash.BookNest.DTO.*;
import com.aakash.BookNest.Exception.ServiceException;
import com.aakash.BookNest.Model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorDao authorDao;

    @Autowired
    AuthorConvert authorConvert;
    public List<AuthorDTOWithId> getAll() throws ServiceException {
       List<Author> authorList =  authorDao.findAll();
       List<AuthorDTOWithId> result = new ArrayList<>();
       for (Author i:authorList){
           result.add(authorConvert.authorToAuthorDTOWithId(i));
       }
        return result;
    }


    public AuthorDTOWithId add(AuthorDTOWithOutId bookDTO) throws ServiceException {
        Author author =authorConvert.authorDTOWithOutIdToAuthor(bookDTO);
        return authorConvert.authorToAuthorDTOWithId( authorDao.save(author));


    }


    public Author getByName(String name)  {

        return authorDao.findByname(name);
    }


    public AuthorDTOWithId update(AuthorDTOWithId newFieldDTO) throws ServiceException {
        Author newAuthor = authorConvert.authorDTOWithIdToAuthor(newFieldDTO);
        Author oldAuthor = authorDao.getOne(newAuthor.getId());

        if(oldAuthor!=null)
        {
            if(nullCheck(newAuthor.getName())) {
                oldAuthor.setName(newAuthor.getName());
            }
        }

        return authorConvert.authorToAuthorDTOWithId(authorDao.save(oldAuthor));
    }


    public boolean delete(long id) throws ServiceException {
        try{
            authorDao.deleteById(id);
            return true;
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public boolean existByName(String name) throws ServiceException{
      try {
          return authorDao.existsByname(name);
      }catch (Exception e){
          throw new ServiceException(e.getMessage());
      }
    }

    private boolean nullCheck(String str) {
        return str != null && !str.isEmpty();
    }
}
