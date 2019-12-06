package com.bridgelabz.addressbook;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class AddressBookTest {

    @Test
    public void addPerson_inAddressBook_shouldReturnPerson() throws Exception {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        int personData = (int) addressBook.addPerson("Priti", "jadhav", "7066323266", "sector 3", "Washi", "maharastra", "354353");
        Assert.assertEquals(1, personData);
    }

    @Test
    public void givenPersonPhoneNumber_EditPersonMobileNumber_ButPersonPhoneNumberDoesNotExist_ShouldReturnOne() throws Exception {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        int listIndex = addressBook.findPerson("123456789");
        Object result = addressBook.editMobileNumber(listIndex, "7066323266");
        Assert.assertEquals("java.lang.Exception: person phoneNumber not found", result.toString());
    }

    @Test
    public void givenPersonPhoneNumber_EditPersonMobile_ButPersonPhoneNumberDoesNotExit_shouldReturnOne() throws Exception {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        int listIndex = addressBook.findPerson("67678");
        Object result = addressBook.editMobileNumber(listIndex, "7066323266");
        Assert.assertEquals("java.lang.Exception: person phoneNumber not found", result.toString());
    }

    @Test
    public void givePersonPhoneNumber_EditPersonSuccessfully_shouldReturnOne() throws Exception {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        int listIndex = addressBook.findPerson("7066323266");
        int result = (Integer) addressBook.editMobileNumber(listIndex, "9284755415");
        Assert.assertEquals(1, result);
    }

    @Test
    public void givenPersonNumber_EditAddressSuccessfully_shouldReturnOne() throws Exception {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        int listIndex = addressBook.findPerson("7066323266");
        int result = (int) addressBook.editPersonAddress(listIndex, "sector 2", "Washi", "Maharastra", "5456465");
        Assert.assertEquals(1, result);
    }

    @Test
    public void givenPersonPhoneNumber_EditPersonAddress_ButPersonPhoneNumberDoesNotExit_shouldReturnOne() throws Exception {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        int listIndex = addressBook.findPerson("67678");
        Object result = addressBook.editPersonAddress(listIndex, "sector 2", "latur", "Maharastra", "2436453");
        Assert.assertEquals("java.lang.Exception: person phoneNumber not found", result.toString());
    }

    @Test
    public void givenPersonList_sortByLastName_shouldReturnList() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        List<Person> personList = addressBook.sortByLastName();
        Assert.assertEquals("bbb", personList.get(0).getLastName());
    }

    @Test
    public void givenPersonList_sortByZipCode_shouldReturnList() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        List<Person> personList = addressBook.sortByZipCode();
        Assert.assertEquals("12345", personList.get(0).getAddress().getZip());
    }

    @Test
    public void givenPersonPhoneNumber_deletePerson_butPersonPhoneDoesNotExit_shouldReturnOne() throws Exception {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        int listIndex = addressBook.findPerson("123456789");
        Object result = addressBook.deletePersonData(listIndex, "7066323266");
        Assert.assertEquals("java.lang.Exception: person phoneNumber not found", result.toString());
    }

    @Test
    public void givenPersonPhoneNumber_PersonDeletedSuccessfully_shouldReturnOne() throws Exception {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        int listIndex = addressBook.findPerson("7066323266");
        int result = (Integer) addressBook.deletePersonData(listIndex, "7066323266");
        Assert.assertEquals(1, result);
    }

    @Test
    public void createNewAddressBook_shouldreturnFile() throws Exception {
        AddressBookManagement addressBookManagement = new AddressBookManagement();
        String fileName = "aaa";
        try {
            int result = (int) addressBookManagement.createAddressBook(fileName);
        } catch (Exception e) {
            Assert.assertEquals("AddressBook already exit", e.getMessage());
        }

    }

    @Test
    public void openAddressBook_shouldReturnFile() throws Exception {
        AddressBookManagement addressBookManagement=new AddressBookManagement();
        String fileName="priya";
        int result= (Integer) addressBookManagement.openAddressBook(fileName);
        Assert.assertEquals(1,result);
    }

    @Test
    public void openAddressBook_ifFileNotFound() throws Exception {
        AddressBookManagement addressBookManagement=new AddressBookManagement();
        Object result=addressBookManagement.openAddressBook("aaamm");
        Assert.assertEquals("java.lang.Exception: given addressbook does not exist",result.toString());
    }
}