package com.robertorebolledonaharro.bichoapi.media.repository;

import com.robertorebolledonaharro.bichoapi.media.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MediaRepository extends JpaRepository<Media, UUID> {
}
