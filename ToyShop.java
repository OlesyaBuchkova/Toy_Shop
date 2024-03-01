import java.util.PriorityQueue;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.IOException;

public class ToyShop {
    private PriorityQueue<Toy> toys;

    public ToyShop() {
         
         this.toys = new PriorityQueue<>(Comparator.comparingInt(Toy::getWeight).reversed());
        }
    
        public void addToy(Toy toy) {
            toys.add(toy);
        }
        
    public Toy getToy() {
        return toys.poll(); 
    }

    public static void main(String[] args) {
        ToyShop store = new ToyShop();
           
        Toy[] arr1 = new Toy[]{
                new Toy(1, "Мишка", 2),
                new Toy(2, "Солдатик", 5),
                new Toy(3, "Кукла", 8),
                new Toy(4, "Пупс", 4)
            };
               
        for (int i = 0; i < arr1.length; i++) {
            store.addToy(arr1[i]);
        }
        
        
         try (FileWriter writer = new FileWriter("toy_shop.txt")) {
            for (int i = 0; i < 10; i++) {
                Toy toy = store.getToy();
                if (toy != null) {
                    writer.write(toy.toString() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}