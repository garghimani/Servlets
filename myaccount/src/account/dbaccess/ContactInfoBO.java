package account.dbaccess;

import account.validation.AccountValidation;

public class ContactInfoBO {

	public ContactInfoBO() {
		super();
	}

	public void addContactInfo(ContactInfoVOO contactVOO) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + contactVOO.getAddress());
		allMessages.append(accValidate.validateContactDetails(contactVOO.getAddress(), contactVOO.getCity(),
				contactVOO.getState(), contactVOO.getCountry(), contactVOO.getPhone(), contactVOO.getPersonID()));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + contactVOO.getAddress());
			ContactInfoDB contactDB = new ContactInfoDB();
			contactDB.addContactInfo(contactVOO.getAddress(), contactVOO.getCity(),
				contactVOO.getState(), contactVOO.getCountry(), contactVOO.getPhone(), contactVOO.getPersonID());
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}
	
	public ContactInfoVOO viewContactInfo(String firstName) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		ContactInfoVOO contactVO = null;
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			ContactInfoDB contactDB = new ContactInfoDB();
			contactVO = contactDB.getContactInfo(firstName) ;
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
		return contactVO;
	}
	
	public void modifyContactInfo(String firstName, String address) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			ContactInfoDB contactDB = new ContactInfoDB();
			contactDB.updateContactInfo(firstName, address);
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}
	
	public void deleteContactInfo(String firstName) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			ContactInfoDB contactDB = new ContactInfoDB();
			contactDB.deleteContactInfo(firstName);
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
