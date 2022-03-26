INSERT INTO booking.tutors(tutor_id, name, surname)
VALUES ('35d9c736-f6bc-4ce8-b2df-914d9f4ad0bf', 'Adam', 'Nowak');

INSERT INTO booking.courses(course_id, course_name, course_description, tutor_id)
VALUES ('f1c02c6c-6e8f-4091-b449-87524d972abd', 'Matematyka - poziom podstawowy',
        'Kurs dla uczniów szkół podstawowych mających problemy z matematyką', '35d9c736-f6bc-4ce8-b2df-914d9f4ad0bf');
INSERT INTO booking.courses(course_id, course_name, course_description, tutor_id)
VALUES ('044c25c6-d53d-4a56-b7ae-1fe8681100c5', 'Matematyka - poziom rozszerzony',
        'Kurs dla uczniów szkół podstawowych i ponadpodstawowych chcących rozwijać swoje zainteresowania związane z matematyką',
        '35d9c736-f6bc-4ce8-b2df-914d9f4ad0bf');

INSERT INTO booking.pupils(pupil_id, name, surname)
VALUES ('bcc1e6c1-fe3c-408a-b667-af97abd01221', 'Kamil', 'Kowalski');

INSERT INTO booking.bookings(booking_id, booking_status, meeting_start_time, meeting_end_time, lesson_price, currency, course_id, pupil_id)
VALUES ('0175a846-3baf-40b9-a5a0-eece49179278', 'TEMPLATE', '2022-04-15 9:30:00', '2022-04-15 11:00:00', '60.00'::float8::numeric::money, 'PLN',
        'f1c02c6c-6e8f-4091-b449-87524d972abd', 'bcc1e6c1-fe3c-408a-b667-af97abd01221');
INSERT INTO booking.bookings(booking_id, booking_status, meeting_start_time, meeting_end_time, lesson_price, currency, course_id, pupil_id)
VALUES ('a8b7d555-368a-4eca-8d88-d341c7041a8d', 'PLANNED', '2022-03-20 9:30:00', '2022-03-20 10:45:00', '50.00'::float8::numeric::money, 'PLN',
        'f1c02c6c-6e8f-4091-b449-87524d972abd', 'bcc1e6c1-fe3c-408a-b667-af97abd01221');
INSERT INTO booking.bookings(booking_id, booking_status, meeting_start_time, meeting_end_time, lesson_price, currency, course_id, pupil_id)
VALUES ('f3724b4a-e705-4425-8d71-610bf7b91adb', 'APPROVED', '2022-03-10 9:00:00', '2022-03-10 10:00:00', '40.00'::float8::numeric::money, 'PLN',
        'f1c02c6c-6e8f-4091-b449-87524d972abd', 'bcc1e6c1-fe3c-408a-b667-af97abd01221');
INSERT INTO booking.bookings(booking_id, booking_status, meeting_start_time, meeting_end_time, lesson_price, currency, course_id, pupil_id)
VALUES ('5a260660-be15-45c2-970d-f1124fe65c7a', 'ACCEPTED', '2022-03-07 9:00:00', '2022-03-07 10:00:00', '40.00'::float8::numeric::money, 'PLN',
        'f1c02c6c-6e8f-4091-b449-87524d972abd', 'bcc1e6c1-fe3c-408a-b667-af97abd01221');
INSERT INTO booking.bookings(booking_id, booking_status, meeting_start_time, meeting_end_time, lesson_price, currency, course_id, pupil_id)
VALUES ('20e505cc-9e51-4200-b9b9-329ded2df54d', 'CANCELED', null, null, '40.00'::float8::numeric::money, 'PLN',
        'f1c02c6c-6e8f-4091-b449-87524d972abd', 'bcc1e6c1-fe3c-408a-b667-af97abd01221');
