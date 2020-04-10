package account.dbaccess;

import account.validation.AccountValidation;

public class PersonalInfoBO {

	public PersonalInfoBO() {
		super();
	}

	public void addPersonalInfo(PersonalInfoVOO personalVOO) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + personalVOO.getFirstName());
		allMessages.append(accValidate.validatePersonalDetails(personalVOO.getFirstName(), personalVOO.getMiddleName(),
				personalVOO.getLastName(), personalVOO.getGender()));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + personalVOO.getFirstName());
			PersonalInfoDB personalDB = new PersonalInfoDB();
			personalDB.addPersonalInfo(personalVOO.getFirstName(), personalVOO.getMiddleName(),
				personalVOO.getLastName(), personalVOO.getGender());
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}
	
	public PersonalInfoVOO viewPersonalInfo(String firstName) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		PersonalInfoVOO personaVO = null;
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			PersonalInfoDB personalDB = new PersonalInfoDB();
			personaVO = personalDB.getPersonalInfo(firstName);
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
		return personaVO;
	}
	
	public void modifyPersonalInfo(String firstName, String lastName) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			PersonalInfoDB personalDB = new PersonalInfoDB();
			personalDB.updatePersonalInfo(firstName, lastName);
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}
	
	public void deletePersonalInfo(String firstName) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			PersonalInfoDB personalDB = new PersonalInfoDB();
			personalDB.deletePersonalInfo(firstName);
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
