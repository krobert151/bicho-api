package com.robertorebolledonaharro.bichoapi.savedlist.repo;

import com.robertorebolledonaharro.bichoapi.savedlist.model.SavedList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SavedListResponse extends JpaRepository<SavedList, UUID> {
}
