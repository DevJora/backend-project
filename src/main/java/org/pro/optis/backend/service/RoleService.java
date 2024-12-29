package org.pro.optis.backend.service;

import org.pro.optis.backend.TypeRole;
import org.pro.optis.backend.bo.Role;
import org.pro.optis.backend.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    Role findRoleByName(TypeRole roleName){
        return this.roleRepository.findByRole(roleName).orElse(null);
    }

    void modifyRoleAccordingToLicence(String Licence, Role role){
        if(Licence.equals("TRIAL")){
        }
        if(Licence.equals("SINGLE")){
        }
        if(Licence.equals("MULTI")){
        }
    }
}
