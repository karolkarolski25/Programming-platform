namespace lab10
{
    public class Supplier
    {
        public readonly int Id;
        public string CompanyName;
        public string City;
        public string HomePage;

        public Supplier(int id)
        {
            Id = id;
        }

        public override string ToString()
        {
            return $"Id: {Id}, CompanyName: {CompanyName}, City: {City}, homePage: {HomePage}";
        }
    }
}
