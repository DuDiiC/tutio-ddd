student -> student_front_end "Wyszukiwanie kursów, zapisy na nie, branie udziału w zajęciach, wystawianie opinii"
student -> student_mobile "Wyszukiwanie kursów, zapisy na nie, branie udziału w zajęciach, wystawianie opinii"

tutor -> tutor_front_end "Zarządzanie kursami, prowadzenie zajęć, tworzenie podsumowań"
tutor -> tutor_mobile "Zarządzanie kursami, prowadzenie zajęć, tworzenie podsumowań"

staff -> management_front_end "Rozpatrywanie podań nauczycieli, weryfikacja użytkowników, rozpatrywanie zgłoszeń użytkowników"

student_front_end -> streaming_server "WebRTC [protokół SIP]"
student_mobile -> streaming_server "WebRTC [protokół SIP]"
tutor_front_end -> streaming_server "WebRTC [protokół SIP]"
tutor_mobile -> streaming_server "WebRTC [protokół SIP]"

student_front_end -> api_gateway "[JSON/HTTPS]"
student_mobile -> api_gateway "[JSON/HTTPS]"
tutor_front_end -> api_gateway "[JSON/HTTPS]"
tutor_mobile -> api_gateway "[JSON/HTTPS]"
streaming_server -> api_gateway "[JSON/HTTPS]"
authentication_ms -> api_gateway "JWT"

management_front_end -> management_server "[JSON/HTTPS]"

message_broker -> notification_server "Żądanie wyłania powiadomień"

api_gateway -> authentication_ms "Żądanie uwierzytelnienia"
api_gateway -> registration_ms ""
api_gateway -> booking_ms ""
api_gateway -> courses_management_ms ""
api_gateway -> meetings_ms ""
api_gateway -> reviews_ms ""
meetings_ms -> reviews_ms ""

registration_ms -> message_broker "Publikuj"
authentication_ms -> message_broker "Publikuj"
booking_ms -> message_broker "Publikuj"
meetings_ms -> message_broker "Publikuj"
reviews_ms -> message_broker "Publikuj"
management_server -> message_broker "Publikuj"

api_server -> payment_service "Komunikacja z API" "JSON/HTTPS"

api_server -> google_calendar "Komunikacja z API" "JSON/HTTPS"

api_server -> database "[JDBC]"
management_server -> database "[JDBC]"