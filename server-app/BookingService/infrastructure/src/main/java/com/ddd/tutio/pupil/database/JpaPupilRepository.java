package com.ddd.tutio.pupil.database;

import com.ddd.tutio.pupil.Pupil;
import com.ddd.tutio.pupil.PupilId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface JpaPupilRepository extends JpaRepository<Pupil, PupilId> {
}
