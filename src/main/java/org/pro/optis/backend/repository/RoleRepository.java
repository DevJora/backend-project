package org.pro.optis.backend.repository;

import org.pro.optis.backend.TypeRole;
import org.pro.optis.backend.bo.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByRole(TypeRole role);


}
