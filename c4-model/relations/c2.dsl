# actors -> systems
student -> client_apps "Wyszukiwanie kursów, zapisy na nie, branie udziału w zajęciach, wystawianie opinii"
tutor -> client_apps "Zarządzanie kursami, prowadzenie zajęć, tworzenie podsumowań"
staff -> management_app "Rozpatrywanie podań nauczycieli, weryfikacja użytkowników, rozpatrywanie zgłoszeń użytkowników"

# inside system
client_apps -> api_server "" "JSON/HTTPS"
api_server -> message_broker "Publikuj"
api_server -> database "" "JDBC"
management_app -> message_broker "Publikuj"
management_app -> database "" "JDBC"

# systems -> external services
client_apps -> web_rtc "WebRTC" "SIP"
web_rtc -> api_server "" "JSON/HTTPS"
api_server -> google_calendar "Komunikacja z API" "JSON/HTTPS"
api_server -> stripe "Komunikacja z API" "JSON/HTTPS"
message_broker -> twilio "Komunikacja z API" "JSON/HTTPS"
