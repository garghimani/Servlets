package account.dbaccess;

import account.validation.AccountValidation;

public class BankInfoBO {

	public BankInfoBO() {
		super();
	}

	public void addBankInfo(BankInfoVOO bankVOO) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + bankVOO.getBankName());
		allMessages.append(accValidate.validateBankDetails(bankVOO.getBankName(), bankVOO.getAccountNumber(),
				bankVOO.getSsn(), bankVOO.getPersonId()));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + bankVOO.getBankName());
			BankInfoDB bankDB = new BankInfoDB();
			bankDB.addBankInfo(bankVOO.getBankName(), bankVOO.getAccountNumber(),
				bankVOO.getSsn(), bankVOO.getPersonId());
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}
	
	public BankInfoVOO viewBankInfo(String firstName) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		BankInfoVOO bankVO = null;
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			BankInfoDB bankDB = new BankInfoDB();
			bankVO = bankDB.getBankInfo(firstName);
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
		return bankVO;
	}
	
	public void modifyBankInfo(String firstName, String bankName) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			BankInfoDB bankDB = new BankInfoDB();
			bankDB.updateBankInfo(firstName, bankName);
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}
	
	public void deleteBankInfo(String firstName) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			BankInfoDB bankDB = new BankInfoDB();
			bankDB.deleteBankInfo(firstName);
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
