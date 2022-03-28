CREATE TABLE IF NOT EXISTS booking.tutors
(
    tutor_id       UUID PRIMARY KEY,
    name           VARCHAR(50)  NOT NULL,
    surname        VARCHAR(100) NOT NULL,
    db_create_time TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    db_modify_time TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS booking.courses
(
    course_id          UUID PRIMARY KEY,
    course_name        VARCHAR(100) NOT NULL,
    course_description TEXT         NOT NULL,
    tutor_id           UUID         NOT NULL,
    db_create_time     TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    db_modify_time     TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_course_tutor FOREIGN KEY (tutor_id)
        REFERENCES booking.tutors (tutor_id)
);

CREATE TABLE IF NOT EXISTS booking.pupils
(
    pupil_id       UUID PRIMARY KEY,
    name           VARCHAR(50)  NOT NULL,
    surname        VARCHAR(100) NOT NULL,
    db_create_time TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    db_modify_time TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS booking.bookings
(
    booking_id         UUID PRIMARY KEY,
    booking_status     VARCHAR(50)                 DEFAULT 'TEMPLATE' NOT NULL,
    meeting_start_time TIMESTAMP WITHOUT TIME ZONE,
    meeting_end_time   TIMESTAMP WITHOUT TIME ZONE,
    lesson_price       MONEY                                          NOT NULL,
    currency           VARCHAR(3)                                     NOT NULL,
    course_id          UUID                                           NOT NULL,
    pupil_id           UUID                                           NOT NULL,
    db_create_time     TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    db_modify_time     TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_booking_course FOREIGN KEY (course_id)
        REFERENCES booking.courses (course_id),
    CONSTRAINT fk_booking_pupil FOREIGN KEY (pupil_id)
        REFERENCES booking.pupils (pupil_id)
);

CREATE TABLE IF NOT EXISTS booking.meetings
(
    meeting_id         UUID PRIMARY KEY,
    meeting_status     VARCHAR(50)                 NOT NULL,
    meeting_cost       MONEY                       NOT NULL,
    meeting_start_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    meeting_end_time   TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    currency           VARCHAR(3)                  NOT NULL,
    booking_id         UUID                        NOT NULL,
    course_id          UUID                        NOT NULL,
    pupil_id           UUID                        NOT NULL,
    db_create_time     TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    db_modify_time     TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_meeting_booking FOREIGN KEY (booking_id)
        REFERENCES booking.bookings (booking_id),
    CONSTRAINT fk_meeting_course FOREIGN KEY (course_id)
        REFERENCES booking.courses (course_id),
    CONSTRAINT fk_meeting_pupil FOREIGN KEY (pupil_id)
        REFERENCES booking.pupils (pupil_id)
);

CREATE OR REPLACE FUNCTION update_modify_time_column()
    RETURNS TRIGGER AS
$$
BEGIN
    NEW.db_modify_time = now();
    RETURN NEW;
END;
$$ language 'plpgsql';

CREATE TRIGGER tr_update_modify_time_tutors
    BEFORE UPDATE
    ON booking.tutors
    FOR EACH ROW
EXECUTE PROCEDURE update_modify_time_column();

CREATE TRIGGER tr_update_modify_time_courses
    BEFORE UPDATE
    ON booking.courses
    FOR EACH ROW
EXECUTE PROCEDURE update_modify_time_column();

CREATE TRIGGER tr_update_modify_time_pupils
    BEFORE UPDATE
    ON booking.pupils
    FOR EACH ROW
EXECUTE PROCEDURE update_modify_time_column();

CREATE TRIGGER tr_update_modify_time_bookings
    BEFORE UPDATE
    ON booking.bookings
    FOR EACH ROW
EXECUTE PROCEDURE update_modify_time_column();

CREATE TRIGGER tr_update_modify_time_meetings
    BEFORE UPDATE
    ON booking.meetings
    FOR EACH ROW
EXECUTE PROCEDURE update_modify_time_column();
