import Controller.Controller;
import Repository.Repository;
import View.View;

import Exceptions.InputException;
import Model.IVegetable;
import Model.Pepper;
import Model.Tomato;
import Model.Eggplant;




public class Main {
    public static void main(String args[]) {
        try {
            Repository repository = new Repository(10);
            Controller controller = new Controller(repository);


            //Eggplant eggplant = new Eggplant(1);
            //Pepper pepper = new Pepper(2);
            //Tomato tomato = new Tomato(3);
            //repository.add(pepper);
            //repository.add(tomato);
            //repository.add(eggplant);

            //repository.remove(2);
            //IVegetable[] filteredVegetables = controller.getFilteredVegetables(2);
            //System.out.println(filteredVegetables.length);
            //System.out.println(filteredVegetables[0]);
            //

            View view = new View(controller);
            view.start();
        } catch (ArithmeticException arithmeticException) {
            System.out.println(arithmeticException.getMessage());
        }
    }
}