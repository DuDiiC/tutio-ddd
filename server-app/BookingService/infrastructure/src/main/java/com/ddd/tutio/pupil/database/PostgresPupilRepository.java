package com.ddd.tutio.pupil.database;

import com.ddd.tutio.pupil.Pupil;
import com.ddd.tutio.pupil.PupilId;
import com.ddd.tutio.pupil.PupilRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PostgresPupilRepository implements PupilRepository {

    private final JpaPupilRepository jpaPupilRepository;

    public PostgresPupilRepository(JpaPupilRepository jpaPupilRepository) {
        this.jpaPupilRepository = jpaPupilRepository;
    }

    @Override
    public Pupil getById(PupilId pupilId) {
        return jpaPupilRepository.getById(pupilId);
    }

    @Override
    public boolean existsById(PupilId pupilId) {
        return jpaPupilRepository.existsById(pupilId);
    }
}
