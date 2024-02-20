package com.robertorebolledonaharro.bichoapi.userdata.repository;

import com.robertorebolledonaharro.bichoapi.userdata.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserDataRepository extends JpaRepository<UserData, UUID> {
}
