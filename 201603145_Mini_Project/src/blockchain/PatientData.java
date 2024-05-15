package blockchain;

import java.io.Serializable;
import java.util.Map;

import acsse.csc03a3.Transaction;

/**
 * @author 
 */
public class PatientData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String FirstName;
	private String LastName;
	private String ID;
	private String sex;
	private String previousVisit;
	private String cell;
	private String address;
	private String emergencyContact;
	private String password;
	private String doctor;
	private String DOB;
	private String eFirstName;
	private String eLastName;
	private String reason;
	private String vitals;
	private String temp;
	private String rate;
	private String bp;
	private String weight;
	private String height;
	
	private String data;
	
	private Map<String, String> patientInfo;
	
	public PatientData() {
		
	}
	/**
	 * 
	 * @param fName
	 * @param lName
	 * @param id Should only ever be set once and never change
	 * @param sex
	 * @param cell
	 * @param address
	 * @param emContact
	 */
	public PatientData(String fName, String lName, String id, String sex, String cell, String address, String emContact, 
			String password, String doctor) {
		this.FirstName = fName;
		this.LastName = lName;
		this.ID = id;
		this.sex = sex;
		this.cell = cell;
		this.address = address;
		this.emergencyContact = emContact;
		this.password = password;
		this.doctor = doctor;
	}
	public PatientData(String string) {
		data = string;
	}
	public PatientData(Map<String, String> info) {
		
		patientInfo = info;
		this.FirstName = info.get("first-name");
		this.LastName = info.get("last-name");
		this.eFirstName = info.get("emergency-name");
		this.eLastName = info.get("emergency-last");
		this.emergencyContact = info.get("emergancy-contact");
		this.ID = info.get("id");
		this.sex = info.get("sex");
		this.cell = info.get("contact");
		this.address = info.get("address");
		this.DOB = info.get("Date of birth");
		this.reason = info.get("Reason");
		this.vitals = info.get("Vitals");
		this.temp = info.get("Temp");
		this.rate = info.get("Rate");
		this.bp = info.get("Blood Pressure");
		this.weight = info.get("Weight");
		this.height = info.get("Height");
		this.doctor = info.get("doctor");
	}
	
	public Transaction<PatientData> parseString(String string) {
		PatientData p = null;
		Transaction<PatientData> t = null;
		
		if(string.startsWith("Block{") && string.endsWith("}")) {
			String dataString = string.substring(7, string.length() - 1);

              	// Split the fields string by ", "
                String[] fields = dataString.split(", ");

                // Initialize variables for each field
//                String sender = null;
//                String receiver = null;
//                String data = null;
//                
//                String line = fields[1];
//                if(line.startsWith("transactions=[") && line.endsWith("]")) {
//                	String tranString = line.substring(15, string.length() - 1);
//                	if(tranString.startsWith("Transaction{") && tranString.endsWith("}")) {
//                		String[] innerFields = tranString.split(",");
//                    	
//                    	for(String inner : innerFields) {
//                    		String[] keyValue = inner.split("=");
//                    		String key = keyValue[0];
//                    		String value = keyValue[1];
//                    		
//    	                	switch (key) {
//    	                      case "sender":
//    	                          sender = value;
//    	                          break;
//    	                      case "transaction":
//    	                          receiver = value;
//    	                          break;
//    	                      case "patientCondition":
//    	                          data = value;
//    	                          break;
//    	                	}
//                    	}
//                	}
//                	
//                }
                
                p = new PatientData(data);
        		t = new Transaction<>("", "", p);
		
		
		}
		return t;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String geteFirstName() {
		return eFirstName;
	}
	public void seteFirstName(String eFirstName) {
		this.eFirstName = eFirstName;
	}
	public String geteLastName() {
		return eLastName;
	}
	public void seteLastName(String eLastName) {
		this.eLastName = eLastName;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getVitals() {
		return vitals;
	}
	public void setVitals(String vitals) {
		this.vitals = vitals;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getBp() {
		return bp;
	}
	public void setBp(String bp) {
		this.bp = bp;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public Map<String, String> getPatientInfo() {
		return patientInfo;
	}
	public void setPatientInfo(Map<String, String> patientInfo) {
		this.patientInfo = patientInfo;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
	public String getDoctor() {
		return this.doctor;
	}
	
	public void setMap(Map<String, String> map) {
		patientInfo = map;
	}
	public Map<String, String> getMap(){
		return patientInfo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPreviousVisit() {
		return previousVisit;
	}
	public void setPreviousVisit(String previousVisit) {
		this.previousVisit = previousVisit;
	}
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	
	
	
}
