package entities;

public class MySecondEntity  extends MyFirstEntity {
	private MyFirstEntity anEntity;
	
	public MyFirstEntity getAnEntity(){
		return anEntity;
	}
	public void set AnEntity(MyFirstEntity _args){
		this.anEntity = _args;
	}
}


