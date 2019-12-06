package com.bridgelabz.addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class AddressBookTest {

    @Test
    public void addPerson_inAddressBook_shouldReturnPerson() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        int personData = 0;
        try {
            personData = (int) addressBook.addPerson("Priti", "jadhav", "7066323266", "sector 3", "Washi", "maharastra", "354353");
        } catch (Exception e) {
            Assert.assertEquals(1, personData);
        }

    }


    @Test
    public void givenPersonPhoneNumber_EditPersonMobile_ButPersonPhoneNumberDoesNotExit_shouldReturnOne() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");

        try {
            Object result = addressBook.editMobileNumber("67678", "7066323266");
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.INVALID_NUMBER,e.type );
        }

    }

    @Test
    public void givePersonPhoneNumber_EditPersonSuccessfully_shouldReturnOne() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        int result = 0;
        try {
            result = (Integer) addressBook.editMobileNumber("7066323266" ,"9284755415");
        } catch (AddressBookException e) {
            Assert.assertEquals(1, result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenPersonNumber_EditAddressSuccessfully_shouldReturnOne() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        try {
          int result = (Integer) addressBook.editPersonAddress("7066323266", "sector 2", "Washi", "Maharastra", "5456465");
            Assert.assertEquals(1, result);
        } catch (AddressBookException e) {
           e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenPersonPhoneNumber_EditPersonAddress_ButPersonPhoneNumberDoesNotExit_shouldReturnOne() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");

        try {
            Object result = addressBook.editPersonAddress("67678", "sector 2", "latur", "Maharastra", "2436453");
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.INVALID_NUMBER,e.type );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void givenPersonList_sortByLastName_shouldReturnList() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        List<Person> personList = null;
        try {
            personList = addressBook.sortByLastName();
        } catch (IOException e) {
            Assert.assertEquals("bbb", personList.get(0).getLastName());
        }

    }

    @Test
    public void givenPersonList_sortByZipCode_shouldReturnList() throws IOException {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        List<Person> personList = null;
        try {
            personList = addressBook.sortByZipCode();
        } catch (IOException e) {
            Assert.assertEquals("12345", personList.get(0).getAddress().getZip());
        }

    }


    @Test
    public void givenPersonPhoneNumber_PersonDeletedSuccessfully_shouldReturnOne() throws Exception {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        int listIndex = addressBook.findPerson("7066323266");
        try {
            int result = (Integer) addressBook.deletePersonData(listIndex, "7066323266");
            Assert.assertEquals(1, result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void createNewAddressBook_shouldreturnFile(){
        AddressBookManagement addressBookManagement = new AddressBookManagement();
        String fileName = "UP";
        try {
            int result = (int) addressBookManagement.createAddressBook(fileName);
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.FILE_ALREADY_EXIST,e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void openAddressBook_shouldReturnObject() {
        AddressBookManagement addressBookManagement = new AddressBookManagement();
        AddressBook result = null;
        try {
            result = addressBookManagement.openAddressBook("MH");
        } catch (Exception e) {
            Assert.assertTrue(result instanceof AddressBook);
        }

    }

    @Test
    public void openAddressBook_ifAddressBookNotFound_throwException()
    {
        AddressBookManagement addressBookManagement=new AddressBookManagement();
        try {
            addressBookManagement.openAddressBook("ABC");
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.FILE_NOT_FOUND,e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveAddressBook_ifSaveReturn_returnOne() throws Exception {
        AddressBookManagement addressBookManagement = new AddressBookManagement();
        Object person = addressBookManagement.openAddressBook("aaa");
        int result = 0;
        try {
            result = (int) addressBookManagement.saveAddressBook(person);
        } catch (Exception e) {
            Assert.assertEquals(1, result);

        }
    }

    @Test
    public void saveAddressBook_ifAddressBookNotFound_throwException()
    {
        AddressBookManagement addressBookManagement=new AddressBookManagement();
        try {
            addressBookManagement.openAddressBook("xyz");
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.FILE_NOT_FOUND,e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}