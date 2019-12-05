package com.bridgelabz.addressbook;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class AddressBook {
    ObjectMapper mapper=new ObjectMapper();
    private List<Person>personList;
    private String fileName="/home/admin165/Desktop/Priya/AddressBook/src/main/resources/AddressBook.json";

    public int addPerson(String firstName, String lastName, String phoneNumber,String address, String city, String state, String zip) throws IOException {

        Address addressObj=new Address();
        Person personObj=new Person();
        personObj.setFirstName(firstName);
        personObj.setLastName(lastName);
        addressObj.setAddress(address);
        addressObj.setCity(city);
        addressObj.setState(state);
        addressObj.setZip(zip);
        personObj.setAddress(addressObj);
        personObj.setPhoneNumber(phoneNumber);
        personList.add(personObj);

        writeIntoJson(personList);
        return 1;
    }


    public void writeIntoJson(List<Person>personList) throws IOException {

       mapper.writeValue(new File(this.fileName),personList);
   }

   public void readPersonData(String fileName) throws IOException {
       personList=mapper.readValue(new File(this.fileName),new TypeReference<List<Person>>(){});
   }
}
