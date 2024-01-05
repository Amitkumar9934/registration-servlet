package registration_model;

public interface DAOService {
	//Abstract method
	public void connectDB();
	public boolean verifyLogin(String email,String password);
	public void saveRegistration(String name,String city,String email,String mobile);
	public void updateRegistration(String email, String mobile);
}
