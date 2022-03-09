# actors -> systems
student -> client_apps "wyszukiwanie kursów, dokonywanie rezerwacji, branie udziału w zajęciach, wystawianie opinii"
tutor -> client_apps "zarządzanie kursami, prowadzenie zajęć, tworzenie podsumowań"
staff -> management_app "rozpatrywanie podań nauczycieli, weryfikacja użytkowników, rozpatrywanie zgłoszeń"

# inside system
client_apps -> api_server "" "JSON/HTTPS"
api_server -> message_broker ""
api_server -> database "" "JDBC"
management_app -> message_broker ""
management_app -> database "" "JDBC"
client_apps -> web_rtc "WebRTC" "SIP"
web_rtc -> api_server "" "JSON/HTTPS"

# systems -> external services
api_server -> google_calendar "integracja z API" "JSON/HTTPS"
api_server -> stripe "integracja z API" "JSON/HTTPS"
message_broker -> twilio "integracja z API" "JSON/HTTPS"
