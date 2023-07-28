package com.bcrypt.jbCrypt.repos;

import com.bcrypt.jbCrypt.models.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<SiteUser, Long> {

    public SiteUser findSiteUserByUserName(String userName);
}
