namespace lab10
{
    public class Category
    {
        public readonly int Id;
        public string Name;
        public string Description;

        public Category(int id)
        {
            Id = id;
        }

        public override string ToString()
        {
            return $"Id: {Id}, Name: {Name}, Description: {Description}";
        }
    }
}
