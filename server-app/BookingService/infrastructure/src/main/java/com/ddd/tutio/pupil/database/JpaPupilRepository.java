package com.ddd.tutio.pupil.database;

import com.ddd.tutio.pupil.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface JpaPupilRepository extends JpaRepository<Pupil, UUID> {
}
