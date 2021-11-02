staff -> management_front_end "Rozpatrywanie podań nauczycieli, weryfikacja użytkowników, rozpatrywanie zgłoszeń użytkowników"
management_front_end -> management_server "" "JSON/HTTPS"
management_server -> message_broker "Publikuj"
management_server -> database "" "JDBC"
