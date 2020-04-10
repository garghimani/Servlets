package assign.dbaccess;

import java.util.ArrayList;

import assign.validation.EMailValidation;

 
/**
 * 
 * EMailBO
 *
 */

public class EMailBO {
 
	/**
	 * No Argument Constructor
	 */
	public EMailBO() {
		super();
	}

	public EMailAddressVOO getEMailAddress(String inEMailID) throws EMailValidationException, Exception{

		EMailAddressVOO eMailAddress = null;
		StringBuffer allMessages = new StringBuffer();
		//validation
		EMailValidation eMailValidation = new EMailValidation();
		allMessages.append(eMailValidation.validateEmailAddress(inEMailID));
		if (allMessages.length() == 0){
			//database insert
			EMailDBAccess eMailDBAccess = new EMailDBAccess();
			eMailAddress = eMailDBAccess.getEMailAddress(inEMailID);
		}
		else{
			  throw new EMailValidationException(allMessages.toString());
		}
		return eMailAddress;
	}




	public void addEMailAddress(EMailAddressVOO inEMailAddressVO) throws EMailValidationException, Exception{
		StringBuffer allMessages = new StringBuffer();
		//2a: validation
		EMailValidation eMailValidation = new EMailValidation();
		String errorMsg = eMailValidation.validateEmailAddress(inEMailAddressVO.geteMailID());
		//emailaddress
		allMessages.append(errorMsg);
		//firstname
		errorMsg = eMailValidation.validateFirstName(inEMailAddressVO.getfName());
		allMessages.append(errorMsg);
		//lastname
		//remaining fields
		
		
		
		//2b: no error from validation, call db component
		if (allMessages.length() == 0){
			EMailDBAccess eMailDBAccess = new EMailDBAccess();
			eMailDBAccess.addEMailAddress(inEMailAddressVO);
		}
		//if error return to controller
		else{
			 EMailValidationException emailValidationException = new EMailValidationException(allMessages.toString());
			 throw emailValidationException;
		}
		return;
	}


	public void deleteEMailAddress(String inEMailID) throws EMailValidationException, Exception{
		StringBuffer allMessages = new StringBuffer();
		EMailAddressVOO eMailAddress = null;
		EMailValidation eMailValidation = new EMailValidation();
		allMessages.append(eMailValidation.validateEmailAddress(inEMailID));
		if (allMessages.length() == 0){
			EMailDBAccess eMailDBAccess = new EMailDBAccess();
			eMailDBAccess.deleteEMailAddress(inEMailID);
		}
		else{
			throw new EMailValidationException(allMessages.toString());
		}
		return;
	}



	public void updateEMailAddress(EMailAddressVOO inEMailAddress) throws EMailValidationException, Exception{
		StringBuffer allMessages = new StringBuffer();
		EMailAddressVOO eMailAddress = null;
		EMailValidation eMailValidation = new EMailValidation();
		allMessages.append(eMailValidation.validateEmailAddress(inEMailAddress.geteMailID()));
		if (allMessages.length() == 0){
			EMailDBAccess eMailDBAccess = new EMailDBAccess();
			eMailDBAccess.updateEMailAddress(inEMailAddress);
		}
		else{
			throw new EMailValidationException(allMessages.toString());
		}
		return;
	}
	
	//Added by Himani
	public void updateEMailAddressPhone(String inEMailAddress, String inWPhone, String inMPhone) throws EMailValidationException, Exception{
		StringBuffer allMessages = new StringBuffer();
		EMailAddressVOO eMailAddress = null;
		EMailValidation eMailValidation = new EMailValidation();
		allMessages.append(eMailValidation.validateEmailAddress(inEMailAddress));
		if (allMessages.length() == 0){
			System.out.println("Inside BO : "+inEMailAddress+"  "+inWPhone+"  "+inMPhone);
			EMailDBAccess eMailDBAccess = new EMailDBAccess();
			eMailDBAccess.updateEmailAddressPhone(inEMailAddress, inWPhone, inMPhone);
		}
		else{
			throw new EMailValidationException(allMessages.toString());
		}
		return;
	}
    //End Add by Himani


	public ArrayList getAllEMailAddressList() throws EMailValidationException, Exception{
		EMailDBAccess eMailDBAccess = new EMailDBAccess();
		ArrayList eMailList = eMailDBAccess.getAllEMailAdressEntries();
		return eMailList;
	}



	public ArrayList getAllEMailAddressListbyGroup(String inEmailAddress) throws EMailValidationException, Exception{
		EMailDBAccess eMailDBAccess = new EMailDBAccess();
		System.out.println("Inside BO : "+inEmailAddress);//Added by Himani
		ArrayList eMailList = eMailDBAccess.getAllEMailAdressEntriesbyGroup(inEmailAddress);
		return eMailList;
	}


//Group Calls

	public Group getGroup(String inGroup) throws EMailValidationException, Exception{
		EMailDBAccess eMailDBAccess = new EMailDBAccess();
		Group group = eMailDBAccess.getGroup(inGroup);
		return group;
	} 

	public void addGroup(Group inGroup) throws EMailValidationException, Exception{
		EMailDBAccess eMailDBAccess = new EMailDBAccess();
		eMailDBAccess.addGroup(inGroup);
		return;
	}

	public void updateGroup(Group inGroup) throws EMailValidationException, Exception{
		EMailDBAccess eMailDBAccess = new EMailDBAccess();
		eMailDBAccess.updateGroup(inGroup);
		return;
	}

	public void deleteGroup(String inGroupID) throws EMailValidationException, Exception{
		EMailDBAccess eMailDBAccess = new EMailDBAccess();
		eMailDBAccess.deleteGroup(inGroupID);
		return;
	}

	public ArrayList getAllGroups() throws EMailValidationException, Exception{
		EMailDBAccess eMailDBAccess = new EMailDBAccess();
		ArrayList groupList = eMailDBAccess.getAllGroupEntries();
		return groupList;
	}


public static void main(String[] arg){
	EMailBO eMailBO = new EMailBO();
	try{
	    eMailBO.getEMailAddress("");
	} catch (Exception e){
		e.printStackTrace();
	}
}


}
 
