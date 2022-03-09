# components -> api_gateway
client_apps -> api_gateway "" "JSON/HTTPS"
web_rtc -> api_gateway "" "JSON/HTTPS"
security_ms -> api_gateway "JWT"

# api gateway -> microservices
api_gateway -> security_ms "żądanie uwierzytelnienia"
api_gateway -> registration_ms
api_gateway -> booking_ms
api_gateway -> meetings_ms
api_gateway -> reviews_ms
api_gateway -> courses_management_ms
api_gateway -> tutor_profile_management
api_gateway -> searching_ms
api_gateway -> calendar_ms
api_gateway -> chat_ms

# microservices -> message_broker
registration_ms -> message_broker
booking_ms -> message_broker
meetings_ms -> message_broker
reviews_ms -> message_broker
courses_management_ms -> message_broker
tutor_profile_management -> message_broker
payment_ms -> message_broker
calendar_ms -> message_broker
chat_ms -> message_broker

# microservices -> database
security_ms -> database
registration_ms -> database
booking_ms -> database
meetings_ms -> database
reviews_ms -> database
courses_management_ms -> database
tutor_profile_management -> database
searching_ms -> database
calendar_ms -> database

# microservices -> external services
calendar_ms -> google_calendar "integracja z API" "JSON/HTTPS"
payment_ms -> stripe "integracja z API" "JSON/HTTPS"