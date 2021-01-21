using System;
using System.Collections.Generic;
using System.Linq;

namespace lab11
{
    class Program
    {
        private static List<Category> categoryList = new List<Category>();
        private static List<Supplier> supplierList = new List<Supplier>();
        private static Warehouse warehouse = new Warehouse();

        static void Main(string[] args)
        {
            // 1 - 2
            AddCategories(5);
            AddSuppliers(10);

            AddProducts(4);

            warehouse.UpdateProductCount(0, 100);

            warehouse.UpdateProductCount(123, 100);

            Console.WriteLine(warehouse.GetProductsCount());

            warehouse.GetProductsList();

            /*       
                Added product
                Added product
                Added product
                Added product

                Updated Id: 0, Name: ProductName1,
                        Category: Id: 2, Name: Category3, Description: Category description3,
                        Supplier: Id: 2, CompanyName: CompanyName3, City: City3, homePage: HomePage3 from 7 to 100

                Product with id 123 not found

                Products count: 4

                Products list

                Id: 0, Name: ProductName1,
                        Category: Id: 2, Name: Category3, Description: Category description3,
                        Supplier: Id: 2, CompanyName: CompanyName3, City: City3, homePage: HomePage3
                        Count: 100

                Id: 1, Name: ProductName2,
                        Category: Id: 2, Name: Category3, Description: Category description3,
                        Supplier: Id: 5, CompanyName: CompanyName6, City: City6, homePage: HomePage6
                        Count: 8

                Id: 2, Name: ProductName3,
                        Category: Id: 4, Name: Category5, Description: Category description5,
                        Supplier: Id: 2, CompanyName: CompanyName3, City: City3, homePage: HomePage3
                        Count: 7

                Id: 3, Name: ProductName4,
                        Category: Id: 2, Name: Category3, Description: Category description3,
                        Supplier: Id: 1, CompanyName: CompanyName2, City: City2, homePage: HomePage2
                        Count: 2
            */

            //3
            Factorial.Start(250000);

            /*
                Factorial result: 3,018230E+1240914
                RunTime 00:01:57.53 ms
            */

            //4
            TxtService.MostFrequent("holmes.txt");

            /*
                się - 785
                nie - 703
                sir - 284
                jest - 233
                pan - 230
                ale - 204
                mnie - 179
                tak - 170
                jego - 170
                był - 158
                holmes - 151
                czy - 150
                już - 113
                jak - 108
                było - 105
                stapleton - 96
                przez - 95
                ten - 94
                jej - 91
                mortimer - 86
            */
        }

        private static void AddCategories(int count)
        {
            for (int i = 0; i < count; i++)
            {
                categoryList.Add(new Category(i)
                {
                    Name = $"Category{i + 1}",
                    Description = $"Category description{i + 1}"
                });
            }
        }

        private static void AddSuppliers(int count)
        {
            for (int i = 0; i < count; i++)
            {
                supplierList.Add(new Supplier(i)
                {
                    CompanyName = $"CompanyName{i + 1}",
                    City = $"City{i + 1}",
                    HomePage = $"HomePage{i + 1}"
                });
            }
        }

        private static void AddProducts(int count)
        {
            var random = new Random();

            for (int i = 0; i < count; i++)
            {
                warehouse.AddNewProduct(new Product(i)
                {
                    Name = $"ProductName{i + 1}",
                    Category = categoryList.ElementAt(random.Next(0, categoryList.Count)),
                    Supplier = supplierList.ElementAt(random.Next(0, supplierList.Count))

                }, random.Next(0, 10));
            }
        }
    }
}
