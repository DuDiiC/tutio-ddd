# actors -> client apps
student -> student_front_end "wyszukiwanie kursów, dokonywanie rezerwacji, branie udziału w zajęciach, wystawianie opinii"
student -> student_mobile "wyszukiwanie kursów, dokonywanie rezerwacji, branie udziału w zajęciach, wystawianie opinii"
tutor -> tutor_front_end "zarządzanie kursami, prowadzenie zajęć, tworzenie podsumowań"
tutor -> tutor_mobile "zarządzanie kursami, prowadzenie zajęć, tworzenie podsumowań"

# client_apps -> WebRTC
student_front_end -> web_rtc "WebRTC" "SIP"
student_mobile -> web_rtc "WebRTC" "SIP"
tutor_front_end -> web_rtc "WebRTC" "SIP"
tutor_mobile -> web_rtc "WebRTC" "SIP"

# client_apps -> api_server
student_front_end -> api_server "" "JSON/HTTPS"
student_mobile -> api_server "" "JSON/HTTPS"
tutor_front_end -> api_server "" "JSON/HTTPS"
tutor_mobile -> api_server "" "JSON/HTTPS"

# WebRTC -> api_server
web_rtc -> api_server "" "JSON/HTTPS"
