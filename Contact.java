public class Contact {
     
    private String contactName;
    private String contactNumber;
    private boolean isFavorit;

//  class Constrctor
    public Contact(String contactName, String contantNumber){
        this.contactName   = contactName;
        this.contactNumber = contantNumber;
        this.isFavorit  = false; 

    }

//  name getter
    public String getName(){
        return contactName;
    }

//  name setter
    public void setName(String name){
        this.contactName = name;
    }

//  number getter
    public String getNumber(){
        return contactNumber;
    }

//  number setter
    public void setNumber(String number){
        this.contactNumber = number;
    }

//  isFavorit getter
public boolean getFavourite(){
    return isFavorit;
}
//  isFavorite setter
public void setFavourite(boolean b){
    isFavorit = b;
}

public String toString(){
    return "Name: " + this.getName() + "\n" +"Number: "+ this.getNumber();
}

}
