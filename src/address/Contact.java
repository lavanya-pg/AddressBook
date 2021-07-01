package address;

public class Contact
{
	public Contact() {}
	
	String firstName, lastName, address, city, state, email;
	    long phoneNumber, zipCode;
	     
	    public Contact(String firstName, String lastName, String address, String city, String state, String email, long phoneNumber, long zipCode)
	    {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.address = address;
	        this.city = city;
	        this.state = state;
	        this.email = email;
	        this.phoneNumber = phoneNumber;
	        this.zipCode = zipCode;
	    }
	        
		public String getFirstName()
		{
	        return firstName;
	    }
	
	    public void setFirstName(String firstName)
	    {
	        this.firstName = firstName;
	    }
	    public String getLastName()
	    {
	        return lastName;
	    }
	
	    public void setLastName(String lastName)
	    {
	        this.lastName = lastName;
	    }
	
	    public String getAddress() 
	    {
	        return address;
	    }
	
	    public void setAddress(String address)
	    {
	        this.address = address;
	    }
	
	    public String getCity()
	    {
	        return city;
	    }
	
	    public void setCity(String city) 
	    {
	    	this.city = city;
	    }
	
	    public String getState() 
	    {
	        return state;
	    }
	
	    public void setState(String state)
	    {
	        this.state = state;
	    }
	
	    public String getEmail() 
	    {
	        return email;
	    }
	
	    public void setEmail(String email)
	    {
	        this.email = email;
	    }
	
	    public long getPhoneNumber()
	    {
	        return phoneNumber;
	    }
	
	    public void setPhoneNumber(long phoneNumber)
	    {
	    	this.phoneNumber = phoneNumber;
	    }
	
	    public long getZipCode()
	    {
	        return zipCode;
	    }
	
	    public void setZipCode(long zipCode)
	    {
	        this.zipCode = zipCode;
	    }
	 
	

}
