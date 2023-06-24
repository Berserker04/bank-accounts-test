package com.bank.person;


import com.bank.person.properties.Address;
import com.bank.person.properties.Gender;
import com.bank.person.properties.CellPhone;
import com.bank.person.properties.Identification;
import com.bank.person.properties.Name;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private Address address;
    private CellPhone cellPhone;
    private Gender gender;
    private Identification adIdentification;
    private Name name;

    public Person(Address address, CellPhone cellPhone, Gender gender, Identification adIdentification, Name name) {
        this.address = address;
        this.cellPhone = cellPhone;
        this.gender = gender;
        this.adIdentification = adIdentification;
        this.name = name;
    }
}
