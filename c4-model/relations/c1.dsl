# actors -> tutio
student -> tutio "Wyszukiwanie kursów, zapisy na nie, branie udziału w zajęciach, wystawianie opinii"
tutor -> tutio "Zarządzanie kursami, prowadzenie zajęć, tworzenie podsumowań"
staff -> tutio "Rozpatrywanie podań nauczycieli, weryfikacja użytkowników, rozpatrywanie zgłoszeń użytkowników"

# tutio -> external services
tutio -> stripe "Komunikacja z API" "JSON/HTTPS"
tutio -> twilio "Komunikacja z API" "JSON/HTTPS"
tutio -> google_calendar "Komunikacja z API" "JSON/HTTPS"
tutio -> web_rtc "WebRTC" "SIP"
web_rtc -> tutio "" "JSON/HTTPS"
