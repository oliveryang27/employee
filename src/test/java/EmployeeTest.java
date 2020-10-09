
import employee.Employee;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author oliver
 */
public class EmployeeTest {

  @BeforeClass
  public static void setup() {

    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> SETUP");
  }

  @Test
  public void testAListofEmployeesToFindManagers() {
    Employee roger = new Employee(1, "Roger", null);
    Employee peter = new Employee(2, "Peter", roger);
    Employee ryan = new Employee(3, "Ryan", peter);
    Employee oli = new Employee(4, "Oliver", peter);
    Employee thomas = new Employee(5, "Thomas", oli);
    Employee craig = new Employee(6, "Craig", roger);

    assertEquals(0, roger.findManagers());
    assertEquals(1, peter.findManagers());
    assertEquals(2, oli.findManagers());
    assertEquals(1, craig.findManagers());

    craig.setManager(peter);
    assertEquals(2, craig.findManagers());
  }

  @Test
  public void testAListofEmployeesToFindSubordinates() {
    Employee roger = new Employee(1, "Roger", null);
    Employee peter = new Employee(2, "Peter", roger);
    Employee ryan = new Employee(3, "Ryan", peter);
    Employee oli = new Employee(4, "Oliver", peter);
    Employee thomas = new Employee(5, "Thomas", oli);
    Employee craig = new Employee(6, "Craig", roger);

    assertEquals(5, roger.findSubordinateCount());
    assertEquals(3, peter.findSubordinateCount());
    assertEquals(1, oli.findSubordinateCount());
    assertEquals(0, craig.findSubordinateCount());

    craig.setManager(peter);
    assertEquals(4, peter.findSubordinateCount());
  }
  
  @Test
  public void testAnEmployeePromotedAndThenToFindFindManagers() {
    Employee roger = new Employee(1, "Roger", null);
    Employee peter = new Employee(2, "Peter", roger);
    Employee ryan = new Employee(3, "Ryan", peter);
    Employee oli = new Employee(4, "Oliver", peter);
    Employee thomas = new Employee(5, "Thomas", oli);
    Employee craig = new Employee(6, "Craig", roger);

    assertEquals(0, roger.findManagers());
    assertEquals(1, peter.findManagers());
    assertEquals(2, oli.findManagers());
    assertEquals(1, craig.findManagers());

    craig.setManager(null);
    assertEquals(0, craig.findManagers());
    assertEquals(4, roger.findSubordinateCount());
  }
}
