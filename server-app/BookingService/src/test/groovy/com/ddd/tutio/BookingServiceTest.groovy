package com.ddd.tutio

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class BookingServiceTest extends Specification {

    @Autowired
    private InfoController controller

    def "when context is loaded then all expected beans are created"() {
        expect: "the InfoController is created"
        controller
    }
}
