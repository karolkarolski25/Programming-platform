using System;
using System.Collections.Generic;
using System.Linq;

namespace lab11
{
    public class Warehouse
    {
        private Dictionary<Product, int> products = new Dictionary<Product, int>();

        public void AddNewProduct(Product product, int count)
        {
            products.Add(product, count);

            Console.WriteLine("Added product");
        }

        public string GetProductsCount()
        {
            return $"\nProducts count: {products.Count}";
        }

        public void UpdateProductCount(int id, int count)
        {
            var prod = products.FirstOrDefault(p => p.Key.Id == id);

            if (prod.Key != null)
            {
                products[prod.Key] = count;

                Console.WriteLine($"\nUpdated {prod.Key} from {prod.Value} to {count}");
            }
            else
            {
                Console.WriteLine($"\nProduct with id {id} not found");
            }
        }

        public void GetProductsList()
        {
            Console.WriteLine("\nProducts list\n");

            foreach (var product in products)
            {
                Console.WriteLine($"{product.Key}\n\tCount: {product.Value}\n");
            }
        }
    }
}
