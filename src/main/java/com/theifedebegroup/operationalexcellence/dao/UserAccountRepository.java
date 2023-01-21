package com.theifedebegroup.operationalexcellence.dao;

import com.theifedebegroup.operationalexcellence.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

}
