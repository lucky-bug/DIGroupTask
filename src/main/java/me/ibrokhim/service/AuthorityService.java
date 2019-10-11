package me.ibrokhim.service;

import me.ibrokhim.entity.Authority;
import me.ibrokhim.repository.AuthorityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {
    private final AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public List<Authority> getAll() {
        return authorityRepository.findAll();
    }

    public Authority getById(int id) {
        return authorityRepository.getOne(id);
    }

    public Authority insert(Authority authority) {
        return authorityRepository.save(authority);
    }

    public Authority update(Authority authority) {
        return authorityRepository.save(authority);
    }

    public Authority delete(int id) {
        Authority authority = authorityRepository.getOne(id);

        if (authority != null) {
            authorityRepository.delete(authority);
        }

        return null;
    }
}
