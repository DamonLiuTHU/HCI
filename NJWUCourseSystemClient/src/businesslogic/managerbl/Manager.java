package businesslogic.managerbl;

import java.rmi.RemoteException;

import po.managerpo.ManagerPO;
import rmiconnector.RemoteDataFactory;
import vo.managervo.ManagerVO;
import dataservice.managerdataservice.ManagerDataService;
import dataservice.managerdataservice.MessageDataService;


public class Manager{
	ManagerDataService data=(ManagerDataService) new RemoteDataFactory().getData("Manager");
	MessageDataService messageData=(MessageDataService) new RemoteDataFactory().getData("Message");
		
	String id;
	String password;
	String name;
	String contactInfo;
	
	public Manager(String id){
		this.id=id;
		ManagerPO mp=new ManagerPO();
		try {
			mp=data.find(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		password=mp.getPassword();
		name=mp.getName();
		contactInfo=mp.getContactInfo();
	}
	
	public Manager(){

	}
	
	public int login(String id, String psw) {
		ManagerPO mp=new ManagerPO();
		try {
			mp=data.find(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(mp==null){
			return 0;
		}else if(!mp.getPassword().equals(psw)){
			return 1;
		}else{
			return 2;
		}
	}
	
	public void changePassword(String newPw){
		password=newPw;
		try {
			data.updatePw(new ManagerPO(id,password));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	 
	public ManagerVO getManagerInfo(){
		ManagerPO mp;
		try {
			mp = data.find(id);
			return new ManagerVO(mp);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean isIDExist(String id){
		if(login(id,"")==0){
			return false;
		}else{
			return true;
		}
	}
	
	public String getID(){
		return id;
	}
	public String getPassword(){
		return password;
	}	
	public String getName(){
		return name;
	}
	public String getContactInfo(){
		return contactInfo;
	}
	public void setContactInfo(String info){
		contactInfo=info;
		try {
			data.updateCi(new ManagerPO(id,contactInfo,null));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
