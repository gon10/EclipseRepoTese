package org.rslingo.rsl.generator.Angular5andASP.NET_Core.DAL.Models

class CreateEntitiesLinks{
	
	String myName;
	
	new(String myName) {
		this.myName = myName;
	}
	
	def sayHello(){
		return "hello all my name is" + this.myName;
	}	
}
