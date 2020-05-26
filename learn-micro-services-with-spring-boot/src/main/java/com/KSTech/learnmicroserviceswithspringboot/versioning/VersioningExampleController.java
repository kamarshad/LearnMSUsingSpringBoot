package com.KSTech.learnmicroserviceswithspringboot.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningExampleController {

    // URI versioning example
    @GetMapping("/v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("Mohad Kamar Shad");
    }
    @GetMapping("/v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("Mohd", "Kamar"));
    }

    // Param versioning example
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 getPersonParamV1() {
        return new PersonV1("Mohad Kamar Shad");
    }
    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 getPersonParamV2() {
        return new PersonV2(new Name("Mohd", "Kamar Shad"));
    }

    // Header versioning example
    @GetMapping(value = "/person/header", headers = "ACCEPT_VERSION=1")
    public PersonV1 getPersonHeaderV1() {
        return new PersonV1("Kamar Shad");
    }
    @GetMapping(value = "/person/ACCEPT_VERSION=2")
    public PersonV2 getPersonHeaderV2() {
        return new PersonV2(new Name("Mohd", "Kamar Shad"));
    }
}
