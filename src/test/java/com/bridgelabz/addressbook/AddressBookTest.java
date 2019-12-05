package com.bridgelabz.addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AddressBookTest
{

    @Test
    public void addPerson_inAddressBook_shouldReturnPerson() throws IOException {
        AddressBook addressBook =  new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        int personData=addressBook.addPerson("priya","gund","7066323266","ShahuColony","latur","maharastra","413510");
        Assert.assertEquals(1,personData);
        }
}
