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

    public List <Person>sortByLastName() throws IOException {
        for(int i=0;i<this.personList.size()-1;i++){
            for(int j=0;j<this.personList.size()-i-1;j++){
                if(this.personList.get(j).getLastName().compareTo(this.personList.get(j+1).getLastName())>0){
                    Person temp=this.personList.get(j);
                    this.personList.set(j,this.personList.get(j+1));
                    this.personList.set(j+1,temp);
                }
            }
        }
        writeIntoJson(this.personList);
        return this.personList;

    }

    public List <Person>sortByZipCode() throws IOException {
        for(int i=0;i<this.personList.size()-1;i++){
            for(int j=0;j<this.personList.size()-i-1;j++)
            {
              if(this.personList.get(j).getAddress().getZip().compareTo(this.personList.get(j+1).getAddress().getZip())>0) {
                    Person temp=this.personList.get(j);
                    this.personList.set(j,this.personList.get(j+1));
                    this.personList.set(j+1,temp);
            }
            }
        }
        writeIntoJson(this.personList);
        return this.personList;
    }


    public Object deletePersonData(int listIndex,String phoneNumber) throws Exception {
        try{
            listIndex=this.findPerson(phoneNumber);
        if (listIndex == -1) {
            throw new Exception("person phoneNumber not found");
        }
            this.personList.remove(listIndex);
        writeIntoJson(this.personList);
        return 1;
    }catch(Exception e){
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
