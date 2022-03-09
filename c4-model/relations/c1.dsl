# actors -> tutio
student -> tutio "wyszukiwanie kursów, dokonywanie rezerwacji, branie udziału w zajęciach, wystawianie opinii"
tutor -> tutio "zarządzanie kursami, prowadzenie zajęć, tworzenie podsumowań"
staff -> tutio "rozpatrywanie podań nauczycieli, weryfikacja użytkowników, rozpatrywanie zgłoszeń"

# tutio -> external services
tutio -> stripe "integracja z API" "JSON/HTTPS"
tutio -> twilio "integracja z API" "JSON/HTTPS"
tutio -> google_calendar "integracja z API" "JSON/HTTPS"
