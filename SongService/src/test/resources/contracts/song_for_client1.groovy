package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description "Should return song by id=1"

    request {
        url "/songs/1"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                "id": "1",
                "artist": "Die Antwort",
                "name": "Name",
                "album": "Gamer",
                "year": "2009"
        )
    }
}