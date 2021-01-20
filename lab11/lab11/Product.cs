namespace lab11
{
    public class Product
    {
        public readonly int Id;
        public string Name;
        public Category Category;
        public Supplier Supplier;
        public decimal unitPrice;

        public Product(int id)
        {
            Id = id;
        }

        public override string ToString()
        {
            return $"Id: {Id}, Name: {Name}, \n\tCategory: {Category}, \n\tSupplier: {Supplier}";
        }
    }
}
