package org.rslingo.rsl.generator.Angular5andASP.NET_Core.DAL.Models;

@SuppressWarnings("all")
public class CreateEntitiesLinks {
  private String myName;
  
  public CreateEntitiesLinks(final String myName) {
    this.myName = myName;
  }
  
  public String sayHello() {
    return ("hello all my name is" + this.myName);
  }
}
