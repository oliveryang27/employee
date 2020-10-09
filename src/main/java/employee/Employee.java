/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oliver
 */
public class Employee {

  private int ID;
  private String name;
  private Employee manager;
  private List<Employee> subordinates;
  private int totalSubordinates;
  private int totalManagers;

  public Employee(int ID, String name, Employee manager) {
    this.ID = ID;
    this.name = name;
    this.manager = manager;
    subordinates = new ArrayList<>();
    if (hasManager()) {
      manager.addSubordinate(this);
    }
    totalSubordinates = 0;
  }

  public Employee() {

  }

  public Integer getID() {
    return ID;
  }

  public void setID(Integer id) {
    this.ID = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Employee getManager() {
    return manager;
  }

  public void setManager(Employee manager) {
    totalSubordinates = 0;
    totalManagers = 0;
    if (manager != null && !manager.equals(this.manager)) {
      manager.addSubordinate(this);
      if (hasManager()) {
        this.manager.removeSubordinate(this);
      }
    }
    else if (manager == null) {
      if (hasManager()) {
        this.manager.removeSubordinate(this);
      }
    }
    this.manager = manager;
    if (this.manager != null) {
      this.manager.setTotalSubordinates(0);
      this.manager.setTotalManagers(0);
    }
  }

  public final Boolean hasManager() {
    return manager != null;
  }

  public void setTotalSubordinates(int totalSubordinates) {
    this.totalSubordinates = totalSubordinates;
  }

  public void setTotalManagers(int totalManagers) {
    this.totalManagers = totalManagers;
  }

  public Boolean hasSubordinates() {
    return subordinates != null && subordinates.size() > 0;
  }

  public void addSubordinate(Employee e) {
    subordinates.add(e);
  }

  public void removeSubordinate(Employee e) {
    subordinates.remove(e);
  }

  public List<Employee> getSubordinates() {
    return subordinates;
  }

  public int findManagers() {
    findManagers(this);
    return totalManagers;
  }

  private void findManagers(Employee e) {
    if (e.hasManager()) {
      totalManagers++;
      findManagers(e.getManager());
    }
  }

  public int findSubordinateCount() {
    findSubordinateCount(this);
    return totalSubordinates;
  }

  private void findSubordinateCount(Employee e) {
    if (e.hasSubordinates()) {
      for (Employee sub : e.getSubordinates()) {
//        System.out.println(sub);
        totalSubordinates++;
        findSubordinateCount(sub);
      }
    }
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 29 * hash + this.ID;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Employee other = (Employee) obj;
    if (this.ID != other.ID) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Employee{" + "ID=" + ID + ", name=" + name + ", manager=" + manager + ", subordinates=" + subordinates.size() + '}';
  }
}
