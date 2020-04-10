package account.dbaccess;

import account.validation.AccountValidation;

public class AccountBO {

	public AccountBO() {
		super();
	}
	
	public AccountVOO getLoginDetails(AccountVOO accountVO)throws AccountValidationException, Exception {
		
		AccountVOO accVO = null;
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		allMessages.append(accValidate.validateUserName(accountVO.getUserName()));
		allMessages.append(accValidate.validatePassword(accountVO.getPasswd()));
		if (allMessages.length() == 0) {
			//retrieving database record
			LoginDB loginDB = new LoginDB();
			accVO = loginDB.getLoginInfo(accountVO.getUserName(), accountVO.getPasswd());
		}
		else {
			throw new AccountValidationException(allMessages.toString());
		}
		return accVO;
	}
	
	public void addLoginDetails(AccountVOO accountVO)throws AccountValidationException, Exception{
		
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : "+accountVO.getUserName()+"  "+accountVO.getPasswd());
		allMessages.append(accValidate.validateUserName(accountVO.getUserName()));
		allMessages.append(accValidate.validatePassword(accountVO.getPasswd()));
		System.out.println("BO Messages :"+allMessages.toString());
		if(allMessages.length() == 0) {
			System.out.println("In BO : "+accountVO.getUserName()+"  "+accountVO.getPasswd());
			LoginDB loginDB = new LoginDB();
			loginDB.addLoginInfo(accountVO.getUserName(), accountVO.getPasswd());
		}
		else {
			throw new AccountValidationException(allMessages.toString());
		}
	}

	public static void main(String[] args) {

		AccountBO accBO = new AccountBO();
		try {
			System.out.println("Inside Account BO");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
