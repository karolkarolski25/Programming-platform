package pl.poznan.put.cie.coffee;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class CoffeeMain {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		System.out.println("Coffee");
		while (true) {
			System.out.println("\n"
                                        + "Choose an action\n"
                                        + "(a) select coffee,\n"
                                        + "(b) list all,\n"
                                        + "(c) create new coffee,\n"
                                        + "(d) update coffee,\n"
                                        + "(e) delete coffee,\n"
                                        + "(f) show all suppliers,\n"
                                        + "(g) show one supplier,\n"
                                        + "(h) delete supplier,\n"
                                        + "(i) add supplier,\n"
                                        + "(any other key) exit.\n");

			CoffeeDao dao = new CoffeeDao();
                        
                        SuppliersDao supDao = new SuppliersDao();
                        
			Scanner in = new Scanner(System.in);
                        
                        String s = in.nextLine();
                        
                        System.out.println();
                        
			switch (s) {
				case "a": {
					System.out.println("Please enter coffee name : ");
					String name = in.nextLine();
					System.out.println(dao.GetOneCoffee(name));
					break;
				}
				case "b": {
					List<Coffee> coffeeList = dao.GetAllCoffees();
					for (Coffee c : coffeeList) {
						System.out.println(c.toString());
					}
					break;
				}
				case "c": {
					System.out.print("Please enter coffee name : ");
					String name = in.nextLine();
					System.out.print("Please enter coffee supplier ID : ");
					int supId = Integer.parseInt(in.nextLine());
					System.out.print("Please enter coffee price: ");
					BigDecimal price = new BigDecimal(in.nextLine());
					System.out.print("Please enter coffee sales : ");
					int sales = Integer.parseInt(in.nextLine());
					System.out.print("Please enter coffee total : ");
					int total = Integer.parseInt(in.nextLine());                                      
                                        
					dao.CreateNewCoffee(new Coffee(name, supId, price, sales, total));
					break;
				}
				case "d": {
					System.out.print("Please enter coffee name : ");
					String name = in.nextLine();
					System.out.print("Please enter coffee supplier ID : ");
					int supId = Integer.parseInt(in.nextLine());
					System.out.print("Please enter coffee price: ");
					BigDecimal price = new BigDecimal(in.nextLine());
					System.out.print("Please enter coffee sales : ");
					int sales = Integer.parseInt(in.nextLine());
					System.out.print("Please enter coffee total : ");
					int total = Integer.parseInt(in.nextLine());
					dao.UpdateCoffee(new Coffee(name, supId, price, sales, total));
					break;
				}
				case "e": {
					System.out.print("Please enter coffee name : ");
					String name = in.nextLine();
					System.out.print("Please enter coffee suppplier ID : ");
					int supId = Integer.parseInt(in.nextLine());
					dao.DeleteCoffee(name, supId);
					break;
				}
                                case "f":
                                {
                                    for (Suppliers c : supDao.GetAllSuppliers()) 
                                    {
                                        System.out.println(c.toString());
                                    }                                                                  
                                    break;
                                }
                                case "g":
                                {
                                    System.out.println("Please enter supplier name : ");
                                    
                                    String name = in.nextLine();
                                    
                                    System.out.println(supDao.GetSupplier(name));
                                    
                                    break;
                                }
                                case "h":
                                {
                                    System.out.println("Please enter supplier id to delete: ");
                                    
                                    int id = in.nextInt();
                                    
                                    supDao.DeleteSupplier(id);
                                    
                                    break;
                                }
                                case "i":
                                {                                                
                                    supDao.AddSupplier(new Suppliers(3, "TestName", "testStreet", "TestCity", "NY" , "12345"));
                                    
                                    break;
                                }
				default:
					break;
			}
		}
	}

}
