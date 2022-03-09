staff -> management_front_end "rozpatrywanie podań nauczycieli, weryfikacja użytkowników, rozpatrywanie zgłoszeń"
management_front_end -> management_server "" "JSON/HTTPS"
management_server -> message_broker ""
management_server -> database "" "JDBC"
