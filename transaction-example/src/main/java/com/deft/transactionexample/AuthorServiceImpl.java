package com.deft.transactionexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public void updateAuthorName(Long id, String name) {
        Author author = authorRepository.findById(id).orElse(null);
        author.setName(name);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void updateAuthorNameSupport(Long id, String name) {
        Author author = authorRepository.findById(id).orElse(null);
        author.setName(name);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void updateAuthorNameMandatory(Long id, String name) {
        Author author = authorRepository.findById(id).orElse(null);
        author.setName(name);
    }


    @Override
    @Transactional
    public void updateAuthorNameRequireNew(Long id, String name) {
        Author author = authorRepository.findById(id).orElse(null);
        updateAnotherAuthor(2L, "new name");
        author.setName(name);
        throw new RuntimeException("no way");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)

    public void updateAnotherAuthor(Long id, String name) {
        Author author = authorRepository.findById(id).orElse(null);
        author.setName(name);

    }

    @Override
    @Transactional(readOnly = true)
    public Author getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        return author;
    }

    @Override
    @Transactional
            (rollbackFor = Throwable.class,
                    noRollbackFor = EntityNotFoundException.class)
    public void updateAuthorWithRollbackCustom(Long id, String name) {
        Author author = authorRepository.findById(id).orElse(null);
        author.setName(name);
    }

}
