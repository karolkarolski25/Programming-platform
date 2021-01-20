using System;
using System.Collections.Generic;
using System.Linq;

namespace lab10
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

            //3
            Factorial.Start(50000);

            //4
            TxtService.MostFrequent("holmes.txt");
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
