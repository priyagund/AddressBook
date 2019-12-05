package com.bridgelabz.addressbook;
import org.junit.Assert;
import org.junit.Test;


public class AddressBookTest
{

    @Test
    public void addPerson_inAddressBook_shouldReturnPerson() throws Exception {
        AddressBook addressBook =  new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        int personData= (int) addressBook.addPerson("priya","gund","7066323266","ShahuColony","pune","maharastra","413510");
        Assert.assertEquals(1,personData);
        }

    @Test
    public void givenPersonPhoneNumber_EditPersonMobileNumber_ButPersonPhoneNumberDoesNotExist_ShouldReturnOne() throws Exception {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        int listIndex=addressBook.findPerson("123456789");
        Object result = addressBook.editMobileNumber(listIndex, "7066323266");
        Assert.assertEquals("java.lang.Exception: person phoneNumber not found", result.toString());
    }

    @Test
    public void givenPersonPhoneNumber_EditPersonMobile_ButPersonPhoneNumberDoesNotExit_shouldReturnOne() throws Exception {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        int listIndex=addressBook.findPerson("67678");
        Object result = addressBook.editMobileNumber(listIndex, "7066323266");
        Assert.assertEquals("java.lang.Exception: person phoneNumber not found", result.toString());
    }

    @Test
    public void givePersonPhoneNumber_EditPersonSuccessfully_shouldReturnOne() throws Exception {
        AddressBook addressBook=new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        int listIndex=addressBook.findPerson("7066323266");
        int result = (Integer) addressBook.editMobileNumber(listIndex, "9284755415");
        Assert.assertEquals(1,result);
    }

    @Test
    public void givenPersonNumber_EditAddressSuccessfully_shouldReturnOne() throws Exception {
        AddressBook addressBook=new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        int listIndex=addressBook.findPerson("7066323266");
        int result= (int) addressBook.editPersonAddress(listIndex,"sector 2","Washi","Maharastra","5456465");
        Assert.assertEquals(1,result);
    }
    @Test
    public void givenPersonPhoneNumber_EditPersonAddress_ButPersonPhoneNumberDoesNotExit_shouldReturnOne() throws Exception {
        AddressBook addressBook = new AddressBook();
        addressBook.readPersonData("/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json");
        int listIndex=addressBook.findPerson("67678");
        Object result = addressBook.editPersonAddress(listIndex,"sector 2","latur","Maharastra","2436453");
        Assert.assertEquals("java.lang.Exception: person phoneNumber not found", result.toString());
    }

}
