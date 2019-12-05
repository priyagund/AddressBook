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

    public Object addPerson( String firstName, String lastName, String phoneNumber, String address, String city, String state, String zip) throws Exception {
        try {
            Address addressObj = new Address();
            addressObj.setAddress(address);
            addressObj.setCity(city);
            addressObj.setState(state);
            addressObj.setZip(zip);
            Person personObj = new Person();
            personObj.setFirstName(firstName);
            personObj.setLastName(lastName);
            personObj.setPhoneNumber(phoneNumber);
            personObj.setAddress(addressObj);
            personList.add(personObj);
            writeIntoJson(this.personList);
            return 1;
        }catch(Exception e){
            return e;
        }
    }


    public int findPerson(String phoneNumber) {
        int listIndex=-1;
        for(int i=0;i<this.personList.size();i++){

            if(this.personList.get(i).getPhoneNumber().compareTo(phoneNumber)==0){
                listIndex=i;
                break;
            }
        }
        return listIndex;
    }
    public Object editMobileNumber(int listIndex, String newPhoneNumber)  {
        try{
            if(listIndex==-1)
            {
                throw new Exception("person phoneNumber not found");
            }
            this.personList.get(listIndex).setPhoneNumber(newPhoneNumber);
            writeIntoJson(this.personList);
            return 1;
        }catch(Exception e){
            return e;
        }

    }

    public Object editPersonAddress(int listIndex, String address, String city , String state, String zipCode) throws Exception {
        try {
            if (listIndex == -1) {
                throw new Exception("person phoneNumber not found");
            }
                Address addressObj = new Address();
                addressObj.setAddress(address);
                addressObj.setCity(city);
                addressObj.setState(state);
                addressObj.setZip(zipCode);
                this.personList.get(listIndex).setAddress(addressObj);
                writeIntoJson(this.personList);


            return 1;
        }
        catch (Exception e) {
            return e;
        }
    }
    public void writeIntoJson(List<Person>personList) throws IOException {

       mapper.writeValue(new File(this.fileName),personList);
   }

   public void readPersonData(String fileName) throws IOException {
       personList=mapper.readValue(new File(this.fileName),new TypeReference<List<Person>>(){});
   }

}
